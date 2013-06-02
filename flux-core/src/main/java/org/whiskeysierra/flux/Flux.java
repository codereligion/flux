package org.whiskeysierra.flux;

import com.google.common.base.Preconditions;
import org.whiskeysierra.flux.direct.DirectConverterMapping;
import org.whiskeysierra.flux.spi.ConverterMapping;

public final class Flux {

    private Flux() {

    }

    public static ConverterMapping createMapping(FeatureSet features) {
        Preconditions.checkNotNull(features, "Features");
        return new DirectConverterMapping(features);
    }

    public static Capacitor createCapacitor() {
        return createCapacitor(Features.defaults());
    }

    private static Capacitor createCapacitor(FeatureSet features) {
        Preconditions.checkNotNull(features, "Features");
        final ConverterMapping mapping = createMapping(features);
        return new DefaultCapacitor(mapping, features);
    }

}
