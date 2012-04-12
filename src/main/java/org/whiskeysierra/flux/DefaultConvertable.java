package org.whiskeysierra.flux;

import com.google.common.base.Optional;
import com.google.common.reflect.TypeToken;

public final class DefaultConvertable extends AbstractConvertable {

    private final ConverterMapping mapping;
    private final Object data;

    public DefaultConvertable(ConverterMapping mapping, Object data) {
        this.mapping = mapping;
        this.data = data;
    }

    @Override
    public Optional<Object> raw() {
        return Optional.of(data);
    }

    @Override
    public <O> Optional<O> tryTo(TypeToken<O> output) {
        final TypeToken<Object> input = new TypeToken<Object>(data.getClass()) {};
        final Converter<Object, O> converter = mapping.search(input, output);

        if (converter == null) {
            return Optional.absent();
        } else {
            return Optional.fromNullable(converter.convert(data, null));
        }
    }

}
