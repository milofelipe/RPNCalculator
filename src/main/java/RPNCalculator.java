import java.util.*;

/**
 * RPN Calculator Logic
 */
class RPNCalculator {
    private final RPNStack rpnStack = new RPNStack();

    void calculate(String input) throws InsufficientParameters {
        Objects.requireNonNull(input, "input is required");

        List<String> tokens = convertInputStringToList(input);

        int position = 1;   // Need this if InsufficientParameters exception is thrown
        for (String token : tokens) {
            if (isOperator(token)) {
                try {
                    Operation operation = OperationFactory.getOperation(token);
                    operation.operate(rpnStack);
                } catch (EmptyStackException e) {
                    throw new InsufficientParameters(token, position);
                }
            } else if (isNumber(token)) {
                rpnStack.push(new RPNDouble(Double.valueOf(token), rpnStack));
            }

            // Update position counter
            position = position + token.length() + 1;
        }
    }

    String printStack() {
        return rpnStack.toString();
    }

    private List<String> convertInputStringToList(String input) {
        List<String> tokens = new ArrayList<>();
        Collections.addAll(tokens, input.split(" "));
        return tokens;
    }

    private boolean isOperator(String token) {
        return "+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token) ||
                "sqrt".equals(token) || "clear".equals(token) || "undo".equals(token);
    }

    private boolean isNumber(String token) {
        try {
            Double.parseDouble(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}