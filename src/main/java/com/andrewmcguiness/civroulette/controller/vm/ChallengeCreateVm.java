package com.andrewmcguiness.civroulette.controller.vm;


public class ChallengeCreateVm {
    private String title;
    private String body;
    private Integer points;
    private String difficulty;

    public ChallengeCreateVm() {
    }

    public ChallengeCreateVm(String title, String body, Integer points, String difficulty) {
        this.title = title;
        this.body = body;
        this.points = points;
        this.difficulty = difficulty;
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
}
