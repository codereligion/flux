package org.whiskeysierra.flux.direct;

import org.whiskeysierra.flux.FeatureSet;
import org.whiskeysierra.flux.spi.AbstractConverterMappingTest;
import org.whiskeysierra.flux.spi.ConverterMapping;

public final class DirectConverterMappingTest extends AbstractConverterMappingTest {

    @Override
    public ConverterMapping unit(FeatureSet features) {
        return new DirectConverterMapping(features);
    }

}
