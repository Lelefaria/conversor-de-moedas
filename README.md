# 💱 Conversor de Moedas - Java

Este projeto foi desenvolvido como parte do programa **Oracle Next Education (ONE)** em parceria com a **Alura**. O objetivo principal é aplicar conceitos de requisições HTTP em Java, consumir APIs externas e manipular dados em JSON usando a biblioteca **Gson**.

## 📌 Descrição

A aplicação permite converter valores entre diferentes moedas em tempo real, utilizando a API pública da **ExchangeRate API**. O usuário pode escolher entre diferentes pares de moedas e ver o resultado da conversão com base na taxa de câmbio atual.

## 🧠 Conceitos Praticados

- Requisições HTTP com `HttpURLConnection`
- Consumo de APIs REST
- Leitura e parsing de dados JSON com `Gson`
- Manipulação de entrada do usuário com `Scanner`
- Estrutura condicional com `switch` e laços `while`

## ⚙️ Tecnologias Utilizadas

- Java 17+
- Biblioteca [Gson](https://github.com/google/gson) para tratamento de JSON
- API [ExchangeRate API](https://www.exchangerate-api.com/)
- IDE IntelliJ

## 📋 Funcionalidades

- Conversão entre:
  - Dólar e Peso Argentino
  - Dólar e Real Brasileiro
  - Dólar e Peso Colombiano (e vice-versa)
- Escolha interativa via terminal
- Atualização de taxas em tempo real via API
