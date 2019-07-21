package com.designMode.adapter;

public class MyVedioPlayer implements VedioPlayer{
    @Override
    public void playVedio(String file) {
        System.out.println("MyVedioPlayer -> file "+file+" has been playing");
    }
}
