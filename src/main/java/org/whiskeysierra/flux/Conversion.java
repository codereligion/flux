package org.whiskeysierra.flux;

import com.google.common.reflect.TypeToken;

public interface Conversion {

    <I, O> O run(I input, TypeToken<O> output);

}
