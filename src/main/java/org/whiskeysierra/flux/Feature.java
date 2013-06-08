package org.whiskeysierra.flux;

public enum Feature {

    SUPER_TYPING,

    SUB_TYPING,

    /**
     * Support identity conversions for all types.
     */
    IDENTITY,

    TRANSITIVE,

    /**
     * A missing converter binding will result in a null value, rather than an exception.
     */
    SILENT

}
