# Grupo 18 - Agricolab

[![tests](https://github.com/ES-UFABC/Grupo-18-Agricolab/actions/workflows/tests.yml/badge.svg)](https://github.com/ES-UFABC/Grupo-18-Agricolab/actions/workflows/tests.yml)

1. Ananda de Oliveira Gonçalves Antenor
1. Arthur Rigolon Lança
1. Bruno Rios Sousa
1. Richard Chinem Fujii
1. Wesley Batista Soares
1. Paulo Consoni

=======================
# Sobre

=======================

# Pré Requisitos

* JDK 11
* Spring Framework
* IDE (Eclipse, IntelliJ, Spring Tool Suite)
* NodeJS
* NPM
* Angular CLI

========================

# Desenho Arquitetura

![arquitetura](https://user-images.githubusercontent.com/32601542/157986724-677be37f-1cd3-4c84-9b58-eefe6afbde4c.png)

========================

# Como instalar

## Frontend

- Para instalar o frontend em Angular, é necessário ter instalado o NodeJS e o NPM
- Execute o comando "npm install -g @angular/cli" no seu terminal para instalar o Angular CLI
- Após clonar o projeto, navegue até a pasta "frontend" com seu terminal
- Execute o comando "npm install" para instalar as dependências do projeto

### Para visualizar na rede local (permite abrir no smartphone)

- No terminal, execute o comando "npm start-host" ou "ng serve --host 0.0.0.0"
- Localize o IP da sua máquina que está rodando o projeto e acesse por http://SEU-IP-DA-MAQUINA:4200 em seu smartphone

## Backend

- É necessário baixar o projeto, java 11 e o IntelliJ community
- Rodar o comando maven "mvn clean install"
- Configurar uma nova aplicação como na imagem abaixo:
![config](https://user-images.githubusercontent.com/32601542/167998253-0a3bac85-039e-4399-9d74-4bbe04fb3af7.png)
- Rodar com as teclas "Shift + f10"

========================

# Como usar

## Frontend

- Com as dependências instaladas, execute o comando "npm start" ou "ng serve"
- Após a aplicação ser inicializada, ela deve estar rodando na porta http://localhost:4200

## Backend
- Após rodar a aplicação, o back end estará rodando na porta http://localhost:8080

=======

# Banco dados - Entidades
![repository](https://user-images.githubusercontent.com/32601542/157987135-902fce02-d728-4e4d-b72c-4830896a782c.png)

# End Points API's

## Produtor

### GET /produtor/all

Retorna uma lista de todos os produtores cadastrados.

Exemplo Retorno:

```
[
    {
        "idProdutor": 1,
        "nomeProdutor": "TESTE2",
        "tipoProdutor": "pj",
        "emailProdutor": "java2@email.com",
        "senhaProdutor": "senhateste",
        "pedidosRecebidos": [],
        "produtos": [
            {
                "idProduto": 132,
                "nomeProduto": "testeedd",
                "quantidadeProduto": 400,
                "valorProduto": 110.15
            }
        ],
        "cnpjProdutor": "1201212132",
        "cpfProdutor": null,
        "telefoneProdutor": "111-1111",
        "enderecoProdutor": "rua dos bobos",
        "complementoEnderecoProdutor": "casa",
        "latitudeProdutor": 12.12121000,
        "longitudeProdutor": 15.12121000
    },
    {
        "idProdutor": 2,
        "nomeProdutor": "TESTE2",
        "tipoProdutor": "pj",
        "emailProdutor": "java21@email.com",
        "senhaProdutor": "senhateste",
        "pedidosRecebidos": [
            {
                "idPedido": 141,
                "nomePedido": "testenovo22",
                "quantidadePedido": 2,
                "valorPedido": 220.30
            },
            {
                "idPedido": 169,
                "nomePedido": "testenovo22",
                "quantidadePedido": 2,
                "valorPedido": 220.30
            },
            {
                "idPedido": 171,
                "nomePedido": "novo pedido",
                "quantidadePedido": 2,
                "valorPedido": 220.30
            }
        ],
        "produtos": [
            {
                "idProduto": 126,
                "nomeProduto": "testenovo22",
                "quantidadeProduto": 382,
                "valorProduto": 110.15
            },
            {
                "idProduto": 133,
                "nomeProduto": "testeedd",
                "quantidadeProduto": 392,
                "valorProduto": 110.15
            },
            {
                "idProduto": 170,
                "nomeProduto": "novo pedido",
                "quantidadeProduto": 398,
                "valorProduto": 110.15
            }
        ],
        "cnpjProdutor": "1201212132",
        "cpfProdutor": null,
        "telefoneProdutor": "111-1111",
        "enderecoProdutor": "rua dos bobos",
        "complementoEnderecoProdutor": "casa",
        "latitudeProdutor": 12.12121000,
        "longitudeProdutor": 15.12121000
    }
]
```

### GET /produtor/{idProdutor}

Retorna as informações de detalhe do produtor, de acordo com o Id enviado.

Exemplo Retorno:
```
{
    "idProdutor": "1",
    "nomeProdutor": "TESTE2",
    "emailProdutor": "java2@email.com",
    "enderecoProdutor": "rua dos bobos",
    "complementoEnderecoProdutor": "casa",
    "cnpjProdutor": "1201212132",
    "senhaProdutor": "senhateste",
    "telefoneProdutor": "111-1111",
    "tipoProdutor": "pj",
    "latitudeProdutor": 12.12121000,
    "produtos": [
        {
            "idProduto": 132,
            "nomeProduto": "testeedd",
            "quantidadeProduto": 400,
            "valorProduto": 110.15
        }
    ],
    "pedidosRecebidos": [],
    "longitudeProdutor": 15.12121000
}
```
### PATCH /produtor/{idProdutor}

Modifica um produtor já registrado com o id enviado. Apenas os parametros enviados no body serão modificados no produtor existente. Caso o produtor não exista, um novo produtor é criado com as inforamções enviadas. 

Exemplo Body:
```
{
    "nomeProdutor": "TESTE2",
    "enderecoProdutor": "rua dos bobos",
    "complementoEnderecoProdutor": "casa",
    "cnpjProdutor": "1201212132",
    "senhaProdutor": "senhateste",
    "telefoneProdutor": "111-1111",
    "tipoProdutor": "pj",
    "latitudeProdutor": "12.12121",
    "longitudeProdutor": "15.12121"
}
```

Exemplo Retorno:
```
{
    "idProdutor": "9",
    "nomeProdutor": "TESTE2",
    "emailProdutor": "java3222@email.com",
    "enderecoProdutor": "rua dos bobos",
    "complementoEnderecoProdutor": "casa",
    "cnpjProdutor": "1201212132",
    "senhaProdutor": "senhateste",
    "telefoneProdutor": "111-1111",
    "tipoProdutor": "pj",
    "latitudeProdutor": 12.12121,
    "produtos": [],
    "pedidosRecebidos": [],
    "longitudeProdutor": 15.12121
}
```

### DELETE /produtor/{idProdutor}

Deleta um produtor, de acordo com o Id enviado.

### POST /produtor

Cria um produtor na base.

Exemplo Body:
```
{
    "nomeProdutor": "TESTE2",
    "emailProdutor": "java3222Teste@email.com",
    "enderecoProdutor": "rua dos bobos",
    "complementoEnderecoProdutor": "casa",
    "cnpjProdutor": "1201212132",
    "senhaProdutor": "senhateste",
    "telefoneProdutor": "111-1111",
    "tipoProdutor": "pj",
    "latitudeProdutor": "12.12121",
    "longitudeProdutor": "15.12121"
}
```

Exemplo Retorno:
```
{
    "idProdutor": "10",
    "nomeProdutor": "TESTE2",
    "emailProdutor": "java3222Teste@email.com",
    "enderecoProdutor": "rua dos bobos",
    "complementoEnderecoProdutor": "casa",
    "cnpjProdutor": "1201212132",
    "senhaProdutor": "senhateste",
    "telefoneProdutor": "111-1111",
    "tipoProdutor": "pj",
    "latitudeProdutor": 12.12121,
    "produtos": [],
    "pedidosRecebidos": [],
    "longitudeProdutor": 15.12121
}
```

### POST /api/agricolab/v1/produtor/login

Realiza a autenticação para o login do produtor.

Exemplo Body:
```
{
    "emailConsumidor": "java@email.com",
    "senhaConsumidor": "senhateste"
}
```

## Consumidor

### GET /consumidor/all

Retorna uma lista de todos os consumidores cadastrados.

Exemplo Retorno:
```
[
    {
        "idConsumidor": 1,
        "tipoConsumidor": "pj",
        "segmentoConsumidorPJ": null,
        "nomeConsumidor": "TESTE",
        "emailConsumidor": "java@email.com",
        "senhaConsumidor": "teste",
        "cnpjConsumidor": "1201212132",
        "cpfConsumidor": null,
        "telefoneConsumidor": "111-1111",
        "enderecoConsumidor": "rua dos bobos",
        "complementoEnderecoConsumidor": null,
        "latitudeConsumidor": 12.12121000,
        "longitudeConsumidor": 15.12121000,
        "pedidos": [
            {
                "idPedido": 141,
                "nomePedido": "testenovo22",
                "quantidadePedido": 2,
                "valorPedido": 220.30
            },
            {
                "idPedido": 169,
                "nomePedido": "testenovo22",
                "quantidadePedido": 2,
                "valorPedido": 220.30
            },
            {
                "idPedido": 171,
                "nomePedido": "novo pedido",
                "quantidadePedido": 2,
                "valorPedido": 220.30
            }
        ]
    },
    {
        "idConsumidor": 3,
        "tipoConsumidor": null,
        "segmentoConsumidorPJ": null,
        "nomeConsumidor": "Consumidor 2",
        "emailConsumidor": "c2@c2",
        "senhaConsumidor": "1111",
        "cnpjConsumidor": null,
        "cpfConsumidor": null,
        "telefoneConsumidor": "11 912345678",
        "enderecoConsumidor": "Rio Grande do Norte;586;Vila São Pedro;Santo André;São Paulo",
        "complementoEnderecoConsumidor": null,
        "latitudeConsumidor": -23.66630470,
        "longitudeConsumidor": -46.50501460,
        "pedidos": [
            {
                "idPedido": 167,
                "nomePedido": "teste1",
                "quantidadePedido": 1,
                "valorPedido": 120.15
            },
            {
                "idPedido": 168,
                "nomePedido": "teste1",
                "quantidadePedido": 7,
                "valorPedido": 841.05
            }
        ]
    }
]
```

### GET /consumidor/{idConsumidor}

Retorna um cliente de acordo com o id enviado.

Exemplo Retorno:
```
{
    "idConsumidor": "1",
    "nomeConsumidor": "TESTE",
    "emailConsumidor": "java@email.com",
    "enderecoConsumidor": "rua dos bobos",
    "complementoEnderecoConsumidor": null,
    "cnpjConsumidor": "1201212132",
    "senhaConsumidor": "teste",
    "telefoneConsumidor": "111-1111",
    "pedidosConsumidor": [
        {
            "idPedido": 141,
            "nomePedido": "testenovo22",
            "quantidadePedido": 2,
            "valorPedido": 220.30
        },
        {
            "idPedido": 169,
            "nomePedido": "testenovo22",
            "quantidadePedido": 2,
            "valorPedido": 220.30
        },
        {
            "idPedido": 171,
            "nomePedido": "novo pedido",
            "quantidadePedido": 2,
            "valorPedido": 220.30
        }
    ],
    "tipoConsumidor": "pj",
    "latitudeConsumidor": 12.12121000,
    "longitudeConsumidor": 15.12121000
}
```

### PATCH /consumidor/{idConsumidor}

Modifica um consumidor já registrado com o id enviado. Apenas os parametros enviados no body serão modificados no consumidor existente. Caso o consumidor não exista, um novo consumidor é criado com as inforamções enviadas. 

Exemplo Body:
```
{
    "nomeConsumidor": "TESTE",
    "enderecoConsumidor": "rua dos bobos",
    "complementoEnderecoconsumidor": "casa",
    "cnpjConsumidor": "1201212132",
    "telefoneConsumidor": "111-1111",
    "senhaConsumidor": "teste",
    "tipoConsumidor": "pj",
    "segmentoConsumidorPJ":"Agro",
    "latitudeConsumidor": "12.12121",
    "longitudeConsumidor": "15.12121"
}
```

Exemplo Retorno:
```
{
    "idConsumidor": "14",
    "nomeConsumidor": "TESTE",
    "emailConsumidor": "java12334@email.com",
    "enderecoConsumidor": "rua dos bobos",
    "complementoEnderecoConsumidor": null,
    "cnpjConsumidor": "1201212132",
    "senhaConsumidor": "teste",
    "telefoneConsumidor": "111-1111",
    "pedidosConsumidor": null,
    "tipoConsumidor": "pj",
    "latitudeConsumidor": 12.12121,
    "longitudeConsumidor": 15.12121
}
```

### DELETE /consumidor/{idConsumidor}

Deleção de consumidor de acordo com o id enviado.

### POST /consumidor

Criação de consumidores.

Exemplo Body:
```
{
    "nomeConsumidor": "TESTE",
    "emailConsumidor": "java12334@email.com",
    "enderecoConsumidor": "rua dos bobos",
    "complementoEnderecoconsumidor": "casa",
    "cnpjConsumidor": "1201212132",
    "telefoneConsumidor": "111-1111",
    "senhaConsumidor": "teste",
    "tipoConsumidor": "pj",
    "segmentoConsumidorPJ":"Agro",
    "latitudeConsumidor": "12.12121",
    "longitudeConsumidor": "15.12121"
}
```

Exemplo Retorno:
```
{
    "idConsumidor": "12",
    "nomeConsumidor": "TESTE",
    "emailConsumidor": "java12334@email.com",
    "enderecoConsumidor": "rua dos bobos",
    "complementoEnderecoConsumidor": null,
    "cnpjConsumidor": "1201212132",
    "senhaConsumidor": "teste",
    "telefoneConsumidor": "111-1111",
    "pedidosConsumidor": null,
    "tipoConsumidor": "pj",
    "latitudeConsumidor": 12.12121,
    "longitudeConsumidor": 15.12121
}
```

### POST /api/agricolab/v1/login

Realiza a autenticação para o login do consumidor.

Exemplo Body:
```
{
    "emailConsumidor": "java@email.com",
    "senhaConsumidor": "senhateste"
}
```

### GET /consumidor/nextprodutores/{Latitude}/{Longitude}

Retorna uma lista de produtores em um raio de 3 km da localicação enviada.

Exemplo Retorno:
```
[
    {
        "idProdutor": 1,
        "nomeProdutor": "TESTE2",
        "tipoProdutor": "pj",
        "emailProdutor": "java2@email.com",
        "senhaProdutor": "senhateste",
        "pedidosRecebidos": [],
        "produtos": [
            {
                "idProduto": 132,
                "nomeProduto": "testeedd",
                "quantidadeProduto": 400,
                "valorProduto": 110.15
            }
        ],
        "cnpjProdutor": "1201212132",
        "cpfProdutor": null,
        "telefoneProdutor": "111-1111",
        "enderecoProdutor": "rua dos bobos",
        "complementoEnderecoProdutor": "casa",
        "latitudeProdutor": 12.12121000,
        "longitudeProdutor": 15.12121000
    },
    {
        "idProdutor": 2,
        "nomeProdutor": "TESTE2",
        "tipoProdutor": "pj",
        "emailProdutor": "java21@email.com",
        "senhaProdutor": "senhateste",
        "pedidosRecebidos": [
            {
                "idPedido": 141,
                "nomePedido": "testenovo22",
                "quantidadePedido": 2,
                "valorPedido": 220.30
            },
            {
                "idPedido": 169,
                "nomePedido": "testenovo22",
                "quantidadePedido": 2,
                "valorPedido": 220.30
            },
            {
                "idPedido": 171,
                "nomePedido": "novo pedido",
                "quantidadePedido": 2,
                "valorPedido": 220.30
            }
        ],
        "produtos": [
            {
                "idProduto": 126,
                "nomeProduto": "testenovo22",
                "quantidadeProduto": 382,
                "valorProduto": 110.15
            },
            {
                "idProduto": 133,
                "nomeProduto": "testeedd",
                "quantidadeProduto": 392,
                "valorProduto": 110.15
            },
            {
                "idProduto": 170,
                "nomeProduto": "novo pedido",
                "quantidadeProduto": 398,
                "valorProduto": 110.15
            }
        ],
        "cnpjProdutor": "1201212132",
        "cpfProdutor": null,
        "telefoneProdutor": "111-1111",
        "enderecoProdutor": "rua dos bobos",
        "complementoEnderecoProdutor": "casa",
        "latitudeProdutor": 12.12121000,
        "longitudeProdutor": 15.12121000
    },
    {
        "idProdutor": 7,
        "nomeProdutor": "TESTE Bruno",
        "tipoProdutor": "pj",
        "emailProdutor": "javaaa3@email.com",
        "senhaProdutor": "senhateste",
        "pedidosRecebidos": [
            {
                "idPedido": 183,
                "nomePedido": "novo pedido",
                "quantidadePedido": 2,
                "valorPedido": 220.30
            },
            {
                "idPedido": 184,
                "nomePedido": "novo pedido",
                "quantidadePedido": 2,
                "valorPedido": 220.30
            },
            {
                "idPedido": 185,
                "nomePedido": "novo pedido",
                "quantidadePedido": 2,
                "valorPedido": 220.30
            },
            {
                "idPedido": 186,
                "nomePedido": "novo pedido",
                "quantidadePedido": 2,
                "valorPedido": 220.30
            },
            {
                "idPedido": 187,
                "nomePedido": "novo pedido",
                "quantidadePedido": 2,
                "valorPedido": 220.30
            },
            {
                "idPedido": 188,
                "nomePedido": "novo pedido",
                "quantidadePedido": 2,
                "valorPedido": 220.30
            },
            {
                "idPedido": 189,
                "nomePedido": "novo pedido",
                "quantidadePedido": 2,
                "valorPedido": 220.30
            },
            {
                "idPedido": 190,
                "nomePedido": "novo pedido",
                "quantidadePedido": 2,
                "valorPedido": 220.30
            },
            {
                "idPedido": 193,
                "nomePedido": "novo pedido",
                "quantidadePedido": 2,
                "valorPedido": 220.30
            },
            {
                "idPedido": 195,
                "nomePedido": "novo pedido",
                "quantidadePedido": 2,
                "valorPedido": 220.30
            },
            {
                "idPedido": 196,
                "nomePedido": "alface",
                "quantidadePedido": 2,
                "valorPedido": 220.30
            },
            {
                "idPedido": 199,
                "nomePedido": "batata 3",
                "quantidadePedido": 2,
                "valorPedido": 220.30
            },
            {
                "idPedido": 200,
                "nomePedido": "batata 4",
                "quantidadePedido": 2,
                "valorPedido": 220.30
            },
            {
                "idPedido": 201,
                "nomePedido": "batata 3",
                "quantidadePedido": 2,
                "valorPedido": 220.30
            }
        ],
        "produtos": [
            {
                "idProduto": 181,
                "nomeProduto": "novo pedido",
                "quantidadeProduto": 378,
                "valorProduto": 110.15
            },
            {
                "idProduto": 182,
                "nomeProduto": "alface",
                "quantidadeProduto": 294,
                "valorProduto": 110.15
            },
            {
                "idProduto": 197,
                "nomeProduto": "batata 3",
                "quantidadeProduto": 296,
                "valorProduto": 110.15
            },
            {
                "idProduto": 198,
                "nomeProduto": "batata 4",
                "quantidadeProduto": 298,
                "valorProduto": 110.15
            }
        ],
        "cnpjProdutor": "1201212132",
        "cpfProdutor": null,
        "telefoneProdutor": "111-1111",
        "enderecoProdutor": "rua dos bobos",
        "complementoEnderecoProdutor": "casa",
        "latitudeProdutor": 12.12121000,
        "longitudeProdutor": 15.12121000
    },
    {
        "idProdutor": 9,
        "nomeProdutor": "TESTE2",
        "tipoProdutor": "pj",
        "emailProdutor": "java3222@email.com",
        "senhaProdutor": "senhateste",
        "pedidosRecebidos": [],
        "produtos": [],
        "cnpjProdutor": "1201212132",
        "cpfProdutor": null,
        "telefoneProdutor": "111-1111",
        "enderecoProdutor": "rua dos bobos",
        "complementoEnderecoProdutor": "casa",
        "latitudeProdutor": 12.12121000,
        "longitudeProdutor": 15.12121000
    }
]
```

## Produtos

### POST /produtor/cadastro/produto/{idProdutor}

Cadastro de produto para um produtor específico.

Exemplo Body:
```
{
    "nomeProduto": "produto Novo",
    "quantidadeProduto": 402,
    "valorProduto": 210.15
}
```

Exemplo Retorno:
```
{
    "idProdutor": 1,
    "nomeProdutor": "TESTE2",
    "tipoProdutor": "pj",
    "emailProdutor": "java2@email.com",
    "senhaProdutor": "senhateste",
    "pedidosRecebidos": [],
    "produtos": [
        {
            "idProduto": 132,
            "nomeProduto": "testeedd",
            "quantidadeProduto": 400,
            "valorProduto": 110.15
        },
        {
            "idProduto": 207,
            "nomeProduto": "testeedd",
            "quantidadeProduto": 400,
            "valorProduto": 110.15
        },
        {
            "idProduto": 208,
            "nomeProduto": "produto Novo",
            "quantidadeProduto": 402,
            "valorProduto": 210.15
        }
    ],
    "cnpjProdutor": "1201212132",
    "cpfProdutor": null,
    "telefoneProdutor": "111-1111",
    "enderecoProdutor": "rua dos bobos",
    "complementoEnderecoProdutor": "casa",
    "latitudeProdutor": 12.12121000,
    "longitudeProdutor": 15.12121000
}
```

### DELETE /produtor/delete/produto/{idProduto}

Deleta um produto de acordo com o id enviado.

### PUT /produtor/alterar/produto/{idProduto}

Altera um produto já cadastrado de acordo com o id do produto.

Exemplo Body:
```
{
    "nomeProduto": "Produto novo 2",
    "quantidadeProduto": 500,
    "valorProduto": 120.15
}
```

### GET /produtor/produto/all

Retorna a lista de todos os produtos cadastrados.

Exemplo Retorno:
```
[
    {
        "idProduto": 126,
        "nomeProduto": "testenovo22",
        "quantidadeProduto": 382,
        "valorProduto": 110.15
    },
    {
        "idProduto": 132,
        "nomeProduto": "testeedd",
        "quantidadeProduto": 400,
        "valorProduto": 110.15
    },
    {
        "idProduto": 133,
        "nomeProduto": "testeedd",
        "quantidadeProduto": 392,
        "valorProduto": 110.15
    }
]
```

## Pedidos

### GET /consumidor/pedido/all

Retorna a lista de todos os pedidos cadastrados.

Exemplo Retorno:
```
[
    {
        "idPedido": 141,
        "nomePedido": "testenovo22",
        "quantidadePedido": 2,
        "valorPedido": 220.30
    },
    {
        "idPedido": 167,
        "nomePedido": "teste1",
        "quantidadePedido": 1,
        "valorPedido": 120.15
    },
    {
        "idPedido": 168,
        "nomePedido": "teste1",
        "quantidadePedido": 7,
        "valorPedido": 841.05
    }
]
```

### DELETE /consumidor/delete/pedido/{idPedido}

Deleta um pedido de acordo com o id do pedido.

### PUT /consumidor/alterar/pedido/{idPedido}

Exemplo Body:
```

```

Exemplo Retorno:
```

```

### POST /consumidor/pedidos/{idProdutor}/{idConsumidor}

Cria um pedido de acordo com o idConsumidor e o idProdutor enviado.

Exemplo Body:
```
{
    "nomeProduto": "alface",
    "quantidadeProduto":2
}
```

Exemplo Retorno:
```

```

## Validacao

### GET /api/agricolab/v1/validacao/{email}

Retorna um boolean informando se o email já existe na base ou não.

Exemplo Retorno:
```
true
```

