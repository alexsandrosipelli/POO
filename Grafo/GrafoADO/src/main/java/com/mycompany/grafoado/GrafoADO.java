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
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author alexs
 */
public class GrafoADO {

    public static void main(String[] args) {
        String nomeVertice;
        String esquinaInicio;
        String esquinaFim;
        double tempoPercurso;

        int escolha = 0;
        Grafo grafo = new Grafo();

        while (escolha != 5) {

            escolha = Integer.parseInt(JOptionPane.showInputDialog(null, "Escolha a opção \n"
                    + " 1- Inserir ponto de partida \n"
                    + " 2- Iserir conexao e tempo de percurso \n"
                    + " 3- Ver mapa atual \n"
                    + " 4- Fazer por interface \n"
                    + " 5- sair  "));
            if (escolha == 1) {
                nomeVertice = JOptionPane.showInputDialog(null, "De nome a esquina");

                grafo.adicionarVertice(nomeVertice);
            } else if (escolha == 2) {
                esquinaInicio = JOptionPane.showInputDialog(null, "De qual esquina voce esta partindo?");
                esquinaFim = JOptionPane.showInputDialog(null, "Qual a esquina que voce chegou?");
                tempoPercurso = Double.parseDouble(JOptionPane.showInputDialog(null, "Qual foi o tempo ?"));
                grafo.adicionarAresta(tempoPercurso, esquinaInicio, esquinaFim);
            } else if (escolha == 3) {
                
                grafo.BuscaEmLargura();
            } else if (escolha == 4) {
                SwingUtilities.invokeLater(() -> new ViewGrafo());

            } else if (escolha == 5) {
                System.exit(0);

            } else {
                JOptionPane.showMessageDialog(null, "Escolha invalida!!");
            }
        }

    }

}
