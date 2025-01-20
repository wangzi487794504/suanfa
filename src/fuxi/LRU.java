package fuxi;

import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.Opcodes;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * ClassName:LRU
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/10/7 9:17
 * @Version 1.0
 */
public class LRU<K,V> extends LinkedHashMap<K,V> {
    private final int capacity;

    public LRU(int initialCapacity, float loadFactor, int capacity) {
        super(initialCapacity, loadFactor);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size()>capacity;
    }
}
class LRU2<K,V>{
    private final  int capacity;
    private Map<K,V> cache;
    private LinkedList<K> keyList;

    public LRU2(int capacity) {
        this.capacity = capacity;
        cache=new HashMap<>(capacity);
        keyList=new LinkedList<>();
    }
    public synchronized V get(K key){
        if (cache.containsKey(key)){
            keyList.remove(key);
            keyList.addLast(key);
            return cache.get(key);
        }
        return null;
    }
    public synchronized V get2(K key){
        if (cache.containsKey(key)){
            keyList.remove(key);
            //从对头移除元素的
            keyList.addLast(key);
            return cache.get(key);
        }
        return null;
    }
    public synchronized void put2(K key,V value){
        if (cache.containsKey(key)){
            //包含要移除，需要更新
            cache.remove(key);
        }
        //如果缓存满了，要移除最久未使用的
        while (cache.size()>=capacity){
            K oldestKey = keyList.removeFirst();
            cache.remove(oldestKey);
        }
        // 将新的key-value存入缓存中，并将该key添加到keyList的末尾，表示最近被访问
        cache.put(key, value);
        keyList.addLast(key);
    }

    public static void main(String[] args) {
    }
    static class MyClass extends ClassLoader{
        static ClassWriter ca = new ClassWriter(0);

        public static void main(String[] args) {
            MyClass myClass=new MyClass();
            // 版本号， public， 类名, 包名, 父类， 接口
            ca.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, "Class" , null, "java/lang/Object", null);
            // 返回 byte[]
            byte[] code = ca.toByteArray();
            // 执行了类的加载
            myClass.defineClass("Class" , code, 0, code.length); // Class 对象
        }
    }
}
