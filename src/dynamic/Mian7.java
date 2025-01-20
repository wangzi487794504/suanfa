package dynamic;

import java.util.*;

/**
 * ClassName:Mian6
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/22 15:28
 * @Version 1.0
 */
public class Mian7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //组数
        int t=scanner.nextInt();
        for (int i = 0; i < t; i++) {
            //文件夹数量
            int n= scanner.nextInt();
            //不同机构的数量
            int x= scanner.nextInt();
            List<Set<String>> sets=new ArrayList<>();
            //遍历收藏夹数量
            for (int j = 0; j < n; j++) {
                //每个文件夹去重
                Set<String> hashSet=new HashSet<>();
                //遍历单个收藏夹
                int m= scanner.nextInt();
                for (int k = 0; k < m; k++) {
                    hashSet.add(scanner.next());
                }
                //添加到集合
               sets.add(hashSet);
            }
            //遍历收藏夹，每次遍历两个不一样的
            boolean result=false;
            int index1=-1;
            int index2=-1;
            for (int j = 0; j < n-1; j++) {
                for (int k = j+1; k < n; k++) {
                    //获取第一个列表
                    Set<String> temp=new HashSet<>(sets.get(i));
                    //把第二个列表添加进去，为x则返回
                    temp.addAll(sets.get(j));
                    if (temp.size()==x){
                        if (!result || (i<index1) || (i==index1 && j<index2)){
                            result=true;
                            index1=i;
                            index2=j;
                        }

                    }
                }
                if (result){
                    break;
                }
            }
            if (result){
                System.out.println("YES");
                System.out.println((index1+1)+" "+(index2+1));
                //结束，找到一个就行
            }
            else {
                System.out.println("NO");
            }
        }
        scanner.close();
    }
}
