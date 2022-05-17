public class node {
    static class Node { 
		int data; 
		Node next; 

		// Constructor 
		Node(int d) { 
			data = d; 
			next = null; 
		} 
    } 
    
    public Node problem3(Node L) {
        if(L == null || L. next == null) {
            return L;
        }
        Node n = L.next;
        Node r = problem3(n.next);
        L.next = r;
        n.next = L;
        return n;

    }

    
}
