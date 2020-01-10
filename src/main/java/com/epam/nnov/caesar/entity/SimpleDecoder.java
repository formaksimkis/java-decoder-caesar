package com.epam.nnov.caesar.entity;

import java.util.ArrayList;
import java.util.List;

public class SimpleDecoder extends AbstractDecoder{

    private List<String> decodeList;

    public SimpleDecoder(SimpleAlphabet alphabet) {
        super(alphabet);
        decodeList = new ArrayList<>();
    }

    public List<String> getDecodeList() {
        return decodeList;
    }

    private char shiftLetterToRightInAlphabet(char findLetter, int shift) {
        char shiftedLetter = findLetter;
        int lengthAlphabet = getAlphabet().getLengthAlphabet();
        char[] lowerCaseLetters = getAlphabet().getLowerCaseLetters();
        char[] upperCaseLetters = getAlphabet().getUpperCaseLetters();
        if (Character.isLowerCase(findLetter)) {
            for (int i = 0; i < lengthAlphabet; i++) {
                if (findLetter == lowerCaseLetters[i]) {
                    shiftedLetter = i + shift < lengthAlphabet ? lowerCaseLetters[i + shift] : lowerCaseLetters[i + shift - lengthAlphabet];
                    break;
                }
            }
        } else {
            for (int i = 0; i < lengthAlphabet; i++) {
                if (findLetter == upperCaseLetters[i]) {
                    shiftedLetter = i + shift < lengthAlphabet ? upperCaseLetters[i + shift] : upperCaseLetters[i + shift - lengthAlphabet];
                    break;
                }
            }
        }
        return shiftedLetter;
    }

    @Override
    public void decodeText(String textToDecode) {
        int lengthAlphabet = getAlphabet().getLengthAlphabet();
        StringBuilder builder;
        for (int k = 0; k < lengthAlphabet; k++) {
            builder = new StringBuilder();
            for (int i = 0; i < textToDecode.length(); i++) {
                char decodeLetter = textToDecode.charAt(i);
                if (Character.isLetter(decodeLetter)) {
                    builder.append(shiftLetterToRightInAlphabet(decodeLetter, k));
                } else builder.append(decodeLetter);
            }
            decodeList.add(builder.toString());
        }
    }
}