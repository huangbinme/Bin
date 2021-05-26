package com.thread.notify.print;

public class Demo {
    public static void main(String[] args) {
        Object o = new Object();
        LetterPrinter letterPrinter = new LetterPrinter(o);
        NumberPrinter numberPrinter = new NumberPrinter(o);
        letterPrinter.start();
        numberPrinter.start();
    }
}
