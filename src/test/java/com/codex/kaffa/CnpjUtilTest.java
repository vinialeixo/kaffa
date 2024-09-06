package com.codex.kaffa;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.codex.kaffa.cnpj.utils.CnpjUtil;

public class CnpjUtilTest {

    @Test
    public void testValidFormattedCNPJ() {
        String validCnpjFormatted = "12.345.678/0001-95";
        assertTrue(CnpjUtil.isValidCNPJ(validCnpjFormatted), "Valid formatted CNPJ should return true");
    }

    @Test
    public void testValidUnformattedCNPJ() {
        String validCnpjUnformatted = "12345678000195";
        assertTrue(CnpjUtil.isValidCNPJ(validCnpjUnformatted), "Valid unformatted CNPJ should return true");
    }

    @Test
    public void testShortCNPJ() {
        String shortCnpj = "12.345.678/0001-9"; // Short CNPJ
        assertFalse(CnpjUtil.isValidCNPJ(shortCnpj), "Short CNPJ should return false");
    }

    @Test
    public void testLongCNPJ() {
        String longCnpj = "12.345.678/0001-955"; // Long CNPJ
        assertFalse(CnpjUtil.isValidCNPJ(longCnpj), "Long CNPJ should return false");
    }

    @Test
    public void testCNPJWithLetters() {
        String cnpjWithLetters = "12.345.678/000A-95"; // CNPJ with letters
        assertFalse(CnpjUtil.isValidCNPJ(cnpjWithLetters), "CNPJ with letters should return false");
    }
}
