public class circularLinkedList{
    public Node head = null;
    public Node tail = null;

    class Node {

        int value;
        Node nextNode;
    
        public Node(int value) {
            this.value = value;
        }
    }
    public void addNode(int value) {
        Node newNode = new Node(value);
    
        if (head == null) {
            head = newNode;
        } else {
            tail.nextNode = newNode;
        }
    
        tail = newNode;
        tail.nextNode = head;
    }
    public static void main(String[] args) {
        circularLinkedList c2 = new circularLinkedList();
        c2.addNode(13);
        c2.addNode(7);
        c2.addNode(24);
        c2.addNode(1);
        c2.addNode(8);
        c2.addNode(37);
        c2.addNode(46);
        

        
    }
}