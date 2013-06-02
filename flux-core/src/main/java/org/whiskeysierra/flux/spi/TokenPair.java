package org.whiskeysierra.flux.spi;

import com.google.common.base.Preconditions;
import com.google.common.reflect.TypeToken;

final class TokenPair<I, O> {

    private final TypeToken<I> input;
    private final TypeToken<O> output;

    TokenPair(TypeToken<I> input, TypeToken<O> output) {
        this.input = Preconditions.checkNotNull(input, "Input");
        this.output = Preconditions.checkNotNull(output, "Output");
    }

    TypeToken<I> getInput() {
        return input;
    }

    TypeToken<O> getOutput() {
        return output;
    }

}
