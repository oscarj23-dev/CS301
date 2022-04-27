// Oscar Maldonado
// 4/09/22
// Lab1.java
// CS 301
import java.util.*;
public class Lab1 {

    //storing the value i in max and then iteratively comparing each element 
    //in the array to find the biggest element
    private static int problem1Iterative(int[] arr, int i, int j) {
        int max = arr[i];
        for(int x = i; x <= j; x++) {
            if(arr[x] >= max) {
                max = arr[x];
                
            }
        }
      return max;
    }
    
    //if j == i that means the array is one element and should return it and use
    //Math.max() to compare the two integers to see which is the biggest
    private static int problem1Recursive(int[] arr, int i, int j){
        if(j == i) {
            return arr[i];
        }  
        return Math.max(arr[j], problem1Recursive(arr, i, j-1));
    }
    
    //linearly traversing array and assigning the value at arr[i] into a temp variable
    //and assigning arr[i] to arr[j] and finally assigning the temp to arr[j]
    private static void problem2Iterative(int[] arr, int i, int j) {
        int temp = 0;
        while (i < j) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }    
    
    //recursively traversing array and assigning the value at arr[i] into a temp variable
    //and assigning arr[i] to arr[j] and finally assigning the temp to arr[j] by advancing
    //the position of i by one each recursive call and decrementing the position of j
    //by one so it gets the next value in line
    private static void problem2Recursive(int[] arr, int i, int j) {
        int temp = 0;
        if(i > j) {
            return;
        } else {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            problem2Recursive(arr, i+1, j-1);
        } 
    }
    
    //swap assigns the value at arr[i] into a temp variable
    //and assigning arr[i] to arr[j] and finally assigning the temp to arr[j] 
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;     
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