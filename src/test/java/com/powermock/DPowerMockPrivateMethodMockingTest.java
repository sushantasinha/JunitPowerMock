package com.powermock;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.powermock.api.mockito.PowerMockito.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest({CollaboratorForPrivateMocking.class}) //Class name where the Static method is present. Fully qualified class name i.e. incl package name ()
public class DPowerMockPrivateMethodMockingTest {

    //Method With No Arguments but With Return Value
    @Test
    public void privateMethodWithNoArgButReturnValue () throws Exception {
        //Partial mock for final methods
        CollaboratorForPrivateMocking collaborator = new CollaboratorForPrivateMocking();
        CollaboratorForPrivateMocking mock = spy(collaborator);
        when(mock, "privateMethod").thenReturn("I am a private mock method.");
        String returnValue = mock.privateMethodCaller();
        verifyPrivate(mock).invoke("privateMethod");
    }

    //Method With Argument and Return Value
    @Test
    public void privateMethodWithArgButReturnValue () throws Exception {
        //Partial mock for final methods
        CollaboratorForPrivateMocking collaborator = new CollaboratorForPrivateMocking();
        CollaboratorForPrivateMocking mock = spy(collaborator);
        when(mock, "privateMethodWithParam", ArgumentMatchers.anyString()).thenReturn("All");
        String returnValue = mock.privateMethodWithParamCaller("Sushanta");
        Assert.assertEquals("All Welcome to the Java world.", returnValue);
        verifyPrivate(mock).invoke("privateMethodWithParam", "Sushanta");
    }

}
