package com.codereligion.flux.converters.hash;

import com.google.common.collect.ImmutableMap;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import com.google.common.reflect.TypeToken;
import com.codereligion.flux.Capacitor;
import com.codereligion.flux.ConversionException;
import com.codereligion.flux.spi.Converter;

import javax.annotation.Nullable;
import java.util.Map;

public final class StringToHashFunctionConverter implements Converter<String, HashFunction> {

    private final Map<String, HashFunction> functions = ImmutableMap.<String, HashFunction>builder().
        put("Adler-32", Hashing.adler32()).
        put("CRC-32", Hashing.crc32()).
        put("MD5", Hashing.md5()).
        put("MurmurHash3-128", Hashing.murmur3_128()).
        put("MurmurHash3-32", Hashing.murmur3_32()).
        put("SHA-1", Hashing.sha1()).
        put("SHA-256", Hashing.sha256()).
        put("SHA-512", Hashing.sha512()).
        build();

    @Nullable
    @Override
    public <V extends String> HashFunction convert(V value, TypeToken<V> input, Capacitor capacitor) {

        final HashFunction function = functions.get(value);

        if (function == null) {
            throw new ConversionException(String.format("Unknown hash algorithm '%s'", value));
        } else {
            return function;
        }
    }
}
