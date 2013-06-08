package org.whiskeysierra.flux;


import org.junit.Assert;
import org.junit.Test;
import org.whiskeysierra.flux.converters.primitives.PrimitivesBundle;

public final class UnboxingFeatureTest {

    private Capacitor createCapacitor(Feature... features) {
        return Flux.createCapacitor(Features.of(features), new PrimitivesBundle());
    }

    @Test
    public void testbooleanEnabled() {
        final Capacitor capacitor = createCapacitor(Feature.UNBOXING);
        Assert.assertEquals(true, capacitor.convert("true").to(boolean.class));
    }

    @Test
    public void testbyteEnabled() {
        final Capacitor capacitor = createCapacitor(Feature.UNBOXING);
        Assert.assertEquals((byte) 127, (byte) capacitor.convert("127").to(byte.class));
    }

    @Test
    public void testCharEnabled() {
        final Capacitor capacitor = createCapacitor(Feature.UNBOXING);
        Assert.assertEquals('a', (long) capacitor.convert("a").to(char.class));
    }

    @Test
    public void testdoubleEnabled() {
        final Capacitor capacitor = createCapacitor(Feature.UNBOXING);
        Assert.assertEquals(12345d, capacitor.convert("12345").to(double.class), 0.0d);
    }

    @Test
    public void testfloatEnabled() {
        final Capacitor capacitor = createCapacitor(Feature.UNBOXING);
        Assert.assertEquals(12345f, capacitor.convert("12345").to(float.class), 0.0f);
    }

    @Test
    public void testIntEnabled() {
        final Capacitor capacitor = createCapacitor(Feature.UNBOXING);
        Assert.assertEquals(12345, (int) capacitor.convert("12345").to(int.class));
    }

    @Test
    public void testlongEnabled() {
        final Capacitor capacitor = createCapacitor(Feature.UNBOXING);
        Assert.assertEquals(12345L, (long) capacitor.convert("12345").to(long.class));
    }

    @Test
    public void testshortEnabled() {
        final Capacitor capacitor = createCapacitor(Feature.UNBOXING);
        Assert.assertEquals((short) 12345, (short) capacitor.convert("12345").to(short.class));
    }

    @Test
    public void testbooleanTransitive() {
        final Capacitor capacitor = createCapacitor(Feature.UNBOXING, Feature.TRANSITIVE);
        Assert.assertEquals(true, capacitor.convert("true").to(boolean.class));
    }

    @Test
    public void testbyteTransitive() {
        final Capacitor capacitor = createCapacitor(Feature.UNBOXING, Feature.TRANSITIVE);
        Assert.assertEquals((byte) 127, (byte) capacitor.convert("127").to(byte.class));
    }

    @Test
    public void testCharTransitive() {
        final Capacitor capacitor = createCapacitor(Feature.UNBOXING, Feature.TRANSITIVE);
        Assert.assertEquals('a', (long) capacitor.convert("a").to(char.class));
    }

    @Test
    public void testdoubleTransitive() {
        final Capacitor capacitor = createCapacitor(Feature.UNBOXING, Feature.TRANSITIVE);
        Assert.assertEquals(12345d, capacitor.convert("12345").to(double.class), 0.0d);
    }

    @Test
    public void testfloatTransitive() {
        final Capacitor capacitor = createCapacitor(Feature.UNBOXING, Feature.TRANSITIVE);
        Assert.assertEquals(12345f, capacitor.convert("12345").to(float.class), 0.0f);
    }

    @Test
    public void testIntTransitive() {
        final Capacitor capacitor = createCapacitor(Feature.UNBOXING, Feature.TRANSITIVE);
        Assert.assertEquals(12345, (int) capacitor.convert("12345").to(int.class));
    }

    @Test
    public void testlongTransitive() {
        final Capacitor capacitor = createCapacitor(Feature.UNBOXING, Feature.TRANSITIVE);
        Assert.assertEquals(12345L, (long) capacitor.convert("12345").to(long.class));
    }

    @Test
    public void testshortTransitive() {
        final Capacitor capacitor = createCapacitor(Feature.UNBOXING, Feature.TRANSITIVE);
        Assert.assertEquals((short) 12345, (short) capacitor.convert("12345").to(short.class));
    }

    @Test(expected = UnknownConversionException.class)
    public void testbooleanDisabled() {
        final Capacitor capacitor = createCapacitor();
        Assert.assertEquals(true, capacitor.convert("true").to(boolean.class));
    }

    @Test(expected = UnknownConversionException.class)
    public void testbyteDisabled() {
        final Capacitor capacitor = createCapacitor();
        Assert.assertEquals((byte) 127, (byte) capacitor.convert("127").to(byte.class));
    }

    @Test(expected = UnknownConversionException.class)
    public void testCharDisabled() {
        final Capacitor capacitor = createCapacitor();
        Assert.assertEquals('a', (long) capacitor.convert("a").to(char.class));
    }

    @Test(expected = UnknownConversionException.class)
    public void testdoubleDisabled() {
        final Capacitor capacitor = createCapacitor();
        Assert.assertEquals(12345d, capacitor.convert("12345").to(double.class), 0.0d);
    }

    @Test(expected = UnknownConversionException.class)
    public void testfloatDisabled() {
        final Capacitor capacitor = createCapacitor();
        Assert.assertEquals(12345f, capacitor.convert("12345").to(float.class), 0.0f);
    }

    @Test(expected = UnknownConversionException.class)
    public void testIntDisabled() {
        final Capacitor capacitor = createCapacitor();
        Assert.assertEquals(12345, (int) capacitor.convert("12345").to(int.class));
    }

    @Test(expected = UnknownConversionException.class)
    public void testlongDisabled() {
        final Capacitor capacitor = createCapacitor();
        Assert.assertEquals(12345L, (long) capacitor.convert("12345").to(long.class));
    }

    @Test(expected = UnknownConversionException.class)
    public void testshortDisabled() {
        final Capacitor capacitor = createCapacitor();
        Assert.assertEquals((short) 12345, (short) capacitor.convert("12345").to(short.class));
    }

}
