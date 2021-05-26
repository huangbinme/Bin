package com.design.factory;

public class IcCardFactory extends Factory{
    @Override
    public Product createProduct(String name) {
        Product product = new IcCard();
        product.setName(name);
        return product;
    }

    @Override
    public void registerProduct(Product product) {
        product.setRegister(Boolean.TRUE);
    }
}
