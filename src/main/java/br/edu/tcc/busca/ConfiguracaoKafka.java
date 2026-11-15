package br.edu.tcc.busca;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.*;
import org.springframework.kafka.config.TopicBuilder;
@Configuration
@Profile("kafka")
public class ConfiguracaoKafka {
 @Bean NewTopic solicitacoes() { return TopicBuilder.name("produto.busca.solicitada").partitions(3).replicas(1).build(); }
 @Bean NewTopic conclusoes() { return TopicBuilder.name("produto.busca.concluida").partitions(3).replicas(1).build(); }
}
