package partten.staticProxy;

/**
 * ClassName:Proxy
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/8/13 22:24
 * @Version 1.0
 */
public class Proxy {
    private Host host;
    public Proxy(){

    }
    public Proxy(Host host){
        this.host=host;
    }
    public void rent(){
        host.rent();
    }
    public void seeHouse(){
        System.out.println("看房子");;
    }
}
