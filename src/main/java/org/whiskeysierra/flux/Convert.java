package org.whiskeysierra.flux;

import com.google.common.reflect.TypeToken;
import org.whiskeysierra.flux.spi.Converter;

public interface Convert {

    <I> InputBindingBuilder<I> from(Class<I> input);

    <I> InputBindingBuilder<I> from(TypeToken<I> input);

    <I, O> void using(Converter<I, O> converter);

}
