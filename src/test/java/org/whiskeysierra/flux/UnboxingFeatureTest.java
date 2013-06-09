package org.whiskeysierra.flux;


import org.junit.Assert;
import org.junit.Test;
import org.whiskeysierra.flux.converters.primitives.PrimitivesToStringBundle;
import org.whiskeysierra.flux.converters.wrappers.StringToWrappersBundle;

public final class UnboxingFeatureTest {

    private Capacitor createCapacitor(Feature... features) {
        return Flux.createCapacitor(Features.of(features),
            new StringToWrappersBundle(),
            new PrimitivesToStringBundle());
    }

    @Test
    public void toBooleanEnabled() {
        final Capacitor capacitor = createCapacitor(Feature.UNBOXING);
        Assert.assertEquals(true, capacitor.convert("true").to(boolean.class));
    }

    @Test
    public void toByteEnabled() {
        final Capacitor capacitor = createCapacitor(Feature.UNBOXING);
        Assert.assertEquals((byte) 127, (byte) capacitor.convert("127").to(byte.class));
    }

    @Test
    public void toCharEnabled() {
        final Capacitor capacitor = createCapacitor(Feature.UNBOXING);
        Assert.assertEquals('a', (char) capacitor.convert("a").to(char.class));
    }

    @Test
    public void toDoubleEnabled() {
        final Capacitor capacitor = createCapacitor(Feature.UNBOXING);
        Assert.assertEquals(12345d, capacitor.convert("12345").to(double.class), 0.0d);
    }

    @Test
    public void toFloatEnabled() {
        final Capacitor capacitor = createCapacitor(Feature.UNBOXING);
        Assert.assertEquals(12345f, capacitor.convert("12345").to(float.class), 0.0f);
    }

    @Test
    public void toIntEnabled() {
        final Capacitor capacitor = createCapacitor(Feature.UNBOXING);
        Assert.assertEquals(12345, (int) capacitor.convert("12345").to(int.class));
    }

    @Test
    public void toLongEnabled() {
        final Capacitor capacitor = createCapacitor(Feature.UNBOXING);
        Assert.assertEquals(12345L, (long) capacitor.convert("12345").to(long.class));
    }

    @Test
    public void toShortEnabled() {
        final Capacitor capacitor = createCapacitor(Feature.UNBOXING);
        Assert.assertEquals((short) 12345, (short) capacitor.convert("12345").to(short.class));
    }

    @Test
    public void toBooleanEnabledAndTranstive() {
        final Capacitor capacitor = createCapacitor(Feature.UNBOXING, Feature.TRANSITIVE);
        Assert.assertEquals(true, capacitor.convert("true").to(boolean.class));
    }

    @Test
    public void toByteEnabledAndTranstive() {
        final Capacitor capacitor = createCapacitor(Feature.UNBOXING, Feature.TRANSITIVE);
        Assert.assertEquals((byte) 127, (byte) capacitor.convert("127").to(byte.class));
    }

    @Test
    public void toCharEnabledAndTranstive() {
        final Capacitor capacitor = createCapacitor(Feature.UNBOXING, Feature.TRANSITIVE);
        Assert.assertEquals('a', (long) capacitor.convert("a").to(char.class));
    }

    @Test
    public void toDoubleEnabledAndTranstive() {
        final Capacitor capacitor = createCapacitor(Feature.UNBOXING, Feature.TRANSITIVE);
        Assert.assertEquals(12345d, capacitor.convert("12345").to(double.class), 0.0d);
    }

    @Test
    public void toFloatEnabledAndTranstive() {
        final Capacitor capacitor = createCapacitor(Feature.UNBOXING, Feature.TRANSITIVE);
        Assert.assertEquals(12345f, capacitor.convert("12345").to(float.class), 0.0f);
    }

    @Test
    public void toIntEnabledAndTranstive() {
        final Capacitor capacitor = createCapacitor(Feature.UNBOXING, Feature.TRANSITIVE);
        Assert.assertEquals(12345, (int) capacitor.convert("12345").to(int.class));
    }

    @Test
    public void toLongEnabledAndTranstive() {
        final Capacitor capacitor = createCapacitor(Feature.UNBOXING, Feature.TRANSITIVE);
        Assert.assertEquals(12345L, (long) capacitor.convert("12345").to(long.class));
    }

    @Test
    public void toShortEnabledAndTranstive() {
        final Capacitor capacitor = createCapacitor(Feature.UNBOXING, Feature.TRANSITIVE);
        Assert.assertEquals((short) 12345, (short) capacitor.convert("12345").to(short.class));
    }

    @Test(expected = UnknownConversionException.class)
    public void toBooleanDisabled() {
        final Capacitor capacitor = createCapacitor();
        Assert.assertEquals(true, capacitor.convert("true").to(boolean.class));
    }

    @Test(expected = UnknownConversionException.class)
    public void toByteDisabled() {
        final Capacitor capacitor = createCapacitor();
        Assert.assertEquals((byte) 127, (byte) capacitor.convert("127").to(byte.class));
    }

    @Test(expected = UnknownConversionException.class)
    public void toCharDisabled() {
        final Capacitor capacitor = createCapacitor();
        Assert.assertEquals('a', (long) capacitor.convert("a").to(char.class));
    }

    @Test(expected = UnknownConversionException.class)
    public void toDoubleDisabled() {
        final Capacitor capacitor = createCapacitor();
        Assert.assertEquals(12345d, capacitor.convert("12345").to(double.class), 0.0d);
    }

    @Test(expected = UnknownConversionException.class)
    public void toFloatDisabled() {
        final Capacitor capacitor = createCapacitor();
        Assert.assertEquals(12345f, capacitor.convert("12345").to(float.class), 0.0f);
    }

    @Test(expected = UnknownConversionException.class)
    public void toIntDisabled() {
        final Capacitor capacitor = createCapacitor();
        Assert.assertEquals(12345, (int) capacitor.convert("12345").to(int.class));
    }

    @Test(expected = UnknownConversionException.class)
    public void toLongDisabled() {
        final Capacitor capacitor = createCapacitor();
        Assert.assertEquals(12345L, (long) capacitor.convert("12345").to(long.class));
    }

    @Test(expected = UnknownConversionException.class)
    public void toShortDisabled() {
        final Capacitor capacitor = createCapacitor();
        Assert.assertEquals((short) 12345, (short) capacitor.convert("12345").to(short.class));
    }

    @Test
    public void fromBooleanEnabled() {
        final Capacitor capacitor = createCapacitor(Feature.UNBOXING);
        Assert.assertEquals("true", capacitor.convert(true).to(String.class));
    }

    @Test
    public void fromByteEnabled() {
        final Capacitor capacitor = createCapacitor(Feature.UNBOXING);
        Assert.assertEquals("127", capacitor.convert((byte) 127).to(String.class));
    }

    @Test
    public void fromCharEnabled() {
        final Capacitor capacitor = createCapacitor(Feature.UNBOXING);
        Assert.assertEquals("a", capacitor.convert('a').to(String.class));
    }

    @Test
    public void fromDoubleEnabled() {
        final Capacitor capacitor = createCapacitor(Feature.UNBOXING);
        Assert.assertEquals("12345.0", capacitor.convert(12345d).to(String.class));
    }

    @Test
    public void fromFloatEnabled() {
        final Capacitor capacitor = createCapacitor(Feature.UNBOXING);
        Assert.assertEquals("12345.0", capacitor.convert(12345f).to(String.class));
    }

    @Test
    public void fromIntEnabled() {
        final Capacitor capacitor = createCapacitor(Feature.UNBOXING);
        Assert.assertEquals("12345", capacitor.convert(12345).to(String.class));
    }

    @Test
    public void fromLongEnabled() {
        final Capacitor capacitor = createCapacitor(Feature.UNBOXING);
        Assert.assertEquals("12345", capacitor.convert(12345L).to(String.class));
    }

    @Test
    public void fromShortEnabled() {
        final Capacitor capacitor = createCapacitor(Feature.UNBOXING);
        Assert.assertEquals("12345", capacitor.convert((short) 12345).to(String.class));
    }

    @Test
    public void fromBooleanEnabledAndTransitive() {
        final Capacitor capacitor = createCapacitor(Feature.UNBOXING, Feature.TRANSITIVE);
        Assert.assertEquals("true", capacitor.convert(true).to(String.class));
    }

    @Test
    public void fromByteEnabledAndTransitive() {
        final Capacitor capacitor = createCapacitor(Feature.UNBOXING, Feature.TRANSITIVE);
        Assert.assertEquals("127", capacitor.convert((byte) 127).to(String.class));
    }

    @Test
    public void fromCharEnabledAndTransitive() {
        final Capacitor capacitor = createCapacitor(Feature.UNBOXING, Feature.TRANSITIVE);
        Assert.assertEquals("a", capacitor.convert('a').to(String.class));
    }

    @Test
    public void fromDoubleEnabledAndTransitive() {
        final Capacitor capacitor = createCapacitor(Feature.UNBOXING, Feature.TRANSITIVE);
        Assert.assertEquals("12345.0", capacitor.convert(12345d).to(String.class));
    }

    @Test
    public void fromFloatEnabledAndTransitive() {
        final Capacitor capacitor = createCapacitor(Feature.UNBOXING, Feature.TRANSITIVE);
        Assert.assertEquals("12345.0", capacitor.convert(12345f).to(String.class));
    }

    @Test
    public void fromIntEnabledAndTransitive() {
        final Capacitor capacitor = createCapacitor(Feature.UNBOXING, Feature.TRANSITIVE);
        Assert.assertEquals("12345", capacitor.convert(12345).to(String.class));
    }

    @Test
    public void fromLongEnabledAndTransitive() {
        final Capacitor capacitor = createCapacitor(Feature.UNBOXING, Feature.TRANSITIVE);
        Assert.assertEquals("12345", capacitor.convert(12345L).to(String.class));
    }

    @Test
    public void fromShortEnabledAndTransitive() {
        final Capacitor capacitor = createCapacitor(Feature.UNBOXING, Feature.TRANSITIVE);
        Assert.assertEquals("12345", capacitor.convert((short) 12345).to(String.class));
    }

    @Test(expected = UnknownConversionException.class)
    public void fromBooleanDisabled() {
        final Capacitor capacitor = createCapacitor();
        Assert.assertEquals("tru", capacitor.convert(true).to(String.class));
    }

    @Test(expected = UnknownConversionException.class)
    public void fromByteDisabled() {
        final Capacitor capacitor = createCapacitor();
        Assert.assertEquals("127", capacitor.convert((byte) 127).to(String.class));
    }

    @Test(expected = UnknownConversionException.class)
    public void fromCharDisabled() {
        final Capacitor capacitor = createCapacitor();
        Assert.assertEquals("a", capacitor.convert('a').to(String.class));
    }

    @Test(expected = UnknownConversionException.class)
    public void fromDoubleDisabled() {
        final Capacitor capacitor = createCapacitor();
        Assert.assertEquals("12345.0", capacitor.convert(12345d).to(String.class));
    }

    @Test(expected = UnknownConversionException.class)
    public void fromFloatDisabled() {
        final Capacitor capacitor = createCapacitor();
        Assert.assertEquals("12345.0", capacitor.convert(12345f).to(String.class));
    }

    @Test(expected = UnknownConversionException.class)
    public void fromIntDisabled() {
        final Capacitor capacitor = createCapacitor();
        Assert.assertEquals("12345", capacitor.convert(12345).to(String.class));
    }

    @Test(expected = UnknownConversionException.class)
    public void fromLongDisabled() {
        final Capacitor capacitor = createCapacitor();
        Assert.assertEquals("12345", capacitor.convert(12345L).to(String.class));
    }

    @Test(expected = UnknownConversionException.class)
    public void fromShortDisabled() {
        final Capacitor capacitor = createCapacitor();
        Assert.assertEquals("12345", capacitor.convert((short) 12345).to(String.class));
    }

}
