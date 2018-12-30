package udemy.java.algorithmic.recursion.search;

final class BinarySearch {
    private final int[] array;

    BinarySearch(int[] array) {
        this.array = array;
    }

    public int search(int item) {
        return search(0, array.length - 1, item);
    }

    private int search(int start, int end, int item) {
        if(end < start) {
            System.out.println("not found");
            return -1;
        }

        int middle = (start + end) / 2;
        if(item == array[middle]) {
            return middle;
        } else if(item < array[middle]) {
            return search(start, middle - 1, item);
        } else {
            return search(middle + 1, end, item);
        }
    }

    public static void main(String[] args) {
        int[] array = {-4,-1,0,1,4,6,9};
        BinarySearch binarySearch = new BinarySearch(array);
        System.out.println(binarySearch.search(10));
        System.out.println(binarySearch.search(2));
        System.out.println(binarySearch.search(4));
    }
}
