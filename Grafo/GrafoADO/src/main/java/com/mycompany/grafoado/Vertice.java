/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grafoado;

import java.util.ArrayList;

/**
 *
 * @author alexs
 */
/*Esses campos adicionais são úteis ao lidar com grafos direcionados,
    onde as arestas têm uma direção específica de um vértice de origem 
    para um vértice de destino.    arestasEntrada armazena todas as arestas 
    que apontam para este vértice, enquanto arestasSaida armazena todas as 
    arestas que saem deste vértice.*/
public class Vertice<TIPO> {

    private TIPO dado;
    /*dado que será obtido apos, e generico para receber qualquer tipo*/
    private ArrayList<Aresta<TIPO>> arestasEntrada;
    /* Este é um campo que armazena todas as arestas que entram neste vértice.*/
    private ArrayList<Aresta<TIPO>> arestasSaida;
     /*Este é um campo que armazena todas as arestas que saem deste vértice.*/

    public Vertice(TIPO valor) {
        this.dado = valor;
        this.arestasEntrada = new ArrayList<Aresta<TIPO>>();
        this.arestasSaida = new ArrayList<Aresta<TIPO>>();
        /* inicializa o vértice com o valor fornecido e cria listas vazias para arestasEntrada e arestasSaida.*/
    }
    public TIPO getDado() {
        return dado;  // Retorna o dado associado a um vértice
    }
    public void setDado(TIPO dado) {
        this.dado = dado;  // Define um novo valor para o dado associado a um vértice
    }
    public void adicionarArestaEntrada(Aresta<TIPO> aresta) {
        this.arestasEntrada.add(aresta);  // Adiciona uma nova aresta de entrada à lista de arestas de entrada do vértice
    }
    public void adicionarArestaSaida(Aresta<TIPO> aresta) {
        this.arestasSaida.add(aresta);  // Adiciona uma nova aresta de saída à lista de arestas de saída do vértice
    }
    public ArrayList<Aresta<TIPO>> getArestasEntrada() {
        return arestasEntrada;  // Retorna a lista de arestas de entrada associadas ao vértice
    }
    public void setArestasEntrada(ArrayList<Aresta<TIPO>> arestasEntrada) {
        this.arestasEntrada = arestasEntrada;  // Define a lista de arestas de entrada para o vértice
    }
    public ArrayList<Aresta<TIPO>> getArestasSaida() {
        return arestasSaida;  // Retorna a lista de arestas de saída associadas ao vértice
    }
    public void setArestasSaida(ArrayList<Aresta<TIPO>> arestasSaida) {
        this.arestasSaida = arestasSaida;  // Define a lista de arestas de saída para o vértice
    }
}
