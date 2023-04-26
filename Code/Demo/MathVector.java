/* 
   Author: Dr. Becnel     
   CSCI 3302 Section 001
   Date 1/15/2023

   The MathVector class is used to represent mathematical vectors.
   It defines public operations that operate on these vectors.

   Files Required: None
   Input: n/a
   Output: n/a

   Sample Run: n/a (see TestMathVector)
*/

import java.util.Scanner;

public class MathVector {

   private double[] elements; // holds the elements stored in the actual vector

   // =======================CONSTRUCTORS========================

   /**
    * This constructor allocates space for the array representing
    * the vector. One extra array location is allocated in order for
    * the index of the array components to start at 1 instead of 0.
    * 
    * @param n - given a positive integer for the number of elements in the vector
    *          Post: creates a MathVector of the given size
    */
   public MathVector(int n) {
      elements = new double[n + 1];
   }

   // ===================METHODS========================

   /**
    * zero
    * This is a class method that gives the returns of
    * vector of all zeros of the given length.
    * 
    * @param n - given a positive integer for the number of vector components
    * @return a vector of the given length containing all zeros
    */
   public static MathVector zero(int n) {
      MathVector v = new MathVector(n);

      for (int i = 1; i <= n; i++)
         v.set(i, 0);

      return v;
   }

   /**
    * sub
    * This method returns a specific vector component as indicated by
    * the given integer.
    * 
    * @param i - given an implicit vector object and the index of the
    *          vector component, i should be between 1 and n (the length
    *          of the vector)
    * @return the element stored at that index
    */
   private double sub(int i) {
      return this.elements[i];
   }

   /**
    * set
    * This method sets the ith element of the vector with the given value.
    * 
    * @param i     - given a vector object, index of the vector component between 1
    *              and the length of the vector, and a value for the component to
    *              hold
    * @param value - nothing is returned; the array representing the vector is
    *              updated
    */
   private void set(int i, double value) {
      this.elements[i] = value;
   }

   /**
    * numElements
    * This method returns the number of elements in the vector.
    * Pre : given an implicit vector object
    * 
    * @return -the number of components (elements) in the vector is being returned
    */
   public int numElements() {
      // we are not using the first element, so we subtract 1
      return (this.elements.length - 1);
   }

   /**
    * readVector
    * This method reads the values from the input into the implicit vector object.
    * 
    * @param input - given a implicit vector object and the scanner for its
    *              components to be read from.
    *              Post : sets the components of the vector based on the input read
    *              from the scanner
    */
   public void readVector(Scanner input) {
      MathVector v = this;
      int n = v.numElements();

      for (int i = 1; i <= n; i++)
         v.set(i, input.nextDouble());
   }

   /**
    * toString
    * This method returns a string representation of the given
    * implicit vector.
    * Pre: given a implicit vector object
    * Post: returns string representing the vector
    */
   public String toString() {
      MathVector v = this;
      int n = v.numElements();

      StringBuilder s = new StringBuilder("[");

      // add the components in position 1,2,...,n-1
      for (int i = 1; i <= n - 1; i++)
         s.append(v.sub(i) + ", ");

      s.append(v.sub(n) + "]"); // add last element

      return s.toString();
   }

   /**
    * add
    * This method returns a MathVector which is the result of
    * adding the implicit parameter v to the given vector w. 
    * @param w - given a vector w of the same length as the given
    * implicit vector.
    * @return - returns a vector v+w resulting from adding the two vectors
    */
   public MathVector add(MathVector w) {
      MathVector v = this;
      int n = v.numElements();

      // create a MathVector the same length as v
      MathVector result = new MathVector(n);


      return result;
   }

   /**
    * subtract
    * This method returns a MathVector which is the result of
    * subtracting the given vector w from the implicit parameter. 
    * @param w - given a vector w of the same length as the given
    * implicit vector.
    * @return - returns a vector v-w resulting from subtracting the two vectors
    */
   public MathVector subtract(MathVector w) {
      MathVector v = this;
      int n = v.numElements();

      // create a MathVector the same length as v
      MathVector result = new MathVector(n);

      return result;
   }

   /**
    * dot
    * This method returns a real number which
    * is the dot product of the given vector w with the
    * implicit parameter v.
    * Pre: given a vector w of the same length as the given
    * implicit vector.
    * Post: returns a number v.w resulting from the dot product
    * of the two vectors
    */
   public double dot(MathVector w) {   
      MathVector v = this;
      int n = v.numElements();

      double d = 0; // holds the dot product

      return d;
   }

   /**
    * scalarMultiply
    * This method returns a vector which
    * is the implicit vector v multiplied by the given
    * real number k.
    * Pre: given the implicit vector and the real number k
    * Post: returns a vector resulting from k*v
    */
    public MathVector scalarMultiply(double k) {
      MathVector v = this;
      int n = v.numElements();

      // result of the multiplication
      MathVector result = new MathVector(n);


      return result;
   }

   /**
    * magniture
    * This method returns a real number which
    * is the magnitude of the implicit parameter v.
    * Pre: given the implicit vector.
    * Post: returns ||v||, the magnitude of v
   */
   public double magnitude() {
      MathVector v = this;
      int n = v.numElements();

      // holds the sum of the components squared
      double sum = 0;
      // take the square root and return the result
      return Math.sqrt(sum);
   }

} // end class MathVector
