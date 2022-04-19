//Oscar Maldonado
//CS301
//LabAssigntment2.java
//4/19/2022

import java.util.*;
public class LabAssignment2{
   /*Sample problem recursive*/
   public static boolean recSample(String str){
      if(str.length() == 0 || str.length() == 1){
         return true;
      }
      
      if(str.charAt(0) == str.charAt(str.length()-1) ){
         return recSample(str.substring(1, str.length()-1));
      }
      
      return false;     
   }
   
   
   /*Sample problem iterative*/
   public static boolean itrSample(String str){
   
      for(int i=0, j=str.length()-1; i<str.length()/2; i++, j--){
         if( (str.charAt(i)) != (str.charAt(j)) ){
            return false;
         }
      }
      
      return true;
   }
   /*-------------------------------*/
   /*Recursive function #1*/
   public static int recFunc1(int x){
      if(x==0 || x==1){
         return x;
      }
      
      return x + recFunc1(x-1);
   }
   
   
   /*Iterative function #1*/
   //implements recFunc1 iteratively using a for loop and adding i + i + 1 into sum then returning it.
   public static int itrFunc1(int x){
      int sum = 0;
      for(int i = x; i >= 1; i-= 2) {
          sum += i + i-1;
      } 
      return sum;
   }
   /*-------------------------------*/
   
   
   /*Recursive function #2*/
   public static boolean recFunc2(int[] arr, int i, int j){
      if(j <= i){
         return true; 
      }
      
      if(arr[i] != arr[j]){
         return false;
      }
      
      return recFunc2(arr,i+1, j-1);    
   }
   
   /*Iterative function #2*/
   //implements recFunc2 iteratively using a for loop and traverses the array from i to j
   //the function returns true if j<= x (x has the value of i it just increments every iteration of the loop)
   //it returns false if the element at arr[x] is not equal to the element at arr[j]
   public static boolean itrFunc2(int[]arr, int i, int j){
      boolean val = false;
      for(int x = i; x < arr.length; x++) {
          if(j <= x) {
              return !val;
          }
          if(arr[x] != arr[j]) {
              return val;
          }
          j--;
      }
      return val;
   }
   /*-------------------------------*/
   
   
   
   /*Recursive function #3*/
   public static boolean recFunc3(int[] arr, int i, int j){
        if(arr.length <= 1 || i == j){
            return false;
        }
        
        if(arr[i] == arr[i+1]){
            return true;
        }
        
        return recFunc3(arr, i+1, j);
   }
   
   
   /*Iterative function #3*/
   //implements recFunc3 iteratively using a for loop and traverses the array from i to j
   //the function returns false if the length of the array is 1 or if x == j
   //returns true if arr[x] == arr[x+1]
   public static boolean itrFunc3(int[]arr, int i, int j){
      boolean val = false;
      for(int x = i; x < arr.length; x++) {
          if(arr.length <= 1 || x == j) {
              return val;
          }
          if(arr[x] == arr[x + 1]) {
              return !val;
          }
      }
      return val;
   }
   /*-------------------------------*/
   
   
   /*Recursive function #4*/
   public static int recFunc4(int i, int j){
       if(j <= 1){
           return i;
       }
       
       return i + recFunc4(i, j-1);
   }
   
   
   /*Iterative function #4*/
   //implements recFunc4 iteratively, returns the value of i if j <= 1
   //then traverses the array with a forloop from x to j, adding x to sum until j is == 1, then returns sum
   public static int itrFunc4(int i, int j){
      int sum = 0;
      if(j <= 1) {
          return i;
      }
      for(int x = i; j >= 1; j--) {
          sum += x;
      }
      return sum;
   }
   /*-------------------------------*/
   
   
   /*Recursive function #5*/
   public static int recFunc5(int i){
       if(i == 0){
          return 0;
       }
       
       return (i%10) + recFunc5(i/10);
        
   }
   
   
   /*Iterative function #5*/
   //implements recFunc5 iteratively, returning 0 if i == 0
   //then adds i%10 to sum as long as i > 0 then returns sum
   public static int itrFunc5(int i){
      int sum = 0;
      if(i == 0){
          return 0;
      }
      while(i > 0){
          int mod = i%10;
          i = i/10;
          sum += mod;
      } 
      return sum;
   }
   /*-------------------------------*/
   
   
   
   
   /*     Some simple tests
   Do not modify the code below*/
   public static void main(String[] args){
      Random rand = new Random();
      
      
      /*Running sample function*/           
      System.out.println("Running sample function :");
      String[] strs = {"wildcats", "kayak", "civic", "school", "abcdcba"};
      
      for(int i=0; i<strs.length; i++){
         boolean expected = recSample(strs[i]);
         System.out.println("  run # "+(i+1)+":\n"+"    input : "+strs[i]+"       output : "+expected);
         
         boolean result = itrSample(strs[i]);
         if(result != expected){
            System.out.println("    test : FAILED");
         }else{
            System.out.println("    test : PASSED");
         }
      }
      /*--------------------------------------*/
      
      
      /*Running function #1*/           
      System.out.println("\nRunning function #1 :");
      
      for(int i=1; i<=5; i++){
         int randNum = rand.nextInt(11);
         int expected = recFunc1(randNum);
         System.out.println("  run # "+i+":\n"+"    input : "+randNum+" output : "+expected);
         
         int result = itrFunc1(randNum);
         if(result != expected){
            System.out.println("    test : FAILED");
         }else{
            System.out.println("    test : PASSED");
         }
      }
      /*--------------------------------------*/
      
      
       /*Running function #2*/           
      {System.out.println("\nRunning function #2 :");
      int[][] arrays = {{4, 6, 2, 2, 6, 4}, {1, 2, 4, 5, 4, 7, 2}, {1, 2, 1}, {9, 
5, 3, 3, 5, 9}, {4, 3, 2}};
      int[][] inputs = {{1, 3}, {2, 4}, {0, 2}, {0, 4}, {1, 1}};
      
      for(int i=0; i<arrays.length; i++){
         boolean expected = recFunc2(arrays[i], inputs[i][0], inputs[i][1]);
         System.out.println("  run # "+(i+1)+":\n"+"    input : "+Arrays.toString(arrays[i])+
                              ", i="+inputs[i][0]+", j="+inputs[i][1]+"   output : "+expected);
         
         boolean result = itrFunc2(arrays[i], inputs[i][0], inputs[i][1]);
         if(result != expected){
            System.out.println("    test : FAILED");
         }else{
            System.out.println("    test : PASSED");
         }         
      }}
      /*--------------------------------------*/
      
      
      /*Running function #3*/           
      {System.out.println("\nRunning function #3 :");
      int[][] arrays = {{4, 6, 2, 2, 6, 4}, {1, 2, 4}, {1, 2, 1, 1}, {1, 2, 3, 2, 
1}, {9, 9, 9, 9}};
      int[][] inputs = {{1, 4}, {0, 2}, {1, 3}, {0, 4}, {1, 3}};
      
      for(int i=0; i<arrays.length; i++){
         boolean expected = recFunc3(arrays[i], inputs[i][0], inputs[i][1]);
         System.out.println("  run # "+(i+1)+":\n"+"    input : "+Arrays.toString(arrays[i])+
                              ", i="+inputs[i][0]+", j="+inputs[i][1]+"   output : "+expected);
         
         boolean result = itrFunc3(arrays[i], inputs[i][0], inputs[i][1]);
         if(result != expected){
            System.out.println("    test : FAILED");
         }else{
            System.out.println("    test : PASSED");
         }         
      }}
      /*--------------------------------------*/
      
      
      /*Running function #4*/           
      {System.out.println("\nRunning function #4 :");
      
      for(int i=1; i<=5; i++){
         int randNum1 = rand.nextInt(10)+1;
         int randNum2 = rand.nextInt(10)+1;
         int expected = recFunc4(randNum1, randNum2);
         System.out.println("  run # "+i+":\n"+"    input : i="+randNum1+", j= "+randNum2+" output : "+expected);
         
         int result = itrFunc4(randNum1, randNum2);
         if(result != expected){
            System.out.println("    test : FAILED");
         }else{
            System.out.println("    test : PASSED");
         }
      }}
      /*--------------------------------------*/
      
      
      /*Running function #5*/           
      {System.out.println("\nRunning function #5 :");
      
      for(int i=1; i<=5; i++){
         int randNum = rand.nextInt(1000)+1;
         int expected = recFunc5(randNum);
         System.out.println("  run # "+i+":\n"+"    input : i="+randNum+" output : "+expected);
         
         int result = itrFunc5(randNum);
         if(result != expected){
            System.out.println("    test : FAILED");
         }else{
            System.out.println("    test : PASSED");
         }
      }}
      /*--------------------------------------*/
     
   }
}