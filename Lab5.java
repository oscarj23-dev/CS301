// Oscar Maldonado
// May, 18th, 2022
// Lab 5
// CS301

import java.io.*;
import java.util.*;

public class Lab5 {
    /**
     *  Problem 1: Determine the number of nodes based on their number of children.
		Iterative Solution
	*/

    private static int[] problem1Iterative(Node root) {
		// checks if tree exists
		if(root == null) {
			return new int[] {-1,-1,-1};
		}

		// create a new int arr size 3 for the node counter, and a stack to 
		// push the nodes onto
		int[] arr = new int[3];
		Stack<Node> s = new Stack<Node>();
		Node curr = root;
		s.push(curr);

		// while the stack is not empty, go through the if-else if chain to determine
		// whether the node is a leaf, full, or half node.
		while(!s.isEmpty()) {
			if(curr.left == null && curr.right == null) {
				curr = s.pop();
				arr[0]++;
			} else if(curr.left != null && curr.right != null) {
				s.push(curr.left);
				s.push(curr.right);
				arr[2]++;
				curr = s.pop();
			} else if(curr.left != null && curr.right == null) {
				s.push(curr.left);
				arr[1]++;
				curr = s.pop();
			} else if(curr.left == null && curr.right != null) {
				s.push(curr.right);
				arr[1]++;
				curr = s.pop();
			} else if(curr == root) {
				s.pop();
			}
		}
       	return arr;
    }

    /**
     *  Problem 1: Determine the number of nodes based on their number of children.
        Recursive Solution
    */
    private static int[] problem1Recursive(Node root) {
        int[] arr = {0, 0, 0}; 
		
		// create arrays for left and right subtree
        int[] left = {0, 0, 0}; // see how they are used below
        int[] right = {0, 0, 0};
		
		// check if tree exists
        if(root == null) {
            return new int[] {-1, -1, -1};
		}
		
		// essentially the second basecase, check if the node is a leaf,
		// if so increment the proper array index
        if(root.left == null && root.right == null) {
            arr[0]++;
            return arr;
        }

		// go through the if-else if chain to determine
		// whether the node is a leaf, full, or half node.
        if(root.left != null && root.right != null) {
            left = problem1Recursive(root.left); //store the returning array
            right = problem1Recursive(root.right); //store the returning array
            arr[2]++;
        } else if(root.left != null && root.right == null) {
            arr[1]++;
            left = problem1Recursive(root.left); //store the returning array
        } else if(root.left == null && root.right != null) {
            arr[1]++;
            right = problem1Recursive(root.right); //store the returning array
        }
        // now combine the values that got returned from the recursive calls
        arr[0] += left[0] + right[0];
        arr[1] += left[1] + right[1];
        arr[2] += left[2] + right[2];
        return arr;
    }
    
    /**
     *  Problem 2: Determine the maximum distance from the root to a leaf.
        Iterative Solution
	*/
	
	// in essence what I tried doing with this method is what I did with problem1iter
	// I create two stacks for both subtrees and iterate through the tree
	// if its a leaf, increment the   counter cause a leaf node's height is 0
	// if it is a half, increment the counter again and traverse down the node that
	// is not null, and if it is a full, increment the counter and pursue down both 
	// paths untill null is how I wanted this method to work but I ran out of time
	// so this is as far as I got.
    private static int problem2Iterative(Node root) {
		if(root == null) {
			return -1;
		}

		Stack<Node> left = new Stack<>();
		Stack<Node> right = new Stack<>();
		Node leftSub = root.left;
		Node rightSub = root.right;
		int leftTree = -1;
		int rightTree = -1;
		left.push(leftSub);
		right.push(rightSub);

		while(!left.isEmpty()) {
			if(leftSub.left == null && leftSub.right == null) {
				leftSub = left.pop();
				leftTree++;
			} else if(leftSub.left != null && leftSub.right != null) {
				left.push(leftSub.left);
				left.push(leftSub.right);
				leftSub = left.pop();
				leftTree++;
			} else if(leftSub.left != null && leftSub.right == null) {
				left.push(leftSub.left);
				leftSub = left.pop();
				leftTree++;
			} else if(leftSub.left == null && leftSub.right != null) {
				left.push(leftSub.right);
				leftSub = left.pop();
				leftTree++;
			} else if(leftSub == root) {
				left.pop();
			}
		}
		while(!right.isEmpty()) {
			if(rightSub.left == null && rightSub.right == null) {
				rightSub = right.pop();
				rightTree++;
			} else if(rightSub.left != null && rightSub.right != null) {
				right.push(rightSub.left);
				right.push(rightSub.right);
				rightSub = right.pop();
				rightTree++;
			} else if(rightSub.left != null && rightSub.right == null) {
				right.push(rightSub.left);
				rightSub = right.pop();
				rightTree++;
			} else if(rightSub.left == null && rightSub.right != null) {
				right.push(rightSub.right);
				rightSub = right.pop();
				rightTree++;
			} else if(rightSub == root) {
				right.pop();
			}
		}
       	return Math.max(leftTree, rightTree);
    }
    
    /**
     *  Problem 2: Determine the maximum distance from the root to a leaf.
        Recursive Solution
	*/
	// basically a tree traversal, add 1 with every method call, 
	// basecase returns -1 because that would mean the tree does not exist
	// if it does exist 1 because a leaf's height is 0, and recursively
	// repeat this process
    private static int problem2Recursive(Node root) {
        if(root == null) {
            return -1;
        } 
        int h1 = 1 + problem2Recursive(root.left);
        int h2 = 1 + problem2Recursive(root.right);
        return Math.max(h1, h2);
    }
    
    
    
    

    // ---------------------------------------------------------------------
    // Do not change any of the code below!

    static class Node
    {
        public int value;
        public Node left;
        public Node right;
    }

    private static final int LabNo = 5;
    private static final String classNum = "CS 301";

    private static final Random rng = new Random(654321);

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
        int[] left = testCase[0];
        int[] right = testCase[1];
        int[] solution = testCase[2];
        
        
        Node root = makeTree(left, right);

        int[] answer = null;
        
        if(style == 1)
        {
           answer = problem1Iterative(root); 
        }else{
           answer = problem1Recursive(root);
        } 
        

        if (answer == null || answer.length != solution.length) return false;

        for (int i = 0; i < answer.length; i++)
        {
            if (answer[i] != solution[i]) return false;
        }

        return true;
    }

    private static boolean testProblem2(int[][] testCase, int style)
    {
        int[] left = testCase[0];
        int[] right = testCase[1];
        int solution = testCase[2][0];

        Node root = makeTree(left, right);

        int answer = 0;
        
        if(style == 1)
        {
           answer = problem2Iterative(root); 
        }else{
           answer = problem2Recursive(root);
        }

        return solution == answer;
    }

    private static void testProblems(int prob, int style)
    {
        int noOfLines = 10000;

        System.out.println("-- -- -- -- --");
        
        switch (style)
        {
            case 1:
                  System.out.println(noOfLines + " test cases for problem " + prob + " iterative solution.");
                  break;
            case 2:
                  System.out.println(noOfLines + " test cases for problem " + prob + " recursive solution.");
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

                System.out.println("    left: " + Arrays.toString(testCase[0]));
                System.out.println("   right: " + Arrays.toString(testCase[1]));

                passedAll = false;
                break;
            }
        }

        if (passedAll)
        {
            System.out.println("All test passed.");
        }

    }

    private static Node makeTree(int[] left, int[] right)
    {
        int size = left.length;
        Node[] nodes = new Node[size];

        for (int i = 0; i < size; i++)
        {
            nodes[i] = new Node();
        }

        for (int i = 0; i < size; i++)
        {
            if (left[i] >=0) 
               nodes[i].left = nodes[left[i]];
            if (right[i] >=0)
                nodes[i].right = nodes[right[i]];
        }

        return nodes[0];
    }

    private static int[][] makeRndBinaryTree(int size)
    {
        int[] left = new int[size];
        int[] right = new int[size];
        int[] childCount = new int[size];
        int[] values = new int[size];

        ArrayList<Integer> available = new ArrayList<Integer>();

        available.add(0);
        left[0] = -1;
        right[0] = -1;
        values[0] = rng.nextInt(size * size);

        for (int i = 1; i < size; i++)
        {
            int parInd = rng.nextInt(available.size());
            int par = available.get(parInd);

            if (childCount[par] == 0)
            {
                if (rng.nextInt(2) == 0)
                {
                    left[par] = i;
                }
                else
                {
                    right[par] = i;
                }

                childCount[par]++;
            }
            else // childCount[par] == 0
            {
                if (left[par] < 0)
                {
                    left[par] = i;
                }
                else
                {
                    right[par] = i;
                }
                childCount[par]++;

                available.set(parInd, available.get(available.size() - 1));
                available.remove(available.size() - 1);
            }

            left[i] = -1;
            right[i] = -1;

            available.add(i);
        }

        return new int[][] { left, right, childCount };

    }

    private static int[][] createProblem1(int max)
    {
        int maxSize = max < 250 ? max : 250;
        int size = rng.nextInt(maxSize) + 1;

        int[][] rndTree = makeRndBinaryTree(size);
        int[] answer = { 0, 0, 0 };

        for (int i = 0; i < rndTree[2].length; i++)
        {
            answer[rndTree[2][i]]++;
        }

        return new int[][] { rndTree[0], rndTree[1], answer };
    }

    private static int[][] createProblem2(int max)
    {
        int maxSize = max < 250 ? max : 250;
        int size = rng.nextInt(maxSize) + 1;

        int[][] rndTree = makeRndBinaryTree(size);
        int[] dist = new int[size];
        int maxDis = 0;

        for (int i = 0; i < size; i++)
        {
            int left = rndTree[0][i];
            int right = rndTree[1][i];
            int chCnt = rndTree[2][i];

            if (left >= 0) dist[left] = dist[i] + 1;
            if (right >= 0) dist[right] = dist[i] + 1;

            if (chCnt == 0)
            {
                maxDis = Math.max(maxDis, dist[i]);
            }
        }

        return new int[][] { rndTree[0], rndTree[1], new int[] { maxDis } };
    }

}
