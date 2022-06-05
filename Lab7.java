// Oscar Maldonado
// May 31st, 2022
// CS301
// Lab 7
import java.io.*;
import java.util.*;
public class Lab7
{
    /**
     *  Problem 1: Determine if two given binary search trees store the same 
numbers.
        Iterative Solution
     */
    private static boolean problem1Iterative(Node t1, Node t2) {
        // check if the trees are null, if yes they are the same return true
        if(t1 == null && t2 == null) {
            return true;
        }

        // create two stacks, two temp nodes for both trees and a boolean sentinel value
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        boolean sentinel = false;
        Node currLT = t1;
        Node currRT = t2;

        // ifthe first stack isnt empty OR the node is not null and the second stack is not empty Or the node is not null
        // execute the below code or return the sentinel if the condition fails
        while(!s1.isEmpty() || currLT != null && !s2.isEmpty() || currRT != null) {
            // traverse the first tree
            while(currLT != null) {
                s1.push(currLT);
                currLT = currLT.left;
            }
            currLT = s1.pop();
            // traverse the second tree
            while(currRT != null) {
                s2.push(currRT);
                currRT = currRT.left;
            }
            currRT = s2.pop();
            // check if the keys are the same, set sentinel to true and advance the pointers, else return false
            if(currLT.key == currRT.key) {
                sentinel = true;
                currLT = currLT.right;
                currRT = currRT.right;
            } else {
                sentinel = false;
                return sentinel;
            }
        }
        return sentinel;
    }
    
     /**
     *  Problem 1: Determine if two given binary search trees store the same 
numbers.
        Recursive Solution
     */
    private static boolean problem1Recursive(Node t1, Node t2) {
                // check if the trees are null, if yes they are the same return true
        if(t1 == null && t2 == null) {
            return true;
        } else {
            // ifthe first stack isnt empty OR the node is not null and the second stack is not empty Or the node is not null
            // execute the below code or return false if the condition fails
            if(t1 != null && t2 != null && t1.key == t2.key) {
                boolean val1 = problem1Recursive(t1.left, t2.left);
                boolean val2 = problem1Recursive(t1.right, t2.right);
                return val1 == val2;
            } else {
                return false;
            }
        }
    }

    /**
     *  Problem 2: Determine the sum of all node's keys between min and max 
(inclusive).
        Iterative Solution
     */
    private static int problem2Iterative(Node root, int min, int max) {
        // base case: if null then the sum is 0
        if(root == null) {
            return 0;
        }
        // base case: if the min is greater than the max then the value will always be 0
        if(max < min) {
            return 0;
        }
        Stack<Node> s = new Stack<>();
        int total = 0;
        Node curr = root;

        // check if the nod is null or if the stack is empty
        while(curr != null || !s.isEmpty()) {
            // advance the pointer
            while(curr != null) {
                s.push(curr);
                curr = curr.left;
            }
            curr = s.pop();
            // check if the key is in between the min and max parameters, if yest add that key to the total
            if(curr.key >= min && curr.key <= max) {
                total += curr.key;
            }
            curr = curr.right;
        }
        
        return total;
    }
    
    
     /**
     *  Problem 2: Determine the sum of all node's keys between min and max 
(inclusive).
        Recursive Solution
     */
    private static int problem2Recursive(Node root, int min, int max) {
        // base case: if null then the sum is 0
        if (root == null) {
            return 0;
        }

        // base case: if the min is greater than the max then the value will always be 0
        if(min > max) {
            return 0;
        }
        // recursively call the methods with left and right passed in as parameters
        int h1 = problem2Recursive(root.left, min, max);
        int h2 = problem2Recursive(root.right, min, max);
        
        // check if the key is in between the min and max parameters, if yest add that key to the h1 variable
        if(root.key <= max && root.key >= min) {
            h1 += root.key;
        } 
        // add the h1 and h2 variables together and return that value
        return h1 + h2;
    }
    // ---------------------------------------------------------------------
    // Do not change any of the code below!
    private static class Node
    {
        public Node left = null;
        public Node right = null;
        public int key;
        public Node(int key)
        {
            this.key = key;
        }
    }
    private static void insert(Node root, int key)
    {
        if (root == null)
        {
            root = new Node(key);
            return;
        }
        for (Node node = root;;)
        {
            if (key < node.key)
            {
                if (node.left == null)
                {
                    node.left = new Node(key);
                }
                node = node.left;
            }
            else if (key > node.key)
            {
                if (node.right == null)
                {
                    node.right = new Node(key);
                }
                node = node.right;
            }
            else // key = node.key
            {
                // Nothing to do, because no value to update.
                break;
            }
        }
    }
    private static int[] getInOrder(Node root)
    {
        if (root == null) return new int[] { };
        Stack<Node> stack = new Stack<Node>();
        ArrayList<Integer> orderList = new ArrayList<Integer>();
        for (Node node = root;;)
        {
            if (node == null)
            {
                if (stack.empty()) break;
                node = stack.pop();
                orderList.add(node.key);
                node = node.right;
            }
            else
            {
                stack.push(node);
                node = node.left;
            }
        }
        int[] order = new int[orderList.size()];
        for (int i = 0; i < order.length; i++)
        {
            order[i] = orderList.get(i);
        }
        return order;
    }
    private static int[] getPreOrder(Node root)
    {
        if (root == null) return new int[] { };
        Stack<Node> stack = new Stack<Node>();
        ArrayList<Integer> orderList = new ArrayList<Integer>();
        for (Node node = root;;)
        {
            if (node == null)
            {
                if (stack.empty()) break;
                node = stack.pop();
                node = node.right;
            }
            else
            {
                orderList.add(node.key);
                stack.push(node);
                node = node.left;
            }
        }
        int[] order = new int[orderList.size()];
        for (int i = 0; i < order.length; i++)
        {
            order[i] = orderList.get(i);
        }
        return order;
    }
    private static int[] getPostOrder(Node root)
    {
        if (root == null) return new int[] { };
        Stack<Node> stack = new Stack<Node>();
        Stack<Integer> stackCtr = new Stack<Integer>();
        ArrayList<Integer> orderList = new ArrayList<Integer>();
        stack.push(root);
        stackCtr.push(0);
        while (!stack.empty())
        {
            int ctr = stackCtr.pop();
            Node node = stack.peek();
            if (ctr == 0)
            {
                // First visit.
                stackCtr.push(1);
                if (node.left != null)
                {
                    stack.push(node.left);
                    stackCtr.push(0);
                }
            }
            else if (ctr == 1)
            {
                // Second visit.
                // Left subtree done.
                stackCtr.push(2);
                if (node.right != null)
                {
                    stack.push(node.right);
                    stackCtr.push(0);
                }
            }
            else // ctr >= 2
            {
                // Third visit.
                // Right subtree done.
                stack.pop();
                orderList.add(node.key);
            }
        }
        int[] order = new int[orderList.size()];
        for (int i = 0; i < order.length; i++)
        {
            order[i] = orderList.get(i);
        }
        return order;
    }
    // ---------------------------------------------------------------------
    private static final int LabNo = 7;
    private static final String classNum = "CS 301";
    private static final Random rng = new Random(1);
    public static void main(String args[])
    {
        System.out.println(classNum + " -- Lab " + LabNo);
        testProblems(1, 1);
        testProblems(1, 2);
        testProblems(2, 1);
        testProblems(2, 2);
    }
    private static boolean testProblem1(int[][] testCase, int style)
    {
        int[] tree1 = testCase[0];
        int[] tree2 = testCase[1];
        boolean solution = testCase[2][0] == 1;
        Node root1 = new Node(tree1[0]);
        Node root2 = new Node(tree2[0]);
        for (int i = 1; i < tree1.length; i++)
        {
            insert(root1, tree1[i]);
            insert(root2, tree2[i]);
        }
        
        boolean answer;
        
        if(style == 1)
        {
           answer = problem1Iterative(root1, root2); 
        }else{
           answer = problem1Recursive(root1, root2);
        } 
        return solution == answer;
    }
    private static boolean testProblem2(int[][] testCase, int style)
    {
        int[] tree = testCase[0];
        int[] range = testCase[1];
        int solution = testCase[2][0];
        Node root = new Node(tree[0]);
        for (int i = 1; i < tree.length; i++)
        {
            insert(root, tree[i]);
        }
        int answer;
        
        if(style == 1)
        {
           answer = problem2Iterative(root, range[0], range[1]); 
        }else{
           answer = problem2Recursive(root, range[0], range[1]);
        } 
        return answer == solution;
    }
    private static void testProblems(int prob, int style)
    {
        int noOfLines = 100000;
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
            int[][] testCase = null;
            try
            {
                switch (prob)
                {
                    case 1:
                        testCase = createProblem1(i);
                        passed = testProblem1(testCase, style);
                        break;
                    case 2:
                        testCase = createProblem2(i);
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
                if (prob == 1)
                {
                    System.out.println("  tree 1: " + 
Arrays.toString(testCase[0]));
                    System.out.println("  tree 2: " + 
Arrays.toString(testCase[1]));
                }
                else
                {
                    System.out.println("    tree: " + 
Arrays.toString(testCase[0]));
                    System.out.println("   range: " + 
Arrays.toString(testCase[1]));
                }
                passedAll = false;
                break;
            }
        }
        if (passedAll)
        {
            System.out.println("All test passed.");
        }
    }
    private static void shuffle(int[] arr)
    {
        for (int i = 0; i < arr.length; i++)
        {
            int rndInd = rng.nextInt(arr.length - i) + i;
            int tmp = arr[i];
            arr[i] = arr[rndInd];
            arr[rndInd] = tmp;
        }
    }
    private static int[] getRandomNumbers(int size)
    {
        int maxSize = size * 10;
        int[] integers = new int[maxSize];
        for (int i = 0; i < maxSize; i++)
        {
            integers[i] = i;
        }
        shuffle(integers);
        return Arrays.copyOf(integers, size);
    }
    private static int[][] createProblem1(int max)
    {
        int maxSize = max < 250 ? max : 250;
        int size = rng.nextInt(maxSize) + 5;
        int equal = rng.nextInt(2);
        int[] tree1 = getRandomNumbers(size);
        int[] tree2 = tree1.clone();
        if (equal == 0)
        {
            int ind = rng.nextInt(tree1.length);
            tree1[ind]++;
        }
        return new int[][]
        {
            tree1,
            tree2,
            new int[] { equal }
        };
    }
    private static int[][] createProblem2(int max)
    {
        int maxSize = max < 250 ? max : 250;
        int size = rng.nextInt(maxSize) + 5;
        int[] keys = getRandomNumbers(2 * size);
        int minKey = keys[rng.nextInt(2 * size)];
        int maxKey = keys[rng.nextInt(2 * size)];
        shuffle(keys);
        int[] tree = Arrays.copyOf(keys, size);
        int sum = 0;
        for (int i = 0; i < tree.length; i++)
        {
            if (tree[i] >= minKey && tree[i] <= maxKey)
            {
                sum += tree[i];
            }
        }
        return new int[][]
        {
            tree,
            new int[] { minKey, maxKey },
            new int[] { sum }
        };
    }
}
