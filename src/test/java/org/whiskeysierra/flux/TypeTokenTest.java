package org.whiskeysierra.flux;

import com.google.common.reflect.TypeToken;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;

public final class TypeTokenTest {

    @Test
    public void classLiteral() {
        TypeToken.of(String.class);
    }

    @Test
    public void subclass() {
        new TypeToken<String>() {};
    }

    @Test
    public void equals() {
        Assert.assertEquals(TypeToken.of(String.class), new TypeToken<String>() {});
    }

    @Test
    public void genericSubclass() {
        new TypeToken<Collection<String>>() {};
    }

}
