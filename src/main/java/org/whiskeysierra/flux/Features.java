package org.whiskeysierra.flux;

import com.google.common.base.Preconditions;
import com.google.common.collect.Iterables;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.Set;

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
        final Set<Feature> set = EnumSet.noneOf(Feature.class);
        Iterables.addAll(set, features);
        return new DefaultFeatureSet(set);
    }

}
