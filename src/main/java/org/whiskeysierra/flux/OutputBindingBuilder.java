package org.whiskeysierra.flux;

import org.whiskeysierra.flux.spi.Converter;

public interface OutputBindingBuilder<I, O> {

    void using(Converter<I, O> converter);

}
