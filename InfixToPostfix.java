
import java.io.*;
import java.util.Scanner;
import static java.lang.Math.*;
/**
 * Class InfixToPostfix converts infix expression to posdtfix expression and returns it to driver.
 * 
 * @author Taylor Elledge 
 * @version 1.0 Last modified 9/19/2013
 */
public class InfixToPostfix
{
    private StringBuffer sb;
    private OStack operators;
    /**
     * Constructor for objects of class InfixToPostfix
     */
    public InfixToPostfix()
    {
        operators = new OStack();
    }

    /**
     * infixToPostfix(String reader) takes input string from driver and converts it to postfix notation then returns
     * string buffer to driver.
     * @param reader
     * @return sb.toStrin()
     */
    public String infixToPostfix(String reader)
    {
        sb = new StringBuffer("");
        for(char temp: reader.toCharArray())
        {
            InfixToPostfix eval = new InfixToPostfix();
            int precedenceTemp = eval.priority(temp);
            if(Character.isDigit(temp))
            {
                sb.append(temp);
            }
            else if(temp == '(')
            {
                operators.push(temp);
            }
            else if(temp == '+' || temp == '-' || temp == '*' || temp == '/' || temp == '^')
            {

                if(operators.isEmpty() || precedenceTemp > eval.priority((Character)operators.top()))
                {
                    operators.push(temp);
                }
                else
                {
                    
                   while(!operators.isEmpty() && precedenceTemp <= eval.priority((Character)operators.top()) 
                        && (Character)operators.top() != '(')
                   {
                            sb.append((Character)operators.pop());
                   }
                    
                    operators.push(temp);
                }
            }
            else if(temp ==')')
            {
                while((Character)operators.top() != '(')
                {
                    sb.append((Character)operators.pop());
                }
                operators.pop();
            }
        }
        while(!operators.isEmpty())
        {
            sb.append((Character)operators.pop());
        }
        return sb.toString();
    }

    /**
     * priority(char op) takes char parameter and returns integer priority based on the precedence of the operator 
     * in relation to postfix method 
     * @param op
     * @return int
     */
    public int priority(char op)
    {

        switch(op)
        {
            case'^': return 3;
            case'*':
            case'/': return 2;
            case'+':
            case'-': return 1;
            default: return 0;
        }

    }
}