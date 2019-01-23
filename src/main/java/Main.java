import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RPNCalculator rpnCalculator = new RPNCalculator();

        System.out.println("RPN Calculator.");
        System.out.println("Valid operators are: +, -, *, /, sqrt, undo, clear.");
        System.out.println("Please enter your input:");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            try {
                rpnCalculator.calculate(scanner.nextLine());
            } catch (InsufficientParameters insufficientParameters) {
                System.out.println(insufficientParameters.getMessage());
            }
            System.out.println(rpnCalculator.printStack());
        }
    }
}