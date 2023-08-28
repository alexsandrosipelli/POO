/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.ado1poo;

/**
 *
 * @author alexs
 */
import java.io.*;

public class lab1 {

    public static void main(String[] args) {

        // nome do arquivo
        String nomeDoArquivo1 = "C:\\Users\\alexs\\OneDrive\\Documentos\\NetBeansProjects\\ADO1POO\\src\\main\\java\\com\\mycompany\\ado1poo\\pib.txt";
//      String nomeDoArquivo2 = "regioes.txt";

        // linha temporaria
        String linha = null;

        /*      ------------------------------------- */
 /*      Abertura de arquivo e loop de leitura */
 /*      ------------------------------------- */
        try {
            FileReader fileReader = new FileReader(nomeDoArquivo1);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // loop por cada linha do arquivo
            double valor = 0;
            while ((linha = bufferedReader.readLine()) != null) {
                String[] partes = linha.split(";");
                System.out.println(linha);
                valor += Double.parseDouble(partes[1].trim());
            }
            
            System.out.println("o valor é : " + valor );
            // feche o arquivo
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo inexistente: '" + nomeDoArquivo1 + "'");
        } catch (IOException ex) {
            System.out.println("Erro lendo o arquivo '" + nomeDoArquivo1 + "'");
        }

        /*      ------------------------------------- */
 /*      Exemplo de escrita em arquivo         */
 /*      ------------------------------------- */
        String arquivoDeSaida = "saida.txt";

        try {

            FileWriter fileWriter = new FileWriter(arquivoDeSaida);

            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write("pib da regiao sul = $$$$");
            bufferedWriter.newLine();
            bufferedWriter.write("pib da regiao suldeste = $$$$");
            bufferedWriter.newLine();
            bufferedWriter.write("pib da regiao nordeste = $$$$");
            bufferedWriter.newLine();
            bufferedWriter.write("pib da regiao norte = $$$$");
            bufferedWriter.newLine();
            bufferedWriter.write("pib da regiao Centro-Oeste = $$$$");

            // feche o arquivo
            bufferedWriter.close();
        } catch (IOException ex) {
            System.out.println("Erro de escrita em '" + arquivoDeSaida + "'");
        }

    }
}
