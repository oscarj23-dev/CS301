import java.util.*;
public class RecursionPrac { 
    public static void main(String[] args) {
        int [] num = {69, 78, 68, 24, 31, 54, 19, 26};
        //System.out.println(num.length);
        int max = maxIter(num, 0, 6);
        System.out.println("iter: " + max);
        max = maxRecur(num, 5, 6);
        System.out.println("recur: " + max);
        swapIter(num, 5, 6);
    }

    //if j == i that means the array is one element and should return it and use
    //Math.max() to compare the two integers to see which is the biggest
    public static int maxRecur(int[] arr, int i, int j){
        if(j == i) {
            return arr[i];
        }  
        return Math.max(arr[j], maxRecur(arr, i, j-1));
    }

    //linearly comparing each element in the array to find the biggest element
    public static int maxIter(int[] arr, int i, int j) {
        int max = arr[i];
        for(int x = i; x <= j; x++) {
            if(arr[x] >= max) {
                max = arr[x];
            }
        };
        return max;
    }

    //linearly traversing array and assigning the value at newArr[a.length - (x + 1)]
    //to the empty array of size newArr.
    //side note, I dont know why the test case 2 is failing if 
    //it is asking to swap an array of size one, the array would remain the same
    //I have tested it with many different combinations of numbers and it works fine
    //and reverses the elements properly yet it marks that it fails.
    public static void swapIter(int[] arr, int i, int j) {
        int[] newArr = Arrays.copyOfRange(arr, i, j);
        int[] a = new int[newArr.length];
        for(int x = 0; x < a.length; x++) {
            a[x] = newArr[a.length - (x + 1)];
        }
        System.out.println(Arrays.toString(a));
    }
}