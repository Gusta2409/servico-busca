package br.edu.tcc.busca;
import org.springframework.stereotype.Component;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import br.edu.tcc.busca.Contratos.*;
@Component
@org.springframework.context.annotation.Profile("kafka")
public class ConsumidorSolicitacoes {
 private final Buscador buscador; private final ObjectMapper json; private final KafkaTemplate<String,String> kafka;
 public ConsumidorSolicitacoes(Buscador buscador,ObjectMapper json,KafkaTemplate<String,String> kafka) { this.buscador=buscador; this.json=json; this.kafka=kafka; }
 @KafkaListener(topics="produto.busca.solicitada") public void consumir(String mensagem) throws Exception {
  var evento=json.readValue(mensagem,EventoSolicitado.class);
  var resultado=buscador.buscar(evento.buscaId(),evento.termo());
  kafka.send("produto.busca.concluida",evento.buscaId().toString(),json.writeValueAsString(resultado)).get(12,java.util.concurrent.TimeUnit.SECONDS);
 }
}
