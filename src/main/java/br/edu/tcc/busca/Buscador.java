package br.edu.tcc.busca;
import java.util.*;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import br.edu.tcc.busca.Contratos.*;
@Service
public class Buscador {
 private final List<ConectorFonte> fontes;
 public Buscador(@Value("${fontes.atraso-a-ms}") long a, @Value("${fontes.atraso-b-ms}") long b, @Value("${fontes.atraso-c-ms}") long c, @Value("${fontes.probabilidade-falha}") double falha) {
  fontes = List.of(new FonteSimulada("LOJA_A",a,new BigDecimal("299.90"),falha),new FonteSimulada("LOJA_B",b,new BigDecimal("319.90"),falha),new FonteSimulada("LOJA_C",c,new BigDecimal("289.90"),falha));
 }
 public EventoConcluido buscar(UUID id, String termo) {
  try { var resultados = fontes.stream().map(f -> f.buscar(termo)).toList(); return new EventoConcluido(UUID.randomUUID(),id,termo,java.time.Instant.now(),"CONCLUIDA",resultados,null); }
  catch (RuntimeException erro) { return new EventoConcluido(UUID.randomUUID(),id,termo,java.time.Instant.now(),"FALHOU",List.of(),erro.getMessage()); }
 }
}
