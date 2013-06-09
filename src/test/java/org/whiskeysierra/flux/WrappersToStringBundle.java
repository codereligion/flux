package org.whiskeysierra.flux;

import com.google.common.primitives.Primitives;
import org.whiskeysierra.flux.converters.base.ObjectToStringConverter;

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
