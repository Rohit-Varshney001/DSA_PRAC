package Sorting.Sorting_Questions;

import java.util.ArrayList;
import java.util.List;

public class merge_overlaping_interval {
    public void merge_Overlaping(ArrayList<ArrayList<Integer>> list){
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i<list.size(); i++){
            ArrayList<Integer> lst1 = list.get(i);
            ArrayList<Integer> lst2 = list.get(i+1);
            ArrayList<Integer> addResult = new ArrayList<>();

            if(lst1.get(1) >= lst2.get(0)){
                result.add(lst1.get(0),lst2.get(1));
            }
            else{

            }


        }
    }
}
