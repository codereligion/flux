package org.whiskeysierra.flux.converters.io;

import org.whiskeysierra.flux.Bundle;
import org.whiskeysierra.flux.Convert;

public final class IOBundle implements Bundle {

    @Override
    public void configure(Convert convert) {
        convert.using(new InputStreamToBase64StringConverter());
        convert.using(new StringToBaseEncodingConverter());
        convert.using(new StringToCharsetConverter());
        convert.using(new StringToFileConverter());
    }

}
