package factory;

public class Demo {
    public static void main(String[] args) {
        Factory factory = new IcCardFactory();
        Product product = factory.create("IcCard_001");
        product.use();
    }
}
