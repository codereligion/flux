package org.whiskeysierra.flux.internal;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.Maps;
import com.google.common.reflect.Invokable;
import com.google.common.reflect.TypeToken;
import org.reflections.ReflectionUtils;
import org.whiskeysierra.flux.Bundle;
import org.whiskeysierra.flux.ConfigurationException;
import org.whiskeysierra.flux.Convert;
import org.whiskeysierra.flux.Converts;
import org.whiskeysierra.flux.InputBindingBuilder;
import org.whiskeysierra.flux.Key;
import org.whiskeysierra.flux.spi.Converter;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.TypeVariable;
import java.util.Map;
import java.util.Set;

import static com.google.common.base.Predicates.not;
import static org.reflections.ReflectionUtils.withAnnotation;
import static org.reflections.ReflectionUtils.withModifier;
import static org.reflections.ReflectionUtils.withParametersCount;

public final class BindingCollector implements Convert {

    private final Map<Key<?, ?>, Converter<?, ?>> mapping = Maps.newHashMap();

    @SuppressWarnings("unchecked")
    private Set<Method> getAllMethods(TypeToken<? extends Bundle> type,
        Predicate<? super Method> first, Predicate<? super Method> second) {
        return ReflectionUtils.getAllMethods(type.getRawType(), first, second);
    }

    @SuppressWarnings("unchecked")
    private Set<Method> getAllMethods(TypeToken<? extends Bundle> type,
        Predicate<? super Method> first, Predicate<? super Method> second, Predicate<? super Method> third) {
        return ReflectionUtils.getAllMethods(type.getRawType(), first, second, third);
    }

    private void checkIllegalConvertsMethods(TypeToken<? extends Bundle> type) {
        for (Method method : getAllMethods(type, withAnnotation(Converts.class), not(withModifier(Modifier.PUBLIC)))) {
            throw new ConfigurationException(String.format("'%s' is not public", method));
        }

        for (Method method : getAllMethods(type, withAnnotation(Converts.class), not(withParametersCount(1)))) {
            throw new ConfigurationException(String.format("'%s' has too many parameters", method));
        }
    }

    private Set<Method> findConvertsMethods(TypeToken<? extends Bundle> type) {
        return getAllMethods(type, withAnnotation(Converts.class), withModifier(Modifier.PUBLIC), withParametersCount(1));
    }

    @Override
    public void install(Bundle bundle) {
        Preconditions.checkNotNull(bundle, "Bundle");
        bundle.configure(this);

        final TypeToken<? extends Bundle> type = TypeToken.of(bundle.getClass());

        checkIllegalConvertsMethods(type);

        for (Method method : findConvertsMethods(type)) {
            @SuppressWarnings("unchecked")
            final Invokable<Bundle, Object> invokable = (Invokable<Bundle, Object>) type.method(method);

            @SuppressWarnings("unchecked")
            final TypeToken<Object> input = (TypeToken<Object>) invokable.getParameters().get(0).getType();

            @SuppressWarnings("unchecked")
            final TypeToken<Object> output = (TypeToken<Object>) invokable.getReturnType();

            from(input).to(output).using(new InvokableConverter(bundle, invokable));
        }
    }


    @Override
    public <I> InputBindingBuilder<I> from(Class<I> input) {
        Preconditions.checkNotNull(input, "Input");
        return from(TypeToken.of(input));
    }

    @Override
    public <I> InputBindingBuilder<I> from(TypeToken<I> input) {
        Preconditions.checkNotNull(input, "Input");
        return new DefaultInputBindingBuilder<I>(mapping, input);
    }

    @Override
    public <I, O> void using(Converter<I, O> converter) {
        final TypeToken<?> token = TypeToken.of(converter.getClass()).getSupertype(Converter.class);
        final TypeVariable<Class<Converter>>[] typeParameters = Converter.class.getTypeParameters();

        @SuppressWarnings("unchecked")
        final TypeToken<I> input = (TypeToken<I>) token.resolveType(typeParameters[0]);

        @SuppressWarnings("unchecked")
        final TypeToken<O> output = (TypeToken<O>) token.resolveType(typeParameters[1]);

        from(input).to(output).using(converter);
    }

    public Map<Key<?, ?>, Converter<?, ?>> getMapping() {
        return mapping;
    }

}
