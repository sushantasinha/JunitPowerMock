package com.powermock;

public class PowerMockCalls {

    public String firstMethodCall(final String name) {
        String result = CollaboratorWithStaticMethods.firstMethod(name);
        result = result + "!!!";
        return result;
    }

    public String secondMethodCall() {
        String result = CollaboratorWithStaticMethods.secondMethod();
        result = result + "!!!";
        return result;
    }

    public String thirdMethod() {
        String result = CollaboratorWithStaticMethods.thirdMethod();
        result = result + "###";
        return result;
    }

    public String fourthMethod() {
        if(false) {
            return CollaboratorWithStaticMethods.thirdMethod();
        }
        return "Hi...";
    }

}