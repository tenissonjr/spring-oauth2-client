package br.gel.casa.ditec.copad.springoauth2client.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.web.client.OAuth2ClientHttpRequestInterceptor;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import br.gel.casa.ditec.copad.springoauth2client.interfaces.IConsultaRfbClient;

@Configuration
public class ConsultaRfbClientConfig {

    @Value("${consulta-rfb.url}")
    private String urlServicoConsultaRfbApi;

    @Bean
    public IConsultaRfbClient consultaRfbClient(OAuth2AuthorizedClientManager authorizedClientManager) {

        var interceptor = new OAuth2ClientHttpRequestInterceptor(authorizedClientManager);
        interceptor.setClientRegistrationIdResolver((HttpRequest request) -> "client-service");

        var restClient = RestClient.builder()
                .baseUrl(urlServicoConsultaRfbApi)
                .requestInterceptor(interceptor)
                .defaultHeader("Ponto-CD-Consulta", "P_6677")
                .build();


         // Retorna um objeto criado pelo Spring Boot que implementa a interface IConsultaRfbClient
        return HttpServiceProxyFactory.builder()
                .exchangeAdapter(RestClientAdapter.create(restClient))
                .build()
                .createClient(IConsultaRfbClient.class);

    }

}
