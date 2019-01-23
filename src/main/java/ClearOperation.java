public class ClearOperation implements Operation {
    @Override
    public void operate(RPNStack rpnStack) {
        rpnStack.clear();
    }
}
