package com.wzzy.api.controller;

import com.wzzy.api.entity.Person;
import com.wzzy.api.service.PessoaService;
import org.springframework.web.bind.annotation.*;

@RestController
public class PessoaController {

    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping("API")
    public String mensagem(){
        return "Olá mundo";
    }

    @GetMapping("{nome}")
    public String boasVindas(@PathVariable String nome) {
        return "Seja bem vindo " + nome;
    }

    @PostMapping("create")
    public Person criarPessoa(@RequestBody Person person){
        return pessoaService.criarPessoa(person);

    }
}
