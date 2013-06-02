package org.whiskeysierra.flux.spi;

import com.google.common.base.Preconditions;
import com.google.common.reflect.TypeToken;

import java.lang.reflect.TypeVariable;

public abstract class AbstractConverterMapping implements ConverterMapping {

    private <I, O> TokenPair<I, O> extract(Converter<I, O> converter) {
        final TypeToken<?> token = TypeToken.of(converter.getClass()).getSupertype(Converter.class);
        final TypeVariable<Class<Converter>>[] typeParameters = Converter.class.getTypeParameters();

        @SuppressWarnings("unchecked")
        final TypeToken<I> input = (TypeToken<I>) token.resolveType(typeParameters[0]);

        @SuppressWarnings("unchecked")
        final TypeToken<O> output = (TypeToken<O>) token.resolveType(typeParameters[1]);

        return new TokenPair<I, O>(input, output);
    }

    @Override
    public <I, O> void register(Converter<I, O> converter) throws IllegalArgumentException {
        Preconditions.checkNotNull(converter, "Converter");
        final TokenPair<I, O> pair = extract(converter);
        register(pair.getInput(), pair.getOutput(), converter);
    }

    @Override
    public <I, O> void register(Class<I> input, Class<O> output, Converter<? super I, ? extends O> converter)
        throws IllegalArgumentException {
        Preconditions.checkNotNull(input, "Input");
        Preconditions.checkNotNull(output, "Output");
        Preconditions.checkNotNull(converter, "Converter");
        register(TypeToken.of(input), TypeToken.of(output), converter);
    }

    @Override
    public <I, O> void register(Class<I> input, TypeToken<O> output, Converter<? super I, ? extends O> converter)
        throws IllegalArgumentException {
        Preconditions.checkNotNull(input, "Input");
        Preconditions.checkNotNull(output, "Output");
        Preconditions.checkNotNull(converter, "Converter");
        register(TypeToken.of(input), output, converter);
    }

    @Override
    public <I, O> void register(TypeToken<I> input, Class<O> output, Converter<? super I, ? extends O> converter)
        throws IllegalArgumentException {
        Preconditions.checkNotNull(input, "Input");
        Preconditions.checkNotNull(output, "Output");
        Preconditions.checkNotNull(converter, "Converter");
        register(input, TypeToken.of(output), converter);
    }

    @Override
    public <I, O> void tryRegister(Converter<I, O> converter) {
        Preconditions.checkNotNull(converter, "Converter");
        final TokenPair<I, O> pair = extract(converter);
        tryRegister(pair.getInput(), pair.getOutput(), converter);
    }

    @Override
    public <I, O> void tryRegister(Class<I> input, Class<O> output, Converter<? super I, ? extends O> converter) {
        Preconditions.checkNotNull(input, "Input");
        Preconditions.checkNotNull(output, "Output");
        Preconditions.checkNotNull(converter, "Converter");
        tryRegister(TypeToken.of(input), TypeToken.of(output), converter);
    }

    @Override
    public <I, O> void tryRegister(Class<I> input, TypeToken<O> output, Converter<? super I, ? extends O> converter) {
        Preconditions.checkNotNull(input, "Input");
        Preconditions.checkNotNull(output, "Output");
        Preconditions.checkNotNull(converter, "Converter");
        tryRegister(TypeToken.of(input), output, converter);
    }

    @Override
    public <I, O> void tryRegister(TypeToken<I> input, Class<O> output, Converter<? super I, ? extends O> converter) {
        Preconditions.checkNotNull(input, "Input");
        Preconditions.checkNotNull(output, "Output");
        Preconditions.checkNotNull(converter, "Converter");
        tryRegister(input, TypeToken.of(output), converter);
    }

    @Override
    public <I, O> void forceRegister(Converter<I, O> converter) {
        Preconditions.checkNotNull(converter, "Converter");
        final TokenPair<I, O> pair = extract(converter);
        forceRegister(pair.getInput(), pair.getOutput(), converter);
    }

    @Override
    public <I, O> void forceRegister(Class<I> input, Class<O> output, Converter<? super I, ? extends O> converter) {
        Preconditions.checkNotNull(input, "Input");
        Preconditions.checkNotNull(output, "Output");
        Preconditions.checkNotNull(converter, "Converter");
        forceRegister(TypeToken.of(input), TypeToken.of(output), converter);
    }

    @Override
    public <I, O> void forceRegister(Class<I> input, TypeToken<O> output, Converter<? super I, ? extends O> converter) {
        Preconditions.checkNotNull(input, "Input");
        Preconditions.checkNotNull(output, "Output");
        Preconditions.checkNotNull(converter, "Converter");
        forceRegister(TypeToken.of(input), output, converter);
    }

    @Override
    public <I, O> void forceRegister(TypeToken<I> input, Class<O> output, Converter<? super I, ? extends O> converter) {
        Preconditions.checkNotNull(input, "Input");
        Preconditions.checkNotNull(output, "Output");
        Preconditions.checkNotNull(converter, "Converter");
        forceRegister(input, TypeToken.of(output), converter);
    }

    @Override
    public <I, O> Converter<I, O> search(Class<I> input, Class<O> output) {
        Preconditions.checkNotNull(input, "Input");
        Preconditions.checkNotNull(output, "Output");
        return search(TypeToken.of(input), TypeToken.of(output));
    }

    @Override
    public <I, O> Converter<I, O> search(Class<I> input, TypeToken<O> output) {
        Preconditions.checkNotNull(input, "Input");
        Preconditions.checkNotNull(output, "Output");
        return search(TypeToken.of(input), output);
    }

    @Override
    public <I, O> Converter<I, O> search(TypeToken<I> input, Class<O> output) {
        Preconditions.checkNotNull(input, "Input");
        Preconditions.checkNotNull(output, "Output");
        return search(input, TypeToken.of(output));
    }

}
