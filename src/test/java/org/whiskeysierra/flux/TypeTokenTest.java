package org.whiskeysierra.flux;

import com.google.common.base.Objects;
import com.google.common.reflect.TypeToken;
import org.junit.Assert;
import org.junit.Test;
import org.whiskeysierra.flux.converters.collections.MapToConvertableMapConverter;
import org.whiskeysierra.flux.converters.primitives.StringToBooleanConverter;

import javax.sound.sampled.BooleanControl;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Collection;
import java.util.Map;

public final class TypeTokenTest {

    @Test
    public void classLiteral() {
        TypeToken.of(String.class);
    }

    @Test
    public void subclass() {
        new TypeToken<String>() {
        };
    }

    @Test
    public void equals() {
        Assert.assertEquals(TypeToken.of(String.class), new TypeToken<String>() {
        });
    }

    @Test
    public void genericSubclass() {
        new TypeToken<Collection<String>>() {
        };
    }

    @Test
    public void converterType() {
        final TypeToken<Converter<String, Boolean>> expected = new TypeToken<Converter<String, Boolean>>() {
        };

        final Converter<?, ?> converter = new StringToBooleanConverter();
        final TypeToken<?> actual = TypeToken.of(converter.getClass()).getSupertype(Converter.class);

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void typeParameter() {
        final TypeToken<Boolean> expected = TypeToken.of(Boolean.class);

        final Converter<?, ?> converter = new StringToBooleanConverter();
        final TypeToken<?> token = TypeToken.of(converter.getClass()).getSupertype(Converter.class);

        final TypeVariable<Class<Converter>>[] typeParameters = Converter.class.getTypeParameters();
        final TypeToken<?> actual = token.resolveType(typeParameters[1]);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void partialTypeParameter() {
        final TypeToken<Map<?, Convertable>> expected = new TypeToken<Map<?, Convertable>>() {
        };

        final Converter<?, ?> converter = new MapToConvertableMapConverter<Object>(null);
        final TypeToken<?> token = TypeToken.of(converter.getClass()).getSupertype(Converter.class);

        final TypeVariable<Class<Converter>>[] typeParameters = Converter.class.getTypeParameters();
        final TypeToken<?> actual = token.resolveType(typeParameters[1]);

        Assert.assertFalse(Objects.equal(expected, actual));
        Assert.assertTrue(expected.isAssignableFrom(actual));
        Assert.assertFalse(actual.isAssignableFrom(expected));
    }

}
