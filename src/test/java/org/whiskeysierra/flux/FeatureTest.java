package org.whiskeysierra.flux;

import org.junit.Test;

public abstract class FeatureTest {

    @Test
    public abstract void testEnabled();

    @Test(expected = RuntimeException.class)
    public abstract void testDisabled();

}
