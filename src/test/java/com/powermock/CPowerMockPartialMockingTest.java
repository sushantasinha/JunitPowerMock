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
@PrepareForTest({CollaboratorForPartialMocking.class}) //Class name where the Static method is present. Fully qualified class name i.e. incl package name ()
public class CPowerMockPartialMockingTest {
    
    @Test
    public void partialMockStaticMethod () {
        //Partial mock for static methods
        spy(CollaboratorForPartialMocking.class);
        when(CollaboratorForPartialMocking.staticMethod()).thenReturn("I am a static mock method.");
        Assert.assertEquals("I am a static mock method.", CollaboratorForPartialMocking.staticMethod());
        verifyStatic(CollaboratorForPartialMocking.class);
        CollaboratorForPartialMocking.staticMethod();
    }

    @Test
    public void partialMockFinalMethod () {
        //Partial mock for final methods
        CollaboratorForPartialMocking collaborator = new CollaboratorForPartialMocking();
        CollaboratorForPartialMocking mock = spy(collaborator);
        when(mock.finalMethod()).thenReturn("I am a final mock method.");
        String returnValue = mock.finalMethod();
        Assert.assertEquals("I am a final mock method.", returnValue);
        Mockito.verify(mock).finalMethod();
    }

    @Test
    public void partialMockPrivateMethod () throws Exception {
        //Partial mock for final methods
        CollaboratorForPartialMocking collaborator = new CollaboratorForPartialMocking();
        CollaboratorForPartialMocking mock = spy(collaborator);
        when(mock, "privateMethod").thenReturn("I am a private mock method.");
        String returnValue = mock.privateMethodCaller();
        verifyPrivate(mock).invoke("privateMethod");
    }

}
