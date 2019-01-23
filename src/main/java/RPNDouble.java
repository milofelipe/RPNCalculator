/**
 * Custom Double class that has a reference to the previous Stack (needed for undo operation)
 */
class RPNDouble {
    private RPNStack previousStack;
    private double value;

    RPNDouble(Double value, RPNStack rpnStack) {
        this.value = value;
        this.previousStack = rpnStack;
    }

    double getValue() {
        return value;
    }

    RPNStack getPreviousStack() {
        return previousStack;
    }
}
