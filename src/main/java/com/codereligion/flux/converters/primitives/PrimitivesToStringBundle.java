package com.codereligion.flux.converters.primitives;

import com.codereligion.flux.Bundle;
import com.codereligion.flux.Convert;
import com.codereligion.flux.Converts;

public final class PrimitivesToStringBundle implements Bundle {

    @Override
    public void configure(Convert convert) {

    }

    @Converts
    public String toString(boolean value) {
        return Boolean.toString(value);
    }

    @Converts
    public String toString(byte value) {
        return Byte.toString(value);
    }

    @Converts
    public String toString(char value) {
        return Character.toString(value);
    }

    @Converts
    public String toString(double value) {
        return Double.toString(value);
    }

    @Converts
    public String toString(float value) {
        return Float.toString(value);
    }

    @Converts
    public String toString(int value) {
        return Integer.toString(value);
    }

    @Converts
    public String toString(long value) {
        return Long.toString(value);
    }

    @Converts
    public String toString(short value) {
        return Short.toString(value);
    }

}
