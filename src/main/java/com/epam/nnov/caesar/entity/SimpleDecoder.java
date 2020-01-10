package com.epam.nnov.caesar.entity;

import java.util.ArrayList;
import java.util.List;

public class SimpleDecoder implements Decoder {

    private List<String> decodeList;
    private SimpleAlphabet alphabet;

    public SimpleDecoder(SimpleAlphabet alphabet) {
        this.alphabet = alphabet;
        decodeList = new ArrayList<>();
    }

    @Override
    public List<String> getDecodeList() {
        return decodeList;
    }

    @Override
    public SimpleAlphabet getAlphabet() {
        return alphabet;
    }

    @Override
    public void setAlphabet(SimpleAlphabet alphabet) {
            this.alphabet = alphabet;
    }

    // сдвигает букву в большом или малом алфавите в зависимости от регистра буквы
    @Override
    public char shiftLowerOrUpperCaseLetter(char findLetter, int shift) {
        char shiftedLetter;
        if (Character.isLowerCase(findLetter)) {
            shiftedLetter = shiftSymbol(findLetter, getAlphabet().getLowerCaseLetters(), shift);
        } else {
            shiftedLetter = shiftSymbol(findLetter, getAlphabet().getUpperCaseLetters(), shift);
        }
        return shiftedLetter;
    }

    // находит и сдвигает символ в массиве символов
    @Override
    public char shiftSymbol(char findSymbol, char[] mass, int shift) {
        int lengthAlphabet = mass.length;
        char shiftedLetter = findSymbol;
        for (int i = 0; i < lengthAlphabet; i++) {
            if (findSymbol == mass[i]) {
                shiftedLetter = i + shift < lengthAlphabet ? mass[i + shift] : mass[i + shift - lengthAlphabet];
                break;
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
                    builder.append(shiftLowerOrUpperCaseLetter(decodeLetter, k));
                } else builder.append(decodeLetter);
            }
            decodeList.add(builder.toString());
        }
    }
}