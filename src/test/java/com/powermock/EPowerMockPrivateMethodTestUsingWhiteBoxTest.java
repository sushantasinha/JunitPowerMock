package com.powermock;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import static org.powermock.api.mockito.PowerMockito.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest({CollaboratorForPrivateMocking.class}) //Class name where the Static method is present. Fully qualified class name i.e. incl package name ()
public class EPowerMockPrivateMethodTestUsingWhiteBoxTest {

    //Method With Argument and Return Value
    @Test
    public void privateMethodWithArgButReturnValue () throws Exception {
        CollaboratorForPrivateMocking collaborator = new CollaboratorForPrivateMocking();
        CollaboratorForPrivateMocking mock = spy(collaborator);
        //when(mock, "privateMethodWithParam", ArgumentMatchers.anyString()).thenReturn("All");//This is if we want to mock private method
        String returnValue = Whitebox.invokeMethod(mock, "privateMethodWithParam", "Everyone"); //If we want to test private method directly, without mocking
        Assert.assertEquals("HelloEveryone !", returnValue);
        verifyPrivate(mock).invoke("privateMethodWithParam", "Everyone");
    }

}
