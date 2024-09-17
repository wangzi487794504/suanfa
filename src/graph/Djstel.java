package graph;

import tree.Inorder;
import tree.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * ClassName:djstel
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/17 17:01
 * @Version 1.0
 */
public class Djstel {
    public static HashMap<GraphNode, Integer> dijkstra(GraphNode from){
        HashMap<GraphNode, Integer> distenceMap=new HashMap<>();
        distenceMap.put(from, 0);
        //已经选中过的点
        HashSet<GraphNode> selectNodes=new HashSet<>();
        //得到除标记以外的最短路径的点
        //第一次必是from
        GraphNode minNode=getMInDestance(distenceMap,selectNodes);
        while (minNode!=null){
            //原始点到跳转点的距离
            int distance=distenceMap.get(minNode);
            minNode.edges.forEach(edge->{
                GraphNode to=edge.to;
                //不包含说明是正无穷
                if (!distenceMap.containsKey(to)){
                    distenceMap.put(to,distance+edge.weight);
                }
                else {
                    //和原有的比较大小
                    distenceMap.put(to,Math.min(distance+edge.weight, distenceMap.get(to)));
                }
            });
            selectNodes.add(minNode);
            minNode=getMInDestance(distenceMap,selectNodes);
        }
        return distenceMap;
    }

    private static GraphNode getMInDestance(HashMap<GraphNode, Integer> distenceMap, HashSet<GraphNode> selectNodes) {
        GraphNode minNode=null;
        int minDistance=Integer.MAX_VALUE;
        for (Map.Entry<GraphNode, Integer> temp : distenceMap.entrySet()) {
            GraphNode toNode=temp.getKey();
            int distance=temp.getValue();
            if (!selectNodes.contains(toNode)&& distance<minDistance){
                minNode=toNode;
                minDistance=distance;
            }
        }
        return minNode;
    }
}
class GraphNode{
    public int value;
    //入读
    public int in;
    public int out;
    public ArrayList<Node> nexts;
    public ArrayList<Edge> edges;
    public GraphNode(int value){
        this.value=value;
        in=0;
        out=0;
        nexts=new ArrayList<>();
        edges=new ArrayList<>();
    }
}
class Edge{
        public GraphNode to;
        public int weight;
        public GraphNode from;
        public Edge(GraphNode to,GraphNode from,int weight){
            this.to=to;
            this.from=from;
            this.weight=weight;
        }
}
