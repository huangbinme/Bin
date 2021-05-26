package factory;

public abstract class Product {
    protected String name;
    protected Boolean register = Boolean.FALSE;

    public abstract void use();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getRegister() {
        return register;
    }

    public void setRegister(Boolean register) {
        this.register = register;
    }
}
