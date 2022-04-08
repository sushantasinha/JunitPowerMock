package com.powermock;

public class CollaboratorWithConstructorAndFinalMethods {

    public CollaboratorWithConstructorAndFinalMethods(){
        System.out.println("NAC");
    }

    public CollaboratorWithConstructorAndFinalMethods(int i ){
        System.out.println(i);
    }

    public final String helloMethod() {
        return "Hello World!";
    }
}
