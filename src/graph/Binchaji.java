package graph;

import tree.Node;

import java.util.HashMap;

/**
 * ClassName:Binchaji
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/14 22:56
 * @Version 1.0
 */
public class Binchaji {
    private int[] parent;//i的父亲是k
    private int[] size;//size(i)=k，如果i是代表节点才有意义
    //一共有多少个集合
    private int sets;
    //初始化
    public Binchaji(int n){
        parent=new int[n];
        size=new int[n];
        sets=n;
        //初始化，每一个父节点指向自己本身
        for (int i = n-1; i >= 0; i--) {
            parent[i]=i;
            size[i]=1;
        }
    }
    //一直汪上,得到代表节点
    //优化：做路径压缩
    private int find(int i){
        if (i!=parent[i]){
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }
    public void union(int i,int j){
        int f1=find(i);
        int f2=find(j);
        //代表节点不一样,union
        if (f1!=f2) {
            //比size大小
            if (size[f1] >= size[f2]) {
                size[f1] += size[f2];
                parent[f2] = f1;
            } else {
                size[f2] += size[f1];
                parent[f1] = f2;
            }
            sets--;
        }
    }
    public int getSets(){
        return sets;
    }
}
class Anli1{
    private Binchaji binchaji;
    public int findCircleNum(int[][] isConnected) {
        //初始化并查集
        binchaji=new Binchaji(isConnected.length);
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = i+1; j < isConnected[i].length; j++) {
                if (isConnected[i][j]==1){
                    binchaji.union(i,j);
                }
            }
        }
        return binchaji.getSets();
    }
}
