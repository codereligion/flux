package org.codereligion.flux;

import com.codereligion.flux.Bundle;
import com.codereligion.flux.Convert;
import com.google.common.primitives.Primitives;
import com.codereligion.flux.converters.base.ObjectToStringConverter;

public final class WrappersToStringBundle implements Bundle {

    @Override
    public void configure(Convert convert) {
        for (Class<?> type : Primitives.allWrapperTypes()) {
            @SuppressWarnings("unchecked")
            final Class<Object> input = (Class<Object>) type;
            convert.from(input).to(String.class).using(new ObjectToStringConverter());
        }
    }

}
