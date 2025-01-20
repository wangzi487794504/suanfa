package test;

import java.util.Map;
import java.util.Objects;

/**
 * ClassName:Test3
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/10/14 19:00
 * @Version 1.0
 */
public class Test3 {
}
class MyHashpMap<K,V>{
    private static  int capacity=16;
    private static float DEFAULT_LOAD_FACTOR = 0.75f;
    private Entry<K,V>[] entrys;
    private int size=0;
    public MyHashpMap(){
       this(capacity);
    }
    //获取容量大小的二次幂
    public MyHashpMap(int capacity){
        //定义一个entry数组
        entrys=new Entry[capacity];
    }
    public void put(K key,V value){
        //确认位置
        int index = key.hashCode() % entrys.length;
        Entry<K,V> cur=entrys[index];
        while (cur!=null){
            //如果已经有了这个值
            //更新
            if (cur.getKey()==key){
                cur.value=value;
                return;
            }
            cur=cur.next;
        }
        //weikong，则直接赋值，头插法
        cur=new Entry<>(key,value,cur);
        size++;
    }
    public int getReHashSize(int n){
        int result=1;
        if (result<=n){
            result*=2;
        }
        return result;
    }
    static class Entry<K,V> {
        K key;
        V value;
        Entry<K, V> next;
        public Entry(){

        }
        public Entry(K key, V value,Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
        public K getKey() {
            return key;
        }
        public V getValue() {
            return value;
        }
    }

}
