package com.andrewmcguiness.civroulette.controller.vm;

import java.io.Serializable;
import java.time.ZonedDateTime;

public class SpinVm implements Serializable {
    private Long id;
    private String name;
    private ZonedDateTime createdDate;

    public SpinVm() {
    }

    public SpinVm(Long id, String name, ZonedDateTime createdDate) {
        this.id = id;
        this.name = name;
        this.createdDate = createdDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ZonedDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(ZonedDateTime createdDate) {
        this.createdDate = createdDate;
    }
}
