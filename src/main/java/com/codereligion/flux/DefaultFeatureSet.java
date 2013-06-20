package com.codereligion.flux;

import com.google.common.base.Preconditions;
import com.google.common.collect.ForwardingSet;

import java.util.Set;

final class DefaultFeatureSet extends ForwardingSet<Feature> implements FeatureSet {

    private final Set<Feature> features;

    public DefaultFeatureSet(Set<Feature> features) {
        this.features = Preconditions.checkNotNull(features, "Features");
    }

    @Override
    protected Set<Feature> delegate() {
        return features;
    }

}
