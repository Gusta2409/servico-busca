package br.edu.tcc.busca;
import br.edu.tcc.busca.Contratos.Resultado;
public interface ConectorFonte { String fonte(); Resultado buscar(String termo); }
