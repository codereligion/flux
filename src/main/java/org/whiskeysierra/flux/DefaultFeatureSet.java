package org.whiskeysierra.flux;

import com.google.common.base.Preconditions;
import com.google.common.collect.ForwardingSet;
import com.google.common.collect.ImmutableSet;

import java.util.Set;

final class DefaultFeatureSet extends ForwardingSet<Feature> implements FeatureSet {

    private final ImmutableSet<Feature> features;

    public DefaultFeatureSet(ImmutableSet<Feature> features) {
        this.features = Preconditions.checkNotNull(features, "Features");
    }

    @Override
    protected Set<Feature> delegate() {
        return features;
    }

}
