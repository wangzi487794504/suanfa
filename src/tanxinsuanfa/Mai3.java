package tanxinsuanfa;

import java.util.*;

/**
 * ClassName:Main
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/21 16:25
 * @Version 1.0
 */
public class Mai3 {
    public static void main(String[] args) {
        //输入
        Scanner scanner = new Scanner(System.in);
        //汽车数量
        int total=scanner.nextInt();
        //维护一个数组
        int[][] cars=new int[total][2];
        //保存对象
        for (int i = 0; i < total; i++) {
            cars[i][0]= scanner.nextInt();
            cars[i][1]= scanner.nextInt();
        }
        //按位置排序
        //追尾就算有问题
        Arrays.sort(cars, Comparator.comparingInt(a->a[0]));
        //定义一个集合
        int[] speed=new int[total];
        for (int i = 0; i < total; i++) {
            speed[i]= cars[i][1];
        }
        List<Integer> list=new ArrayList<>();
        for (int i : speed) {
            int pos=Collections.binarySearch(list, i);
            if (pos<0){
                pos=-(pos+1);

            }
            if (pos<list.size()){
                list.set(pos, i);
            }
            else {
                list.add(i);
            }
        }
        System.out.println(total-list.size());
    }

}
