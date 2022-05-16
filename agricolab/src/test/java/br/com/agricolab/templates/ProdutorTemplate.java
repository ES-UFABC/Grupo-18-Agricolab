package br.com.agricolab.templates;

import br.com.agricolab.domain.Produtor;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

import java.math.BigDecimal;
import java.util.ArrayList;

public class ProdutorTemplate implements TemplateLoader {

    public static final String VALIDO = "valido";

    @Override
    public void load() {

        Fixture.of(Produtor.class).addTemplate(VALIDO, new Rule(){
            {
                add("id","1");
                add("nomeProdutor","teste");
                add("emailProdutor","testeprodutor@hotmail.com");
                add("enderecoProdutor","rua teste produtor");
                add("complementoEnderecoProdutor","complemento teste");
                add("cnpjProdutor","21312132323");
                add("senhaProdutor","senhaprodutorteste");
                add("telefoneProdutor","111111111");
                add("tipoProdutor","pj");
                add("latitudeProdutor",new BigDecimal("12.12121"));
                add("produtos", new ArrayList<>());
                add("longitudeProdutor",new BigDecimal("15.12121"));


            }
        });

    }
}
