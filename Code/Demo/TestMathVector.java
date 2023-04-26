/* Dr. Becnel 
csci3302-001
Jan-15-2023
This file tests the public methods of the MathVector Class.

Files Required: MathVector.java, vector.txt

Input: The contents of vector.txt are one line with the number
of elements in each vector and two lines with the contents of
two math vectors. (see example below)

Output:
The original vectors are displayed.
The sum, difference, and dot product of two vectors are displayed.
The scalar multiple of hte first vector by 2 and the second vector by -3
are displayed.
The magnitude of both vectors are displayed

Sample Run:
---------------------------------------------------------------------
Contents of vector.txt

3
-2.0 3.0 -1.0
1.0  4.0  2.0

Console Output:
---------------------------------------------------------------------
Vectors Read:
v = [-2.0, 3.0, -1.0]  w = [1.0, 4.0, 2.0]

Calculations:
v+w = [-1.0, 7.0, 1.0]
v-w = [-3.0, -1.0, -3.0]
v.w = 8.0
2v = [-4.0, 6.0, -2.0]
-3w = [-3.0, -12.0, -6.0]
||v|| = 3.7416573867739413
||w|| = 4.58257569495584
 */

import java.util.Scanner;
import java.io.*;  // input output for files

public class TestMathVector {
   public static void main(String[] args) throws IOException {
        
        // Create a File object from an input file vector.txt.
        // First line has size of the vector
        // second line has the elements
        File vecFile = new File("vector.txt");
        Scanner inputFile = new Scanner(vecFile);
        int size = inputFile.nextInt(); // read the size
        
        // create the vectors v and w
        MathVector v = new MathVector(size);
        MathVector w = new MathVector(size);
        
        // read the vector element from the file
        v.readVector(inputFile); 
        w.readVector(inputFile); 
        
        // vectors read
        System.out.println("Vectors Read: ");
        System.out.println("v = " + v + "  w = " + w);
        System.out.println();
        
        // vector calculations         
        System.out.println("Calculations: ");
        System.out.println("v+w = " + v.add(w));
        System.out.println("v-w = " + v.subtract(w));
        System.out.println("v.w = " + v.dot(w));
        System.out.println("2v = " + v.scalarMultiply(2));
        System.out.println("-3w = " + w.scalarMultiply(-3));
        System.out.println("||v|| = " + v.magnitude());
        System.out.println("||w|| = " + w.magnitude());
         
   }  // end main
} // end class