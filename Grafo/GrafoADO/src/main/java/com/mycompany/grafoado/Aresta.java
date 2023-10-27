/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grafoado;

/**
 *
 * @author alexs
 */
public class Aresta<TIPO> {
    private Double peso;  // Peso da aresta
    private Vertice<TIPO> inicio;  // Vértice de início da aresta
    private Vertice<TIPO> fim;  // Vértice final da aresta

    public Aresta(Double peso, Vertice<TIPO> inicio, Vertice<TIPO> fim){
        this.peso = peso;   
        this.inicio = inicio;
        this.fim = fim;
    }

    public Double getPeso() {
        return peso;  // Retorna o peso da aresta
    }

    public void setPeso(Double peso) {
        this.peso = peso;  // Define um novo peso para a aresta
    }

    public Vertice<TIPO> getInicio() {
        return inicio;  // Retorna o vértice de início da aresta
    }

    public void setInicio(Vertice<TIPO> inicio) {
        this.inicio = inicio;  // Define um novo vértice de início para a aresta
    }

    public Vertice<TIPO> getFim() {
        return fim;  // Retorna o vértice final da aresta
    }

    public void setFim(Vertice<TIPO> fim) {
        this.fim = fim;  // Define um novo vértice final para a aresta
    }
}
