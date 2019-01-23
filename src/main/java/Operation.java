import java.util.EmptyStackException;
import java.util.Objects;

public interface Operation {
    void operate(RPNStack rpnStack);

    default void validateStack(RPNStack rpnStack) {
        Objects.requireNonNull(rpnStack, "rpnStack is required");

        if (rpnStack.size() < 2) {
            throw new EmptyStackException();
        }
    }
}