public class forwardAndBack
//solves Q4
//If the list was circular, and you had no check for the tail, you would go on and on and on forever and ever and ever.
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
    public forwardAndBack()
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
        if(checkEmpty()){ head = newNode;}
        else{tail.next = newNode;}
        newNode.last = tail;
        tail = newNode;
        sizeOf++;
    }
    // public void printSkip(){
    //     if(checkEmpty()){System.out.print("Empty List"); return;}
    //     System.out.print(head.data + "\t");
    //     node current = head;
    //     while(current.next != null)
    //     {
    //         node newCurrent = current.next;
    //         if(newCurrent.next != null)
    //         {
    //             System.out.print(newCurrent.next.data + "\t");
    //             current = newCurrent.next;
    //         }
    //         else{System.out.print("\n**done with 1-skip**\n"); return;}
            
    //     }
    //     System.out.print("\n**done with 1-skip**\n");
    // }

    // public void printSkip3(){
    //     if(checkEmpty()){System.out.print("Empty List"); return;}
    //     System.out.print(head.data + "\t");
    //     node current = head;
    //     while(current.next.next != null)
    //     {
    //         node newCurrent = current.next.next;
    //         if(newCurrent.next.next != null)
    //         {
    //             System.out.print(newCurrent.next.next.data + "\t");
    //             current = newCurrent.next;
    //         }
    //         else{System.out.print("\n**done with 3-skip**\n"); return;}
    //     }
    //     System.out.print("\n**done with 3-skip**\n");
        
    // }
//solution to 4 is here.
    public void forwardAndBackPrint(){
        if(checkEmpty()){System.out.print("Empty List"); return;}
        node current = head;
        while(current != tail)
        {
            System.out.print(current.data + "\t");
            current = current.next;
        }
        System.out.print(current.data + "\t" + "\nforward complete\n");

        while(current != head)
        {
            System.out.print(current.last.data + "\t");
            current = current.last;
        }
        System.out.print("\nfinished reverse");
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
        forwardAndBack lls = new forwardAndBack();
        lls.insert(3);
        lls.insert(5);

        lls.insert(5);
        lls.insert(7);

        lls.insert(11);
        lls.insert(13);

        lls.insert(17);
        lls.insert(19);

        lls.forwardAndBackPrint(); //expect 3,5,5,6,11,13,17,19--,17,13,11,7,5,5,3--
        //lls.printSkip(); //expect 3,5,11,17
        //lls.printSkip3(); //expect 3,11,19

    }

}