import java.util.Scanner;

 public class Calculator {
     private final Scanner scanner;
 
     public Calculator(Scanner scanner) {
         this.scanner = scanner;
     }
 
     public void performCalculation() {
         System.out.println("CHATBOT: Choose an operation: 1) Add 2) Subtract 3) Multiply 4) Divide");
         String choice = scanner.nextLine();
 
         try {
             System.out.print("Enter first number: ");
             double num1 = scanner.nextDouble();
 
             System.out.print("Enter second number: ");
             double num2 = scanner.nextDouble();
             scanner.nextLine();
 
             switch (choice) {
                 case "1":
                     System.out.println("CHATBOT: Result: " + (num1 + num2));
                     break;
                 case "2":
                     System.out.println("CHATBOT: Result: " + (num1 - num2));
                     break;
                 case "3":
                     System.out.println("CHATBOT: Result: " + (num1 * num2));
                     break;
                 case "4":
                     if (num2 == 0) {
                         throw new ArithmeticException("Cannot divide by zero!");
                     }
                     System.out.println("CHATBOT: Result: " + (num1 / num2));
                     break;
                 default:
                     throw new ChatException("Invalid operation choice.");
             }
         } catch (ArithmeticException e) {
             System.out.println("CHATBOT ERROR: " + e.getMessage());
         } catch (Exception e) {
             System.out.println("CHATBOT ERROR: Invalid input.");
             scanner.nextLine();
         }
 
         ChatUtils.waitForKeyPress(scanner);
     }
 }
 