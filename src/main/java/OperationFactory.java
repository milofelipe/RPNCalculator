class OperationFactory {
    static Operation getOperation(String token) {
        switch (token) {
            case "+":
                return new PlusOperation();
            case "-":
                return new MinusOperation();
            case "*":
                return new MultiplyOperation();
            case "/":
                return new DivideOperation();
            case "sqrt":
                return new SquareRootOperation();
            case "undo":
                return new UndoOperation();
            case "clear":
                return new ClearOperation();
            default:
                return new UnknownOperation();
        }
    }
}