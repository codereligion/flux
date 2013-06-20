package com.codereligion.flux;

import com.google.common.base.Preconditions;
import com.codereligion.flux.internal.BindingCollector;
import com.codereligion.flux.internal.ConverterFinder;
import com.codereligion.flux.internal.direct.DirectConverterFinder;
import com.codereligion.flux.internal.transitive.TransitiveConverterFinder;
import com.codereligion.flux.spi.Converter;

import java.util.Map;

public final class Flux {

    private Flux() {

    }

    public static Capacitor createCapacitor(Bundle... bundles) {
        return createCapacitor(Features.defaults(), bundles);
    }

    public static Capacitor createCapacitor(FeatureSet features, Bundle... bundles) {
        Preconditions.checkNotNull(features, "Features");
        Preconditions.checkNotNull(bundles, "Bundles");

        final BindingCollector collector = new BindingCollector();

        for (Bundle bundle : bundles) {
            collector.install(bundle);
        }

        final Map<Key<?, ?>, Converter<?, ?>> mapping = collector.getMapping();

        final ConverterFinder finder = createFinder(features, mapping);
        return new DefaultCapacitor(features, finder);
    }

    private static ConverterFinder createFinder(FeatureSet features, Map<Key<?, ?>, Converter<?, ?>> mapping) {
        if (features.contains(Feature.TRANSITIVE)) {
            return new TransitiveConverterFinder(features, mapping);
        } else {
            return new DirectConverterFinder(features, mapping);
        }
    }

}
