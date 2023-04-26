public class RecursionExamples {
    public static int fact(int n) {
        if (n ==0) 
            return 1;
        else 
            return n*fact(n-1);
    }

    public static void headPrint(int n) {
        if (n >= 1) {
            System.out.println(n + " ");
            headPrint(n-1);
        }
    }

    public static void main(String[] args) {
        headPrint(3);
    }
}