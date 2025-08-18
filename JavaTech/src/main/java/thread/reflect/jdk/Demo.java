package thread.reflect.jdk;

import java.lang.reflect.Proxy;

public class Demo {

    public static void main(String[] args) {
        UserService service = new UserServiceImp();
        UserService userServiceByProxy = (UserService) Proxy.newProxyInstance(
                service.getClass().getClassLoader(),
                service.getClass().getInterfaces(),
                new UserInvocationHandler(service));
        userServiceByProxy.save();
    }

}
