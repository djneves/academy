package com.ctw.workstation.simple;

public class HelloExtAcademy {

    ExternalMessageService externalMessageService;

    protected HelloExtAcademy(ExternalMessageService externalMessageServiceSpy) {
        this.externalMessageService = externalMessageServiceSpy;
    }

    public String sayHello(String name) {
        if(name != null) {
            return externalMessageService.sayHelloFromOuterSpace(name);
        }else{
            String helloOuterSpace = null;
            try {
                helloOuterSpace = externalMessageService.sayHelloFromOuterSpace();
            } catch (Exception e) {
                return "Houston we have a problem";
            }

            externalMessageService.fazAlgo();
            return helloOuterSpace + " Academy";
        }
    }
}
