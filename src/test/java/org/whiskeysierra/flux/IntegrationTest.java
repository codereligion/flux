package org.whiskeysierra.flux;

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
import org.whiskeysierra.flux.internal.ConverterFinder;
import org.whiskeysierra.flux.internal.direct.DirectConverterFinder;

import java.util.Arrays;
import java.util.List;

public final class IntegrationTest {

    private Capacitor unit() {
        return unit(Features.defaults());
    }

    private Capacitor unit(FeatureSet features) {
        return Flux.createCapacitor(features, new Bundle() {

            @Override
            public void configure(Convert convert) {
                convert.using(new StringToBooleanConverter());
                convert.using(new StringToByteConverter());
                convert.using(new StringToCharacterConverter());
                convert.using(new StringToDoubleConverter());
                convert.using(new StringToFloatConverter());
                convert.using(new StringToIntegerConverter());
                convert.using(new StringToLongConverter());
                convert.using(new StringToShortConverter());

                convert.using(new StringToBigDecimalConverter());
                convert.using(new StringToBigIntegerConverter());

                convert.using(new ObjectToStringConverter());
            }

        });
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

}
