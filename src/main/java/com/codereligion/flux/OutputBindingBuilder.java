package com.codereligion.flux;

import com.codereligion.flux.spi.Converter;

public interface OutputBindingBuilder<I, O> {

    void using(Converter<I, O> converter);

}
