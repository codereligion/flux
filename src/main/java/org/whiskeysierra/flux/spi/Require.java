package org.whiskeysierra.flux.spi;

import org.whiskeysierra.flux.Feature;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Require {

    Feature[] value() default {};

}
