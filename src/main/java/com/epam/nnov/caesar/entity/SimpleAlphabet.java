package com.epam.nnov.caesar.entity;

public class SimpleAlphabet extends AbstractAlphabet{

    private char[] lowerCaseLetters;
    private char[] upperCaseLetters;

    public SimpleAlphabet(String nameAlphabet, char[] lowerCaseLetters, char[] upperCaseLetters) {
        super(nameAlphabet);
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
}