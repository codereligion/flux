package com.codereligion.flux.converters.io;

import com.codereligion.flux.Bundle;
import com.codereligion.flux.Convert;

public final class IOBundle implements Bundle {

    @Override
    public void configure(Convert convert) {
        convert.using(new InputStreamToBase64StringConverter());
        convert.using(new StringToBaseEncodingConverter());
        convert.using(new StringToCharsetConverter());
        convert.using(new StringToFileConverter());
    }

}
