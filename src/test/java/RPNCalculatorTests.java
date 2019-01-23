import org.junit.Assert;
import org.junit.Test;

public class RPNCalculatorTests {
    @Test
    public void example1() throws InsufficientParameters {
        RPNCalculator rpnCalculator = new RPNCalculator();
        rpnCalculator.calculate("5 2");
        Assert.assertEquals("stack: 5 2", rpnCalculator.printStack());
    }

    @Test
    public void example2() throws InsufficientParameters {
        RPNCalculator rpnCalculator = new RPNCalculator();
        rpnCalculator.calculate("2 sqrt");
        Assert.assertEquals("stack: 1.4142135624", rpnCalculator.printStack());
        rpnCalculator.calculate("clear 9 sqrt");
        Assert.assertEquals("stack: 3", rpnCalculator.printStack());
    }

    @Test
    public void example3() throws InsufficientParameters {
        RPNCalculator rpnCalculator = new RPNCalculator();
        rpnCalculator.calculate("5 2 -");
        Assert.assertEquals("stack: 3", rpnCalculator.printStack());
        rpnCalculator.calculate("3 -");
        Assert.assertEquals("stack: 0", rpnCalculator.printStack());
        rpnCalculator.calculate("clear");
        Assert.assertEquals("stack:", rpnCalculator.printStack());
    }

    @Test
    public void example4() throws InsufficientParameters {
        RPNCalculator rpnCalculator = new RPNCalculator();
        rpnCalculator.calculate("5 4 3 2");
        Assert.assertEquals("stack: 5 4 3 2", rpnCalculator.printStack());
        rpnCalculator.calculate("undo undo *");
        Assert.assertEquals("stack: 20", rpnCalculator.printStack());
        rpnCalculator.calculate("5 *");
        Assert.assertEquals("stack: 100", rpnCalculator.printStack());
        rpnCalculator.calculate("undo");
        Assert.assertEquals("stack: 20 5", rpnCalculator.printStack());
    }

    @Test
    public void example5() throws InsufficientParameters {
        RPNCalculator rpnCalculator = new RPNCalculator();
        rpnCalculator.calculate("7 12 2 /");
        Assert.assertEquals("stack: 7 6", rpnCalculator.printStack());
        rpnCalculator.calculate("*");
        Assert.assertEquals("stack: 42", rpnCalculator.printStack());
        rpnCalculator.calculate("4 /");
        Assert.assertEquals("stack: 10.5", rpnCalculator.printStack());
    }

    @Test
    public void example6() throws InsufficientParameters {
        RPNCalculator rpnCalculator = new RPNCalculator();
        rpnCalculator.calculate("1 2 3 4 5");
        Assert.assertEquals("stack: 1 2 3 4 5", rpnCalculator.printStack());
        rpnCalculator.calculate("*");
        Assert.assertEquals("stack: 1 2 3 20", rpnCalculator.printStack());
        rpnCalculator.calculate("clear 3 4 -");
        Assert.assertEquals("stack: -1", rpnCalculator.printStack());
    }

    @Test
    public void example7() throws InsufficientParameters {
        RPNCalculator rpnCalculator = new RPNCalculator();
        rpnCalculator.calculate("1 2 3 4 5");
        Assert.assertEquals("stack: 1 2 3 4 5", rpnCalculator.printStack());
        rpnCalculator.calculate("* * * *");
        Assert.assertEquals("stack: 120", rpnCalculator.printStack());
    }

    @Test
    public void example8() {
        RPNCalculator rpnCalculator = new RPNCalculator();
        try {
            rpnCalculator.calculate("1 2 3 * 5 + * * 6 5");
        } catch (InsufficientParameters e) {
            Assert.assertEquals("operator * (position: 15): insufficient parameters", e.getMessage());
            Assert.assertEquals("stack: 11", rpnCalculator.printStack());
        }
    }
}
