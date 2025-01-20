package sort;

/**
 * ClassName:Qianzhuishu
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/10/8 17:22
 * @Version 1.0
 */
public class Qianzhuishu {
    public static class Node1{
        public int pass;
        public int end;
        public Node1[] nexts;

        public Node1() {
            pass=0;
            end=0;
            //26个字母 nexts[i]不存在
            nexts=new Node1[26];
        }
    }
    public static class Tree1{
        private Node1 root;
        public Tree1() {
           root=new Node1();
        }

        public void insert(String s){
            if (s==null){
                return;
            }
            char[] charArray = s.toCharArray();
            Node1 node=root;
            node.pass++;
            int path=0;
            for (int i = 0; i < charArray.length; i++) {
                path=charArray[i]-'a';
                if (node.nexts[path]==null){
                    node.nexts[path]=new Node1();
                }
                //node下来
                node=node.nexts[path];
                node.pass++;
            }
            //在这个节点结束的
            node.end++;
        }
        //一个单词出现过几次
        public int search(String s){
            if (s==null){
                return 0;
            }
            char[] charArray = s.toCharArray();
            Node1 node=root;
            int path=0;
            for (int i = 0; i < charArray.length; i++) {
                path=charArray[i]-'a';
                if (node.nexts[path]==null){
                    return 0;
                }
                //node下来
                node=node.nexts[path];
            }
            //在这里结束
            return node.end;
        }
        //查前缀
        public int searchPre(String s){
            if (s==null){
                return 0;
            }
            char[] charArray = s.toCharArray();
            Node1 node=root;
            int path=0;
            for (int i = 0; i < charArray.length; i++) {
                path=charArray[i]-'a';
                if (node.nexts[path]==null){
                    return 0;
                }
                //node下来
                node=node.nexts[path];
            }
            //前缀在这里结束
            return node.pass;
        }
    }
}
