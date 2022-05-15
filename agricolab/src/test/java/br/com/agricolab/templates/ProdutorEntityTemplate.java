package br.com.agricolab.templates;


import br.com.agricolab.repository.model.ProdutorEntity;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

import java.math.BigDecimal;
import java.util.ArrayList;

public class ProdutorEntityTemplate implements TemplateLoader {

    public static final String LOGIN = "login";
    public static final String LOGIN_INCORRETO = "login invalido";
    public static final String PRODUTOR_VALIDO = "produtor Valido";


    @Override
    public void load() {

        Fixture.of(ProdutorEntity.class).addTemplate(LOGIN, new Rule(){
            {
                add("emailProdutor","produtor@hotmail.com");
                add("senhaProdutor","senhaprodutorteste");
            }
        }).addTemplate(LOGIN_INCORRETO, new Rule(){
            {
                add("emailProdutor","produtor@hotmail.com");
                add("senhaProdutor",null);
            }
        }).addTemplate(PRODUTOR_VALIDO, new Rule(){
            {
                add("idProdutor","1");
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
                add("pedidosRecebidos", new ArrayList<>());
                add("longitudeProdutor",new BigDecimal("15.1212"));
            }
        });

    }
}
