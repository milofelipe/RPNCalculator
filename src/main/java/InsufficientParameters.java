class InsufficientParameters extends Exception {
    InsufficientParameters(String operation, int position) {
        super(String.format("operator %s (position: %d): insufficient parameters", operation, position));
    }
}