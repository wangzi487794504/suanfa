package hash;

import java.util.Arrays;
import java.util.HashSet;

/**
 * ClassName:Intersection
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/7/30 20:54
 * @Version 1.0
 */
public class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set=new HashSet();
        HashSet<Integer> set2=new HashSet();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])){
                set2.add(nums2[i]);
            }
        }
        return set2.stream().mapToInt(a->a).toArray();
    }
}
