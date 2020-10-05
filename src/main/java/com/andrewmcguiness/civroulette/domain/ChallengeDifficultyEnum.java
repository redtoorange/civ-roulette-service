package com.andrewmcguiness.civroulette.domain;

public enum ChallengeDifficultyEnum {
    TRIVIAL("Trivial", 1),
    EASY("Easy", 2),
    MEDIUM("Medium", 3),
    HARD("Hard", 4),
    IMPOSSIBLE("Impossible", 5);

    private final String print;
    private final int points;

    ChallengeDifficultyEnum(String print, int points) {
        this.print = print;
        this.points = points;
    }

    public String getPrint() {
        return print;
    }

    public int getPoints() {
        return points;
    }
}
