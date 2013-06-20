package org.codereligion.flux.internal.direct;

import com.codereligion.flux.FeatureSet;
import com.codereligion.flux.Key;
import com.codereligion.flux.internal.direct.DirectConverterFinder;
import org.codereligion.flux.internal.AbstractConverterFinderTest;
import com.codereligion.flux.internal.ConverterFinder;
import com.codereligion.flux.spi.Converter;

import java.util.Map;

public final class DirectConverterFinderTest extends AbstractConverterFinderTest {

    @Override
    protected ConverterFinder unit(FeatureSet features, Map<Key<?, ?>, Converter<?, ?>> mapping) {
        return new DirectConverterFinder(features, mapping);
    }

}
