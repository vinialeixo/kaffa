package com.codex.kaffa.cnpj.utils;

public class CnpjUtil {
    public static boolean isValidCNPJ(String cnpj) {
        String cleanedString = cnpj.replaceAll("[./-]", "");

        if (cleanedString.length() != 14) {
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
