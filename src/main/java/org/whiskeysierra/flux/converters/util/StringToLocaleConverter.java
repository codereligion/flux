package org.whiskeysierra.flux.converters.util;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.reflect.TypeToken;
import org.whiskeysierra.flux.Capacitor;
import org.whiskeysierra.flux.spi.Converter;

import javax.annotation.Nullable;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class StringToLocaleConverter implements Converter<String, Locale> {

    private final Pattern pattern = Pattern.compile("^([a-z]{2}|(?=.+))(?:_([A-Z]{2}|(?=.+))(?:(?<!^_)_(.+))?)?$");

    @Nullable
    @Override
    public <V extends String> Locale convert(V input, TypeToken<V> type, TypeToken<? extends Locale> output, Capacitor capacitor) {
        final Matcher matcher = pattern.matcher(input);
        Preconditions.checkArgument(matcher.matches(), "%s does not match %s", input, pattern);
        final String language = Objects.firstNonNull(matcher.group(1), "");
        final String country = Objects.firstNonNull(matcher.group(2), "");
        final String variant = Objects.firstNonNull(matcher.group(3), "");
        return new Locale(language, country, variant);
    }

}
