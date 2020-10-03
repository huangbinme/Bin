package com.thread.notify;

public class Product {
    private String productName;
    private String producerName;

    public Product(String productName, String producerName) {
        this.productName = productName;
        this.producerName = producerName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", producerName='" + producerName + '\'' +
                '}';
    }
}
