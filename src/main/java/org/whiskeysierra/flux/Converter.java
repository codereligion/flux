package org.whiskeysierra.flux;

import javax.annotation.Nullable;

public interface Converter<I, O> {

    O convert(@Nullable I input);

}
