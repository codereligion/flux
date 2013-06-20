package org.codereligion.flux;

import com.codereligion.flux.Bundle;
import com.codereligion.flux.Capacitor;
import com.codereligion.flux.ConfigurationException;
import com.codereligion.flux.Convert;
import com.codereligion.flux.Converts;
import com.codereligion.flux.Flux;
import org.junit.Assert;
import org.junit.Test;

public final class ConvertsBundleTest {

    public static final class DemoBundle implements Bundle {

        @Override
        public void configure(Convert convert) {

        }

        @Converts
        public Boolean parse(Integer i) {
            return i != 0;
        }

    }

    public static final class PrivateMethodBundle implements Bundle {

        @Override
        public void configure(Convert convert) {

        }

        @Converts
        private Boolean parse(Integer i) {
            return i != 0;
        }

    }

    public static final class ProtectedMethodBundle implements Bundle {

        @Override
        public void configure(Convert convert) {

        }

        @Converts
        protected Boolean parse(Integer i) {
            return i != 0;
        }

    }

    public static final class PackagePrivateMethodBundle implements Bundle {

        @Override
        public void configure(Convert convert) {

        }

        @Converts
        Boolean parse(Integer i) {
            return i != 0;
        }

    }

    public static final class TooManyParametersBundle implements Bundle {

        @Override
        public void configure(Convert convert) {

        }

        @Converts
        public Boolean parse(Integer a, Integer b) {
            return a != 0 || b != 0;
        }

    }

    @Test
    public void test() {
        final Capacitor capacitor = Flux.createCapacitor(new DemoBundle());

        Assert.assertEquals(false, capacitor.convert(0).to(Boolean.class));
        Assert.assertEquals(true, capacitor.convert(1).to(Boolean.class));
    }

    @Test(expected = ConfigurationException.class)
    public void testPrivate() {
        Flux.createCapacitor(new PrivateMethodBundle());
    }

    @Test(expected = ConfigurationException.class)
    public void testProtected() {
        Flux.createCapacitor(new ProtectedMethodBundle());
    }

    @Test(expected = ConfigurationException.class)
    public void testPackagePrivate() {
        Flux.createCapacitor(new PackagePrivateMethodBundle());
    }

    @Test(expected = ConfigurationException.class)
    public void testTooManyParameters() {
        Flux.createCapacitor(new TooManyParametersBundle());
    }


}
