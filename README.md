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


Exemplo Retorno:
```

```

### GET /consumidor/{idConsumidor}


Exemplo Retorno:
```

```

### PATCH /consumidor/{idConsumidor}


Exemplo Body:
```

```

Exemplo Retorno:
```

```

### DELETE /consumidor/{idConsumidor}


Exemplo Retorno:
```

```

### POST /consumidor


Exemplo Body:
```

```

Exemplo Retorno:
```

```

### POST /api/agricolab/v1/login


Exemplo Body:
```

```

Exemplo Retorno:
```

```

### GET /consumidor/nextprodutores/{Latitude}/{Longitude}


Exemplo Retorno:
```

```

## Produtos

### POST /produtor/cadastro/produto/{idProdutor}

Exemplo Body:
```

```

Exemplo Retorno:
```

```

### DELETE /produtor/delete/produto/{idProduto}

Exemplo Retorno:
```

```

### PUT /produtor/alterar/produto/{idProduto}

Exemplo Body:
```

```

Exemplo Retorno:
```

```

### GET /produtor/produto/all

Exemplo Retorno:
```

```

## Pedidos

### GET /consumidor/pedido/all

Exemplo Retorno:
```

```

### DELETE /consumidor/delete/pedido/{idPedido}

Exemplo Retorno:
```

```

### PUT /consumidor/alterar/pedido/{idPedido}

Exemplo Body:
```

```

Exemplo Retorno:
```

```

### POST /consumidor/pedidos/{idProdutor}/{idConsumidor}

Exemplo Body:
```

```

Exemplo Retorno:
```

```

## Validacao

### GET /api/agricolab/v1/validacao/{email}

Exemplo Retorno:
```

```
