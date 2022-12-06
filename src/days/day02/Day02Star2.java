package days.day02;

import java.util.List;

public class Day02Star2 {

    public void run(List<String> lines) {
        int totalScore = 0;
        for (String round : lines) {
            Shape opponentShape = Shape.getShapeByCode(String.valueOf(round.charAt(0)), true);
            Shape myShape = getMyShape(String.valueOf(round.charAt(2)), opponentShape);
            int score = getScoreForRound(myShape, opponentShape);
            totalScore += score;
        }
        System.out.println(totalScore);
    }

    private Shape getMyShape(String necessaryMove, Shape opponentShape) {
        if ("Y".equals(necessaryMove)) {
            return opponentShape;
        }
        switch (opponentShape) {
            case ROCK -> {
                if ("X".equals(necessaryMove)) {
                    return Shape.SCISSORS;
                }
                if ("Z".equals(necessaryMove)) {
                    return Shape.PAPER;
                }
            }
            case PAPER -> {
                if ("X".equals(necessaryMove)) {
                    return Shape.ROCK;
                }
                if ("Z".equals(necessaryMove)) {
                    return Shape.SCISSORS;
                }
            }
            case SCISSORS -> {
                if ("X".equals(necessaryMove)) {
                    return Shape.PAPER;
                }
                if ("Z".equals(necessaryMove)) {
                    return Shape.ROCK;
                }
            }
        }
        throw new IllegalArgumentException();
    }

    private int getScoreForRound(Shape myShape, Shape opponentShape) {
        int score = 0;
        boolean win = false;
        if (myShape.equals(opponentShape)) {
            score += 3;
        }
        switch (myShape) {
            case ROCK -> {
                score += 1;
                if (Shape.SCISSORS.equals(opponentShape)) {
                    win = true;
                }
            }
            case PAPER -> {
                score += 2;
                if (Shape.ROCK.equals(opponentShape)) {
                    win = true;
                }
            }
            case SCISSORS -> {
                score += 3;
                if (Shape.PAPER.equals(opponentShape)) {
                    win = true;
                }
            }
        }
        if (win) {
            score += 6;
        }
        return score;
    }
}
