package org.whiskeysierra.flux;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.reflect.TypeToken;

public final class Key<I, O> {

    private final TypeToken<I> input;

    private final TypeToken<O> output;
    private Key(TypeToken<I> input, TypeToken<O> output) {
        this.input = Preconditions.checkNotNull(input);
        this.output = Preconditions.checkNotNull(output);
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        } else if (that instanceof Key) {
            final Key<?, ?> other = Key.class.cast(that);
            return Objects.equal(input, other.input) && Objects.equal(output, other.output);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(input, output);
    }

    public TypeToken<I> getInput() {
        return input;
    }

    public TypeToken<O> getOutput() {
        return output;
    }

    @Override
    public String toString() {
        return input + " -> " + output;
    }

    public static <I, O> Key<I, O> of(Class<I> input, Class<O> output) {
        Preconditions.checkNotNull(input, "Input");
        Preconditions.checkNotNull(output, "Output");
        return of(TypeToken.of(input), TypeToken.of(output));
    }

    public static <I, O> Key<I, O> of(Class<I> input, TypeToken<O> output) {
        Preconditions.checkNotNull(input, "Input");
        Preconditions.checkNotNull(output, "Output");
        return of(TypeToken.of(input), output);
    }

    public static <I, O> Key<I, O> of(TypeToken<I> input, Class<O> output) {
        Preconditions.checkNotNull(input, "Input");
        Preconditions.checkNotNull(output, "Output");
        return of(input, TypeToken.of(output));
    }

    public static <I, O> Key<I, O> of(TypeToken<I> input, TypeToken<O> output) {
        Preconditions.checkNotNull(input, "Input");
        Preconditions.checkNotNull(output, "Output");
        return new Key<I, O>(input, output);
    }

}
