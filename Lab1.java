import java.io.*;
import java.util.*;
public class Lab1
{
    /**
     *  Problem 1: Finds the largest number in a specific range of the given array.
        Iterative solution
     */
    private static int problem1Iterative(int[] arr, int i, int j) {
        int max = arr[i];
        for(int x = i; x <= j; x++) {
            if(arr[x] >= max) {
                max = arr[x];
            }
        }
      return max;
    }
    
    
    
    /**
     *  Problem 1: Finds the largest number in a specific range of the given array.
        Recursive solution
     */
    private static int problem1Recursive(int[] arr, int i, int j){
        if(j == i) {
            return arr[i];
        }  
        return Math.max(arr[j], problem1Recursive(arr, i, j-1));
    }
    
    /**
     *  Problem 2: Reverse a specific range in a given array.
        Iterative solution
     */
    private static void problem2Iterative(int[] arr, int i, int j){
        int[] newArr = Arrays.copyOfRange(arr, i, j);
        int[] a = new int[newArr.length];
        
      
        for(int x = 0; x < a.length; x++) {
            a[x] = newArr[a.length - (x + 1)];
        }
        //System.out.println(Arrays.toString(a));
    }    
    
     /**
     *  Problem 2: Reverse a specific range in a given array.
        Recursive solution
     */
    private static void problem2Recursive(int[] arr, int i, int j)
    {
        //implement me!   
    }
    
    /**
     *  Swap the items at index i and j of the given array.
        Helper function.
     */
    private static void swap(int[] arr, int i, int j)
    {
        //implement me!     
    }
    // ---------------------------------------------------------------------
    // Do not change any of the code below!
    private static final int LabNo = 1;
    private static final Random rng = new Random(30118);
    public static void main(String args[])
    {
        System.out.println("CS 301 -- Lab " + LabNo);
        testProblems(1, 1);
        testProblems(1, 2);
        testProblems(2, 1);
        testProblems(2, 2);
    }
    private static boolean testProblem1(int[][] testCase, int style)
    {
        int[] arr = testCase[0].clone();
        int i = testCase[1][0];
        int j = testCase[1][1];
        int[] arr2 = arr.clone();
        Arrays.sort(arr2, i, j + 1);
         
        int solution = arr2[j];
        int result = 0;
        
        if(style == 1)
        {
           result = problem1Iterative(arr, i, j); 
        }else{
           result = problem1Recursive(arr, i, j);
        }       
        return result == solution;
    }
    private static boolean testProblem2(int[][] testCase, int style)
    {
        int[] arr = testCase[0].clone();
        int i = testCase[1][0];
        int j = testCase[1][1];
        int[] arr2 = arr.clone();
        if(style == 1)
        {
           problem2Iterative(arr, i, j); 
        }else{
           problem2Recursive(arr, i, j);
        }  
        
         
        for (int ind = 0; ind <= j - i; ind++)
        {
            if (arr[i + ind] != arr2[j - ind]) return false;
        }
        return true;
    }
    private static void testProblems(int prob, int style)
    {
        int noOfLines = 10000;
        System.out.println("-- -- -- -- --");
        
        switch (style)
        {
            case 1:
                  System.out.println(noOfLines + " test cases for problem " + prob 
+ " iterative solution.");
                  break;
            case 2:
                  System.out.println(noOfLines + " test cases for problem " + prob 
+ " recursive solution.");
                  break;
        }
        boolean passedAll = true;
        for (int i = 1; i <= noOfLines; i++)
        {
            boolean passed = false;
            boolean exce = false;
            int[][] testCase = createProblem(5 * i);
            try
            {
                switch (prob)
                {
                    case 1:
                        passed = testProblem1(testCase, style);
                        break;
                    case 2:
                        passed = testProblem2(testCase, style);
                        break;
                }
            }
            catch (Exception ex)
            {
                passed = false;
                exce = true;
            }
            if (!passed)
            {
                System.out.println("Test " + i + " failed!" + (exce ? " (Exception)" : ""));
                System.out.println("    arr: " + Arrays.toString(testCase[0]));
                System.out.println("    i = " + testCase[1][0] + "  |  j = " + 
testCase[1][1]);
                passedAll = false;
                break;
            }
        }
        if (passedAll)
        {
            System.out.println("All test passed.");
        }
    }
    private static int[][] createProblem(int max)
    {
        int maxSize = max < 500 ? max : 500;
        int size = rng.nextInt(maxSize) + 1;
        int[] numbers = getRandomNumbers(size);
        int j = rng.nextInt(size);
        int i = rng.nextInt(j + 1);
        return new int[][] { numbers, new int[] { i, j } };
    }
    private static int[] getRandomNumbers(int size)
    {
        int maxSize = size * 10;
        int[] integers = new int[maxSize];
        for (int i = 0; i < maxSize; i++)
        {
            integers[i] = i;
        }
        // Shuffle
        for (int i = 0; i < maxSize; i++)
        {
            int rndInd = rng.nextInt(maxSize - i) + i;
            int tmp = integers[i];
            integers[i] = integers[rndInd];
            integers[rndInd] = tmp;
        }
        return Arrays.copyOf(integers, size);
    }
}