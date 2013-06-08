package org.whiskeysierra.flux;

import com.google.common.reflect.TypeToken;

public interface InputBindingBuilder<I> {

    <O> OutputBindingBuilder<I, O> to(Class<O> output);

    <O> OutputBindingBuilder<I, O> to(TypeToken<O> output);

}
