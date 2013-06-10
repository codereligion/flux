package org.whiskeysierra.flux.converters.net;

import com.google.common.base.Preconditions;
import com.google.common.reflect.TypeToken;
import org.whiskeysierra.flux.Capacitor;
import org.whiskeysierra.flux.ConversionException;
import org.whiskeysierra.flux.spi.Converter;

import javax.annotation.Nullable;
import java.net.MalformedURLException;
import java.net.URL;

public final class StringToUrlConverter implements Converter<String, URL> {

    private static final String CLASSPATH_PREFIX = "classpath:";

    @Nullable
    @Override
    public <V extends String> URL convert(V value, TypeToken<V> type, TypeToken<? extends URL> output, Capacitor capacitor) {
        if (value.startsWith(CLASSPATH_PREFIX)) {
            final ClassLoader loader = getClassLoader();
            final URL url = loader.getResource(value.substring(CLASSPATH_PREFIX.length()));
            Preconditions.checkArgument(url != null, "%s is not pointing to a valid classpath source", value);
            return url;
        } else {
            try {
                return new URL(value);
            } catch (MalformedURLException e) {
                throw new ConversionException(e);
            }
        }
    }

    private ClassLoader getClassLoader() {
        try {
            return Thread.currentThread().getContextClassLoader();
        } catch (SecurityException e) {
            return getClass().getClassLoader();
        }
    }

}
