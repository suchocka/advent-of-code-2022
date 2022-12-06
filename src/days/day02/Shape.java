package days.day02;

import java.util.Arrays;

public enum Shape {
    ROCK("A", "X"),
    PAPER("B", "Y"),
    SCISSORS("C", "Z");

    private final String opponentCode;
    private final String myCode;

    Shape(String opponentCode, String myCode) {
        this.opponentCode = opponentCode;
        this.myCode = myCode;
    }

    public static Shape getShapeByCode(String code, boolean opponentCode) {
        return Arrays.stream(values())
                .filter(value -> {
                    if (opponentCode) {
                        return value.opponentCode.equals(code);
                    } else {
                        return value.myCode.equals(code);
                    }
                })
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
