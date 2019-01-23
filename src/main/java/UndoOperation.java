import java.util.EmptyStackException;
import java.util.Objects;

public class UndoOperation implements Operation {
    @Override
    public void operate(RPNStack rpnStack) {
        validateStack(rpnStack);
        rpnStack.setStack(rpnStack.pop().getPreviousStack().getStack());
    }

    @Override
    public void validateStack(RPNStack rpnStack) {
        Objects.requireNonNull(rpnStack, "rpnStack is required");

        if (rpnStack.size() < 1) {
            throw new EmptyStackException();
        }
    }
}
