import java.util.EmptyStackException;
import java.util.Objects;

public class SquareRootOperation implements Operation {
    @Override
    public void operate(RPNStack rpnStack) {
        validateStack(rpnStack);
        RPNStack previousStack = new RPNStack(rpnStack.getStack());
        rpnStack.push(new RPNDouble(Math.sqrt(rpnStack.pop().getValue()), previousStack));
    }

    @Override
    public void validateStack(RPNStack rpnStack) {
        Objects.requireNonNull(rpnStack, "rpnStack is required");

        if (rpnStack.size() < 1) {
            throw new EmptyStackException();
        }
    }
}
