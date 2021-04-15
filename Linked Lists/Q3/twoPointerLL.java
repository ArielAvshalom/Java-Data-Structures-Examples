public class twoPointerLL{
    Node head;

    static class Node 
    {
        
        int nodeData;
        Node next;
        Node nextnext;

        Node(int data)
        {
            nodeData = data;
            next = null;
            nextnext = null;
        }
    }

    public static twoPointerLL insert(twoPointerLL list, int nodeData, int nodeData2, int nodeData3)
    {
        Node new_node = new Node(nodeData);
        Node new_node2 = new Node(nodeData2);
        Node new_node3 = new Node(nodeData3);
        new_node.next = new_node2;
        new_node.nextnext = new_node3;
        new_node2.next = new_node3;

        if(list.head == null){
            list.head= new_node;
            System.out.println("\tTesting head: " + list.head.nodeData + "\t" + list.head.next.nodeData + "\t" + list.head.nextnext.nodeData);
        }
        else{
            Node last = list.head;
            while(last.next != null){
                last = last.next;
            }

            last.next = new_node.next;
            last.nextnext = new_node.nextnext;
            System.out.print("\tTesting adding after head: " + last.nodeData + "\t" + last.next.nodeData + "\t" + last.nextnext.nodeData + "\n\n");
        }
        
        return list;
    }

    public static void printListSkip1(twoPointerLL list)
    {
        Node currentNode = list.head;

        while (currentNode != null){
            System.out.print(currentNode.nodeData + "\n");

            currentNode = currentNode.nextnext;
        }
        System.out.print("Finished 1 skip");
    }

    public static void printListSkip3(twoPointerLL list)
    {
        Node currentNode = list.head;
        while(currentNode != null){
            System.out.print(currentNode.nodeData + "\n");
            currentNode = currentNode.nextnext;
            currentNode = currentNode.nextnext;
        }
        System.out.print("Finished 3 skip");
    }

    public static void main(String[] args) {
        twoPointerLL list = new twoPointerLL();

        list = insert(list, 1, 314159, 27891);
        list = insert(list, 314159, 27891, 756125);
        list = insert(list, 27891, 756125, 314159);
        list = insert(list, 756125, 314159, 27891);
        list = insert(list, 314159, 27891, 756125);
        list = insert(list, 27891, 756125, 123);
        list = insert(list, 756125, 123, 456);

        printListSkip1(list);
        printListSkip3(list);
    }
}