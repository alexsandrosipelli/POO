/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grafoado;

/**
 *
 * @author alexs
 */
import java.awt.BorderLayout;
import java.util.ArrayList;

public class Grafo<TIPO> {

    private ArrayList<Vertice<TIPO>> vertices;
    private ArrayList<Aresta<TIPO>> arestas;

    public Grafo() {
        this.vertices = new ArrayList<Vertice<TIPO>>();
        this.arestas = new ArrayList<Aresta<TIPO>>();
    }

    public void adicionarVertice(TIPO dado) {
        Vertice<TIPO> novoVertice = new Vertice<TIPO>(dado);
        this.vertices.add(novoVertice);
    }

    public void adicionarAresta(Double peso, TIPO esquinaInicio, TIPO esquinaFim) {
        /*paramentos como esquina de inicio indica qual o vertice que vai sair a ligaçao e a esquinaFIm qual vai ser o que vai ser ligado*/
        Vertice<TIPO> inicio = this.getVertice(esquinaInicio);
        Vertice<TIPO> fim = this.getVertice(esquinaFim);
        Aresta<TIPO> aresta = new Aresta<TIPO>(peso, inicio, fim);
        inicio.adicionarArestaSaida(aresta);
        fim.adicionarArestaEntrada(aresta);
        this.arestas.add(aresta);
    }

    public Vertice<TIPO> getVertice(TIPO dado) {
        Vertice<TIPO> vertice = null;
        for (int i = 0; i < this.vertices.size(); i++) {
            if (this.vertices.get(i).getDado().equals(dado)) {
                vertice = this.vertices.get(i);
                break;
            }
        }
        return vertice;
    }

    public void BuscaEmLargura() {
        ArrayList<Vertice<TIPO>> marcados = new ArrayList<>(); // visitados
        ArrayList<Vertice<TIPO>> fila = new ArrayList<>(); // após serem visitados, vão para fila

        Vertice<TIPO> atual = this.vertices.get(0); // "esquina A"
        marcados.add(atual); // adiciona "esquina A" aos marcados

        System.out.println("Início da Busca em Largura a partir de: " + atual.getDado());

        fila.add(atual); // após visitá-lo, adiciona à fila

        while (!fila.isEmpty()) {
            Vertice<TIPO> visitado = fila.get(0); // primeiro vértice na fila

            for (int i = 0; i < visitado.getArestasSaida().size(); i++) {
                Vertice<TIPO> proximo = visitado.getArestasSaida().get(i).getFim(); // vértice conectado

                if (!marcados.contains(proximo)) {
                    marcados.add(proximo); // adiciona o próximo aos visitados

                    // Imprime a conexão e marcação
                    System.out.println("Conexão: " + visitado.getDado() + " -> " + proximo.getDado());

                    fila.add(proximo); // adiciona o próximo à fila
                }
            }

            fila.remove(0); // remove o vértice atual da fila após processamento
        }
    }

}
