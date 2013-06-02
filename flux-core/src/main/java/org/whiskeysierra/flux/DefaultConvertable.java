package org.whiskeysierra.flux;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.reflect.TypeToken;

import javax.annotation.Nullable;

final class DefaultConvertable<I> extends AbstractConvertable {

    private final I input;
    private final TypeToken<I> type;
    private final Conversion conversion;

    public DefaultConvertable(@Nullable I input, TypeToken<I> type, Conversion conversion) {
        this.input = input;
        this.type = Preconditions.checkNotNull(type, "Type");
        this.conversion = Preconditions.checkNotNull(conversion, "Conversion");
    }

    @Override
    public Object raw() {
        return input;
    }

    @Override
    public <O> Optional<O> tryTo(TypeToken<O> output) {
        Preconditions.checkNotNull(output, "Output");
        // TODO delay mapping-search until someone calls this
        return conversion.<I, O>run(input, type, output);
    }

}
