public class TestStack2 {

    public static void main(String[] args) {
        StackReferenceBased<Character> stack = new StackReferenceBased<Character>();

        // add numbers 1 through 15 
        for (char i = 'a'; i <= 'z'; i++) {
            Character c = i;
            stack.push(c);
        }
        System.out.println("Original Stack: ");
        System.out.println(stack);
        System.out.println();

        // remove top 5
        for (int i = 1; i<= 5; i++) 
            System.out.println( stack.pop());

        System.out.println();
        System.out.println("Stack after popping: ");
        System.out.println(stack);
        
        stack.popAll();

        System.out.println();
        System.out.println("Stack after pop all:");
        System.out.println(stack);
        System.out.println();
        System.out.println("Is stack empty: " + stack.isEmpty());
    }
    
}
 