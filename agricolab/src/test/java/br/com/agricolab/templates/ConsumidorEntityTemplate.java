package br.com.agricolab.templates;

import br.com.agricolab.repository.model.ConsumidorEntity;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

import java.util.ArrayList;

public class ConsumidorEntityTemplate implements TemplateLoader {

    public static final String VALIDO = "valido";
    public static final String INCORRETO = "incorreto";
    public static final String LOGIN = "login correto";
    public static final String LOGIN_INCORRETO = "login incorreto";

    @Override
    public void load() {
        Fixture.of(ConsumidorEntity.class).addTemplate(VALIDO, new Rule(){
            {
                add("idConsumidor",1);
                add("tipoConsumidor","pf");
                add("segmentoConsumidorPJ","Agro");
                add("nomeConsumidor","teste");
                add("emailConsumidor","teste@hotmail.com");
                add("senhaConsumidor","senhateste");
                add("cnpjConsumidor",null);
                add("cpfConsumidor","54646447");
                add("telefoneConsumidor","1111111111");
                add("enderecoConsumidor","Rua teste");
                add("complementoEnderecoConsumidor",null);
                add("latitudeConsumidor","12,12121");
                add("longitudeConsumidor","15,12121");
                add("pedidos",new ArrayList<>());

            }
        }).addTemplate(LOGIN, new Rule(){

            {
                add("emailConsumidor","teste@hotmail.com");
                add("senhaConsumidor","senhateste");

            }

        }).addTemplate(LOGIN_INCORRETO, new Rule(){

            {
                add("emailConsumidor","teste@hotmail.com");
                add("senhaConsumidor",null);

            }
        });

    }
}