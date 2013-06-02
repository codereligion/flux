package org.whiskeysierra.flux;

import com.google.common.collect.ImmutableMap;
import com.google.common.reflect.TypeToken;
import org.junit.Assert;
import org.junit.Test;
import org.whiskeysierra.flux.converters.base.ObjectToStringConverter;
import org.whiskeysierra.flux.converters.math.StringToBigDecimalConverter;
import org.whiskeysierra.flux.converters.math.StringToBigIntegerConverter;
import org.whiskeysierra.flux.converters.primitives.StringToBooleanConverter;
import org.whiskeysierra.flux.converters.primitives.StringToByteConverter;
import org.whiskeysierra.flux.converters.primitives.StringToCharacterConverter;
import org.whiskeysierra.flux.converters.primitives.StringToDoubleConverter;
import org.whiskeysierra.flux.converters.primitives.StringToFloatConverter;
import org.whiskeysierra.flux.converters.primitives.StringToIntegerConverter;
import org.whiskeysierra.flux.converters.primitives.StringToLongConverter;
import org.whiskeysierra.flux.converters.primitives.StringToShortConverter;
import org.whiskeysierra.flux.direct.DirectConverterMapping;
import org.whiskeysierra.flux.spi.ConverterMapping;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public final class IntegrationTest {

    private Capacitor unit() {
        return unit(Features.defaults());
    }

    private Capacitor unit(FeatureSet features) {
        final ConverterMapping mapping = new DirectConverterMapping(features);

        mapping.register(new StringToBooleanConverter());
        mapping.register(new StringToByteConverter());
        mapping.register(new StringToCharacterConverter());
        mapping.register(new StringToDoubleConverter());
        mapping.register(new StringToFloatConverter());
        mapping.register(new StringToIntegerConverter());
        mapping.register(new StringToLongConverter());
        mapping.register(new StringToShortConverter());

        mapping.register(new StringToBigDecimalConverter());
        mapping.register(new StringToBigIntegerConverter());

        mapping.register(new ObjectToStringConverter());

        return new DefaultCapacitor(mapping, features);
    }

    @Test
    public void raw() {
        final String expected = "12345";
        final Object actual = unit().convert(expected).raw();
        Assert.assertSame(expected, actual);
    }

    @Test
    public void cast() {
        final Object expected = "12345";
        final String actual = unit().convert(expected).cast(String.class);
        Assert.assertSame(expected, actual);
    }

    @Test
    public void castToken() {
        final Object expected = Arrays.asList("a", "b", "c");
        final List<String> actual = unit().convert(expected).cast(new TypeToken<List<String>>() {});
        Assert.assertSame(expected, actual);
    }

    @Test
    public void to() {
        final long value = unit().convert("12345").to(Long.class);
        Assert.assertEquals(12345L, value);
    }

    @Test
    public void toToken() {
        final long value = unit().convert("12345").to(new TypeToken<Long>() {});
        Assert.assertEquals(12345L, value);
    }

    @Test
    public void convertWithTypeHint() {
        final long value = unit().convert("12345", String.class).to(new TypeToken<Long>() {});
        Assert.assertEquals(12345L, value);
    }

    @Test
    public void convertWithTypeTokenHint() {
        final long value = unit().convert("12345", new TypeToken<String>() {}).to(new TypeToken<Long>() {});
        Assert.assertEquals(12345L, value);
    }

    @Test
    public void identity() {
        final Capacitor unit = unit(Features.of(Feature.IDENTITY));
        Assert.assertEquals(true, unit.convert(true).to(Boolean.class));
    }

    @Test
    public void partialQualifiedGeneric() {
        final Map<?, ?> input = ImmutableMap.of("a", "12345", "b", "true", "c", "test");
        final Map<String, Convertable> output = unit().convert(input).to(Tokens.forMap(String.class));

        Assert.assertSame("12345", output.get("a").raw());
        Assert.assertEquals(12345L, (long) output.get("a").to(Long.class));
        Assert.assertSame("true", output.get("b").raw());
        Assert.assertEquals(true, output.get("b").to(Boolean.class));
        Assert.assertSame("test", output.get("c").raw());
    }

}
