package com.epam.nnov.caesar.entity;


import java.util.List;

public interface Decoder {

    SimpleAlphabet getAlphabet();

    void setAlphabet(SimpleAlphabet alphabet);

    char shiftLowerOrUpperCaseLetter(char findLetter, int shift);

    void decodeText(String textToDecode);

    char shiftSymbol(char findSymbol, char[] mass, int shift);

    List getDecodeList();
}