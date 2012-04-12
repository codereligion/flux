package org.whiskeysierra.flux;

public interface Converter<I, O> {

    O convert(I input, ConversionContext context);

}
