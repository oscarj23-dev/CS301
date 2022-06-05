import java.util.*;
class Node{
   int value;
   Node left, right;
   
   public Node(int value){
      this.value = value;
      left = null;
      right = null;
   }
}
class BinaryTree{
   Node root;
   
   /*
   inserts a node into the tree
   */
   public void insert(int value){
      //tree is empty
      if(root == null){
         root = new Node(value);
         return;
      }else{
         Node current = root;
         Node parent = null;
         
         while(true){
            parent = current;
            
            if(value < current.value){
               current = current.left;
               if(current == null){
                  parent.left = new Node(value);
                  return;
               }
            }else{
               current = current.right;
               if(current == null){
                  parent.right = new Node(value);
                  return;
               }
            }
           
         }//clossing while
      
      }//clossing main if-else 
   }
   
   
   /*
   recursive insert method
   */
   public Node insert(Node root, int value){
      //base case
      if(root == null){
         root = new Node(value);
         return root;
      }
      
      //recursive step
      if(value < root.value){
         root.left = insert(root.left, value); 
      }else{
         root.right = insert(root.right, value);
      }
      
      return root;
   }
   
   /*
   a method to find the node in the tree
   with a specific value
   */
   public boolean find(Node root, int key){
      if(root == null){
         return false;
      }
      
      if(root.value == key){
         return true;      
      }else if(key < root.value){
         return find(root.left, key);
      }else{
         return find(root.right, key);
      }
           
   }
   
   
   
   /*
   pre-order traversal
   */
   public void preOrderTraversal(Node root){
      //base case
      if(root == null){
         return;
      }
      
      System.out.print(root.value+" ");
      //go left recursively
      preOrderTraversal(root.left);
      //go right recursively
      preOrderTraversal(root.right);
   }
   
   
   /*
   in-order traversal
   */
   public void inOrderTraversal(Node root){
      //base case
      if(root == null){
         return;
      }
      
      //go left recursively
      inOrderTraversal(root.left);
      //process the root
      System.out.print(root.value+" ");
      //go right recursively
      inOrderTraversal(root.right);
   }
   
   
   /*
   post-order traversal
   */
   public void postOrderTraversal(Node root){
      //base case
      if(root == null){
         return;
      }
      
      //go left recursively
      postOrderTraversal(root.left);
      //go right recursively
      postOrderTraversal(root.right);
      //process the root
      System.out.print(root.value+" ");
      
   }
   
   
   /*
   in-reverse-sorted-order traversal
   */
   public void reverseSorted(Node root){
      //base case
      if(root == null){
         return;
      }
      
      //go right recursively
      reverseSorted(root.right);
      //process the root
      System.out.print(root.value+" ");
      //go left recursively
      reverseSorted(root.left);
      
   }
   
   
   
   
   
   /*
   Iterative Implementation for Pre-Order Traversal
   */
   
   public ArrayList<Integer> preOrder(Node root){
      //node, left, right
      
      if(root == null){
         return new ArrayList<>();
      }
      
      Stack<Node> stack = new Stack<Node>();
      ArrayList<Integer> list = new ArrayList<>();
      Node temp = root;
      
      while(true){
      
         if(temp == null){
           
           if(stack.isEmpty()){
               break;
           }
           
           temp = stack.pop();
           temp = temp.right;
            
         }else{
            list.add(temp.value);
            stack.push(temp);
            temp = temp.left;
         }
      }
      
      
      //implement me
      return list;
   }
   
   
   
   
   /*
   Iterative Implementation for Pre-Order Traversal
   */
   
   public ArrayList<Integer> inOrder(Node root){
    if(root == null){
        return new ArrayList<>();
     }
     
     Stack<Node> stack = new Stack<Node>();
     ArrayList<Integer> list = new ArrayList<>();
     Node temp = root;
     
     while(true){
     
        if(temp == null){
          
          if(stack.isEmpty()){
              break;
          }
          
          temp = stack.pop();
          temp = temp.right;
           
        }else{
            temp = temp.left;
            list.add(temp.value);
            stack.push(temp);
        }
     }
     
     
     //implement me
     return list; 
   }
   
   
   public ArrayList<Integer> postOrder(Node root){
         if(root == null){
            return new ArrayList<>();
         }
         
         Stack<Node> stack = new Stack<Node>();
         Stack<Integer> counterStack = new Stack<Integer>();
         ArrayList<Integer> list = new ArrayList<>();
         Node temp = root;
         
         stack.push(temp);
         counterStack.push(1);
         
         while(!stack.isEmpty()){
         
            int counter = counterStack.pop();
            temp = stack.peek();//retrieve the value but not remove it
            
            if(counter == 1){//first time
               //go left
               counterStack.push(2);
               
               if(temp.left != null){
                  counterStack.push(1);
                  stack.push(temp.left);
               }
               
               
            }else if(counter == 2){//second time
               //have gone to the left
               counterStack.push(3); //marked for next visit
               
               if(temp.right != null){
                  counterStack.push(1);
                  stack.push(temp.right);
               }
            
            }else{//third time
               stack.pop();
               list.add(temp.value);
            }
            
         }
         
         
         //implement me
         return list;
   
   }
   
   
   
   
}
public class TreeDemo{
   public static void main(String[] args){
      BinaryTree t1  = new BinaryTree();
      t1.insert(24);
      t1.insert(80);
      t1.insert(18);
      t1.insert(9);
      t1.insert(90);
      t1.insert(22);
      
      /*  traversals  */
      System.out.print("pre-order : ");
      t1.preOrderTraversal(t1.root);
      System.out.println();
      
      ArrayList<Integer> preOrder = t1.preOrder(t1.root);
      
      System.out.print("pre-order : ");
      for(int x : preOrder){
         System.out.print(x+" ");      
      }
      
      System.out.println();
      
      /*
      *******************************
      */
      
      
      System.out.print("in-order :   ");
      t1.inOrderTraversal(t1.root);
      System.out.println();
      
      
      ArrayList<Integer> inOrder = t1.inOrder(t1.root);
      
      System.out.print("in-order :   ");
      for(int x : inOrder){
         System.out.print(x+" ");      
      }
      
      System.out.println();
       /*
      *******************************
      */
      
     
      
      
      System.out.print("post-order :  ");
      t1.postOrderTraversal(t1.root);
      System.out.println();
 
      ArrayList<Integer> postOrder = t1.postOrder(t1.root);
      
      System.out.print("in-order :   ");
      for(int x : postOrder){
         System.out.print(x+" ");      
      }
      
      System.out.println();
      
      
      //System.out.print("out-order :  ");
      //t1.reverseSorted(t1.root);
      //System.out.println();
      
      
      //System.out.println(t1.find(t1.root, 30));
      
      /*BinarySearchTree t2 = new BinarySearchTree();
      t2.root = t2.insert(t2.root, 50);
      t2.root = t2.insert(t2.root, 25);
      t2.root = t2.insert(t2.root, 15);
      t2.root = t2.insert(t2.root, 30);
      t2.root = t2.insert(t2.root, 75);
      t2.root = t2.insert(t2.root, 85);
      
      t2.inOrderTraversal(t2.root);
      System.out.println();
      */
      
      
   }  
}