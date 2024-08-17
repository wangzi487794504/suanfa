package partten.staticProxy;

/**
 * ClassName:Client
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/8/13 22:24
 * @Version 1.0
 */
public class Client {
    //租房子
    public static void main(String[] args) {
        ProxyInvocationHandler proxyInvocationHandler=new ProxyInvocationHandler();
        proxyInvocationHandler.setRent(new Host());
        proxyInvocationHandler.getRent();
    }
}
