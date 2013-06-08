package org.whiskeysierra.flux;


import org.junit.Assert;
import org.junit.Test;

public final class AutoboxingFeatureTest {

    public static final class DemoBundle implements Bundle {

        @Override
        public void configure(Convert convert) {

        }

        @Converts
        public boolean parseBoolean(String value) {
            return Boolean.parseBoolean(value);
        }

        @Converts
        public byte parseByte(String value) {
            return Byte.parseByte(value);
        }

        @Converts
        public char parseChar(String value) {
            return value.charAt(0);
        }

        @Converts
        public double parseDouble(String value) {
            return Double.parseDouble(value);
        }

        @Converts
        public float parseFloat(String value) {
            return Float.parseFloat(value);
        }

        @Converts
        public int parseInt(String value) {
            return Integer.parseInt(value);
        }

        @Converts
        public long parseLong(String value) {
            return Long.parseLong(value);
        }

        @Converts
        public short parseShort(String value) {
            return Short.parseShort(value);
        }

    }

    private Capacitor createCapacitor(Feature... features) {
        return Flux.createCapacitor(Features.of(features), new DemoBundle());
    }

    @Test
    public void testBooleanEnabled() {
        final Capacitor capacitor = createCapacitor(Feature.AUTOBOXING);
        Assert.assertEquals(true, capacitor.convert("true").to(Boolean.class));
    }

    @Test
    public void testByteEnabled() {
        final Capacitor capacitor = createCapacitor(Feature.AUTOBOXING);
        Assert.assertEquals((byte) 127, (byte) capacitor.convert("127").to(Byte.class));
    }

    @Test
    public void testCharEnabled() {
        final Capacitor capacitor = createCapacitor(Feature.AUTOBOXING);
        Assert.assertEquals('a', (long) capacitor.convert("a").to(Character.class));
    }

    @Test
    public void testDoubleEnabled() {
        final Capacitor capacitor = createCapacitor(Feature.AUTOBOXING);
        Assert.assertEquals(12345d, capacitor.convert("12345").to(Double.class), 0.0d);
    }

    @Test
    public void testFloatEnabled() {
        final Capacitor capacitor = createCapacitor(Feature.AUTOBOXING);
        Assert.assertEquals(12345f, capacitor.convert("12345").to(Float.class), 0.0f);
    }

    @Test
    public void testIntEnabled() {
        final Capacitor capacitor = createCapacitor(Feature.AUTOBOXING);
        Assert.assertEquals(12345, (int) capacitor.convert("12345").to(Integer.class));
    }

    @Test
    public void testLongEnabled() {
        final Capacitor capacitor = createCapacitor(Feature.AUTOBOXING);
        Assert.assertEquals(12345L, (long) capacitor.convert("12345").to(Long.class));
    }

    @Test
    public void testShortEnabled() {
        final Capacitor capacitor = createCapacitor(Feature.AUTOBOXING);
        Assert.assertEquals((short) 12345, (short) capacitor.convert("12345").to(Short.class));
    }

    @Test
    public void testBooleanTransitive() {
        final Capacitor capacitor = createCapacitor(Feature.AUTOBOXING, Feature.TRANSITIVE);
        Assert.assertEquals(true, capacitor.convert("true").to(Boolean.class));
    }

    @Test
    public void testByteTransitive() {
        final Capacitor capacitor = createCapacitor(Feature.AUTOBOXING, Feature.TRANSITIVE);
        Assert.assertEquals((byte) 127, (byte) capacitor.convert("127").to(Byte.class));
    }

    @Test
    public void testCharTransitive() {
        final Capacitor capacitor = createCapacitor(Feature.AUTOBOXING, Feature.TRANSITIVE);
        Assert.assertEquals('a', (long) capacitor.convert("a").to(Character.class));
    }

    @Test
    public void testDoubleTransitive() {
        final Capacitor capacitor = createCapacitor(Feature.AUTOBOXING, Feature.TRANSITIVE);
        Assert.assertEquals(12345d, capacitor.convert("12345").to(Double.class), 0.0d);
    }

    @Test
    public void testFloatTransitive() {
        final Capacitor capacitor = createCapacitor(Feature.AUTOBOXING, Feature.TRANSITIVE);
        Assert.assertEquals(12345f, capacitor.convert("12345").to(Float.class), 0.0f);
    }

    @Test
    public void testIntTransitive() {
        final Capacitor capacitor = createCapacitor(Feature.AUTOBOXING, Feature.TRANSITIVE);
        Assert.assertEquals(12345, (int) capacitor.convert("12345").to(Integer.class));
    }

    @Test
    public void testLongTransitive() {
        final Capacitor capacitor = createCapacitor(Feature.AUTOBOXING, Feature.TRANSITIVE);
        Assert.assertEquals(12345L, (long) capacitor.convert("12345").to(Long.class));
    }

    @Test
    public void testShortTransitive() {
        final Capacitor capacitor = createCapacitor(Feature.AUTOBOXING, Feature.TRANSITIVE);
        Assert.assertEquals((short) 12345, (short) capacitor.convert("12345").to(Short.class));
    }

    @Test(expected = UnknownConversionException.class)
    public void testBooleanDisabled() {
        final Capacitor capacitor = createCapacitor();
        Assert.assertEquals(true, capacitor.convert("true").to(Boolean.class));
    }

    @Test(expected = UnknownConversionException.class)
    public void testByteDisabled() {
        final Capacitor capacitor = createCapacitor();
        Assert.assertEquals((byte) 127, (byte) capacitor.convert("127").to(Byte.class));
    }

    @Test(expected = UnknownConversionException.class)
    public void testCharDisabled() {
        final Capacitor capacitor = createCapacitor();
        Assert.assertEquals('a', (long) capacitor.convert("a").to(Character.class));
    }

    @Test(expected = UnknownConversionException.class)
    public void testDoubleDisabled() {
        final Capacitor capacitor = createCapacitor();
        Assert.assertEquals(12345d, capacitor.convert("12345").to(Double.class), 0.0d);
    }

    @Test(expected = UnknownConversionException.class)
    public void testFloatDisabled() {
        final Capacitor capacitor = createCapacitor();
        Assert.assertEquals(12345f, capacitor.convert("12345").to(Float.class), 0.0f);
    }

    @Test(expected = UnknownConversionException.class)
    public void testIntDisabled() {
        final Capacitor capacitor = createCapacitor();
        Assert.assertEquals(12345, (int) capacitor.convert("12345").to(Integer.class));
    }

    @Test(expected = UnknownConversionException.class)
    public void testLongDisabled() {
        final Capacitor capacitor = createCapacitor();
        Assert.assertEquals(12345L, (long) capacitor.convert("12345").to(Long.class));
    }

    @Test(expected = UnknownConversionException.class)
    public void testShortDisabled() {
        final Capacitor capacitor = createCapacitor();
        Assert.assertEquals((short) 12345, (short) capacitor.convert("12345").to(Short.class));
    }

}
