package org.whiskeysierra.flux;

import com.google.common.collect.Maps;
import com.google.common.reflect.TypeToken;
import org.junit.Assert;
import org.junit.Test;
import org.whiskeysierra.flux.Tokens.Wildcard;
import org.whiskeysierra.flux.converters.wrappers.StringToBooleanConverter;
import org.whiskeysierra.flux.spi.Converter;

import java.lang.reflect.TypeVariable;
import java.util.Map;

public final class TypeTokenTest {

    @Test
    public void equals() {
        Assert.assertEquals(TypeToken.of(String.class), new TypeToken<String>() {
        });
    }

    @Test
    public void converterType() {
        final TypeToken<Converter<String, Boolean>> expected = new TypeToken<Converter<String, Boolean>>() {
        };

        final Converter<?, ?> converter = new StringToBooleanConverter();
        final TypeToken<?> actual = TypeToken.of(converter.getClass()).getSupertype(Converter.class);

        Assert.assertEquals(expected, actual);
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
    public void getTypesInclusive() {
        final TypeToken<Integer> type = TypeToken.of(Integer.class);
        Assert.assertTrue(type.getTypes().contains(type));
    }

    @Test
    public void wildcardIsAssignableFrom() {
        final TypeToken<?> hash = TypeToken.of(Maps.newHashMap().getClass());
        final TypeToken<?> tree = TypeToken.of(Maps.newTreeMap().getClass());

        final TypeToken<Map<?, ?>> wildcard = Wildcard.MAP;

        Assert.assertTrue(wildcard.isAssignableFrom(hash));
        Assert.assertTrue(wildcard.isAssignableFrom(tree));
    }

}
