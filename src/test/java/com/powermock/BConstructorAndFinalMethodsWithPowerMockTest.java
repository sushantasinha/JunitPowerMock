package com.powermock;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.ArgumentMatchers.anyString;
import static org.powermock.api.mockito.PowerMockito.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest({CollaboratorWithConstructorAndFinalMethods.class})
//IMP: PrepareForTest => While mocking static method we passed the name of the static method here.
// But for constructor mocking, it is little different.
//For constructor mocking, we need to pass which class using that constructor i.e. caller class.
public class BConstructorAndFinalMethodsWithPowerMockTest {

    @Test
    public void methodTest () throws Exception {
        CollaboratorWithConstructorAndFinalMethods mock = mock(CollaboratorWithConstructorAndFinalMethods.class);
        whenNew(CollaboratorWithConstructorAndFinalMethods.class).withNoArguments().thenReturn(mock);
        CollaboratorWithConstructorAndFinalMethods collaborator = new CollaboratorWithConstructorAndFinalMethods();
        verifyNew(CollaboratorWithConstructorAndFinalMethods.class).withNoArguments();
    }


    @Test
    public void method2Test () throws Exception {
        CollaboratorWithConstructorAndFinalMethods mock = mock(CollaboratorWithConstructorAndFinalMethods.class);
        whenNew(CollaboratorWithConstructorAndFinalMethods.class).withAnyArguments().thenReturn(mock);
        CollaboratorWithConstructorAndFinalMethods collaborator = new CollaboratorWithConstructorAndFinalMethods(10);
        verifyNew(CollaboratorWithConstructorAndFinalMethods.class).withArguments(10);
    }

    //final method mock
    @Test
    public void methodFinalMockTest () throws Exception {
        CollaboratorWithConstructorAndFinalMethods mock = mock(CollaboratorWithConstructorAndFinalMethods.class);
        whenNew(CollaboratorWithConstructorAndFinalMethods.class).withNoArguments().thenReturn(mock);
        CollaboratorWithConstructorAndFinalMethods collaborator = new CollaboratorWithConstructorAndFinalMethods();
        verifyNew(CollaboratorWithConstructorAndFinalMethods.class).withNoArguments();
        when(collaborator.helloMethod()).thenReturn("ABC");
        String response = collaborator.helloMethod();
        Assert.assertEquals("ABC", response);
        Mockito.verify(collaborator).helloMethod(); //Same for Mockito.verify(collaborator, Mockito.times(1)).helloMethod();
    }

    //final method test
    @Test
    public void methodFinalTest () throws Exception {
        CollaboratorWithConstructorAndFinalMethods collaborator = new CollaboratorWithConstructorAndFinalMethods();
        Assert.assertEquals("Hello World!", collaborator.helloMethod());
    }

}
