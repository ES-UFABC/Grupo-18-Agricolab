package br.com.agricolab.templates;

import br.com.agricolab.domain.Pedido;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

import java.math.BigDecimal;

public class PedidoTemplate implements TemplateLoader {

    public static final String VALIDO = "valido";

    @Override
    public void load() {

        Fixture.of(Pedido.class).addTemplate(VALIDO, new Rule(){
            {

                add("nomeProduto","alface");
                add("quantidadeProduto",400);
                add("valorProduto", new BigDecimal("20.00"));

            }
        });

    }
}
