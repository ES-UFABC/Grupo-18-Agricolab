package br.com.agricolab.templates;

import br.com.agricolab.repository.model.PedidosEntity;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

import java.math.BigDecimal;

public class PedidosEntityTemplate implements TemplateLoader {
    public static final String VALIDO = "pedido valido";

    @Override
    public void load() {

        Fixture.of(PedidosEntity.class).addTemplate(VALIDO, new Rule(){
            {
                add("idPedido",1);
                add("nomePedido","alface");
                add("quantidadePedido", 200);
                add("valorPedido", new BigDecimal("3.000"));
            }


        });
    }
}
