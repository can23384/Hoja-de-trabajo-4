package uvg.edu.gt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Main {
    /*public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("datos.txt"));
            String expression = reader.readLine();
            reader.close();
            
            System.out.println("Expresión infix leída del archivo: " + expression);
            
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }*/
    public static void main(String[] args) {
        // Crear un stack basado en ArrayList
        StackInterface arrayListStack = StackFactory.createStack("arraylist");
        ExpressionEvaluator evaluator1 = new ExpressionEvaluator(arrayListStack);
        String postfixExpression1 = "34+2*";
        int result1 = evaluator1.evaluatePostfixExpression(postfixExpression1);
        System.out.println("Resultado con ArrayListStack: " + result1);

        // Crear un stack basado en Vector
        StackInterface vectorStack = StackFactory.createStack("vector");
        ExpressionEvaluator evaluator2 = new ExpressionEvaluator(vectorStack);
        String postfixExpression2 = "53*62/+";
        int result2 = evaluator2.evaluatePostfixExpression(postfixExpression2);
        System.out.println("Resultado con VectorStack: " + result2);
    }
}