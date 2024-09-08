package tree;

import java.util.List;

/**
 * ClassName:Node
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/8 11:28
 * @Version 1.0
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
