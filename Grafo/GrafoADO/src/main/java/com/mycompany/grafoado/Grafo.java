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

    /* Classe do tipo Generica, e duas listas genericas para amazernar
    os vertices e arestas */
    private ArrayList<Vertice<TIPO>> vertices;
    private ArrayList<Aresta<TIPO>> arestas;

    /*Construtor Essas linhas garantem que quando um novo
 objeto Grafo é criado, ele começa com listas de arestas e vértices
 vazias, prontas para serem preenchidas conforme necessário durante
 a execução do programa. ASSIM O CONSTRUTOR INICIA VAZIAS*/
    public Grafo() {
        this.arestas = new ArrayList<Aresta<TIPO>>();
        this.vertices = new ArrayList<Vertice<TIPO>>();

    }

    /*criando os metodos de adicionar vertice e aresta 
    Vertice<TIPO> novoVertice = new Vertice<TIPO>(dado);: Esta linha cria um
    novo objeto da classe Vertice com o dado fornecido como parâmetro.
    O construtor da 
    classe Vertice é chamado, passando o parâmetro dado.
    this.vertices.add(novoVertice);: Esta linha adiciona o novo vértice criado à
    lista de vértices do grafo. A lista de vértices é presumivelmente um campo
    da classe Grafo, o que permite adicionar o novo vértice a essa lista.
    Portanto, quando o método adicionarVertice é chamado, ele cria um novo
    vértice com o dado fornecido e o adiciona à lista de vértices do grafo.*/
    public void adicionarVertice(TIPO dado) {
        // Cria um novo vértice com o dado fornecido e o adiciona à lista de vértices
        Vertice<TIPO> novoVertice = new Vertice<TIPO>(dado);
        this.vertices.add(novoVertice);
    }

    public void adicionarAresta(Double peso, TIPO ondeLigarInicio, TIPO ondeLigarFim) {
        /*os paramentos que serao passado sera o peso, e de onde para onde EX  2.0,ALEX,SARA assim
        a busca sera feita com alex e sara e ligar eles*/
        Vertice<TIPO> inicio = this.getVertice(ondeLigarInicio);/*usando o get para pegar o vertice e amarzenar na variavel inicio*/
        Vertice<TIPO> fim = this.getVertice(ondeLigarFim);/*usando o get para pegar o vertice e amarzenar o na  variavel fim*/

        Aresta<TIPO> aresta = new Aresta<TIPO>(peso, inicio, fim);/* passando as variaveis para a criaçao da aresta com o peso e os vertices*/
        inicio.adicionarArestaSaida(aresta);
        fim.adicionarArestaEntrada(aresta);
                this.arestas.add(aresta);
    }

    public Vertice<TIPO> getVertice(TIPO dado) {
        // Retorna o vértice correspondente ao dado fornecido, se estiver presente na lista de vértices 
        Vertice<TIPO> vertice = null;
        for (int i = 0; i < this.vertices.size(); i++) {
            if (this.vertices.get(i).getDado().equals(dado)) {
                vertice = this.vertices.get(i);
                break;
            }
        }
        return vertice;
    }

    public void buscaEmLargura() {
        // Inicializa as listas para armazenar os vértices marcados e a fila a ser processada
        ArrayList<Vertice<TIPO>> marcados = new ArrayList<Vertice<TIPO>>();
        ArrayList<Vertice<TIPO>> fila = new ArrayList<Vertice<TIPO>>();

        // Começa com o primeiro vértice na lista de vértices e o adiciona às listas de marcados e fila 
        Vertice<TIPO> atual = this.vertices.get(0);
        marcados.add(atual);
        System.out.println(atual.getDado());
        fila.add(atual);

        // Executa o algoritmo de busca em largura
        while (fila.size() > 0) {
            Vertice<TIPO> visitado = fila.get(0);
            for (int i = 0; i < visitado.getArestasSaida().size(); i++) {
                Vertice<TIPO> proximo = visitado.getArestasSaida().get(i).getFim();
                if (!marcados.contains(proximo)) {
                    // Se o vértice não foi marcado, marca e o adiciona à fila
                    marcados.add(proximo);
                    System.out.println(proximo.getDado());
                    fila.add(proximo);
                }
            }
            fila.remove(0);
        }
    }

}
