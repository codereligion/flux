package com.codereligion.flux;

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
     * Support composition, i.e. chain converters when applicable. E.g. if there are converters configured
     * for the following conversions: A -> B and B -> C, when using composition, there is also an
     * implicit converter from A -> C, being the sequential execution of both converters.
     */
    COMPOSITION,

    /**
     * A missing converter binding will result in a null value, rather than an {@link UnknownConversionException}.
     */
    SILENT,

    /**
     * A conversion error will result in a null value, rather than a {@link ConversionException}.
     */
    NO_ERROR,

    /**
     * TODO Define
     */
    MULTI,

    /**
     * TODO Define
     */
    GENERICS,

    /**
     * Supports unboxing for conversion, i.e. finds converters for primitive types when converting from or to
     * wrapper types. E.g. {@code capacitor.convert("12345").to(Long.class)} also takes converters into account
     * that convert into {@code long} while {@code capacitor.convert(12345L, long.class).to(String.class)}
     * also utilizes converters converting from {@code Long}.
     * <br />
     * The term autoboxing in this context refers to the converter's result, i.e. the primitive result will
     * be autoboxed into its suitable wrapper type.
     */
    AUTOBOXING,

    /**
     * Supports autoboxing for conversions, i.e. finds converters for wrapper types when converting from or to
     * primitives. E.g. {@code capacitor.convert("12345").to(long.class)} also takes converters into account
     * that convert into {@link Long} while {@code capacitor.convert(12345L).to(String.class)}
     * also utilizes converters converting from {@code long}.
     * <br />
     * The term unboxing in this context refers to the converter's result, i.e. the wrapped result will
     * be unboxed into its suitable primitive type.
     */
    UNBOXING

}
