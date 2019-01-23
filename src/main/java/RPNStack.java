import java.text.DecimalFormat;
import java.util.Stack;

/**
 * Custom Stack class specific to RPN Calculator
 */
class RPNStack {
    private Stack<RPNDouble> stack;

    RPNStack() {
        this.stack = new Stack<>();
    }

    RPNStack(Stack<RPNDouble> stack) {
        this.stack = stack;
    }

    void push(RPNDouble value) {
        stack.push(value);
    }

    void clear() {
        stack.clear();
    }

    RPNDouble pop() {
        return stack.pop();
    }

    int size() {
        return stack.size();
    }

    Stack<RPNDouble> getStack() {
        return (Stack<RPNDouble>) stack.clone();
    }

    void setStack(Stack<RPNDouble> stack) {
        this.stack = stack;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##########");
        StringBuilder sb = new StringBuilder("stack:");
        for (RPNDouble number : stack) {
            sb.append(" ").append(df.format(number.getValue()));
        }
        return sb.toString();
    }
}