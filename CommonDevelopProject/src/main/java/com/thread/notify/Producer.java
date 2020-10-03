package com.thread.notify;

public class Producer implements Runnable{
    private ProductQueue productQueue;
    private int produceNumber = 0;

    @Override
    public void run() {
        while (true){
            synchronized (productQueue){
                if(productQueue.isNotFull()){
                    produceProduct(productQueue);
                    productQueue.notifyAll();
                    wait(productQueue);
                }else {
                    System.out.println(String.format("Queue is full, thread [%s]",Thread.currentThread().getName()));
                }
            }
        }

    }

    private void produceProduct(ProductQueue productQueue){
        try {
            Product product = new Product(Integer.toString(produceNumber),Thread.currentThread().getName());
            System.out.println(String.format("[%s] is producing product : [%s]",Thread.currentThread().getName(),product.toString()));
            produceNumber++;
            productQueue.push(product);
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void wait(ProductQueue productQueue){
        try {
            productQueue.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public ProductQueue getProductQueue() {
        return productQueue;
    }

    public void setProductQueue(ProductQueue productQueue) {
        this.productQueue = productQueue;
    }
}
