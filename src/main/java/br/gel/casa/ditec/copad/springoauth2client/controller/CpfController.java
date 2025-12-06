package br.gel.casa.ditec.copad.springoauth2client.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gel.casa.ditec.copad.springoauth2client.interfaces.IConsultaRfbClient;

@RestController
@RequestMapping("/cpf")
public class CpfController {

	private final IConsultaRfbClient consultaRfbClient;

	public CpfController(IConsultaRfbClient consultaRfbClient) {
		this.consultaRfbClient = consultaRfbClient;
	}

	@GetMapping("/{cpf}")
	public String consultarCpf(@PathVariable String cpf) {
		return  consultaRfbClient.consultarCpf(cpf);
	}
}
