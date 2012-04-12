package org.whiskeysierra.flux;

import com.google.common.base.Optional;
import com.google.common.reflect.TypeToken;

public final class DefaultConvertable<I> extends AbstractConvertable {

    private final Conversion conversion;
    private final I input;

    public DefaultConvertable(I input, Conversion conversion) {
        this.conversion = conversion;
        this.input = input;
    }

    @Override
    public Optional<Object> raw() {
        return Optional.<Object>of(input);
    }

    @Override
    public <O> Optional<O> tryTo(TypeToken<O> output) {
        return Optional.fromNullable(conversion.<I, O>run(input, output));
    }

}
