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
        //Partial mock for final methods
        CollaboratorForPrivateMocking collaborator = new CollaboratorForPrivateMocking();
        CollaboratorForPrivateMocking mock = spy(collaborator);
        //when(mock, "privateMethodWithParam", ArgumentMatchers.anyString()).thenReturn("All");
        String returnValue = Whitebox.invokeMethod(mock, "privateMethodWithParam", "Everyone");
        Assert.assertEquals("HelloEveryone !", returnValue);
        verifyPrivate(mock).invoke("privateMethodWithParam", "Everyone");
    }

}
