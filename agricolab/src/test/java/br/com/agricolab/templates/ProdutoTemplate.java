package br.com.agricolab.templates;

import br.com.agricolab.domain.Produto;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

@RunWith(SpringJUnit4ClassRunner.class)
public class ProdutoTemplate implements TemplateLoader {

    public static final String VALIDO = "valido";

    @Override
    public void load() {

        Fixture.of(Produto.class).addTemplate(VALIDO, new Rule(){
            {

                add("nomeProduto","alface");
                add("quantidadeProduto",400);
                add("valorProduto", new BigDecimal("20.00"));

            }
        });

    }
}
