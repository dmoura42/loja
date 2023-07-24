package br.com.alura.loja;

import br.com.alura.loja.pedido.GeraPedido;
import br.com.alura.loja.pedido.GeraPedidoHandler;
import br.com.alura.loja.pedido.acoes.EnviarEmailPedido;
import br.com.alura.loja.pedido.acoes.LogDePedido;
import br.com.alura.loja.pedido.acoes.SalvarPedidoBD;

import java.math.BigDecimal;
import java.util.Arrays;

public class TestesPedidos {
    public static void main(String[] args) {
        String cliente = "Daniel";
        BigDecimal valorOrcamento = new BigDecimal("745.99");
        int quantidadeItens = 3;

        GeraPedido gerador = new GeraPedido(cliente, valorOrcamento, quantidadeItens);
        GeraPedidoHandler handler = new GeraPedidoHandler(Arrays.asList(
                        new SalvarPedidoBD(),
                        new EnviarEmailPedido(),
                        new LogDePedido()));

        handler.executar(gerador);
    }
}
