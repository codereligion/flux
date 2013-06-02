package org.whiskeysierra.flux;

import com.google.common.reflect.TypeToken;
import org.junit.Assert;
import org.junit.Test;
import org.whiskeysierra.flux.converters.primitives.StringToBooleanConverter;
import org.whiskeysierra.flux.spi.Converter;

import java.lang.reflect.TypeVariable;

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
        Assert.assertTrue(TypeToken.of(Integer.class).getTypes().contains(TypeToken.of(Integer.class)));
    }

}
