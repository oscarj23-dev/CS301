import java.util.*;
public class RecursionPrac { 
    public static void main(String[] args) {
        int [] num = {2, 7, 4, 9, 3};
        int val = itrFunc5(77);
        int val2 = recFunc5(77);
        System.out.println("iter: " + val);        
        System.out.println("rec: " + val2);

    }

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

     public static int recFunc5(int i){
        if(i == 0){
           return 0;
        }
        return (i%10) + recFunc5(i/10);
    }
    // //if j == i that means the array is one element and should return it and use
    // //Math.max() to compare the two integers to see which is the biggest
    // public static int maxRecur(int[] arr, int i, int j){
    //     if(j == i) {
    //         return arr[i];
    //     }  
    //     return Math.max(arr[j], maxRecur(arr, i, j-1));
    // }

    // //linearly comparing each element in the array to find the biggest element
    // public static int maxIter(int[] arr, int i, int j) {
    //     int max = arr[i];
    //     for(int x = i; x <= j; x++) {
    //         if(arr[x] >= max) {
    //             max = arr[x];
    //         }
    //     }
    //     return max;
    // }

    // //linearly traversing array and assigning the value at newArr[a.length - (x + 1)]
    // //to the empty array of size newArr.
    // public static void revIter(int[] arr, int i, int j) {
    //     int temp = 0;
    //     while (i < j) {
    //         temp = arr[i];
    //         arr[i] = arr[j];
    //         arr[j] = temp;
    //         i++;
    //         j--;
    //     }
    //     System.out.println("iterative reverse: " + Arrays.toString(arr));
    // }

    // public static void revRec(int[] arr, int i, int j) {
    //     int temp = 0;
    //     if(i > j) {
    //         System.out.println("recursive reverse: " + Arrays.toString(arr));
    //         return;
    //     } else {
    //         temp = arr[i];
    //         arr[i] = arr[j];
    //         arr[j] = temp;
    //         revRec(arr, i+1, j-1);
    //     }
    // }

    // //takes the element at arr[i] and stores it in a temp variable,
    // //then stores the value of arr[j] in the position of arr[i]
    // //then stores the temp in the position of arr[j]
    // public static void swap(int[] arr, int i, int j) {
    //     System.out.println("before" + Arrays.toString(arr));  
    //     int temp = arr[i];
    //     arr[i] = arr[j];
    //     arr[j] = temp;
    //     System.out.println("after" + Arrays.toString(arr));
    // }
}
