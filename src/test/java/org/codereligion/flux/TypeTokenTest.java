package org.codereligion.flux;

import com.google.common.collect.Maps;
import com.google.common.reflect.TypeToken;
import org.junit.Assert;
import org.junit.Test;
import com.codereligion.flux.Tokens.Wildcard;
import com.codereligion.flux.converters.wrappers.StringToBooleanConverter;
import com.codereligion.flux.spi.Converter;

import java.lang.reflect.TypeVariable;
import java.util.Map;

public final class TypeTokenTest {

    @Test
    public void equals() {
        Assert.assertEquals(TypeToken.of(String.class), new TypeToken<String>() {

            private static final long serialVersionUID = 1;

        });
    }

    @Test
    public void converterType() {
        final TypeToken<Converter<String, Boolean>> expected = new TypeToken<Converter<String, Boolean>>() {

            private static final long serialVersionUID = 1;

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

        @SuppressWarnings("rawtypes")
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
