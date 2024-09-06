package com.codex.kaffa.cnpj.utils;

public class CnpjUtil {
    static Integer CnpjMinimumLenght = 14;

    public static boolean isValidCNPJ(String cnpj) {
        String cleanedString = cnpj.replaceAll("[./-]", "");

        if (cleanedString.length() != CnpjMinimumLenght) {
            return false;
        }
        if (containsLetters(cleanedString)) {
            return false;
        }
        return true;
    }

    private static boolean containsLetters(String input) {
        return input.matches(".*[a-zA-Z].*");
    }
}
