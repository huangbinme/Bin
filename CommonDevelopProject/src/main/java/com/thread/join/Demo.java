package com.thread.join;

public class Demo {
    public Thread thread1;
    public Thread thread2;

    public static void main(String[] args) {
        ParentThread parentThread= new ParentThread();
        SubThread subThread = new SubThread();
        Thread thread1 = new Thread(parentThread);
        Thread thread2 = new Thread(subThread);
        subThread.setParent(thread1);
        thread1.start();
        thread2.start();
    }
}
