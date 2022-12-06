package days.day02;

import java.util.List;

public class Day02Star1 {

    public void run(List<String> lines) {
        int totalScore = 0;
        for (String round: lines) {
            Shape opponentShape = Shape.getShapeByCode(String.valueOf(round.charAt(0)), true);
            Shape myShape = Shape.getShapeByCode(String.valueOf(round.charAt(2)), false);
            int score = getScoreForRound(myShape, opponentShape);
            totalScore += score;
        }
        System.out.println(totalScore);
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
