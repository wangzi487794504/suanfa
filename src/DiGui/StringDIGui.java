package DiGui;

import org.junit.Test;

/**
 * ClassName:StringDIGui
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/1/31 20:48
 * @Version 1.0
 */
public class StringDIGui {
    String s;
    public StringDIGui(String s){
        this.s=s;
    }
    public void loop(){
        char[] str=s.toCharArray();
        System.out.println(str.length);
        diGui(str, 0);

    }
    public void diGui(char[] str, int index){
        if (index!=(str.length)){
            char a=str[index];
            diGui(str,index+1);
            System.out.println(a);
        }
        return;
    }

}
