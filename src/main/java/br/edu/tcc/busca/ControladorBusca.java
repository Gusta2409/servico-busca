package br.edu.tcc.busca;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import br.edu.tcc.busca.Contratos.*;
@RestController
public class ControladorBusca {
 private final Buscador buscador;
 public ControladorBusca(Buscador buscador) { this.buscador=buscador; }
 @PostMapping("/interno/buscas/sincrona") public EventoConcluido buscar(@Valid @RequestBody Solicitacao pedido) { return buscador.buscar(pedido.buscaId(),pedido.termo()); }
}
