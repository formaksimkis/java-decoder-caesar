package com.epam.nnov.caesar.entity;


public abstract class AbstractDecoder {

    private SimpleAlphabet alphabet;

    public AbstractDecoder(SimpleAlphabet alphabet) {
        this.alphabet = alphabet;
    }

    public SimpleAlphabet getAlphabet() {
        return alphabet;
    }

    public void setAlphabet(SimpleAlphabet alphabet) {
        this.alphabet = alphabet;
    }

    void decodeText(String textToDecode) {}
}