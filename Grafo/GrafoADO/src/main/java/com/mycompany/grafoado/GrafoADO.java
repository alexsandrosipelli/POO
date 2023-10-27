/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.grafoado;

/**
 *
 * @author alexs
 */
public class GrafoADO {

    public static void main(String[] args) {
        Grafo<String> grafo = new Grafo<String>();
        
        grafo.adicionarVertice("alex");
        grafo.adicionarVertice("sara");
        grafo.adicionarVertice("brenda");
        grafo.adicionarVertice("joao");
        grafo.adicionarAresta(10.0,"alex", "sara");
        grafo.adicionarAresta(5.0,"alex", "lucas");
        grafo.adicionarAresta(3.0,"alex", "joao");
        grafo.adicionarAresta(2.0,"sara", "lucas");
        grafo.adicionarAresta(3.0,"brenda", "joao");
        
        grafo.buscaEmLargura();
    }
    
}
