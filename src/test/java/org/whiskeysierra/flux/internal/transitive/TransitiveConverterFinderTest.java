package org.whiskeysierra.flux.internal.transitive;

import org.whiskeysierra.flux.FeatureSet;
import org.whiskeysierra.flux.Key;
import org.whiskeysierra.flux.internal.AbstractConverterFinderTest;
import org.whiskeysierra.flux.internal.ConverterFinder;
import org.whiskeysierra.flux.spi.Converter;

import java.util.Map;

public final class TransitiveConverterFinderTest extends AbstractConverterFinderTest {

    @Override
    protected ConverterFinder unit(FeatureSet features, Map<Key<?, ?>, Converter<?, ?>> mapping) {
        return new TransitiveConverterFinder(features, mapping);
    }

}
