package br.edu.tcc.busca;
import java.util.*;
import java.math.BigDecimal;
import java.time.Instant;
import jakarta.validation.constraints.*;
public final class Contratos {
 private Contratos() {}
 public record Pedido(@NotBlank @Size(max=255) String termo) {}
 public record Solicitacao(@NotNull UUID buscaId, @NotBlank @Size(max=255) String termo) {}
 public record Resultado(String fonte, String nomeProduto, BigDecimal preco, long tempoFonteMs) {}
 public record EventoSolicitado(UUID eventoId, UUID buscaId, String termo, Instant solicitadoEm) {}
 public record EventoConcluido(UUID eventoId, UUID buscaId, String termo, Instant concluidoEm, String status, List<Resultado> resultados, String erro) {}
 public record Resposta(UUID buscaId, String termo, String modo, String status, Long tempoRespostaInicialMs, Long tempoTotalMs, List<Resultado> resultados) {}
}
