import java.util.*;
public class RecursionPrac { 
    public static void main(String[] args) {
        int [] num = {57, 6, 14, 25, 12, 16};
        //System.out.println(num.length);
        int max = maxIter(num, 0, 4);
        System.out.println("iter: " + max);
        max = maxRecur(num, 0, 4);
        System.out.println("recur: " + max);
        //swap(num, 0, 1);
        revIter(num, 0, 4);
        revRec(num, 0, 4);
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
        }
        return max;
    }

    //linearly traversing array and assigning the value at newArr[a.length - (x + 1)]
    //to the empty array of size newArr.
    public static void revIter(int[] arr, int i, int j) {
        int temp = 0;
        while (i < j) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        System.out.println("iterative reverse: " + Arrays.toString(arr));
    }

    public static void revRec(int[] arr, int i, int j) {
        int temp = 0;
        if(i > j) {
            System.out.println("recursive reverse: " + Arrays.toString(arr));
            return;
        } else {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            revRec(arr, i+1, j-1);
        }
    }

    //takes the element at arr[i] and stores it in a temp variable,
    //then stores the value of arr[j] in the position of arr[i]
    //then stores the temp in the position of arr[j]
    public static void swap(int[] arr, int i, int j) {
        System.out.println("before" + Arrays.toString(arr));  
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        System.out.println("after" + Arrays.toString(arr));
    }
}