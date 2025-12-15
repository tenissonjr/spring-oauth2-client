package br.gel.casa.ditec.copad.springoauth2client.interfaces;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;

public interface IConsultaRfbClient {

    @GetExchange("/cpf/{cpf}")
    String consultarCpf(@PathVariable String cpf);

    @GetExchange("/cnpj/{cnpj}")
    String consultarCnpj(@PathVariable String cnpj);

}
