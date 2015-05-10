 public final class MergeNSortedArray {

    private final PriorityQueue<NodeType> heap;
    private int totalLength;

    public MergeNSortedArray() {
        heap = new PriorityQueue<NodeType>();
    }

    /**
     * All rows of the matrix are expected to be sorted.
     * Else results are unpredictable.
     * 
     * @param matrix
     */
    public MergeNSortedArray(int[][] matrix) {
        if (matrix == null) {
            throw new NullPointerException("The input matrix is null");
        }
        heap = new PriorityQueue<NodeType>();
        addAll(matrix);
    }

    private void addAll(int[][] matrix) {
        for (int[] a : matrix) {            
            add(a);
        }
    }

    /**
     * The input array is expected to be sorted, else results are unpredictable.
     * @param a
     */
    public void add(int[] a) {
        if (a.length == 0) { throw new IllegalArgumentException("Array size should be greater then zero."); }

        totalLength += a.length;
        heap.add(new NodeType(a));
    }

    /**
     * Keeps a counter, to keep track of current element to be considered to 
     * sort.
     * 
     * Any element before the currentIndex, has already been placed in the sorted array.
     *
     */
    private static class NodeType implements Comparable<NodeType> {
        private int index;
        private int[] array;

        public NodeType(int[] array) {
            this.array = array;
        }

        public boolean isFull() {
            return index == array.length;
        }

        public int peek() {
            return array[index];
        } 

        public int getIntAndIncrement() {
            return array[index++];
        }

        //@Override
        public int compareTo(NodeType o) {
            return new Integer(peek()).compareTo(o.peek());
        }
    }

    public int[] mergeNArrays() {
        int[] result = new int[totalLength];
        int index = 0;

        while (!heap.isEmpty()) {
            final NodeType Node = heap.poll();
            result[index++] = Node.getIntAndIncrement();
            if (!Node.isFull())
             //   continue;
            {heap.add(Node);}
        }
        return result;
    }
    
    public static void main(String[] args){
    int[] arr1 = {2,4,6,8,9,12,14,16};
        int[] arr2 = {3,6,7,9,22,25,28};
        int[] arr3 = {2,5,7,8,10,11,16};
        int[] arr4 = {4,8,23,26,28};

        MergeNSortedArray msa = new MergeNSortedArray(new int[][]{arr1, arr2, arr3, arr4});
        int[] expected=msa.mergeNArrays();
    System.out.println(Arrays.toString(expected));
    }
}


/*
public class MergeNSortedArrayTest {

    @Test
    public void testMerge() {
        int[] arr1 = {2,4,6,8,9,12,14,16};
        int[] arr2 = {3,6,7,9,22,25,28};
        int[] arr3 = {2,5,7,8,10,11,16};
        int[] arr4 = {4,8,23,26,28};

        MergeNSortedArray msa = new MergeNSortedArray(new int[][]{arr1, arr2, arr3, arr4});

        int[] expected = {2, 2, 3, 4, 4, 5, 6, 6, 7, 7, 8, 8, 8, 9, 9, 10, 11, 12, 14, 16, 16, 22, 23, 25, 26, 28, 28};

        assertArrayEquals(expected, msa.mergeNArrays());
    }

}

*/
