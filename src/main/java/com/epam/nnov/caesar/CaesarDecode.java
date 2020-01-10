package com.epam.nnov.caesar;

import com.epam.nnov.caesar.entity.SimpleAlphabet;
import com.epam.nnov.caesar.entity.SimpleDecoder;
import com.epam.nnov.caesar.service.SimpleParser;

public class CaesarDecode {

    public static void main(String[] args) {

        String inputTextRussian = "Еъёчхф Вхзёюлх, адздёиу ф ждэщхб, црбх еёдюэчъщъгюъв южаижжзчх, ждчъёнъгжзчдв." +
                " Ъы зёюивй жёхчгюв бюнс ж ъы вдгивъгзхбсгрв аёхкдв. Зъеъёс вгъ дмъчющгд, мзд гъюэцъьгджзс " +
                "тздшд аёхкх фчбфъзжф жбъщжзчюъв гъждчъёнъгжзчх мъбдчъмъжадшд югщючющиивх. Ф юэимюб чхни " +
                "южздёюу ю чгыж юэвъгъгюф, здмгъъ дзёхэюч еджздфггиу юэвъгмючджзс мъбдчъмъжаюк едёдадч." +
                " Ю зъв гъ въгъъ, еджбъщдчхбх гъищхмх. Ф еёюнъб а чрчдщи, мзд чюгдя чжъви вдя югзъббъаз, " +
                "х чдэвдьгд, вды мёъэвъёгдъ жзёъвбъгюъ ад чжъви шхёвдгюмгдви. Гхязю ёънъгюъ вгъ едвдшбх " +
                "еёдшёхввх югзиюзючгдшд зюех, жеълюхбсгд ждэщхггхф щбф юэимъгюф деёъщъбъггрк жздёдг мъбдчъмъжадя щиню." +
                " Въгф вдьгд гхэчхзс дзлдв Вхзёюлр, х ъы, цъэ еёъичъбюмъгюф, вхзъёсу.";

        String inputTextEnglish = "Z nrek kf sv r Armr uvmvcfgvi!";

        String fileNameXML = "alphabet.xml";
        String languageRussian = "Russian";
        String languageEnglish = "English";

        SimpleParser parserAlphabetRussian = new SimpleParser();
        parserAlphabetRussian.parseAlphabet(fileNameXML, languageRussian);
        SimpleAlphabet alphabetRussian = new SimpleAlphabet(languageRussian, parserAlphabetRussian.getLowerCaseLetters(),
                parserAlphabetRussian.getUpperCaseLetters());
        SimpleDecoder decoderTextRussian = new SimpleDecoder(alphabetRussian);
        decoderTextRussian.decodeText(inputTextRussian);
        for (String resultDecode : decoderTextRussian.getDecodeList()) {
            System.out.println(alphabetRussian.getNameAlphabet() + ":" + resultDecode);
        }

        System.out.println();

        SimpleParser parserAlphabetEnglish = new SimpleParser();
        parserAlphabetEnglish.parseAlphabet(fileNameXML, languageEnglish);
        SimpleAlphabet alphabetEnglish = new SimpleAlphabet(languageEnglish, parserAlphabetEnglish.getLowerCaseLetters(),
                parserAlphabetEnglish.getUpperCaseLetters());
        SimpleDecoder decoderTextEnglish = new SimpleDecoder(alphabetEnglish);
        decoderTextEnglish.decodeText(inputTextEnglish);
        for (String resultDecode : decoderTextEnglish.getDecodeList()) {
            System.out.println(alphabetEnglish.getNameAlphabet() + ":" + resultDecode);
        }
    }
}