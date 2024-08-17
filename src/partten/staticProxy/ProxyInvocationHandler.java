package partten.staticProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * ClassName:ProxyInvocationHandler
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/8/14 14:25
 * @Version 1.0
 */
public class ProxyInvocationHandler implements InvocationHandler {
    //被代理的接口
    private RentHouse rentHouse;
    public void setRent(RentHouse rentHouse){
        this.rentHouse=rentHouse;
    }
    public Object getRent(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), rentHouse.getClass().getInterfaces(), this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }
}
