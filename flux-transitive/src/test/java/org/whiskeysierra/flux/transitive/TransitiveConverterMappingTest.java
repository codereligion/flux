package org.whiskeysierra.flux.transitive;

import com.google.common.reflect.TypeToken;
import org.junit.Assert;
import org.junit.Test;
import org.whiskeysierra.flux.Capacitor;
import org.whiskeysierra.flux.spi.Converter;
import org.whiskeysierra.flux.spi.ConverterMapping;
import org.whiskeysierra.flux.converters.base.ObjectToStringConverter;
import org.whiskeysierra.flux.converters.primitives.StringToBooleanConverter;

import javax.annotation.Nullable;
import java.util.List;

public final class TransitiveConverterMappingTest {

    @Test
    public void simpleBinding() {
        final ConverterMapping mapping = new TransitiveConverterMapping();

        final Converter<Object, String> converter = new ObjectToStringConverter();

        final TypeToken<Object> input = TypeToken.of(Object.class);
        final TypeToken<String> output = TypeToken.of(String.class);

        mapping.register(converter);

        Assert.assertSame(converter, mapping.search(input, output));
    }

    @Test
    public void genericBinding() {
        final ConverterMapping mapping = new TransitiveConverterMapping();

        final Converter<String, List<String>> converter = new Converter<String, List<String>>() {

            @Override
            public List<String> convert(@Nullable String input, TypeToken<String> type, Capacitor capacitor) {
                throw new UnsupportedOperationException();
            }

        };

        mapping.register(converter);

        final TypeToken<String> input = TypeToken.of(String.class);
        final TypeToken<List<String>> output = new TypeToken<List<String>>() {
        };

        Assert.assertSame(converter, mapping.search(input, output));
    }

    @Test
    public void transitiveBinding() {
        final ConverterMapping mapping = new TransitiveConverterMapping();

        final Converter<?, ?> objectToString = new ObjectToStringConverter();
        final Converter<?, ?> stringToBoolean = new StringToBooleanConverter();

        mapping.register(objectToString);
        mapping.register(stringToBoolean);

        final Converter<Object, Boolean> converter =
            mapping.search(TypeToken.of(Object.class), TypeToken.of(Boolean.class));

        Assert.assertNotNull(converter);
        Assert.assertTrue(converter instanceof CompoundConverter);

        Assert.assertSame(objectToString, mapping.search(TypeToken.of(Object.class), TypeToken.of(String.class)));
        Assert.assertSame(stringToBoolean, mapping.search(TypeToken.of(String.class), TypeToken.of(Boolean.class)));
    }

    @Test
    public void shortest() {
        final ConverterMapping mapping = new TransitiveConverterMapping();

        final Converter<?, ?> objectToString = new ObjectToStringConverter();
        final Converter<?, ?> stringToBoolean = new StringToBooleanConverter();
        final Converter<?, ?> objectToBoolean = new Converter<Object, Boolean>() {

            @Override
            public Boolean convert(Object input, TypeToken<Object> type, Capacitor capacitor) {
                throw new UnsupportedOperationException();
            }

        };

        mapping.register(objectToString);
        mapping.register(stringToBoolean);
        mapping.register(objectToBoolean);

        Assert.assertSame(objectToBoolean, mapping.search(TypeToken.of(Object.class), TypeToken.of(Boolean.class)));
        Assert.assertSame(objectToString, mapping.search(TypeToken.of(Object.class), TypeToken.of(String.class)));
        Assert.assertSame(stringToBoolean, mapping.search(TypeToken.of(String.class), TypeToken.of(Boolean.class)));
    }

}
