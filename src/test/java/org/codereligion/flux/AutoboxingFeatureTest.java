package org.codereligion.flux;


import com.codereligion.flux.Capacitor;
import com.codereligion.flux.Feature;
import com.codereligion.flux.Features;
import com.codereligion.flux.Flux;
import com.codereligion.flux.UnknownConversionException;
import org.junit.Assert;
import org.junit.Test;
import com.codereligion.flux.converters.primitives.StringToPrimitivesBundle;

public final class AutoboxingFeatureTest {

    private Capacitor createCapacitor(Feature... features) {
        return Flux.createCapacitor(Features.of(features),
            new StringToPrimitivesBundle(),
            new WrappersToStringBundle());
    }

    @Test
    public void toBooleanEnabled() {
        final Capacitor capacitor = createCapacitor(Feature.AUTOBOXING);
        Assert.assertEquals(true, capacitor.convert("true").to(Boolean.class));
    }

    @Test
    public void toByteEnabled() {
        final Capacitor capacitor = createCapacitor(Feature.AUTOBOXING);
        Assert.assertEquals((byte) 127, (byte) capacitor.convert("127").to(Byte.class));
    }

    @Test
    public void toCharEnabled() {
        final Capacitor capacitor = createCapacitor(Feature.AUTOBOXING);
        Assert.assertEquals('a', (long) capacitor.convert("a").to(Character.class));
    }

    @Test
    public void toDoubleEnabled() {
        final Capacitor capacitor = createCapacitor(Feature.AUTOBOXING);
        Assert.assertEquals(12345d, capacitor.convert("12345").to(Double.class), 0.0d);
    }

    @Test
    public void toFloatEnabled() {
        final Capacitor capacitor = createCapacitor(Feature.AUTOBOXING);
        Assert.assertEquals(12345f, capacitor.convert("12345").to(Float.class), 0.0f);
    }

    @Test
    public void toIntEnabled() {
        final Capacitor capacitor = createCapacitor(Feature.AUTOBOXING);
        Assert.assertEquals(12345, (int) capacitor.convert("12345").to(Integer.class));
    }

    @Test
    public void toLongEnabled() {
        final Capacitor capacitor = createCapacitor(Feature.AUTOBOXING);
        Assert.assertEquals(12345L, (long) capacitor.convert("12345").to(Long.class));
    }

    @Test
    public void toShortEnabled() {
        final Capacitor capacitor = createCapacitor(Feature.AUTOBOXING);
        Assert.assertEquals((short) 12345, (short) capacitor.convert("12345").to(Short.class));
    }

    @Test
    public void toBooleanEnabledAndComposition() {
        final Capacitor capacitor = createCapacitor(Feature.AUTOBOXING, Feature.COMPOSITION);
        Assert.assertEquals(true, capacitor.convert("true").to(Boolean.class));
    }

    @Test
    public void toByteEnabledAndComposition() {
        final Capacitor capacitor = createCapacitor(Feature.AUTOBOXING, Feature.COMPOSITION);
        Assert.assertEquals((byte) 127, (byte) capacitor.convert("127").to(Byte.class));
    }

    @Test
    public void toCharEnabledAndComposition() {
        final Capacitor capacitor = createCapacitor(Feature.AUTOBOXING, Feature.COMPOSITION);
        Assert.assertEquals('a', (long) capacitor.convert("a").to(Character.class));
    }

    @Test
    public void toDoubleEnabledAndComposition() {
        final Capacitor capacitor = createCapacitor(Feature.AUTOBOXING, Feature.COMPOSITION);
        Assert.assertEquals(12345d, capacitor.convert("12345").to(Double.class), 0.0d);
    }

    @Test
    public void toFloatEnabledAndComposition() {
        final Capacitor capacitor = createCapacitor(Feature.AUTOBOXING, Feature.COMPOSITION);
        Assert.assertEquals(12345f, capacitor.convert("12345").to(Float.class), 0.0f);
    }

    @Test
    public void toIntEnabledAndComposition() {
        final Capacitor capacitor = createCapacitor(Feature.AUTOBOXING, Feature.COMPOSITION);
        Assert.assertEquals(12345, (int) capacitor.convert("12345").to(Integer.class));
    }

    @Test
    public void toLongEnabledAndComposition() {
        final Capacitor capacitor = createCapacitor(Feature.AUTOBOXING, Feature.COMPOSITION);
        Assert.assertEquals(12345L, (long) capacitor.convert("12345").to(Long.class));
    }

    @Test
    public void toShortEnabledAndComposition() {
        final Capacitor capacitor = createCapacitor(Feature.AUTOBOXING, Feature.COMPOSITION);
        Assert.assertEquals((short) 12345, (short) capacitor.convert("12345").to(Short.class));
    }

    @Test(expected = UnknownConversionException.class)
    public void toBooleanDisabled() {
        final Capacitor capacitor = createCapacitor();
        Assert.assertEquals(true, capacitor.convert("true").to(Boolean.class));
    }

    @Test(expected = UnknownConversionException.class)
    public void toByteDisabled() {
        final Capacitor capacitor = createCapacitor();
        Assert.assertEquals((byte) 127, (byte) capacitor.convert("127").to(Byte.class));
    }

    @Test(expected = UnknownConversionException.class)
    public void toCharDisabled() {
        final Capacitor capacitor = createCapacitor();
        Assert.assertEquals('a', (long) capacitor.convert("a").to(Character.class));
    }

    @Test(expected = UnknownConversionException.class)
    public void toDoubleDisabled() {
        final Capacitor capacitor = createCapacitor();
        Assert.assertEquals(12345d, capacitor.convert("12345").to(Double.class), 0.0d);
    }

    @Test(expected = UnknownConversionException.class)
    public void toFloatDisabled() {
        final Capacitor capacitor = createCapacitor();
        Assert.assertEquals(12345f, capacitor.convert("12345").to(Float.class), 0.0f);
    }

    @Test(expected = UnknownConversionException.class)
    public void toIntDisabled() {
        final Capacitor capacitor = createCapacitor();
        Assert.assertEquals(12345, (int) capacitor.convert("12345").to(Integer.class));
    }

    @Test(expected = UnknownConversionException.class)
    public void toLongDisabled() {
        final Capacitor capacitor = createCapacitor();
        Assert.assertEquals(12345L, (long) capacitor.convert("12345").to(Long.class));
    }

    @Test(expected = UnknownConversionException.class)
    public void toShortDisabled() {
        final Capacitor capacitor = createCapacitor();
        Assert.assertEquals((short) 12345, (short) capacitor.convert("12345").to(Short.class));
    }

    @Test
    public void fromBooleanEnabled() {
        final Capacitor capacitor = createCapacitor(Feature.AUTOBOXING);
        Assert.assertEquals("true", capacitor.convert(true, boolean.class).to(String.class));
    }

    @Test
    public void fromByteEnabled() {
        final Capacitor capacitor = createCapacitor(Feature.AUTOBOXING);
        Assert.assertEquals("127", capacitor.convert((byte) 127, byte.class).to(String.class));
    }

    @Test
    public void fromCharEnabled() {
        final Capacitor capacitor = createCapacitor(Feature.AUTOBOXING);
        Assert.assertEquals("a", capacitor.convert('a', char.class).to(String.class));
    }

    @Test
    public void fromDoubleEnabled() {
        final Capacitor capacitor = createCapacitor(Feature.AUTOBOXING);
        Assert.assertEquals("12345.0", capacitor.convert(12345d, double.class).to(String.class));
    }

    @Test
    public void fromFloatEnabled() {
        final Capacitor capacitor = createCapacitor(Feature.AUTOBOXING);
        Assert.assertEquals("12345.0", capacitor.convert(12345f, float.class).to(String.class));
    }

    @Test
    public void fromIntEnabled() {
        final Capacitor capacitor = createCapacitor(Feature.AUTOBOXING);
        Assert.assertEquals("12345", capacitor.convert(12345, int.class).to(String.class));
    }

    @Test
    public void fromLongEnabled() {
        final Capacitor capacitor = createCapacitor(Feature.AUTOBOXING);
        Assert.assertEquals("12345", capacitor.convert(12345L, long.class).to(String.class));
    }

    @Test
    public void fromShortEnabled() {
        final Capacitor capacitor = createCapacitor(Feature.AUTOBOXING);
        Assert.assertEquals("12345", capacitor.convert((short) 12345, short.class).to(String.class));
    }

    @Test
    public void fromBooleanEnabledAndComposition() {
        final Capacitor capacitor = createCapacitor(Feature.AUTOBOXING, Feature.COMPOSITION);
        Assert.assertEquals("true", capacitor.convert(true, boolean.class).to(String.class));
    }

    @Test
    public void fromByteEnabledAndComposition() {
        final Capacitor capacitor = createCapacitor(Feature.AUTOBOXING, Feature.COMPOSITION);
        Assert.assertEquals("127", capacitor.convert((byte) 127, byte.class).to(String.class));
    }

    @Test
    public void fromCharEnabledAndComposition() {
        final Capacitor capacitor = createCapacitor(Feature.AUTOBOXING, Feature.COMPOSITION);
        Assert.assertEquals("a", capacitor.convert('a', char.class).to(String.class));
    }

    @Test
    public void fromDoubleEnabledAndComposition() {
        final Capacitor capacitor = createCapacitor(Feature.AUTOBOXING, Feature.COMPOSITION);
        Assert.assertEquals("12345.0", capacitor.convert(12345d, double.class).to(String.class));
    }

    @Test
    public void fromFloatEnabledAndComposition() {
        final Capacitor capacitor = createCapacitor(Feature.AUTOBOXING, Feature.COMPOSITION);
        Assert.assertEquals("12345.0", capacitor.convert(12345f, float.class).to(String.class));
    }

    @Test
    public void fromIntEnabledAndComposition() {
        final Capacitor capacitor = createCapacitor(Feature.AUTOBOXING, Feature.COMPOSITION);
        Assert.assertEquals("12345", capacitor.convert(12345, int.class).to(String.class));
    }

    @Test
    public void fromLongEnabledAndComposition() {
        final Capacitor capacitor = createCapacitor(Feature.AUTOBOXING, Feature.COMPOSITION);
        final String to = capacitor.convert(12345L, long.class).to(String.class);
        Assert.assertEquals("12345", to);
    }

    @Test
    public void fromShortEnabledAndComposition() {
        final Capacitor capacitor = createCapacitor(Feature.AUTOBOXING, Feature.COMPOSITION);
        Assert.assertEquals("12345", capacitor.convert((short) 12345, short.class).to(String.class));
    }

    @Test(expected = UnknownConversionException.class)
    public void fromBooleanDisabled() {
        final Capacitor capacitor = createCapacitor();
        Assert.assertEquals("true", capacitor.convert(true, boolean.class).to(String.class));
    }

    @Test(expected = UnknownConversionException.class)
    public void fromByteDisabled() {
        final Capacitor capacitor = createCapacitor();
        Assert.assertEquals("127", capacitor.convert((byte) 127, byte.class).to(String.class));
    }

    @Test(expected = UnknownConversionException.class)
    public void fromCharDisabled() {
        final Capacitor capacitor = createCapacitor();
        Assert.assertEquals("a", capacitor.convert('a', char.class).to(String.class));
    }

    @Test(expected = UnknownConversionException.class)
    public void fromDoubleDisabled() {
        final Capacitor capacitor = createCapacitor();
        Assert.assertEquals("12345.0", capacitor.convert(12345d, double.class).to(String.class));
    }

    @Test(expected = UnknownConversionException.class)
    public void fromFloatDisabled() {
        final Capacitor capacitor = createCapacitor();
        Assert.assertEquals("12345.0", capacitor.convert(12345f, float.class).to(String.class));
    }

    @Test(expected = UnknownConversionException.class)
    public void fromIntDisabled() {
        final Capacitor capacitor = createCapacitor();
        Assert.assertEquals("12345", capacitor.convert(12345, int.class).to(String.class));
    }

    @Test(expected = UnknownConversionException.class)
    public void fromLongDisabled() {
        final Capacitor capacitor = createCapacitor();
        final String to = capacitor.convert(12345L, long.class).to(String.class);
        Assert.assertEquals("12345", to);
    }

    @Test(expected = UnknownConversionException.class)
    public void fromShortDisabled() {
        final Capacitor capacitor = createCapacitor();
        Assert.assertEquals("12345", capacitor.convert((short) 12345, short.class).to(String.class));
    }

}
