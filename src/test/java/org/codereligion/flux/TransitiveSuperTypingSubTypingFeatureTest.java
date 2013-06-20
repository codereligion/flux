package org.codereligion.flux;

import com.codereligion.flux.Bundle;
import com.codereligion.flux.Capacitor;
import com.codereligion.flux.Convert;
import com.codereligion.flux.Feature;
import com.codereligion.flux.Features;
import com.codereligion.flux.Flux;
import com.codereligion.flux.UnknownConversionException;
import org.junit.Assert;
import org.junit.Test;
import com.codereligion.flux.converters.base.BaseBundle;
import com.codereligion.flux.converters.wrappers.StringToIntegerConverter;

public final class TransitiveSuperTypingSubTypingFeatureTest {

    private final Object value = new Object() {
        @Override
        public String toString() {
            return "17";
        }
    };

    private Capacitor createCapacitor(Feature... features) {
        return Flux.createCapacitor(Features.of(features),
            new BaseBundle(),
            new Bundle() {
                @Override
                public void configure(Convert convert) {
                    convert.using(new StringToIntegerConverter());
                }
            });
    }

    @Test
    public void testEnabled() {
        final Capacitor capacitor = createCapacitor(Feature.SUPER_TYPING, Feature.SUB_TYPING, Feature.TRANSITIVE);
        Assert.assertEquals(17, capacitor.convert(value).to(Number.class));
    }

    @Test(expected = UnknownConversionException.class)
    public void testNoSuperTyping() {
        final Capacitor capacitor = createCapacitor(Feature.SUB_TYPING, Feature.TRANSITIVE);
        capacitor.convert(value).to(Number.class);
    }

    @Test(expected = UnknownConversionException.class)
    public void testNoSubTyping() {
        final Capacitor capacitor = createCapacitor(Feature.SUPER_TYPING, Feature.TRANSITIVE);
        capacitor.convert(value).to(Number.class);
    }

    @Test(expected = UnknownConversionException.class)
    public void testNoTransitive() {
        final Capacitor capacitor = createCapacitor(Feature.SUPER_TYPING, Feature.SUB_TYPING);
        capacitor.convert(value).to(Number.class);
    }

    @Test(expected = UnknownConversionException.class)
    public void testNoSuperTypingAndSubTyping() {
        final Capacitor capacitor = createCapacitor(Feature.TRANSITIVE);
        capacitor.convert(value).to(Number.class);
    }

    @Test(expected = UnknownConversionException.class)
    public void testNoSuperTypingAndTransitive() {
        final Capacitor capacitor = createCapacitor(Feature.SUB_TYPING);
        capacitor.convert(value).to(Number.class);
    }

    @Test(expected = UnknownConversionException.class)
    public void testNoSubTypingAndTransitive() {
        final Capacitor capacitor = createCapacitor(Feature.SUPER_TYPING);
        capacitor.convert(value).to(Number.class);
    }

    @Test(expected = UnknownConversionException.class)
    public void testDisabled() {
        final Capacitor capacitor = createCapacitor();
        capacitor.convert(value).to(Number.class);
    }

}
