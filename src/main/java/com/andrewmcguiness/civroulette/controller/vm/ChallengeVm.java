package com.andrewmcguiness.civroulette.controller.vm;


import java.time.ZonedDateTime;

public class ChallengeVm {
    private Long id;

    private String title;
    private String body;
    private Integer points;
    private String difficulty;

    private ZonedDateTime createdDate;

    public ChallengeVm() {
    }

    public ChallengeVm(Long id, String title, String body, Integer points, String difficulty, ZonedDateTime createdDate) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.points = points;
        this.difficulty = difficulty;
        this.createdDate = createdDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public ZonedDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(ZonedDateTime createdDate) {
        this.createdDate = createdDate;
    }
}
