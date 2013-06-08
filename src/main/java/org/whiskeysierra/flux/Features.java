package org.whiskeysierra.flux;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;

import java.util.Arrays;

public final class Features {

    private Features() {

    }

    public static FeatureSet defaults() {
        return of(Feature.SUPER_TYPING, Feature.SUB_TYPING, Feature.IDENTITY);
    }

    public static FeatureSet of(Feature... features) {
        Preconditions.checkNotNull(features, "Features");
        return of(Arrays.asList(features));
    }

    private static FeatureSet of(Iterable<Feature> features) {
        Preconditions.checkNotNull(features, "Features");
        final ImmutableSet<Feature> set = Sets.immutableEnumSet(features);
        return new DefaultFeatureSet(set);
    }
}
