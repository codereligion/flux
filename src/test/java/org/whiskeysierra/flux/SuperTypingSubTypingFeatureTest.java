package org.whiskeysierra.flux;

import com.google.common.reflect.TypeToken;
import org.junit.Assert;
import org.junit.Test;
import org.whiskeysierra.flux.spi.Converter;

public class SuperTypingSubTypingFeatureTest {

    @Test
    public void testEnabled() {
        final Capacitor capacitor = Flux.createCapacitor(Features.of(Feature.SUPER_TYPING, Feature.SUB_TYPING),
            new Bundle() {
                @Override
                public void configure(Convert convert) {
                    convert.using(new Converter<Object, Integer>() {
                        @Override
                        public <V extends Object> Integer convert(V input, TypeToken<V> type, Capacitor capacitor) {
                            return 17;
                        }
                    });
                }
            });

        Assert.assertEquals(17, capacitor.convert("any").to(Number.class));
    }

    @Test(expected = UnknownConversionException.class)
    public void testNoSuperTyping() {
        final Capacitor capacitor = Flux.createCapacitor(Features.of(Feature.SUB_TYPING),
            new Bundle() {
                @Override
                public void configure(Convert convert) {
                    convert.using(new Converter<Object, Integer>() {
                        @Override
                        public <V extends Object> Integer convert(V input, TypeToken<V> type, Capacitor capacitor) {
                            return 17;
                        }
                    });
                }
            });

        capacitor.convert("any").to(Number.class);
    }

    @Test(expected = UnknownConversionException.class)
    public void testNoSubTyping() {
        final Capacitor capacitor = Flux.createCapacitor(Features.of(Feature.SUPER_TYPING),
            new Bundle() {
                @Override
                public void configure(Convert convert) {
                    convert.using(new Converter<Object, Integer>() {
                        @Override
                        public <V extends Object> Integer convert(V input, TypeToken<V> type, Capacitor capacitor) {
                            return 17;
                        }
                    });
                }
            });

        capacitor.convert("any").to(Number.class);
    }

    @Test(expected = UnknownConversionException.class)
    public void testDisabled() {
        final Capacitor capacitor = Flux.createCapacitor(Features.of(),
            new Bundle() {
                @Override
                public void configure(Convert convert) {
                    convert.using(new Converter<Object, Integer>() {
                        @Override
                        public <V extends Object> Integer convert(V input, TypeToken<V> type, Capacitor capacitor) {
                            return 17;
                        }
                    });
                }
            });

        capacitor.convert("any").to(Number.class);
    }

}
