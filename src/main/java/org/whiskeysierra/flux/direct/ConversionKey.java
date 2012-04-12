package org.whiskeysierra.flux.direct;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.reflect.TypeToken;
import org.whiskeysierra.flux.Converter;

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
        final TypeToken<?> token = TypeToken.of(converter.getClass()).getSupertype(Converter.class);

        final TypeVariable<Class<Converter>>[] typeParameters = Converter.class.getTypeParameters();

        @SuppressWarnings("unchecked")
        final TypeToken<I> input = (TypeToken<I>) token.resolveType(typeParameters[0]);

        @SuppressWarnings("unchecked")
        final TypeToken<O> output = (TypeToken<O>) token.resolveType(typeParameters[1]);

        return new ConversionKey<I, O>(input, output);
    }

    public static <I, O> ConversionKey<I, O> of(TypeToken<I> input, TypeToken<O> output) {
        return new ConversionKey<I, O>(input, output);
    }

}
