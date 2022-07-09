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
@PrepareForTest({CollaboratorWithStaticMethods.class})
//Class name where the Static method is present. Fully qualified class name i.e. incl package name ()
public class AMockitoStaticMethodTest {

    //static method mock
    @Test
    public void firstMethodTest () {
        PowerMockito.mockStatic(CollaboratorWithStaticMethods.class);
        when(CollaboratorWithStaticMethods.firstMethod(anyString())).thenReturn("Hello World");
        PowerMockCalls p = new PowerMockCalls();
        System.out.println(p.firstMethodCall("ZZZ"));

    }


    @Test
    public void firstMethodTest2 () {
        PowerMockCalls p = new PowerMockCalls();
        verifyStatic(CollaboratorWithStaticMethods.class, Mockito.timeout(1));
        p.firstMethodCall("zxcvzxcn");
        //Note: The verifyStatic method must be called right before any static method verification for PowerMockito to know that
        // the successive method invocation is what needs to be verified.
        
    }

    @Test (expected = Exception.class)
    public void thirdMethodTest () {
        doThrow(new RuntimeException()).when(CollaboratorWithStaticMethods.class);
        CollaboratorWithStaticMethods.thirdMethod();

    }

    //static method test
    @Test
    public void staticMethodTest () {
        CollaboratorWithStaticMethods c = new CollaboratorWithStaticMethods();
        Assert.assertEquals(CollaboratorWithStaticMethods.firstMethod("vvv"), "Hello vvv !");

    }


}
