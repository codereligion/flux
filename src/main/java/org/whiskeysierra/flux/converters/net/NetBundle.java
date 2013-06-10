package org.whiskeysierra.flux.converters.net;

import org.whiskeysierra.flux.Bundle;
import org.whiskeysierra.flux.Convert;

public final class NetBundle implements Bundle {

    @Override
    public void configure(Convert convert) {
        convert.using(new StringToInetAddressConverter());
        convert.using(new StringToInetSocketAddressConverter());
        convert.using(new StringToUriConverter());
        convert.using(new StringToUrlConverter());
    }

}
