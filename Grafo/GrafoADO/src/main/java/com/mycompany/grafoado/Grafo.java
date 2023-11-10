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
import java.util.LinkedList;
import java.util.Queue;

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
        // Lista de vértices já visitados
        ArrayList<Vertice<TIPO>> marcados = new ArrayList<Vertice<TIPO>>();
        
        // Fila para controlar a ordem de visitação
        Queue<Vertice<TIPO>> fila = new LinkedList<Vertice<TIPO>>();

        // Inicializando a busca a partir do primeiro vértice no grafo
        Vertice<TIPO> inicio = this.vertices.get(0);
        marcados.add(inicio);
        fila.add(inicio);

        System.out.println("Ponto de Partida: " + inicio.getDado());

        while (!fila.isEmpty()) {
            // Removendo o vértice atual da fila
            Vertice<TIPO> visitado = fila.poll();

            // Iterando sobre as arestas do vértice atual
            for (Aresta<TIPO> aresta : visitado.getArestasSaida()) {
                Vertice<TIPO> proximo = aresta.getFim();

                if (!marcados.contains(proximo)) {
                    // Marcando o vértice como visitado
                    marcados.add(proximo);

                    // Imprimindo o vértice visitado
                    System.out.println("Conexão: " + visitado.getDado() + " -> " + proximo.getDado());

                    // Adicionando o vértice à fila para visitar seus vizinhos
                    fila.add(proximo);
                }
            }
        }
    }


}
