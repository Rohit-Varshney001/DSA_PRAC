import java.util.Arrays;

import Sorting.bubble_sort;
import Sorting.insertion_sort;
import Sorting.selection_sort;

public class main {
    public static void main(String[] args) {
        int arr[] = {1,3,2,34,234,4,32,15,1};
        new bubble_sort().bubble_sort(arr);
        new selection_sort().selection_sort(arr);
        new insertion_sort().insertion_sort(arr);

    }
}
