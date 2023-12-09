package com.andrei.rest.unit_test.test_mock_injection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MyClassTest {

    @Mock
    private DependencyOne dependencyOne;

    @Mock
    private DependencyTwo dependencyTwo;

    @InjectMocks
    private MyClass myClass;

    @Test
    void testUseDependencies() {
        //GIVE
        when(dependencyOne.doSomething()).thenReturn("Mocked DependencyOne");
        when(dependencyTwo.doSomething()).thenReturn("Mocked DependencyTwo");

        //WHEN
        String result = myClass.useDependencies();

        //WHEN
        Assertions.assertEquals("Mocked DependencyOne Mocked DependencyTwo", result);
    }
}
