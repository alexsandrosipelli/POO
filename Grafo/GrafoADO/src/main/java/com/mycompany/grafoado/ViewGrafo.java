/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grafoado;

/**
 *
 * @author alexs
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ViewGrafo extends JFrame {
    private final Map<String, Point> vertices = new HashMap<>();
    private final List<Edge> arestas = new ArrayList<>();

    public ViewGrafo() {
        setTitle("Grafo Interativo");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Adiciona os botões à tela
        JButton btnAdicionarVertice = new JButton("Adicionar Vértice");
        JButton btnAdicionarAresta = new JButton("Adicionar Aresta");
        
        //Adiciona os eventos ao botão vertice
        btnAdicionarVertice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String rotulo = JOptionPane.showInputDialog("Digite o rótulo do vértice:");
                vertices.put(rotulo, MouseInfo.getPointerInfo().getLocation());
                repaint();
            }
        });

            //Adiciona eventos ao botão aresta
        btnAdicionarAresta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String origem = JOptionPane.showInputDialog("Digite o rótulo do vértice de origem:");
                String destino = JOptionPane.showInputDialog("Digite o rótulo do vértice de destino:");
                adicionaAresta(origem, destino);//Adiciona a aresta do ponto de origem ao ponto final
            }
        });
        
        // Adiciona um vertice quando clica na janela
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
            }
        });
        
        // Organiza os botões com o FlowLayout
        setLayout(new FlowLayout());
        add(btnAdicionarVertice);
        add(btnAdicionarAresta);

        setVisible(true);
    }
    
    //Método para adicionar arestas
    public void adicionaAresta(String origem, String destino) {
        Point pontoOrigem = vertices.get(origem);//Adiciona a aresta do ponto de origem
        Point pontoDestino = vertices.get(destino);//Até o ponto de destino
        if (pontoOrigem != null && pontoDestino != null) {// Se os pontos informados não forem nulos, a aresta é adicionada com sucesso
            arestas.add(new Edge(pontoOrigem, pontoDestino));
            repaint();
        } else {
            JOptionPane.showMessageDialog(this, "Vértices não encontrados!");
        }
    }
    
    //O metodo paint é responsavel pelas cores, forma e tamanho do itens que aparece na tela
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        for (Map.Entry<String, Point> entry : vertices.entrySet()) {
            String rotulo = entry.getKey();// Acessa a chave no Map
            Point ponto = entry.getValue();// Acessa o valor no Map
            g.setColor(Color.BLUE);// Define a cor do objeto
            g.fillOval(ponto.x - 25, ponto.y - 25, 50, 50);// Define o formato do objeto e a localização do ponto
            g.setColor(Color.WHITE);// Cor da fonte
            g.drawString(rotulo, ponto.x - 5, ponto.y + 5);
        }

        for (Edge aresta : arestas) {
            g.setColor(Color.BLACK);// Cor da aresta
            g.drawLine(aresta.origem.x, aresta.origem.y, aresta.destino.x, aresta.destino.y);// Define os pontos da aresta
        }
    }
    
    //Metodo que determina os pontos da aresta
    private static class Edge {
        private final Point origem;
        private final Point destino;

        public Edge(Point origem, Point destino) {
            this.origem = origem;
            this.destino = destino;
        }
    }
       
}




