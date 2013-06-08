package org.whiskeysierra.flux;

public enum Feature {

    /**
     * Support conversions to output's subtypes.
     */
    SUPER_TYPING,

    /**
     * Support conversions from input's supertypes.
     */
    SUB_TYPING,

    /**
     * Support identity conversions for all types.
     */
    IDENTITY,

    /**
     * Support transitive bindings, i.e. chain converters when applicable.
     */
    TRANSITIVE,

    /**
     * A missing converter binding will result in a null value, rather than an {@link UnknownConversionException}.
     */
    SILENT,

    /**
     * A conversion error will result in a null value, rather than a {@link ConversionException}.
     */
    NO_ERROR,

    /**
     *
     */
    MULTI,

    AUTOBOXING,

    AUTO_UNBOXING

}
