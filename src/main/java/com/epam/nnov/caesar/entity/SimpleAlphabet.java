package com.epam.nnov.caesar.entity;

public class SimpleAlphabet{

    private char[] lowerCaseLetters;
    private char[] upperCaseLetters;
    private int lengthAlphabet = 0;
    private String nameAlphabet;

    public SimpleAlphabet(String nameAlphabet, char[] lowerCaseLetters, char[] upperCaseLetters) {
        this.nameAlphabet = nameAlphabet;
        this.lowerCaseLetters = lowerCaseLetters;
        this.upperCaseLetters = upperCaseLetters;
        setLengthAlphabet(lowerCaseLetters.length);
    }

    public char[] getLowerCaseLetters() {
        return lowerCaseLetters;
    }

    public void setLowerCaseLetters(char[] lowerCaseLetters) {
        this.lowerCaseLetters = lowerCaseLetters;
    }

    public char[] getUpperCaseLetters() {
        return upperCaseLetters;
    }

    public void setUpperCaseLetters(char[] upperCaseLetters) {
        this.upperCaseLetters = upperCaseLetters;
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