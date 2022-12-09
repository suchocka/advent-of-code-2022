package days.day05;

public class Move {

    private int quantity;
    private int sourceStack;
    private int targetStack;

    private Move() {
    }

    public int getQuantity() {
        return quantity;
    }

    public int getSourceStack() {
        return sourceStack;
    }

    public int getTargetStack() {
        return targetStack;
    }

    public static Move.Builder builder() {
        return new Move.Builder();
    }

    static class Builder {
        private Move move = new Move();

        public Builder quantity(String quantity) {
            move.quantity = Integer.parseInt(quantity);
            return this;
        }

        public Builder sourceStack(String sourceStack) {
            move.sourceStack = Integer.parseInt(sourceStack);
            return this;
        }

        public Builder targetStack(String targetStack) {
            move.targetStack = Integer.parseInt(targetStack);
            return this;
        }

        public Move build() {
            return this.move;
        }
    }
}
