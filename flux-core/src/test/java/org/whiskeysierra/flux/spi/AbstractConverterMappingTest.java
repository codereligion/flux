package org.whiskeysierra.flux.spi;

import com.google.common.reflect.TypeToken;
import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Test;
import org.whiskeysierra.flux.Capacitor;
import org.whiskeysierra.flux.Feature;
import org.whiskeysierra.flux.FeatureSet;
import org.whiskeysierra.flux.Features;
import org.whiskeysierra.flux.converters.base.ObjectToStringConverter;
import org.whiskeysierra.flux.direct.DirectConverterMapping;

import javax.annotation.Nullable;
import java.util.List;

public abstract class AbstractConverterMappingTest {

    private final Converter<Object, Object> converter = new Converter<Object, Object>() {

        @Nullable
        @Override
        public <V extends Object> Object convert(V input, TypeToken<V> type, Capacitor capacitor) {
            throw new AssertionError("Called MockConverter.convert(..)");
        }

    };

    private final Class<Object> nullType = null;
    private final TypeToken<Object> nullToken = null;

    private final Class<Object> type = Object.class;
    private final TypeToken<Object> token = TypeToken.of(Object.class);

    protected final ConverterMapping unit() {
        return unit(Features.defaults());
    }

    protected abstract ConverterMapping unit(FeatureSet features);

    @Test(expected = NullPointerException.class)
    public void registerConverterNullConverter() {
        unit().register(null);
    }

    @Test(expected = NullPointerException.class)
    public void registerClassClassConverterNullInput() {
        unit().register(nullType, Object.class, converter);
    }

    @Test(expected = NullPointerException.class)
    public void registerClassClassConverterNullOutput() {
        unit().register(Object.class, nullType, converter);
    }

    @Test(expected = NullPointerException.class)
    public void registerClassClassConverterNullConverter() {
        unit().register(Object.class, Object.class, null);
    }

    @Test(expected = NullPointerException.class)
    public void registerClassClassConverterNullInputNullOutput() {
        unit().register(nullType, nullType, converter);
    }

    @Test(expected = NullPointerException.class)
    public void registerClassClassConverterNullOutputNullConverter() {
        unit().register(Object.class, nullType, null);
    }

    @Test(expected = NullPointerException.class)
    public void registerClassClassConverterNullInputNullConverter() {
        unit().register(nullType, Object.class, null);
    }

    @Test(expected = NullPointerException.class)
    public void registerClassClassConverterNullInputNullOutputNullConverter() {
        unit().register(nullType, nullType, null);
    }

    @Test(expected = NullPointerException.class)
    public void registerClassTokenConverterNullInput() {
        unit().register(nullType, token, converter);
    }

    @Test(expected = NullPointerException.class)
    public void registerClassTokenConverterNullOutput() {
        unit().register(type, nullToken, converter);
    }

    @Test(expected = NullPointerException.class)
    public void registerClassTokenConverterNullConverter() {
        unit().register(type, token, null);
    }

    @Test(expected = NullPointerException.class)
    public void registerClassTokenConverterNullInputNullOutput() {
        unit().register(nullType, nullToken, converter);
    }

    @Test(expected = NullPointerException.class)
    public void registerClassTokenConverterNullInputNullConverter() {
        unit().register(nullType, token, null);
    }

    @Test(expected = NullPointerException.class)
    public void registerClassTokenConverterNullOutputNullConverter() {
        unit().register(type, nullToken, null);
    }

    @Test(expected = NullPointerException.class)
    public void registerClassTokenConverterNullInputNullOutputNullConverter() {
        unit().register(nullType, nullToken, null);
    }

    @Test(expected = NullPointerException.class)
    public void registerTokenClassConverterNullInput() {
        unit().register(nullToken, type, converter);
    }

    @Test(expected = NullPointerException.class)
    public void registerTokenClassConverterNullOutput() {
        unit().register(token, nullType, converter);
    }

    @Test(expected = NullPointerException.class)
    public void registerTokenClassConverterNullConverter() {
        unit().register(token, type, null);
    }

    @Test(expected = NullPointerException.class)
    public void registerTokenClassConverterNullInputNullOutput() {
        unit().register(nullToken, nullType, converter);
    }

    @Test(expected = NullPointerException.class)
    public void registerTokenClassConverterNullInputNullConverter() {
        unit().register(nullToken, type, null);
    }

    @Test(expected = NullPointerException.class)
    public void registerTokenClassConverterNullOutputNullConverter() {
        unit().register(token, nullType, null);
    }

    @Test(expected = NullPointerException.class)
    public void registerTokenClassConverterNullInputNullOutputNullConverter() {
        unit().register(nullToken, nullType, null);
    }

    @Test(expected = NullPointerException.class)
    public void registerTokenTokenConverterNullInput() {
        unit().register(nullToken, token, converter);
    }

    @Test(expected = NullPointerException.class)
    public void registerTokenTokenConverterNullOutput() {
        unit().register(token, nullToken, converter);
    }

    @Test(expected = NullPointerException.class)
    public void registerTokenTokenConverterNullConverter() {
        unit().register(token, token, null);
    }

    @Test(expected = NullPointerException.class)
    public void registerTokenTokenConverterNullInputNullOutput() {
        unit().register(nullToken, nullToken, converter);
    }

    @Test(expected = NullPointerException.class)
    public void registerTokenTokenConverterNullInputNullConverter() {
        unit().register(nullToken, token, null);
    }

    @Test(expected = NullPointerException.class)
    public void registerTokenTokenConverterNullOutputNullConverter() {
        unit().register(token, nullToken, null);
    }

    @Test(expected = NullPointerException.class)
    public void registerTokenTokenConverterNullInputNullOutputNullConverter() {
        unit().register(nullToken, nullToken, null);
    }

    @Test(expected = NullPointerException.class)
    public void tryRegisterConverterNullConverter() {
        unit().tryRegister(null);
    }

    @Test(expected = NullPointerException.class)
    public void tryRegisterClassClassConverterNullInput() {
        unit().tryRegister(nullType, Object.class, converter);
    }

    @Test(expected = NullPointerException.class)
    public void tryRegisterClassClassConverterNullOutput() {
        unit().tryRegister(Object.class, nullType, converter);
    }

    @Test(expected = NullPointerException.class)
    public void tryRegisterClassClassConverterNullConverter() {
        unit().tryRegister(Object.class, Object.class, null);
    }

    @Test(expected = NullPointerException.class)
    public void tryRegisterClassClassConverterNullInputNullOutput() {
        unit().tryRegister(nullType, nullType, converter);
    }

    @Test(expected = NullPointerException.class)
    public void tryRegisterClassClassConverterNullOutputNullConverter() {
        unit().tryRegister(Object.class, nullType, null);
    }

    @Test(expected = NullPointerException.class)
    public void tryRegisterClassClassConverterNullInputNullConverter() {
        unit().tryRegister(nullType, Object.class, null);
    }

    @Test(expected = NullPointerException.class)
    public void tryRegisterClassClassConverterNullInputNullOutputNullConverter() {
        unit().tryRegister(nullType, nullType, null);
    }

    @Test(expected = NullPointerException.class)
    public void tryRegisterClassTokenConverterNullInput() {
        unit().tryRegister(nullType, token, converter);
    }

    @Test(expected = NullPointerException.class)
    public void tryRegisterClassTokenConverterNullOutput() {
        unit().tryRegister(type, nullToken, converter);
    }

    @Test(expected = NullPointerException.class)
    public void tryRegisterClassTokenConverterNullConverter() {
        unit().tryRegister(type, token, null);
    }

    @Test(expected = NullPointerException.class)
    public void tryRegisterClassTokenConverterNullInputNullOutput() {
        unit().tryRegister(nullType, nullToken, converter);
    }

    @Test(expected = NullPointerException.class)
    public void tryRegisterClassTokenConverterNullInputNullConverter() {
        unit().tryRegister(nullType, token, null);
    }

    @Test(expected = NullPointerException.class)
    public void tryRegisterClassTokenConverterNullOutputNullConverter() {
        unit().tryRegister(type, nullToken, null);
    }

    @Test(expected = NullPointerException.class)
    public void tryRegisterClassTokenConverterNullInputNullOutputNullConverter() {
        unit().tryRegister(nullType, nullToken, null);
    }

    @Test(expected = NullPointerException.class)
    public void tryRegisterTokenClassConverterNullInput() {
        unit().tryRegister(nullToken, type, converter);
    }

    @Test(expected = NullPointerException.class)
    public void tryRegisterTokenClassConverterNullOutput() {
        unit().tryRegister(token, nullType, converter);
    }

    @Test(expected = NullPointerException.class)
    public void tryRegisterTokenClassConverterNullConverter() {
        unit().tryRegister(token, type, null);
    }

    @Test(expected = NullPointerException.class)
    public void tryRegisterTokenClassConverterNullInputNullOutput() {
        unit().tryRegister(nullToken, nullType, converter);
    }

    @Test(expected = NullPointerException.class)
    public void tryRegisterTokenClassConverterNullInputNullConverter() {
        unit().tryRegister(nullToken, type, null);
    }

    @Test(expected = NullPointerException.class)
    public void tryRegisterTokenClassConverterNullOutputNullConverter() {
        unit().tryRegister(token, nullType, null);
    }

    @Test(expected = NullPointerException.class)
    public void tryRegisterTokenClassConverterNullInputNullOutputNullConverter() {
        unit().tryRegister(nullToken, nullType, null);
    }

    @Test(expected = NullPointerException.class)
    public void tryRegisterTokenTokenConverterNullInput() {
        unit().tryRegister(nullToken, token, converter);
    }

    @Test(expected = NullPointerException.class)
    public void tryRegisterTokenTokenConverterNullOutput() {
        unit().tryRegister(token, nullToken, converter);
    }

    @Test(expected = NullPointerException.class)
    public void tryRegisterTokenTokenConverterNullConverter() {
        unit().tryRegister(token, token, null);
    }

    @Test(expected = NullPointerException.class)
    public void tryRegisterTokenTokenConverterNullInputNullOutput() {
        unit().tryRegister(nullToken, nullToken, converter);
    }

    @Test(expected = NullPointerException.class)
    public void tryRegisterTokenTokenConverterNullInputNullConverter() {
        unit().tryRegister(nullToken, token, null);
    }

    @Test(expected = NullPointerException.class)
    public void tryRegisterTokenTokenConverterNullOutputNullConverter() {
        unit().tryRegister(token, nullToken, null);
    }

    @Test(expected = NullPointerException.class)
    public void tryRegisterTokenTokenConverterNullInputNullOutputNullConverter() {
        unit().tryRegister(nullToken, nullToken, null);
    }

    @Test(expected = NullPointerException.class)
    public void forceRegisterConverterNullConverter() {
        unit().forceRegister(null);
    }

    @Test(expected = NullPointerException.class)
    public void forceRegisterClassClassConverterNullInput() {
        unit().forceRegister(nullType, Object.class, converter);
    }

    @Test(expected = NullPointerException.class)
    public void forceRegisterClassClassConverterNullOutput() {
        unit().forceRegister(Object.class, nullType, converter);
    }

    @Test(expected = NullPointerException.class)
    public void forceRegisterClassClassConverterNullConverter() {
        unit().forceRegister(Object.class, Object.class, null);
    }

    @Test(expected = NullPointerException.class)
    public void forceRegisterClassClassConverterNullInputNullOutput() {
        unit().forceRegister(nullType, nullType, converter);
    }

    @Test(expected = NullPointerException.class)
    public void forceRegisterClassClassConverterNullOutputNullConverter() {
        unit().forceRegister(Object.class, nullType, null);
    }

    @Test(expected = NullPointerException.class)
    public void forceRegisterClassClassConverterNullInputNullConverter() {
        unit().forceRegister(nullType, Object.class, null);
    }

    @Test(expected = NullPointerException.class)
    public void forceRegisterClassClassConverterNullInputNullOutputNullConverter() {
        unit().forceRegister(nullType, nullType, null);
    }

    @Test(expected = NullPointerException.class)
    public void forceRegisterClassTokenConverterNullInput() {
        unit().forceRegister(nullType, token, converter);
    }

    @Test(expected = NullPointerException.class)
    public void forceRegisterClassTokenConverterNullOutput() {
        unit().forceRegister(type, nullToken, converter);
    }

    @Test(expected = NullPointerException.class)
    public void forceRegisterClassTokenConverterNullConverter() {
        unit().forceRegister(type, token, null);
    }

    @Test(expected = NullPointerException.class)
    public void forceRegisterClassTokenConverterNullInputNullOutput() {
        unit().forceRegister(nullType, nullToken, converter);
    }

    @Test(expected = NullPointerException.class)
    public void forceRegisterClassTokenConverterNullInputNullConverter() {
        unit().forceRegister(nullType, token, null);
    }

    @Test(expected = NullPointerException.class)
    public void forceRegisterClassTokenConverterNullOutputNullConverter() {
        unit().forceRegister(type, nullToken, null);
    }

    @Test(expected = NullPointerException.class)
    public void forceRegisterClassTokenConverterNullInputNullOutputNullConverter() {
        unit().forceRegister(nullType, nullToken, null);
    }

    @Test(expected = NullPointerException.class)
    public void forceRegisterTokenClassConverterNullInput() {
        unit().forceRegister(nullToken, type, converter);
    }

    @Test(expected = NullPointerException.class)
    public void forceRegisterTokenClassConverterNullOutput() {
        unit().forceRegister(token, nullType, converter);
    }

    @Test(expected = NullPointerException.class)
    public void forceRegisterTokenClassConverterNullConverter() {
        unit().forceRegister(token, type, null);
    }

    @Test(expected = NullPointerException.class)
    public void forceRegisterTokenClassConverterNullInputNullOutput() {
        unit().forceRegister(nullToken, nullType, converter);
    }

    @Test(expected = NullPointerException.class)
    public void forceRegisterTokenClassConverterNullInputNullConverter() {
        unit().forceRegister(nullToken, type, null);
    }

    @Test(expected = NullPointerException.class)
    public void forceRegisterTokenClassConverterNullOutputNullConverter() {
        unit().forceRegister(token, nullType, null);
    }

    @Test(expected = NullPointerException.class)
    public void forceRegisterTokenClassConverterNullInputNullOutputNullConverter() {
        unit().forceRegister(nullToken, nullType, null);
    }

    @Test(expected = NullPointerException.class)
    public void forceRegisterTokenTokenConverterNullInput() {
        unit().forceRegister(nullToken, token, converter);
    }

    @Test(expected = NullPointerException.class)
    public void forceRegisterTokenTokenConverterNullOutput() {
        unit().forceRegister(token, nullToken, converter);
    }

    @Test(expected = NullPointerException.class)
    public void forceRegisterTokenTokenConverterNullConverter() {
        unit().forceRegister(token, token, null);
    }

    @Test(expected = NullPointerException.class)
    public void forceRegisterTokenTokenConverterNullInputNullOutput() {
        unit().forceRegister(nullToken, nullToken, converter);
    }

    @Test(expected = NullPointerException.class)
    public void forceRegisterTokenTokenConverterNullInputNullConverter() {
        unit().forceRegister(nullToken, token, null);
    }

    @Test(expected = NullPointerException.class)
    public void forceRegisterTokenTokenConverterNullOutputNullConverter() {
        unit().forceRegister(token, nullToken, null);
    }

    @Test(expected = NullPointerException.class)
    public void forceRegisterTokenTokenConverterNullInputNullOutputNullConverter() {
        unit().forceRegister(nullToken, nullToken, null);
    }

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
    public void searchSimple() {
        final ConverterMapping unit = unit();
        final Converter<Object, String> converter = new ObjectToStringConverter();
        unit.register(converter);

        final TypeToken<Object> input = TypeToken.of(Object.class);
        final TypeToken<String> output = TypeToken.of(String.class);

        Assert.assertSame(converter, unit.search(input, output));
    }

    @Test
    public void searchGeneric() {
        final ConverterMapping mapping = new DirectConverterMapping(Features.defaults());

        final Converter<String, List<String>> converter = new Converter<String, List<String>>() {

            @Nullable
            @Override
            public <V extends String> List<String> convert(@Nullable V input, TypeToken<V> type, Capacitor capacitor) {
                throw new UnsupportedOperationException();
            }

        };

        mapping.register(converter);

        final TypeToken<String> input = TypeToken.of(String.class);
        final TypeToken<List<String>> output = new TypeToken<List<String>>() {
        };

        Assert.assertSame(converter, mapping.search(input, output));
    }

    @Test
    public void searchSubType() {
        final ConverterMapping unit = unit(Features.of(Feature.SUB_TYPING));

        @SuppressWarnings("unchecked")
        final Converter<Number, String> converter = EasyMock.createMock(Converter.class);
        EasyMock.replay(converter);
        unit.register(Number.class, String.class, converter);

        final Converter<Integer, String> found = unit.search(Integer.class, String.class);
        Assert.assertNotNull("Expected to find 'Number -> String' when querying " +
                "for 'Integer -> String'", found);

        EasyMock.verify(converter);
    }

    @Test
    public void searchSuperType() {
        final ConverterMapping unit = unit(Features.of(Feature.SUPER_TYPING));

        @SuppressWarnings("unchecked")
        final Converter<Number, String> converter = EasyMock.createMock(Converter.class);
        EasyMock.replay(converter);
        unit.register(Number.class, String.class, converter);

        final Converter<Number, Object> found = unit.search(Number.class, Object.class);
        Assert.assertNotNull("Expected to find 'Number -> String' when querying " +
                "for 'Number -> Object'", found);

        EasyMock.verify(converter);
    }

    @Test
    public void searchSubTypeAndSuperType() {
        final ConverterMapping unit = unit(Features.of(Feature.SUB_TYPING, Feature.SUPER_TYPING));

        @SuppressWarnings("unchecked")
        final Converter<Number, String> converter = EasyMock.createMock(Converter.class);
        EasyMock.replay(converter);
        unit.register(Number.class, String.class, converter);

        final Converter<Integer, Object> found = unit.search(Integer.class, Object.class);
        Assert.assertNotNull("Expected to find 'Number -> String' when querying " +
                "for 'Integer -> Object'", found);

        EasyMock.verify(converter);

    }

}
