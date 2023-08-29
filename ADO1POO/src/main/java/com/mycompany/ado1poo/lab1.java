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
import java.text.DecimalFormat;

public class lab1 {

    public static void main(String[] args) {

        // nome do arquivo
        String nomeDoArquivo1 = "C:\\Users\\alexs\\OneDrive\\Documentos\\NetBeansProjects\\ADO1POO\\src\\main\\java\\com\\mycompany\\ado1poo\\pib.txt";
//      String nomeDoArquivo2 = "regioes.txt";

        // linha temporaria
        String linha = null;
        double pibTotal = 0;
        String estados[] = new String[27];
        double porEstado[] = new double[27];
        int index = 0;
        /*      ------------------------------------- */
 /*      Abertura de arquivo e loop de leitura */
 /*      ------------------------------------- */
        try {
            FileReader fileReader = new FileReader(nomeDoArquivo1);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // loop por cada linha do arquivo
            while ((linha = bufferedReader.readLine()) != null) {

                String[] partes = linha.split(";");
                pibTotal += Double.parseDouble(partes[1].trim());
                estados[index] = partes[0].trim();
                porEstado[index] = Double.parseDouble(partes[1].trim());
                index++;
            }
            for (int i = 0; i < estados.length; i++) {

                System.out.println("O estado " + estados[i] + " tem o porcentual de " + (String.format("%.2f", porEstado[i] * 100 / pibTotal)));

            }

            System.out.println("o valor do pib total  é : " + (String.format("%.2f", pibTotal)));

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
//
        try {
            String suldeste[] = new String[4];
            String nordeste[] = new String[9];
            String centroOeste[] = new String[4];
            String norte[] = new String[7];
            String sul[] = new String[3];

            FileWriter fileWriter = new FileWriter(arquivoDeSaida);

            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            double suldestePib = 0;
            double sulPib = 0;
            double nortePib = 0;
            double nodestedePib = 0;
            double centroPib = 0;

            for (int i = 0; i < estados.length; i++) {
                /* SULDESTE */
                suldeste[0] = estados[0];
                suldeste[1] = estados[1];
                suldeste[2] = estados[2];
                suldeste[3] = estados[10];
                suldestePib = porEstado[0] + porEstado[1] + porEstado[2] + porEstado[10];
                /* SUL*/
                sul[0] = estados[3];
                sul[1] = estados[4];
                sul[2] = estados[5];
                sulPib = porEstado[3] + porEstado[4] + porEstado[5];
                /* CENTRO OESTE */
                centroOeste[0] = estados[6];
                centroOeste[1] = estados[8];
                centroOeste[2] = estados[13];
                centroOeste[3] = estados[17];
                centroPib = porEstado[6] + porEstado[8] + porEstado[13] + porEstado[17];
                /*NORTE */
                norte[0] = estados[11];
                norte[1] = estados[14];
                norte[2] = estados[22];
                norte[3] = estados[23];
                norte[4] = estados[24];
                norte[5] = estados[25];
                norte[6] = estados[26];
                nortePib = porEstado[11] + porEstado[14] + porEstado[22] + porEstado[23] + porEstado[24] + porEstado[25] + porEstado[26];

                /* NODESTE */
                nordeste[0] = estados[7];
                nordeste[1] = estados[9];
                nordeste[2] = estados[12];
                nordeste[3] = estados[15];
                nordeste[4] = estados[16];
                nordeste[5] = estados[18];
                nordeste[6] = estados[19];
                nordeste[7] = estados[20];
                nordeste[8] = estados[21];
                nodestedePib = porEstado[7] + porEstado[9] + porEstado[12] + porEstado[15] + porEstado[16] + porEstado[18] + porEstado[19] + porEstado[20] + porEstado[21];
            }

            bufferedWriter.write("PIB DA REGIAO NORTE : ");
            bufferedWriter.newLine();
            for (int i = 0; i < norte.length; i++) {
                bufferedWriter.write(norte[i]);
                bufferedWriter.newLine();
            }
            bufferedWriter.write("O pib dessa regiao foi de " + nortePib + " E o porcentual foi de : " + (String.format("%.2f", (nortePib / pibTotal * 100))));
            bufferedWriter.newLine();
            bufferedWriter.newLine();

            bufferedWriter.write("PIB DA REGIAO NORDESTE : ");
            bufferedWriter.newLine();
            for (int i = 0; i < nordeste.length; i++) {
                bufferedWriter.write(nordeste[i]);
                bufferedWriter.newLine();
            }
            bufferedWriter.write("O pib dessa regiao foi de " + nodestedePib + " E o porcentual foi de : " + (String.format("%.2f", (nodestedePib / pibTotal * 100))));
            bufferedWriter.newLine();
            bufferedWriter.newLine();

            bufferedWriter.write("PIB DA REGIAO SULDESTE : ");
            bufferedWriter.newLine();
            for (int i = 0; i < suldeste.length; i++) {
                bufferedWriter.write(suldeste[i]);
                bufferedWriter.newLine();
            }
            bufferedWriter.write("O pib dessa regiao foi de " + suldestePib + " E o porcentual foi de : " + (String.format("%.2f", (suldestePib / pibTotal * 100))));
            bufferedWriter.newLine();
            bufferedWriter.newLine();

            bufferedWriter.write("PIB DA REGIAO SUL: ");
            bufferedWriter.newLine();
            for (int i = 0; i < sul.length; i++) {
                bufferedWriter.write(sul[i]);
                bufferedWriter.newLine();
            }
            bufferedWriter.write("O pib dessa regiao foi de " + sulPib + " E o porcentual foi de : " + (String.format("%.2f", (sulPib / pibTotal * 100))));
            bufferedWriter.newLine();
            bufferedWriter.newLine();

            bufferedWriter.write("PIB DA REGIAO CENTRO OESTE : ");
            bufferedWriter.newLine();
            for (int i = 0; i < centroOeste.length; i++) {
                bufferedWriter.write(centroOeste[i]);
                bufferedWriter.newLine();
            }
            bufferedWriter.write("O pib dessa regiao foi de " + centroPib + " E o porcentual foi de : " + (String.format("%.2f", (centroPib / pibTotal * 100))));
            bufferedWriter.newLine();
            bufferedWriter.newLine();

            // feche o arquivo
            bufferedWriter.close();
        } catch (IOException ex) {
            System.out.println("Erro de escrita em '" + arquivoDeSaida + "'");
        }

    }
}
