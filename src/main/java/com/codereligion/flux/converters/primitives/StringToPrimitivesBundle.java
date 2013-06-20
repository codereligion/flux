package com.codereligion.flux.converters.primitives;

import com.codereligion.flux.Bundle;
import com.codereligion.flux.Convert;
import com.codereligion.flux.Converts;

public final class StringToPrimitivesBundle implements Bundle {

    @Override
    public void configure(Convert convert) {

    }

    @Converts
    public boolean parseBoolean(String value) {
        return Boolean.parseBoolean(value);
    }

    @Converts
    public byte parseByte(String value) {
        return Byte.parseByte(value);
    }

    @Converts
    public char parseChar(String value) {
        return value.length() == 1 ? value.charAt(0) : '\0';
    }

    @Converts
    public double parseDouble(String value) {
        return Double.parseDouble(value);
    }

    @Converts
    public float parseFloat(String value) {
        return Float.parseFloat(value);
    }

    @Converts
    public int parseInt(String value) {
        return Integer.parseInt(value);
    }

    @Converts
    public long parseLong(String value) {
        return Long.parseLong(value);
    }

    @Converts
    public short parseShort(String value) {
        return Short.parseShort(value);
    }

}
