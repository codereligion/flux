package org.whiskeysierra.flux.internal;

import com.google.common.collect.ImmutableMap;
import com.google.common.reflect.TypeToken;
import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Test;
import org.whiskeysierra.flux.Capacitor;
import org.whiskeysierra.flux.Feature;
import org.whiskeysierra.flux.FeatureSet;
import org.whiskeysierra.flux.Features;
import org.whiskeysierra.flux.Key;
import org.whiskeysierra.flux.converters.base.ObjectToStringConverter;
import org.whiskeysierra.flux.internal.direct.DirectConverterFinder;
import org.whiskeysierra.flux.spi.Converter;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public abstract class AbstractConverterFinderTest {

    private final Class<Object> nullType = null;
    private final TypeToken<Object> nullToken = null;

    private final Class<Object> type = Object.class;
    private final TypeToken<Object> token = TypeToken.of(Object.class);

    protected final ConverterFinder unit() {
        return unit(Features.defaults(), Collections.<Key<?, ?>, Converter<?, ?>>emptyMap());
    }

    protected final ConverterFinder unit(Map<Key<?, ?>, Converter<?, ?>> mapping) {
        return unit(Features.defaults(), mapping);
    }

    protected abstract ConverterFinder unit(FeatureSet features, Map<Key<?, ?>, Converter<?, ?>> mapping);

    @Test(expected = NullPointerException.class)
    public void searchClassClassNullInput() {
        unit().search(nullType, type);
    }

    @Test(expected = NullPointerException.class)
    public void searchClassClassNullOutput() {
        unit().search(type, nullType);
    }

    @Test(expected = NullPointerException.class)
    public void searchClassClassNullInputNullOutput() {
        unit().search(nullType, nullType);
    }

    @Test(expected = NullPointerException.class)
    public void searchClassTokenNullInput() {
        unit().search(nullType, token);
    }

    @Test(expected = NullPointerException.class)
    public void searchClassTokenNullOutput() {
        unit().search(type, nullToken);
    }

    @Test(expected = NullPointerException.class)
    public void searchClassTokenNullInputNullOutput() {
        unit().search(nullType, nullToken);
    }

    @Test(expected = NullPointerException.class)
    public void searchTokenClassNullInput() {
        unit().search(nullToken, type);
    }

    @Test(expected = NullPointerException.class)
    public void searchTokenClassNullOutput() {
        unit().search(token, nullType);
    }

    @Test(expected = NullPointerException.class)
    public void searchTokenClassNullInputNullOutput() {
        unit().search(nullToken, nullType);
    }

    @Test(expected = NullPointerException.class)
    public void searchTokenTokenNullInput() {
        unit().search(nullToken, token);
    }

    @Test(expected = NullPointerException.class)
    public void searchTokenTokenNullOutput() {
        unit().search(token, nullToken);
    }

    @Test(expected = NullPointerException.class)
    public void searchTokenTokenNullInputNullOutput() {
        unit().search(nullToken, nullToken);
    }

    @Test
    public void searchMissing() {
        final ConverterFinder unit = unit(ImmutableMap.<Key<?, ?>, Converter<?, ?>>of());
        Assert.assertNull(unit.search(Object.class, String.class));
    }

    @Test
    public void searchSimple() {
        final Converter<Object, String> converter = new ObjectToStringConverter();

        final ConverterFinder unit = unit(ImmutableMap.<Key<?, ?>, Converter<?, ?>>of(
            Key.of(Object.class, String.class), converter
        ));

        final TypeToken<Object> input = TypeToken.of(Object.class);
        final TypeToken<String> output = TypeToken.of(String.class);

        Assert.assertSame(converter, unit.search(input, output));
    }

    @Test
    public void searchGeneric() {
        final Converter<String, List<String>> converter = new Converter<String, List<String>>() {

            @Nullable
            @Override
            public <V extends String> List<String> convert(@Nullable V input, TypeToken<V> type, Capacitor capacitor) {
                throw new UnsupportedOperationException();
            }

        };

        final ConverterFinder mapping = new DirectConverterFinder(Features.defaults(),
            ImmutableMap.<Key<?, ?>, Converter<?, ?>>of(
                Key.of(String.class, new TypeToken<List<String>>() {}), converter
            ));


        final TypeToken<String> input = TypeToken.of(String.class);
        final TypeToken<List<String>> output = new TypeToken<List<String>>() {
        };

        Assert.assertSame(converter, mapping.search(input, output));
    }

    @Test
    public void searchSubType() {
        @SuppressWarnings("unchecked")
        final Converter<Number, String> converter = EasyMock.createMock(Converter.class);
        EasyMock.replay(converter);

        final ConverterFinder unit = unit(Features.of(Feature.SUB_TYPING), ImmutableMap.<Key<?, ?>, Converter<?, ?>>of(
            Key.of(Number.class, String.class), converter
        ));


        final Converter<Integer, String> found = unit.search(Integer.class, String.class);
        Assert.assertNotNull("Expected to find 'Number -> String' when querying " +
            "for 'Integer -> String'", found);

        EasyMock.verify(converter);
    }

    @Test
    public void searchSuperType() {
        @SuppressWarnings("unchecked")
        final Converter<Number, String> converter = EasyMock.createMock(Converter.class);
        EasyMock.replay(converter);

        final ConverterFinder unit = unit(Features.of(Feature.SUPER_TYPING), ImmutableMap.<Key<?, ?>, Converter<?, ?>>of(
            Key.of(Number.class, String.class), converter
        ));

        final Converter<Number, Object> found = unit.search(Number.class, Object.class);
        Assert.assertNotNull("Expected to find 'Number -> String' when querying " +
            "for 'Number -> Object'", found);

        EasyMock.verify(converter);
    }

    @Test
    public void searchSubTypeAndSuperType() {
        @SuppressWarnings("unchecked")
        final Converter<Number, String> converter = EasyMock.createMock(Converter.class);
        EasyMock.replay(converter);

        final ConverterFinder unit = unit(Features.of(Feature.SUB_TYPING, Feature.SUPER_TYPING),
            ImmutableMap.<Key<?, ?>, Converter<?, ?>>of(
                Key.of(Number.class, String.class), converter
            ));

        final Converter<Integer, Object> found = unit.search(Integer.class, Object.class);
        Assert.assertNotNull("Expected to find 'Number -> String' when querying " +
            "for 'Integer -> Object'", found);

        EasyMock.verify(converter);
    }

}
