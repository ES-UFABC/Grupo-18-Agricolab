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

Exemplo:

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

### PATCH /produtor/{idProdutor}

### DELETE /produtor/{idProdutor}

### POST /produtor

### POST /api/agricolab/v1/produtor/login

## Consumidor

### GET /consumidor/all

### GET /consumidor/{idConsumidor}

### PATCH /consumidor/{idConsumidor}

### DELETE /consumidor/{idConsumidor}

### POST /consumidor

### POST /api/agricolab/v1/login

### GET /consumidor/nextprodutores/{Latitude}/{Longitude}

## Produtos

### POST /produtor/cadastro/produto/{idProdutor}

### DELETE /produtor/delete/produto/{idProduto}

### PUT /produtor/alterar/produto/{idProduto}

### GET /produtor/produto/all

## Pedidos

### GET /consumidor/pedido/all

### DELETE /consumidor/delete/pedido/{idPedido}

### PUT /consumidor/alterar/pedido/{idPedido}

### POST /consumidor/pedidos/{idProdutor}/{idConsumidor}

## Validacao

### GET /api/agricolab/v1/validacao/{email}
