package org.codereligion.flux;


import com.codereligion.flux.Capacitor;
import com.codereligion.flux.Feature;
import com.codereligion.flux.Features;
import com.codereligion.flux.Flux;
import com.codereligion.flux.UnknownConversionException;
import org.junit.Assert;
import org.junit.Test;
import com.codereligion.flux.converters.primitives.PrimitivesToStringBundle;
import com.codereligion.flux.converters.wrappers.StringToWrappersBundle;

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
    public void toBooleanEnabledAndComposition() {
        final Capacitor capacitor = createCapacitor(Feature.UNBOXING, Feature.COMPOSITION);
        Assert.assertEquals(true, capacitor.convert("true").to(boolean.class));
    }

    @Test
    public void toByteEnabledAndComposition() {
        final Capacitor capacitor = createCapacitor(Feature.UNBOXING, Feature.COMPOSITION);
        Assert.assertEquals((byte) 127, (byte) capacitor.convert("127").to(byte.class));
    }

    @Test
    public void toCharEnabledAndComposition() {
        final Capacitor capacitor = createCapacitor(Feature.UNBOXING, Feature.COMPOSITION);
        Assert.assertEquals('a', (long) capacitor.convert("a").to(char.class));
    }

    @Test
    public void toDoubleEnabledAndComposition() {
        final Capacitor capacitor = createCapacitor(Feature.UNBOXING, Feature.COMPOSITION);
        Assert.assertEquals(12345d, capacitor.convert("12345").to(double.class), 0.0d);
    }

    @Test
    public void toFloatEnabledAndComposition() {
        final Capacitor capacitor = createCapacitor(Feature.UNBOXING, Feature.COMPOSITION);
        Assert.assertEquals(12345f, capacitor.convert("12345").to(float.class), 0.0f);
    }

    @Test
    public void toIntEnabledAndComposition() {
        final Capacitor capacitor = createCapacitor(Feature.UNBOXING, Feature.COMPOSITION);
        Assert.assertEquals(12345, (int) capacitor.convert("12345").to(int.class));
    }

    @Test
    public void toLongEnabledAndComposition() {
        final Capacitor capacitor = createCapacitor(Feature.UNBOXING, Feature.COMPOSITION);
        Assert.assertEquals(12345L, (long) capacitor.convert("12345").to(long.class));
    }

    @Test
    public void toShortEnabledAndComposition() {
        final Capacitor capacitor = createCapacitor(Feature.UNBOXING, Feature.COMPOSITION);
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
    public void fromBooleanEnabledAndComposition() {
        final Capacitor capacitor = createCapacitor(Feature.UNBOXING, Feature.COMPOSITION);
        Assert.assertEquals("true", capacitor.convert(true).to(String.class));
    }

    @Test
    public void fromByteEnabledAndComposition() {
        final Capacitor capacitor = createCapacitor(Feature.UNBOXING, Feature.COMPOSITION);
        Assert.assertEquals("127", capacitor.convert((byte) 127).to(String.class));
    }

    @Test
    public void fromCharEnabledAndComposition() {
        final Capacitor capacitor = createCapacitor(Feature.UNBOXING, Feature.COMPOSITION);
        Assert.assertEquals("a", capacitor.convert('a').to(String.class));
    }

    @Test
    public void fromDoubleEnabledAndComposition() {
        final Capacitor capacitor = createCapacitor(Feature.UNBOXING, Feature.COMPOSITION);
        Assert.assertEquals("12345.0", capacitor.convert(12345d).to(String.class));
    }

    @Test
    public void fromFloatEnabledAndComposition() {
        final Capacitor capacitor = createCapacitor(Feature.UNBOXING, Feature.COMPOSITION);
        Assert.assertEquals("12345.0", capacitor.convert(12345f).to(String.class));
    }

    @Test
    public void fromIntEnabledAndComposition() {
        final Capacitor capacitor = createCapacitor(Feature.UNBOXING, Feature.COMPOSITION);
        Assert.assertEquals("12345", capacitor.convert(12345).to(String.class));
    }

    @Test
    public void fromLongEnabledAndComposition() {
        final Capacitor capacitor = createCapacitor(Feature.UNBOXING, Feature.COMPOSITION);
        Assert.assertEquals("12345", capacitor.convert(12345L).to(String.class));
    }

    @Test
    public void fromShortEnabledAndComposition() {
        final Capacitor capacitor = createCapacitor(Feature.UNBOXING, Feature.COMPOSITION);
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
