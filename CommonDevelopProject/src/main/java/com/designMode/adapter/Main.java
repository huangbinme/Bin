package com.designMode.adapter;

public class Main {
    public static void main(String[] args) {
        PlayerAdapter playerAdapter = new MyPlayerAdapter();
        playerAdapter.play("audio","file_001");
        playerAdapter.play("vedio","file_002");
    }
}
