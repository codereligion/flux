package org.whiskeysierra.flux;

import javax.annotation.Nullable;

public final class DefaultConvertableFactory extends AbstractConvertableFactory {

    private final ConverterMapping mapping;

    public DefaultConvertableFactory(ConverterMapping mapping) {
        this.mapping = mapping;
    }

    @Override
    public Convertable apply(@Nullable Object input) {
        if (input == null) {
            return NullConvertable.INSTANCE;
        } else {
            return new DefaultConvertable(mapping, input);
        }
    }

}
