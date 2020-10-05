package com.andrewmcguiness.civroulette.controller.vm;

import java.io.Serializable;

public class SpinCreateVm implements Serializable {
    private String name;

    public SpinCreateVm() {
    }

    public SpinCreateVm(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
