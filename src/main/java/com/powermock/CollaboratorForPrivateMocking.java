package com.powermock;

public class CollaboratorForPrivateMocking {
    private String privateMethod() {
        return "Hello Baeldung!";
    }
    public String privateMethodCaller() {
        return privateMethod() + " Welcome to the Java world.";
    }

    private String privateMethodWithParam(String name) {
        String result = "Hello" + name + " !";
        return result;
    }
    public String privateMethodWithParamCaller(String name) {
        return privateMethodWithParam(name) + " Welcome to the Java world.";
    }

}