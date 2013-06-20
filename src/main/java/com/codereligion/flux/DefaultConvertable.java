package com.codereligion.flux;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.reflect.TypeToken;

import javax.annotation.Nullable;

final class DefaultConvertable<I> extends AbstractConvertable {

    private final I value;
    private final TypeToken<I> input;
    private final Conversion conversion;

    public DefaultConvertable(@Nullable I value, TypeToken<I> input, Conversion conversion) {
        this.value = value;
        this.input = Preconditions.checkNotNull(input, "Input");
        this.conversion = Preconditions.checkNotNull(conversion, "Conversion");
    }

    @Override
    public Object raw() {
        return value;
    }

    @Override
    public <O> Optional<O> tryTo(TypeToken<O> output) {
        Preconditions.checkNotNull(output, "Output");
        return conversion.run(value, input, output);
    }

}
