package partten.iterator;

/**
 * ClassName:NameContainer
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/8/17 8:54
 * @Version 1.0
 */
public class NameContainer implements Container{
    private String[] names={"张三","李四","王五"};
    @Override
    public Iterat getIterat() {
        return new NameIterat();
    }
    private class NameIterat implements Iterat{
        int index;
        @Override
        public boolean hasNext() {
            if ((index)<names.length){
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if (this.hasNext()){
                return names[index++];
            }
            return null;
        }
    }
}
