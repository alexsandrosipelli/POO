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
        ArrayList<Vertice<TIPO>> marcados = new ArrayList<Vertice<TIPO>>();//visistados

        ArrayList<Vertice<TIPO>> fila = new ArrayList<Vertice<TIPO>>();//apos serem visitados vao para fila

        Vertice<TIPO> atual = this.vertices.get(0);//"esquina A"
        Aresta<TIPO> aresta = new Aresta<TIPO>();

        marcados.add(atual);//add "esquina A"

        System.out.println(atual.getDado());// imprimir esquina A

        fila.add(atual);//  apos visitalo add na fila de visistados
        

        while (fila.size() > 0) {// durante o cod, vai add o proximo e quando nao tiver mais proximo a fila ficará zero e o loop irá acabar

            Vertice<TIPO> visitado = fila.get(0);//"esquina A" no primeiro loop... amazenado em uma istancia da classe Vertice

            for (int i = 0; i < visitado.getArestasSaida().size(); i++) {// com quantas esquinas vai se conectar a "esquina A"

                Vertice<TIPO> proximo = visitado.getArestasSaida().get(i).getFim();//pegando a esquina que esta sendo conectada e amazenando na instancia da classe vertice "proximo" no caso "esquina C".

                if (!marcados.contains(proximo)) {//se nao contem na lista de marcado add o proximo, no caso o A "esquina C"

                    marcados.add(proximo);// no caso "esquina C"

                    System.out.println(proximo.getDado());// imprimir O proximo nesse caso o "esquina C" 

                    fila.add(proximo);//adicinonando o proximo, a fila ficará com dois index, e apos sair do loop for, irá remover o index 0, no caso "esquina A"
                }
            }//fim do FOR

            fila.remove(0);// apos percorrer todo vertice "esquina A " remove ele e o "esquina C" passará a ser o index 0 e assim mantendo o loop while ate chegar no ultimo.
        }
    }

}
