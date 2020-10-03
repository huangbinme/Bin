package com.thread.notify;

public class Consumer implements Runnable{
    private ProductQueue productQueue;

    @Override
    public void run() {
        while (true){
            synchronized (productQueue){
                if(productQueue.isEmpty()){
                    wait(productQueue);
                }else {
                    consumeProduct(productQueue.pop());
                    productQueue.notifyAll();
                    wait(productQueue);
                }
            }
        }

    }

    private void wait(ProductQueue productQueue){
        try {
            productQueue.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void consumeProduct(Product product){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(String.format("[%s] is consuming product : [%s]",Thread.currentThread().getName(),product.toString()));
    }

    public ProductQueue getProductQueue() {
        return productQueue;
    }

    public void setProductQueue(ProductQueue productQueue) {
        this.productQueue = productQueue;
    }
}
