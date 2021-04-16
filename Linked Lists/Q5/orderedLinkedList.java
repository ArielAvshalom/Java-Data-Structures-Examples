public class orderedLinkedList
//This will solve Q5. It is not complete yet. There is an error in the insertOrdered code somewhere.
//Over here I have both a regular end-based insert and an ordered insert.

//My delete traverses through the whole linked list because I'm not assuming it's ordered.
//delete works as long as ordered insert is not used.

//It isn't to difficult to change that into a delete that could stop partway 
//once the data in the node is greater than the value to delete.
{
    node head;
    node tail;
    int sizeOf;

    class node
    {
        public node next;
        public node last;
        public int data;

        //Bunches of getters and setters.
        // ______________________
        // < self and __init__... >
        //  ----------------------
        //         \   ^__^
        //          \  (xx)\_______
        //             (__)\       )\/\
        //              U  ||----w |
        //                 ||     ||
        public void setData(int value){this.data = value;}
        public int getData(){return this.data;}
        public void setNext(node nextNode){this.next = nextNode;}
        public node getNext(){return this.next;}
        node(int value){this.data = value;}
        node(int value, node next)
        {
            this.data = value;
            this.next = next;
        }

        
    }
    public orderedLinkedList()
    {
        this.head = null;
        this.tail = null;
        this.sizeOf = 0;
    }

    public boolean checkEmpty()
    {
        //return true if empty, false if list contains elements
        if(sizeOf == 0) {return true;}
        else {return false;}
    }

    public void insert(int data) 
    {
        node newNode = new node(data);
        if(checkEmpty()){ head = newNode; sizeOf++;}
        else{tail.next = newNode;}
        newNode.last = tail;
        tail = newNode;
        sizeOf++;
    }

    public void insertOrdered(int data)
    {
        node newNode = new node(data);
        node current; //the node we'll use to iterate
        if(checkEmpty() || head.data > newNode.data){ newNode.next = head; head = newNode; sizeOf++;}
        else
        {
            current = head; //starting iteration here
            while(current != null && current.next.data < newNode.data)
            {
                current = current.next;
                newNode.next = current.next;
                current.next = newNode;

                // if(newNode.data > current.data){current = current.next;}
                // //if(newNode.data <= current.data)
                // else
                // {
                //     node previous = current.last;
                //     node forward = current;
                //     current = newNode;
                //     current.last = previous;
                //     current.next = forward;
                    
                    
                    
                //     //newNode.last = previous;
                //     //newNode.next = current;
                //     //current.last = newNode;
                //     //previous.next = current;
                //     //System.out.print("\nInserted " + newNode.data + " between " + newNode.last.data + " aka previous " + previous.data + " and " + newNode.next.data + " current node is " + current.data);
                //     sizeOf++;
                //     return;
                // }
            }
            // tail.next = newNode;
            // newNode.last = tail;
            // tail = newNode;
            // sizeOf++;
        }
    }
    public void delete(int value)
    {
        node current = head;

        while(current != null){
            if(current.data== value)
            {
                node last = current.last;
                node next = current.next;
                last.next = next;
                next.last = last;
                System.out.print("\nDeleted node " + current.data + " Link established between\t" + last.data + "\tand \t" + next.data + "\n");
                return;
            }
            else{current = current.next;}
        }
        System.out.print("\nDid not find node with data value " + value + "\n");
    }

    public void printList(){
        if(checkEmpty()){System.out.print("Empty List"); return;}
        node current = head;
        while(current != null)
        {
            System.out.print(current.data + "\t");
            current = current.next;
        }
        System.out.print("\n**finished printing list**\n");
    }
    

    public static void main(String[] args) {
        // _____________
        // < twin primes >
        //  -------------
        //         \   ^__^
        //          \  (oo)\_______
        //             (__)\       )\/\
        //                 ||----w |
        //                 ||     ||
        orderedLinkedList lls = new orderedLinkedList();
        lls.insert(3);
        lls.insert(5);

        lls.insert(5);
        lls.insert(7);

        lls.insert(11);
        lls.insert(13);

        lls.insert(17);
        lls.insert(19);

        lls.printList();
        //lls.insertOrdered(4);
        lls.printList();
        //lls.insertOrdered(6);
        lls.printList();

        lls.delete(11);
        lls.delete(9);
        lls.delete(11);
        lls.delete(5);
        lls.printList();
        lls.delete(5);
        lls.printList();

        //lls.forwardAndBackPrint(); //expect 3,5,5,6,11,13,17,19--,17,13,11,7,5,5,3--
        //lls.printSkip(); //expect 3,5,11,17
        //lls.printSkip3(); //expect 3,11,19

    }

}