import java.util.ListIterator;
import java.util.Stack;
 
class check
{
    // Recursive Method to insert an item x in sorted way
    static void sortedInsert(Stack<Integer> s, int x)
    {
        // Base case: Either stack is empty or newly inserted
        // item is greater than top (more than all existing)
        if (s.isEmpty() || x > s.peek())
        {
            s.push(x);
            return;
        }
      
        // If top is greater, remove the top item and recur
        int temp = s.pop();
        sortedInsert(s, x);
      
        // Put back the top item removed earlier
        s.push(temp);
        //return;
    }
      
    // Method to sort stack
    static void sortStack(Stack<Integer> s)
    {
        // If stack is not empty
        if (s.isEmpty())
            return;
        else
        {
            // Remove the top item
            int x = s.pop();
      
            // Sort remaining stack
            sortStack(s);
      
            // Push the top item back in sorted stack
            sortedInsert(s, x);
        }
    }
    
    static void insert_at_bottom(Stack<Integer> st, int x){

    if(st.isEmpty())
    { st.push(x);
        return;
    }
    else{
        /* All items are held in Function Call Stack until we
           reach end of the stack. When the stack becomes
           empty, the st.size() becomes 0, the
           above if part is executed and the item is inserted
           at the bottom */

        int a = st.peek();
                st.pop();
        insert_at_bottom(st, x);

        //push allthe items held in Function Call Stack
        //once the item is inserted at the bottom
        st.push(a);
    }
}
     
    // Utility Method to print contents of stack
    static void printStack(Stack<Integer> s)
    {
       ListIterator<Integer> lt = s.listIterator();
        
       // forwarding
       while(lt.hasNext())
           lt.next();
        
       // printing from top to bottom
       while(lt.hasPrevious())
           System.out.print(lt.previous()+" ");
    }
   
    // Driver method 
    public static void main(String[] args) 
    {
        Stack<Integer> s = new Stack<>();
        s.push(30);
        s.push(-5);
        s.push(18);
        s.push(14);
        s.push(-3);
      
        System.out.println("Stack elements before sorting: ");
        printStack(s);
      
        sortStack(s);
      
        System.out.println(" \n\nStack elements after sorting:");
        printStack(s);
        
        insert_at_bottom(s, 200);
        System.out.println(" \n\nStack elements finally");
        printStack(s);
               
      
    }
}