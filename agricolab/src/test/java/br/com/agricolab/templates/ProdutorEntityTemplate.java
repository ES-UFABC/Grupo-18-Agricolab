package br.com.agricolab.templates;


import br.com.agricolab.repository.model.ProdutorEntity;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class ProdutorEntityTemplate implements TemplateLoader {

    public static final String LOGIN = "login";
    public static final String LOGIN_INCORRETO = "login invalido";


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
        });

    }
}
