package br.com.agricolab.templates;

import br.com.agricolab.domain.Produto;
import br.com.agricolab.repository.model.ProdutosEntity;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

import java.math.BigDecimal;

public class ProdutosEntityTemplate implements TemplateLoader {

    public static final String VALIDO = "valido";

    @Override
    public void load() {

        Fixture.of(ProdutosEntity.class).addTemplate(VALIDO, new Rule(){
            {
                add("idProduto", 1);
                add("nomeProduto","alface");
                add("quantidadeProduto",400);
                add("valorProduto", new BigDecimal("20.00"));

            }
        });

    }
}
