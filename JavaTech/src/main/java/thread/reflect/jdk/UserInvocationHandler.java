package thread.reflect.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class UserInvocationHandler implements InvocationHandler {
    Object obj;

    public UserInvocationHandler(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before saving user");
        Object res = method.invoke(obj, args);
        System.out.println("After saving user");
        return res;
    }
}
