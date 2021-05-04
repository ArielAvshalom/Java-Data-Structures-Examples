//We're going to max heap
//link: https://www.geeksforgeeks.org/max-heap-in-java/

public class MaxHeap_GFG {
    private int[] Heap;
    private int size;
    private int maxsize;

    //constructor for a heap with input maxsize

    public MaxHeap_GFG(int maxsize) {
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new int[this.maxsize + 1];
        Heap[0] = Integer.MAX_VALUE;
    }

    //This is a tree and we need a way to see where it is on an "array"
    private int parent(int pos) {return pos/2;}
    private int leftChild(int pos) {return (2*pos);}
    private int rightChild(int pos) {return (2*pos)+1;}

    private boolean isLeaf(int pos){
        if (pos > (size/2) && pos <= size){ return true;}
        return false;
    }

    //If the parent is smaller than the child [leaf and parent] then swap them

    private void swap(int fpos, int spos){
        int tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }

    private void maxHeapify(int pos){
        if (isLeaf(pos))
            return;
        
        if (Heap[pos] < Heap[leftChild(pos)] || Heap[pos] < Heap[rightChild(pos)]) {
            if (Heap[leftChild(pos)] > Heap[rightChild(pos)]) {
                swap(pos, leftChild(pos));
                maxHeapify(leftChild(pos));
            }
            else{
                swap(pos, rightChild(pos));
                maxHeapify(rightChild(pos));
            }
        }
    }

    public void insert (int element){
        Heap[++size] = element;
        
        int current = size;
        while (Heap[current] > Heap[parent(current)]){
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public void print(){
        for (int i = 1; i <= size/2; i++){
            System.out.print("Parent : " + Heap[i]
            + "Left Child : " + Heap[2*i]
            + "Right Child : " + Heap[2*i+1]);
            System.out.println();
        }
    }

    public int extractMax()
    {
        int popped = Heap[1];
        Heap[1] = Heap[size--];
        maxHeapify(1);
        return popped;
    }
    //Worst case O(N(LOGN)) for a sorter based on heapify.
    public static void main(String[] arg)
    {
        System.out.println("The Max Heap is ");
        MaxHeap_GFG maxHeap = new MaxHeap_GFG(15);
        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(17);
        maxHeap.insert(10);
        maxHeap.insert(84);
        maxHeap.insert(19);
        maxHeap.insert(6);
        maxHeap.insert(22);
        maxHeap.insert(9);
  
        maxHeap.print();
        System.out.println("The max val is "
                           + maxHeap.extractMax());
    }
}



/*abstract
                        
                        21
                13              20
            8       6       7       11


*/