package partten.template;

/**
 * ClassName:AClass
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/8/16 16:59
 * @Version 1.0
 */
public abstract class AClass {
    protected final void makeClass(){
        this.makePPT();
        if (flag()){
            this.makeNote();
        }
        this.makeVidio();
    }
    public final void makePPT(){
        System.out.println("可成");
    }
    public final void makeNote(){
        System.out.println("note");
    }
    public final void makeVidio(){
        System.out.println("制作课程的视频");
    }
    public boolean flag(){
        return false;
    }
    public abstract void ismakeNote();
}
