//import java.io.*;
//import java.util.*;
// import java.util.LinkedList;

// Java program to implement 
// a Singly Linked List 
public class linkedlist { 

	Node head; // head of list 

	// Linked list Node. 
	// This inner class is made static 
	// so that main() can access it 
	static class Node { 
		int data; 
		Node next; 

		// Constructor 
		Node(int d) { 
			data = d; 
			next = null; 
		} 
	} 

	// **************INSERTION************** 

	// Method to insert a new node 
	public static linkedlist insert(linkedlist list, int data) {    
        Node newNode = new Node(data);
        list.head = newNode;    
        Node temp = list.head; 

        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        return list;
	} 

	// **************TRAVERSAL************** 

	// Method to print the linkedlist. 
	public static void printList(linkedlist list) { 
		// Traverse through the linkedlist 
			// Print the data at current node 
            // Go to next node 
            Node curr = list.head;
            if(curr == null) {
                System.out.println("The list is empty!");
            } else {
 
                while(curr != null) {
                    System.out.println(curr.data);
                    curr = curr.next;
                }
            }
        }

	// **************DELETION BY KEY************** 

	// Method to delete a n ode in the linkedlist by KEY 
	public static linkedlist deleteByKey(linkedlist list, int key) { 
        Node curr = list.head;
        Node badNode = null;
		// CASE 1: 
        // If head node itself holds the key to be deleted 
        if(curr.data == key) {
            badNode = list.head;
            curr = curr.next;
            badNode = null;
            System.out.println("found and deleted"); 
            return list;
        }  
		// CASE 2: 
        // If the key is somewhere other than at head      
        while(curr != null && curr.data != key) {
            badNode = curr; //prev node
            curr = curr.next; //next node
        }
        // this condition is only true if the entire list was traversed and the key was 
        // not found 
        if(curr == null) {
            System.out.println("Key was not found in list.");
            return list;
        }
        // this code is reached if the curr.data != key condition of the while loop 
        // failed which means the key was found, so we remove the link and return the list.
        badNode.next = curr.next;
        System.out.println("found and deleted: " + key); 
        return list;
	} 

	// **************DELETION AT A POSITION************** 

	// Method to delete a node in the linkedlist by POSITION 
	public static linkedlist deleteAtPosition(linkedlist list, int index) { 
        Node curr = list.head;
        Node badNode = null;
		// CASE 1: 
		// If index is 0, then head node itself is to be deleted 
            // Display the message 
        if(index == 0) {
            badNode = list.head;
            list.head = list.head.next;
            badNode = null;
            System.out.println("position deleted at index: " + index); 
            return list;
        }
 
        // for loop to traverse the linked list to reach one before the end of the list
        for (int i = 0; i < index -1; i++) {
            if(curr != null) {
                curr = curr.next;
            }
        }

        // checks if the current or the next is not null, if those conditions come to pass
        // the current node is stored in the badNode and the curr.next pointer is moved to the 
        // .next.next position and badNode is set to null, cutting off the node.
        if(curr != null && curr.next != null) {
            badNode = curr;
            curr.next = curr.next.next;
            badNode = null;
            System.out.println("position deleted at index: " + index); 
            return list;
        } else {
            System.out.println("position is greater than list size");
            return list;
        }
    } 
    
    // The RemoveDuplicates method takes in a linked list as a parameter and returns one as well.
    // the goal of this method is to remove any duplicates in a sorted singly linked list.
    private static linkedlist removeDuplicates(linkedlist list) {
        Node curr = list.head;
        Node badNode = null;

        if(curr == null) {
            return null;
        }
        // evaluates if the next node is not null, if true an if statement executes
        // and checks if the current nodes data is the same as the next nodes data
        // and if this is true, badNode is set to the current node and curr.next's
        // pointer is moved to .next.next position, setting it equal to the next node
        // to be evaluated, else it advances by one.
        while(curr.next != null) {
            if(curr.data == curr.next.data) {
                badNode = curr;
                curr.next = curr.next.next;
                badNode = null;
            } else {
                curr = curr.next;
            }
        }
        return list;
    }

	// **************MAIN METHOD************** 

	// method to create a Singly linked list with n nodes 
	public static void main(String[] args) { 
		/* Start with the empty list. */
		linkedlist list = new linkedlist(); 

		// 
		// ******INSERTION****** 
		// 

		// Insert the values 
		list = insert(list, 1); 
		list = insert(list, 2); 
		list = insert(list, 3); 
		list = insert(list, 4); 
		list = insert(list, 5); 
		list = insert(list, 6); 
		list = insert(list, 7); 
		list = insert(list, 8); 

		// Print the linkedlist 
		//printList(list); 

		// 
		// ******DELETION BY KEY****** 
		// 

		// Delete node with value 1 
		// In this case the key is ***at head*** 
		//deleteByKey(list, 1); 

		// Print the linkedlist 
		//printList(list); 

		// Delete node with value 4 
		// In this case the key is present ***in the middle*** 
		//deleteByKey(list, 4); 

		// Print the linkedlist 
		//printList(list); 

		// Delete node with value 10 
		// In this case the key is ***not present*** 
		//deleteByKey(list, 10); 

		// Print the linkedlist 
		//printList(list); 

		// 
		// ******DELETION AT POSITION****** 
		// 

		// Delete node at position 0 
		// In this case the key is ***at head*** 
		//deleteAtPosition(list, 0); 

		// Print the linkedlist 
		//printList(list); 

		// Delete node at position 2 
		// In this case the key is present ***in the middle*** 
		//deleteAtPosition(list, 7); 

		// Print the linkedlist 
		//printList(list); 

		// Delete node at position 10 
		// In this case the key is ***not present*** 
		//deleteAtPosition(list, 10); 

		// Print the linkedlist 
		//printList(list); 
                
		// Build a list with duplicates
		linkedlist duplicates = new linkedlist();
		duplicates = insert(duplicates, 1);
		duplicates = insert(duplicates, 1);
		duplicates = insert(duplicates, 1);
		duplicates = insert(duplicates, 2);
		duplicates = insert(duplicates, 3);
		duplicates = insert(duplicates, 3);
        duplicates = insert(duplicates, 4);
		// Print list with duplicates
        printList(duplicates);
        System.out.println();
        
		// Remove duplicates
		duplicates = removeDuplicates(duplicates);
		// Print list without duplicates
		printList(duplicates);
	} 
} 

