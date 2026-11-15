# Serviço de busca de preços

Microsserviço do TCC que consulta três fontes simuladas de preços. Atende à busca síncrona por REST e consome solicitações assíncronas do Kafka. Não usa banco de dados.

## Executar localmente

São necessários Java 21, Maven e um broker Kafka em `localhost:9092`. O repositório da [API](https://github.com/Gusta2409/api-comparacao) inclui uma configuração opcional de Docker Compose. Se o broker tiver outro endereço, configure `KAFKA_SERVIDORES` no ambiente dos dois serviços.

```sh
mvn verify
mvn spring-boot:run
```

O serviço usa a porta 8081. O perfil padrão é `kafka`. Para executar sem broker, selecione o perfil `demonstracao` nos dois serviços Java.

O endpoint interno é `POST /interno/buscas/sincrona`. Os tópicos Kafka são `produto.busca.solicitada` e `produto.busca.concluida`. Use `ATRASO_A_MS`, `ATRASO_B_MS` e `ATRASO_C_MS` para mudar a latência das fontes, e `PROBABILIDADE_FALHA` (de 0 a 1) para simular falhas.

## Repositórios do TCC

- [api-comparacao](https://github.com/Gusta2409/api-comparacao): API e infraestrutura local.
- [servico-busca](https://github.com/Gusta2409/servico-busca): microsserviço das fontes simuladas.
- [interface-web](https://github.com/Gusta2409/interface-web): interface Angular.
