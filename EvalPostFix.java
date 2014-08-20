import java.io.*;
import java.util.Scanner;
import static java.lang.Math.*;
/**
 * Class EvalPostFix evaluates postfix expression and returns result to driver.
 * 
 * @author Taylor Elledge 
 * @version 1.0 Last modified 9/19/2013
 */
public class EvalPostFix
{
    private int infix;
    private OStack valueStack;
    private OStack operatorStack;
    /**
     * Constructor for objects of class EvalPostFix
     */
    public EvalPostFix()
    {
        valueStack = new OStack();
        operatorStack = new OStack();
    }
    /**
     * evalPostFix(String converted) - determines value of postfix expression.
     * 
     * @param converted
     * @return (Integer) valueStack.pop() 
     */
    public int evalPostFix(String converted)
    {
        for(char temp: converted.toCharArray())
        {
            if(Character.isDigit(temp))
            {
                int tempInt = Character.getNumericValue(temp);
                valueStack.push(tempInt);
            }
            else if(temp == '+')
            {
                int op1 = (Integer)(valueStack.pop());
                int op2 = (Integer)valueStack.pop();
                int newVal = op2 + op1;
                valueStack.push(newVal);
            }
            else if(temp == '*')
            {
                int op1 = (Integer)valueStack.pop();
                int op2 = (Integer)valueStack.pop();
                int newVal = op2 * op1;
                valueStack.push(newVal);
            }
            else if(temp == '/')
            {
                int op1 = (Integer)valueStack.pop();
                int op2 = (Integer)valueStack.pop();
                int newVal = op2 / op1;
                valueStack.push(newVal);
            }
            else if(temp == '-')
            {
                int op1 = (Integer)valueStack.pop();
                int op2 = (Integer)valueStack.pop();
                int newVal = op2 - op1;
                valueStack.push(newVal);
            }
            else if(temp == '^')
            {
                int op1 = (Integer)valueStack.pop();
                int op2 = (Integer)valueStack.pop();
                int newVal = (int)Math.pow(op2, op1);
                valueStack.push(newVal);
            }
        }
        return (Integer)valueStack.pop();
    }
}