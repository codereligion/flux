package org.whiskeysierra.flux;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.reflect.TypeToken;

import java.lang.reflect.TypeVariable;

final class ConversionKey<I, O> {

    private final TypeToken<I> input;
    private final TypeToken<O> output;

    private ConversionKey(TypeToken<I> input, TypeToken<O> output) {
        this.input = Preconditions.checkNotNull(input);
        this.output = Preconditions.checkNotNull(output);
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        } else if (getClass() == that.getClass()) {
            final ConversionKey other = ConversionKey.class.cast(that);
            return Objects.equal(input, other.input) && Objects.equal(output, other.output);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(input, output);
    }

    @Override
    public String toString() {
        return "ConversionKey[input=" + input + ", output=" + output + "]";
    }

    public static <I, O> ConversionKey<I, O> of(Converter<I, O> converter) {
        final Class<? extends Converter> type = converter.getClass();
        final TypeVariable<? extends Class<? extends Converter>>[] parameters = type.getTypeParameters();
        return of(new TypeToken<I>(parameters[0].getClass()) { }, new TypeToken<O>(parameters[1].getClass()) { });
    }

    public static <I, O> ConversionKey<I, O> of(TypeToken<I> input, TypeToken<O> output) {
        return new ConversionKey<I, O>(input, output);
    }

}
