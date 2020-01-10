package com.epam.nnov.caesar;

import com.epam.nnov.caesar.entity.SimpleAlphabet;
import com.epam.nnov.caesar.entity.SimpleDecoder;
import com.epam.nnov.caesar.service.Parser;
import com.epam.nnov.caesar.service.SimpleParser;

import java.util.List;

public class CaesarDecode {

    // вызывающая функция может использовать интерфейс парсера другой реализации
    // если тут будет создаваться какой нибудь другой парсер
    public void parse(Parser parserAlphabet){
        parserAlphabet.parseAlphabet();
    }

    // объединил всю последовательность создания объектов и вызовов в этой функции
    public List<String> decodeText(String fileNameXML, String language, String textToDecode) {
        SimpleParser parserAlphabetRussian = new SimpleParser(fileNameXML, language);
        parse(parserAlphabetRussian);
        SimpleAlphabet alphabetRussian = new SimpleAlphabet(language, parserAlphabetRussian.getLowerCaseLetters(),
                parserAlphabetRussian.getUpperCaseLetters());
        SimpleDecoder decoderTextRussian = new SimpleDecoder(alphabetRussian);
        decoderTextRussian.decodeText(textToDecode);
        return decoderTextRussian.getDecodeList();
    }

    // ну и печать вынес отдельно
    public void printerListResult (List<String> list) {
        for (String resultDecode : list) {
            System.out.println(resultDecode);
        }
        // просто для разделения
        System.out.println();
    }

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

        CaesarDecode caesarDecodeApp = new CaesarDecode();

        // декодируем текст на русском
        caesarDecodeApp.printerListResult(caesarDecodeApp.decodeText(fileNameXML, languageRussian, inputTextRussian));

        // декодируем текст на английском
        caesarDecodeApp.printerListResult(caesarDecodeApp.decodeText(fileNameXML, languageEnglish, inputTextEnglish));
    }
}