package com.epam.nnov.caesar.service;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class SimpleParser implements Parser{

    private char[] upperCaseLetters;
    private char[] lowerCaseLetters;
    private String resource;
    private String language;

    public SimpleParser(String resource, String language) {
        this.resource = resource;
        this.language = language;
    }

    @Override
    public char[] getUpperCaseLetters() {
        return upperCaseLetters;
    }

    @Override
    public char[] getLowerCaseLetters() {
        return lowerCaseLetters;
    }

    @Override
    public void parseAlphabet() {
        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse(new File(resource));
            Node root = document.getDocumentElement();
            NodeList nodes = root.getChildNodes();
            for (int i = 0; i < nodes.getLength(); i++) {
                Node elem = nodes.item(i);
                if (elem.getNodeName().equals(language)) {
                    NodeList alphabets = elem.getChildNodes();
                    for (int j = 0; j < alphabets.getLength(); j++) {
                        Node alphabet = alphabets.item(j);
                        String upperCase = "UpperCase";
                        String lowerCase = "LowerCase";
                        if (alphabet.getNodeName().equals(upperCase)) {
                            this.upperCaseLetters = alphabet.getTextContent().toCharArray();
                        } else if (alphabet.getNodeName().equals(lowerCase)) {
                            this.lowerCaseLetters = alphabet.getTextContent().toCharArray();
                        }
                    }
                }
            }
        }catch (ParserConfigurationException | SAXException | IOException ex) {
            ex.printStackTrace(System.out);
        }
    }
}