package org.whiskeysierra.flux;

import com.google.common.base.Function;

import javax.annotation.Nullable;

public final class DefaultConvertableFactory implements ConvertableFactory {

    private final Conversion conversion;

    private Function<Object, Convertable> function = new Function<Object, Convertable>() {

        @Override
        public Convertable apply(@Nullable Object input) {
            return transform(input);
        }

    };

    public DefaultConvertableFactory(Conversion conversion) {
        this.conversion = conversion;
    }

    @Override
    public Convertable transform(@Nullable Object input) {
        if (input == null) {
            return NullConvertable.INSTANCE;
        } else {
            return new DefaultConvertable<Object>(input, conversion);
        }
    }

    @Override
    public Function<Object, Convertable> asFunction() {
        return function;
    }

}
