package com.design.factory;

public class IcCard extends Product{
    @Override
    public void use() {
        if(getRegister()){
            System.out.println("Starting to use product, product name is "+this.name);
        }else {
            System.out.println("Can't use product cause not register");
        }
    }
}
