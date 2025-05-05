package org.example;

import java.io.InputStreamReader;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import com.google.gson.*;

public class ConversorDeMoedas {
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/bf4c243f95da510b6dfdc96c/latest/";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;
        while (continuar) {
            System.out.println("\n--- Conversor de Moedas ---");
            System.out.println("1. Dólar => Peso Argentino");
            System.out.println("2. Peso Argentino => Dólar");
            System.out.println("3. Dólar => Real Brasileiro");
            System.out.println("4. Real Brasileiro => Dólar");
            System.out.println("5. Dólar => Peso Colombiano");
            System.out.println("6. Peso Colombiano => Dólar");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            if (opcao == 7) {
                continuar = false;
                break;
            }

            System.out.print("Informe o valor a ser convertido: ");
            double valor = scanner.nextDouble();

            String moedaOrigem = "", moedaDestino = "";

            switch (opcao) {
                case 1: moedaOrigem = "USD"; moedaDestino = "ARS"; break;
                case 2: moedaOrigem = "ARS"; moedaDestino = "USD"; break;
                case 3: moedaOrigem = "USD"; moedaDestino = "BRL"; break;
                case 4: moedaOrigem = "BRL"; moedaDestino = "USD"; break;
                case 5: moedaOrigem = "USD"; moedaDestino = "COP"; break;
                case 6: moedaOrigem = "COP"; moedaDestino = "USD"; break;
                default:
                    System.out.println("Opção inválida!");
                    continue;
            }

            try {
                double taxa = obterTaxaDeCambio(moedaOrigem, moedaDestino);
                double convertido = valor * taxa;
                System.out.printf("Resultado: %.2f %s = %.2f %s\n", valor, moedaOrigem, convertido, moedaDestino);
            } catch (Exception e) {
                System.out.println("Erro ao obter taxa de câmbio: " + e.getMessage());
            }
        }

        scanner.close();
        System.out.println("Programa encerrado.");
    }

    public static double obterTaxaDeCambio(String de, String para) throws Exception {
        String url_str = API_URL + de;
        URL url = new URL(url_str);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject jsonobj = root.getAsJsonObject();

        if (!jsonobj.get("result").getAsString().equals("success")) {
            throw new RuntimeException("Falha na requisição da API");
        }

        JsonObject taxas = jsonobj.getAsJsonObject("conversion_rates");
        return taxas.get(para).getAsDouble();
    }
}