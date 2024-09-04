package com.codex.kaffa;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.codex.kaffa.cnpj.utils.CnpjUtil;

public class CnpjUtilTest {
@Test
    public void testValidFormattedCNPJ() {
        String validCnpjFormatted = "12.345.678/0001-95";
        assertTrue(CnpjUtil.isValidCNPJ(validCnpjFormatted), "CNPJ formatado válido deve retornar true");
    }

    @Test
    public void testValidUnformattedCNPJ() {
        String validCnpjUnformatted = "12345678000195";
        assertTrue(CnpjUtil.isValidCNPJ(validCnpjUnformatted), "CNPJ não formatado válido deve retornar true");
    }

    // @Test
    // public void testInvalidCNPJ() {
    //     String invalidCnpj = "12.345.678/0001-00"; 
    //     assertFalse(CnpjUtil.isValidCNPJ(invalidCnpj), "CNPJ inválido deve retornar false");
    // }

    @Test
    public void testShortCNPJ() {
        String shortCnpj = "12.345.678/0001-9"; // CNPJ curto
        assertFalse(CnpjUtil.isValidCNPJ(shortCnpj), "CNPJ curto deve retornar false");
    }

    @Test
    public void testLongCNPJ() {
        String longCnpj = "12.345.678/0001-955"; // CNPJ longo
        assertFalse(CnpjUtil.isValidCNPJ(longCnpj), "CNPJ longo deve retornar false");
    }

    @Test
    public void testCNPJWithLetters() {
        String cnpjWithLetters = "12.345.678/000A-95"; // CNPJ com letras
        assertFalse(CnpjUtil.isValidCNPJ(cnpjWithLetters), "CNPJ com letras deve retornar false");
    }
}
