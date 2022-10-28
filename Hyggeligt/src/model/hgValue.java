package model;

public class hgValue {
    private static final int MAX = 4;
    private int value;

    public hgValue() {
        value = 0;
    }

    public int getValue() {
        return value;
    }

    public void incValue() {
        this.value = this.value + 1;
    }

    public boolean isFull() {
        return value == MAX;
    }
}
