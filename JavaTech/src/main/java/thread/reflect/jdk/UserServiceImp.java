package thread.reflect.jdk;

public class UserServiceImp implements UserService{
    @Override
    public String save() {
        System.out.println("save user");
        return "Success";
    }
}
