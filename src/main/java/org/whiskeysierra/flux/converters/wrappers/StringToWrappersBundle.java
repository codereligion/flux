package org.whiskeysierra.flux.converters.wrappers;

import org.whiskeysierra.flux.Bundle;
import org.whiskeysierra.flux.Convert;

public final class StringToWrappersBundle implements Bundle {

    @Override
    public void configure(Convert convert) {
        convert.using(new StringToBooleanConverter());
        convert.using(new StringToByteConverter());
        convert.using(new StringToCharacterConverter());
        convert.using(new StringToDoubleConverter());
        convert.using(new StringToFloatConverter());
        convert.using(new StringToIntegerConverter());
        convert.using(new StringToLongConverter());
        convert.using(new StringToShortConverter());
    }

}
