import java.util.Scanner;
import java.util.Random;

public class LabProgram {   
   
   public static Boolean showResults(Random rand){
         int result = rand.nextInt(2);
         if(result == 1) {
            return true;
         }
         else {
            return false;   
         }
      }
   
   
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      Random rand = new Random(2); // Seed used in develop mode
      /* Type your code here. */
      int num = scnr.nextInt();
      
      for(int i = 0; i < num; i++) {
         System.out.println(showResults(rand));   
      }
      
   }
}
