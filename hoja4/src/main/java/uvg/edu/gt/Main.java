import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("datos.txt"));
            String infixExpression = reader.readLine();
            reader.close();   
            System.out.println("Expresión infix leída del archivo: " + infixExpression);

            Scanner scanner = new Scanner(System.in);
            boolean menu = true;

            while(menu){
                System.out.println("Seleccione un patrón de diseño:");
                System.out.println("1. arrayList");
                System.out.println("2. vector");
                System.out.println("3. lista");
                int opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        StackInterface arrayListStack = StackFactory.createStack("arraylist");
                        InfixToPostfixConverter converter1 = new InfixToPostfixConverter(arrayListStack);
                        String postfixExpression1 = converter1.infixToPostfix(infixExpression);
                        System.out.println("Expresión infix: " + infixExpression);
                        System.out.println("Expresión postfix con ArrayListStack: " + postfixExpression1);

                        PostfixCalculator calculator = PostfixCalculator.getInstance();
                        double result = calculator.evaluate(postfixExpression1);
                        System.out.println("Resultado: " + result);
                        break;

                    case 2:
                        StackInterface vectorStack = StackFactory.createStack("vector");
                        InfixToPostfixConverter converter2 = new InfixToPostfixConverter(vectorStack);
                        String postfixExpression2 = converter2.infixToPostfix(infixExpression);
                        System.out.println("Expresión infix: " + infixExpression);
                        System.out.println("Expresión postfix con VectorStack: " + postfixExpression2);

                        PostfixCalculator calculator2 = PostfixCalculator.getInstance();
                        double result2 = calculator2.evaluate(postfixExpression2);
                        System.out.println("Resultado: " + result2);
                        break;

                    case 3:
                        System.out.println("Seleccione la implementación de lista a utilizar:");
                        System.out.println("1. Lista simplemente encadenada");
                        System.out.println("2. Lista doblemente encadenada");
                        int choice = scanner.nextInt();
                        scanner.nextLine();
                
                        LinkedListStack stack;
                        if (choice == 1) {
                            stack = new SinglyLinkedListStack();
                        } else if (choice == 2) {
                            stack = new DoublyLinkedListStack();
                        } else {
                            System.out.println("Opción no válida");
                            return;
                        }
                
                        InfixToPostfixConverter converter = new InfixToPostfixConverter(stack);
                        String postfixExpression3 = converter.infixToPostfix(infixExpression);
                        System.out.println("Expresión infix: " + infixExpression);
                        System.out.println("Expresión postfix: " + postfixExpression3);
                
                        break;
                }

            }
                
            } catch (IOException e) {
                System.err.println("Error al leer el archivo: " + e.getMessage());
            }
    }
}