package com.design.adapter.designate;

public class Demo {
    public static void main(String[] args) {
        PlayerAdapter playerAdapter = new MyVideoPlayerAdapter();
        playerAdapter.playing("Video_name_001");
    }
}
