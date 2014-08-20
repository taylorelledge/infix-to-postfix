import java.io.*;
import java.util.Scanner;
/**
 * Taylor Elledge 007686183
 * 
 * Driver - Scans input file passes needed info to classes of program and prints output of program to screen and file.
 */
public class Driver
{
    public static void main(String[]args) throws IOException
    {
         PrintWriter pw =
            new PrintWriter(new FileWriter("csis.txt"));
         Scanner fileScan = (new Scanner(new File("infix.txt")));
         InfixToPostfix infix = new InfixToPostfix();
         EvalPostFix eval = new EvalPostFix();
         
         while(fileScan.hasNextLine())
        {
            String reader = fileScan.nextLine();
            String converted = infix.infixToPostfix(reader);
            int finalValue = eval.evalPostFix(converted);
            System.out.println("Infix: " + reader + "\n Postfix: " + converted + "\n Final Value: " + finalValue);
            pw.println("Infix: " + reader + "\n Postfix: " + converted + "\n Final Value: " + finalValue);
            pw.flush();
        }
         
         
         
    }
}