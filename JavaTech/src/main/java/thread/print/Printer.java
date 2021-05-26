package thread.print;

public class Printer {
    private volatile boolean outputFlag = true;
    private volatile int number = 1;
    private volatile int letter = 0;

    public static char getChar(int i) {
        return i < 0 || i > 25 ? '?' : (char) ('A' + i);
    }

    public void numberPrint() {
        System.out.println(number);
        number++;
    }

    public void letterPrint() {
        System.out.println(Printer.getChar(letter));
        letter++;
    }

    public boolean isOutputFlag() {
        return outputFlag;
    }

    public void setOutputFlag(boolean outputFlag) {
        this.outputFlag = outputFlag;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getLetter() {
        return letter;
    }

    public void setLetter(int letter) {
        this.letter = letter;
    }
}
