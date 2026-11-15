package br.edu.tcc.busca;
import org.junit.jupiter.api.Test;
import java.util.UUID;
import static org.assertj.core.api.Assertions.assertThat;
class BuscadorTeste {
 @Test void retornaTresFontesComPrecosControlados() {
  var resposta=new Buscador(0,0,0,0).buscar(UUID.randomUUID(),"controle");
  assertThat(resposta.status()).isEqualTo("CONCLUIDA");
  assertThat(resposta.resultados()).hasSize(3);
  assertThat(resposta.resultados()).extracting(r->r.preco().toPlainString()).containsExactly("299.90","319.90","289.90");
 }
 @Test void falhaDeFonteProduzEstadoTerminalSemResultadosParciais() {
  var resposta=new Buscador(0,0,0,1).buscar(UUID.randomUUID(),"controle");
  assertThat(resposta.status()).isEqualTo("FALHOU");
  assertThat(resposta.resultados()).isEmpty();
  assertThat(resposta.erro()).contains("LOJA_A");
 }
}
