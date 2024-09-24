package KwayMerge;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElement {
    public static void main(String[] args) {
        List<List<Integer>> lists=new ArrayList<>();
        List<Integer> l1=new ArrayList<>();
        l1.add(2);
        l1.add(6);
        l1.add(8);
        lists.add(l1);
        List<Integer> l2=new ArrayList<>();
        l2.add(3);
        l2.add(6);
        l2.add(10);
        lists.add(l2);
        List<Integer> l3=new ArrayList<>();
        l3.add(5);
        l3.add(8);
        l3.add(11);
        System.out.println(getkthSmallest(lists,3));
    }


    public static int getkthSmallest(List<List<Integer>> lists, int k) {
        int left = lists.get(0).get(0);
        int n=lists.size();
        int n1=lists.get(n-1).size();
        int right = lists.get(n-1).get(n1-1);
        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = 0;
            for (List<Integer> list : lists) {
                for (int num : list) {
                    if (num <= mid) {
                        count++;
                    } else {
                        break;
                    }
                }
            }
            if (count < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

}
