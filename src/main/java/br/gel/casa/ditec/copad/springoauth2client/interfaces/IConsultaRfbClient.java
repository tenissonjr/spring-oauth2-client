package br.gel.casa.ditec.copad.springoauth2client.interfaces;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange("/cpf")
public interface IConsultaRfbClient {

    @GetExchange("/{cpf}")
    String consultarCpf(@PathVariable String cpf);
}
