import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class hola {
    /*public static void main(String[] args) {
        StackInterface arrayListStack = StackFactory.createStack("arraylist");
        InfixToPostfixConverter converter1 = new InfixToPostfixConverter(arrayListStack);
        String infixExpression1 = "a+b*c-(d/e+f*g)";
        String postfixExpression1 = converter1.infixToPostfix(infixExpression1);
        System.out.println("Expresión infix: " + infixExpression1);
        System.out.println("Expresión postfix con ArrayListStack: " + postfixExpression1);

        StackInterface vectorStack = StackFactory.createStack("vector");
        InfixToPostfixConverter converter2 = new InfixToPostfixConverter(vectorStack);
        String infixExpression2 = "(1+2)*9";
        String postfixExpression2 = converter2.infixToPostfix(infixExpression2);
        System.out.println("Expresión infix: " + infixExpression2);
        System.out.println("Expresión postfix con VectorStack: " + postfixExpression2);
    }*/
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("datos.txt"));
            String infixExpression = reader.readLine();
            reader.close();
            
            System.out.println("Expresión infix leída del archivo: " + infixExpression);
            
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        
        Scanner scanner = new Scanner(System.in);
        boolean menu = true;

        while(menu){
            System.out.println("Seleccione un patron de diseño:");
            System.out.println("1. arrayList");
            System.out.println("2. vector");
            System.out.println("3. lista");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese la expresión infix:");
                    String infixExpression = scanner.nextLine();
                    StackInterface arrayListStack = StackFactory.createStack("arraylist");
                    InfixToPostfixConverter converter1 = new InfixToPostfixConverter(arrayListStack);
                    String postfixExpression1 = converter1.infixToPostfix(infixExpression);
                    System.out.println("Expresión infix: " + infixExpression);
                    System.out.println("Expresión postfix con ArrayListStack: " + postfixExpression1);
                    break;

                case 2:
                    StackInterface vectorStack = StackFactory.createStack("vector");
                    InfixToPostfixConverter converter2 = new InfixToPostfixConverter(vectorStack);
                    System.out.println("Ingrese la expresión infix:");
                    String infixExpression2 = scanner.nextLine();
                    String postfixExpression2 = converter2.infixToPostfix(infixExpression2);
                    System.out.println("Expresión infix: " + infixExpression2);
                    System.out.println("Expresión postfix con VectorStack: " + postfixExpression2);
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

                    System.out.println("Ingrese la expresión infix:");
                    String infixExpression3 = scanner.nextLine();
            
                    InfixToPostfixConverter converter = new InfixToPostfixConverter(stack);
                    String postfixExpression = converter.infixToPostfix(infixExpression3);
                    System.out.println("Expresión infix: " + infixExpression3);
                    System.out.println("Expresión postfix: " + postfixExpression);
            
                    break;
            }

        }

    }
    
}
