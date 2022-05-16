package br.com.agricolab.templates;

import br.com.agricolab.core.consumidor.dto.ConsumidorDto;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

import java.math.BigDecimal;
import java.util.ArrayList;

public class ConsumidorDtoTemplate implements TemplateLoader {

    public static final String VALIDO = "valido";
    public static final String INCORRETO = "incorreto";

    @Override
    public void load() {
        Fixture.of(ConsumidorDto.class).addTemplate(VALIDO, new Rule(){
            {
                add("idConsumidor","1");
                add("nomeConsumidor","teste");
                add("emailConsumidor","teste@hotmail.com");
                add("enderecoConsumidor","Rua teste");
                add("complementoEnderecoConsumidor",null);
                add("cnpjConsumidor",null);
                add("senhaConsumidor","senhateste");
                add("telefoneConsumidor","1111111111");
                add("pedidos", new ArrayList<>());
                add("tipoConsumidor","pf");
                add("latitudeConsumidor",new BigDecimal("12.12121"));
                add("longitudeConsumidor",new BigDecimal("15.12121"));

        }
        }).addTemplate(INCORRETO, new Rule(){

        });


    }
}
