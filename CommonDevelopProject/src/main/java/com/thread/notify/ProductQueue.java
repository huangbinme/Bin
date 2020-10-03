package com.thread.notify;

public class ProductQueue {
    private volatile Product[] products;
    private volatile int productSize = 0;

    public ProductQueue(int fixedSize) {
        this.products = new Product[fixedSize];
    }

    public void push(Product product){
        if(products.length<=productSize){
            throw new ArrayIndexOutOfBoundsException();
        }
        products[productSize] = product;
        productSize++;
    }

    public Product pop(){
        if (productSize==0){
            throw new NullPointerException("Null product");
        }

        Product product = products[0];
        productSize--;
        for (int i = 0; i < productSize; i++) {
            products[i] = products[i+1];
        }
        products[productSize] = null;
        return product;
    }

    public boolean isNotFull(){
        return products.length>productSize;
    }

    public boolean isEmpty(){
        return productSize==0;
    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }

    public int getProductSize() {
        return productSize;
    }

    public void setProductSize(int productSize) {
        this.productSize = productSize;
    }
}
