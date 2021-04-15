import java.io.*;

public class linkedList{
    Node head;

    static class Node {
        
        int nodeData;
        Node next;

        Node(int data)
        {
            nodeData = data;
            next = null;
        }
    }

    public static linkedList insert(linkedList list, int nodeData)
    {
        Node new_node = new Node(nodeData);
        new_node.next = null;

        if(list.head == null){
            list.head= new_node;
        }
        else{
            Node last = list.head;
            while (last.next != null){
                last = last.next;
            }

            last.next = new_node;
        }

        return list;

    }

    public static void printList(linkedList list)
    {
        Node currentNode = list.head;

        System.out.print("Here is our crazy old linked list: ");

        while (currentNode != null){
            System.out.print(currentNode.nodeData + " ");

            currentNode = currentNode.next;
        }
    }


    public static void main(String[] args)
    {
        linkedList list = new linkedList();

        list = insert(list, 1);
        list = insert(list, 314159);
        list = insert(list, 27891);
        list = insert(list, 756125);

        printList(list);

    }

}