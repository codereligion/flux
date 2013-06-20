package com.codereligion.flux;

import com.google.common.reflect.TypeToken;
import com.codereligion.flux.spi.Converter;

public interface Convert {

    void install(Bundle bundle);

    <I> InputBindingBuilder<I> from(Class<I> input);

    <I> InputBindingBuilder<I> from(TypeToken<I> input);

    <I, O> void using(Converter<I, O> converter);

}
