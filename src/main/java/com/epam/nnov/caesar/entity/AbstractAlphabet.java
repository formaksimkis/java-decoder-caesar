package com.epam.nnov.caesar.entity;

public class AbstractAlphabet {

    private int lengthAlphabet = 0;
    private String nameAlphabet;

    public AbstractAlphabet(String nameAlphabet) {
        this.nameAlphabet = nameAlphabet;
    }

    public int getLengthAlphabet() {
        return lengthAlphabet;
    }

    public void setLengthAlphabet(int lengthAlphabet) {
        this.lengthAlphabet = lengthAlphabet;
    }

    public String getNameAlphabet() {
        return nameAlphabet;
    }

    public void setNameAlphabet(String nameAlphabet) {
        if (nameAlphabet != null) {
            this.nameAlphabet = nameAlphabet;
        } else {
            this.nameAlphabet = "";
        }
    }
}