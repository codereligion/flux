package com.codereligion.flux.converters.net;

import com.codereligion.flux.Bundle;
import com.codereligion.flux.Convert;

public final class NetBundle implements Bundle {

    @Override
    public void configure(Convert convert) {
        convert.using(new StringToInetAddressConverter());
        convert.using(new StringToInetSocketAddressConverter());
        convert.using(new StringToURIConverter());
        convert.using(new StringToURLConverter());
    }

}
