package com.codex.kaffa.cnpj;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codex.kaffa.cnpj.dto.CnpjValidateRequestDto;
import com.codex.kaffa.cnpj.utils.CnpjUtil;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
@RestController
@RequestMapping("cnpj")
public class CnpjValidateController {

    @GetMapping("")
    public boolean validateCNPJ(@RequestBody CnpjValidateRequestDto paylod) {
        return CnpjUtil.isValidCNPJ(paylod.cnpj());

    }

}
