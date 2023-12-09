package com.andrei.rest.unit_test.test_mock_injection;

public class MyClass {

    private DependencyOne dependencyOne;
    private DependencyTwo dependencyTwo;

    public MyClass(DependencyOne dependencyOne, DependencyTwo dependencyTwo) {
        this.dependencyOne = dependencyOne;
        this.dependencyTwo = dependencyTwo;
    }

    public String useDependencies() {
        return dependencyOne.doSomething() + " " + dependencyTwo.doSomething();
    }
}
