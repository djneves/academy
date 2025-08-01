package com.ctw.workstation.simple;

public class ExternalMessageServiceImpl implements ExternalMessageService {

    @Override
    public String sayHelloFromOuterSpace() {
        return "Hello from outer space";
    }

    @Override
    public String sayHelloFromOuterSpace(String name) {
        return "Hello from outer space" + name;
    }

    @Override
    public void fazAlgo() {
        throw new IllegalStateException("Can't be executed");
    }

}
