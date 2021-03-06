package org.codereligion.flux;

import com.codereligion.flux.Bundle;
import com.codereligion.flux.Capacitor;
import com.codereligion.flux.Convert;
import com.codereligion.flux.Feature;
import com.codereligion.flux.Features;
import com.codereligion.flux.Flux;
import com.codereligion.flux.UnknownConversionException;
import com.google.common.reflect.TypeToken;
import org.junit.Assert;
import org.junit.Test;
import com.codereligion.flux.spi.Converter;

public final class SuperTypingSubTypingFeatureTest {

    private Capacitor createCapacitor(Feature... features) {
        return Flux.createCapacitor(Features.of(features),
            new Bundle() {
                @Override
                public void configure(Convert convert) {
                    convert.using(new Converter<Object, Integer>() {
                        @Override
                        public <V extends Object> Integer convert(V value, TypeToken<V> input, Capacitor capacitor) {
                            return 17;
                        }
                    });
                }
            });
    }

    @Test
    public void testEnabled() {
        final Capacitor capacitor = createCapacitor(Feature.SUPER_TYPING, Feature.SUB_TYPING);
        Assert.assertEquals(17, capacitor.convert("any").to(Number.class));
    }

    @Test(expected = UnknownConversionException.class)
    public void testNoSuperTyping() {
        final Capacitor capacitor = createCapacitor(Feature.SUB_TYPING);
        capacitor.convert("any").to(Number.class);
    }

    @Test(expected = UnknownConversionException.class)
    public void testNoSubTyping() {
        final Capacitor capacitor = createCapacitor(Feature.SUPER_TYPING);
        capacitor.convert("any").to(Number.class);
    }

    @Test(expected = UnknownConversionException.class)
    public void testDisabled() {
        final Capacitor capacitor = createCapacitor();
        capacitor.convert("any").to(Number.class);
    }

}
