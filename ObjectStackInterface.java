
/**
 * Interface for OStack contains all methods of OStack class.
 * 
 * @author Taylor Elledge
 * @version 1.0
 */
public interface ObjectStackInterface
{
    public boolean isEmpty();
    public boolean isFull();
    public void clear();
    public void push(Object o);
    public Object pop();
    public Object top();
    
}
