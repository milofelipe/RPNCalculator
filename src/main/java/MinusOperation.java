public class MinusOperation implements Operation {
    @Override
    public void operate(RPNStack rpnStack) {
        validateStack(rpnStack);

        RPNStack previousStack = new RPNStack(rpnStack.getStack());

        double operand2 = rpnStack.pop().getValue();
        double operand1 = rpnStack.pop().getValue();
        rpnStack.push(new RPNDouble(operand1 - operand2, previousStack));
    }
}
