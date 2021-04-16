public class orderedLinkedList
//this solves Q5
//Over here I have both a regular end-based insert and an ordered insert.

//My delete traverses through the whole linked list until it finds the value to delete. If it doesn't find it, it'll return that the value was not found.
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

    public void orderedInsert(int data)
    {
        node newNode = new node(data);
        node current;
        if(checkEmpty() || head.data > newNode.data){ newNode.next = head; head = newNode; sizeOf++; return;}
        current = head;
        while(current != null)
        {
            if(newNode.data > current.data){current = current.next;}
            else //newNode.data <= current.data
            {
                node last = current.last;
                last.next = newNode;
                newNode.last = last;
                newNode.next = current;
                current.last = newNode;

                sizeOf++;
                System.out.print("\nInserted " + newNode.data + " between " + newNode.last.data + " and " + newNode.next.data + "\n");
                return;
            }
            
            
        }
        tail.next = newNode;
        newNode.last = tail;
        tail = newNode;
        sizeOf++;
    }

    public void delete(int value)
    {
        //check if the head element has the value you'd like to remove.
        if(head.data == value){head = head.next; return;}
        //check if the tail element has the value you'd like to remove.
        if(tail.data == value)
        {
            node last = tail.last;
            last.next = null;
            tail = last; 
            return;
        }
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
        lls.delete(11);
        lls.delete(9);
        lls.delete(11);
        lls.delete(5);
        lls.printList();
        lls.delete(5);
        lls.printList();
        System.out.print("\n***testing for ordered insert***\n");
        lls.orderedInsert(9);  //in middle
        lls.orderedInsert(10); //in middle after previous insert
        lls.orderedInsert(10); //check if duplicates work
        lls.orderedInsert(11); //in middle
        lls.orderedInsert(10); //between two inserted nodes
        lls.orderedInsert(2); //at beginning
        lls.orderedInsert(18); //towards end of list
        lls.orderedInsert(20); //at the end.
        lls.printList();
        //all of the above inserts work!

        System.out.print("\n***testing for delete***\n");
        lls.delete(20);
        lls.delete(19);
        lls.printList();
        lls.delete(20);
        lls.delete(2);
        lls.printList();
        lls.delete(10);
        lls.delete(1);
        lls.delete(100);
        lls.printList();

        //lls.forwardAndBackPrint(); //expect 3,5,5,6,11,13,17,19--,17,13,11,7,5,5,3--
        //lls.printSkip(); //expect 3,5,11,17
        //lls.printSkip3(); //expect 3,11,19

    }

}