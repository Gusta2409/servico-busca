package br.edu.tcc.busca;
import java.math.BigDecimal;
import java.util.concurrent.ThreadLocalRandom;
import br.edu.tcc.busca.Contratos.Resultado;
public record FonteSimulada(String fonte, long atrasoMs, BigDecimal preco, double probabilidadeFalha) implements ConectorFonte {
 public FonteSimulada { if (atrasoMs < 0 || probabilidadeFalha < 0 || probabilidadeFalha > 1) throw new IllegalArgumentException("Configuração de fonte inválida"); }
 public Resultado buscar(String termo) {
  long inicio = System.nanoTime();
  try { Thread.sleep(atrasoMs); } catch (InterruptedException erro) { Thread.currentThread().interrupt(); throw new IllegalStateException("Busca interrompida", erro); }
  if (ThreadLocalRandom.current().nextDouble() < probabilidadeFalha) throw new IllegalStateException("Falha simulada em " + fonte);
  return new Resultado(fonte, termo + " - " + fonte, preco, (System.nanoTime()-inicio)/1_000_000);
 }
}
