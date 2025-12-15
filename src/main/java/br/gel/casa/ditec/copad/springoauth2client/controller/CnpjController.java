package br.gel.casa.ditec.copad.springoauth2client.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gel.casa.ditec.copad.springoauth2client.interfaces.IConsultaRfbClient;

@RestController
@RequestMapping("/cnpj")
public class CnpjController {

	private final IConsultaRfbClient consultaRfbClient;

	public CnpjController(IConsultaRfbClient consultaRfbClient) {
		this.consultaRfbClient = consultaRfbClient;
	}

	@GetMapping("/{cnpj}")
	public String consultarCnpj(@PathVariable String cnpj) {
		return  consultaRfbClient.consultarCnpj(cnpj);
	}
}
