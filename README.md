# ![Flux Capacitor](icon.png) Flux [![Build Status](https://travis-ci.org/whiskeysierra/flux.png?branch=master)](http://travis-ci.org/whiskeysierra/flux)
A Java type conversion framework.

## Quickstart
Creating the Capacitor:
```java
    final Capacitor capacitor = Flux.createCapacitor(new PrimitivesBundle());
    final long value = capacitor.convert("12345").to(Long.class);
    // or
    final long value = capacitor.convert(null).tryTo(Long.class).or(0L);
    ...
````

## Configuration

### Features
When creating the Capacitor, you can pass in a FeatureSet, defining which features you want to enable:

```java
    final FeatureSet features = Features.of(Feature.SILENT, Feature.TRANSITIVE);
    final Capacitor capacitor = Flux.createCapacitor(features);
    ...
````


### Bundles

## Maven

## Build Requirements
 - Java 1.6 or higher
 - Maven 3


## Attributions
![Creative Commons License](http://i.creativecommons.org/l/by/3.0/80x15.png)
Flux Capacitor Icon by [Flowdock Ltd](http://flowdock.com/) is licensed under a
[Creative Commons Attribution 3.0 Unported License](http://creativecommons.org/licenses/by/3.0/).