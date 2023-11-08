/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.grafoado;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author alexs
 */
public class GrafoADO {

    public static void main(String[] args) {
        Grafo<String> grafo = new Grafo<String>();
        
        grafo.adicionarVertice("esquina A");
        
        grafo.adicionarVertice("esquina B");
        
        grafo.adicionarVertice("esquina C");
        
        grafo.adicionarVertice("esquina D");
        
        grafo.adicionarVertice("esquina E");
        
        grafo.adicionarVertice("esquina F");
        
        grafo.adicionarVertice("esquina G");
        
        grafo.adicionarVertice("esquina H");
        
        grafo.adicionarVertice("esquina I");
        
        grafo.adicionarVertice("esquina J");
        
        grafo.adicionarVertice("esquina K");
        
        grafo.adicionarAresta(10.0,"esquina A", "esquina C");
        grafo.adicionarAresta(9.0, "esquina A", "esquina B");
        grafo.adicionarAresta(15.0,"esquina C", "esquina E");
        grafo.adicionarAresta(4.0, "esquina C", "esquina D");
        grafo.adicionarAresta(5.0, "esquina D", "esquina F");
        grafo.adicionarAresta(10.0,"esquina D", "esquina K");
        grafo.adicionarAresta(20.0,"esquina E", "esquina G");
        grafo.adicionarAresta(4.0, "esquina E", "esquina F");
        grafo.adicionarAresta(5.0, "esquina F", "esquina J");
        grafo.adicionarAresta(10.0,"esquina G", "esquina H");
        grafo.adicionarAresta(5.0, "esquina H", "esquina I");
        grafo.adicionarAresta(13.0,"esquina I", "esquina J");
        grafo.adicionarAresta(5.0, "esquina J", "esquina K");
        grafo.adicionarAresta(7.0, "esquina K", "esquina B");
        grafo.adicionarAresta(7.0, "esquina B", "esquina A");
        
        grafo.BuscaEmLargura();
        
       /*  Map<String, List<String>> graf = new HashMap<>();
        graf.put("esquina A", new ArrayList<>(Arrays.asList("esquina C", "esquina B")));
        graf.put("esquina B", new ArrayList<>(Arrays.asList("esquina A", "esquina K")));
        graf.put("esquina C", new ArrayList<>(Arrays.asList("esquina A", "esquina E", "esquina D")));
        graf.put("esquina D", new ArrayList<>(Arrays.asList("esquina C", "esquina F", "esquina K")));
        graf.put("esquina E", new ArrayList<>(Arrays.asList("esquina C", "esquina G", "esquina F")));
        graf.put("esquina F", new ArrayList<>(Arrays.asList("esquina D", "esquina E", "esquina J")));
        graf.put("esquina G", new ArrayList<>(Arrays.asList("esquina E", "esquina H")));
        graf.put("esquina H", new ArrayList<>(Arrays.asList("esquina G", "esquina I")));
        graf.put("esquina I", new ArrayList<>(Arrays.asList("esquina H", "esquina J")));
        graf.put("esquina J", new ArrayList<>(Arrays.asList("esquina F", "esquina I", "esquina K")));
        graf.put("esquina K", new ArrayList<>(Arrays.asList("esquina D", "esquina J", "esquina B")));

        for (Map.Entry<String, List<String>> entry : graf.entrySet()) {
            String vertice = entry.getKey();
            List<String> conexoes = entry.getValue();
            System.out.print(vertice + " -> ");
            for (String conexao : conexoes) {
                System.out.print(conexao + " ");
            }
            System.out.println();
        }*/
    }
    
}
