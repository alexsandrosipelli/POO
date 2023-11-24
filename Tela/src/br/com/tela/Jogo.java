package br.com.tela;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Jogo extends JPanel {
	public Jogo(){
		JFrame frame = new JFrame("Ola Mundo Grafico");
		JButton button = new JButton("Mover bolinha");
		frame.setSize(800, 600);
		button.setBounds(100, 100, 100, 100);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);//desabilita maximizar janela
		frame.setVisible(true);
		frame.add(this); // adiciona o JPanel na janela
		this.setBackground( Color.white ); // seta que o fundo da janela eh branco
		this.add(button);
		
		button.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				paint(getGraphics());
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	
	public int[] mexerCoordenadas() {
		Random random = new Random();
		int[] coordenadas = new int[2];
		int x = 0;
		int y = 0;
		x = random.nextInt(600);
		y = random.nextInt(400);
		coordenadas[0] = x;
		coordenadas[1] = y;
		return coordenadas;
		
	}
	
	
	
	@Override
	public void paint(Graphics g) {
		// limpa a janela
		super.paint(g);
		int[] coordenadas = mexerCoordenadas();
		Random randomColor = new Random();
		int cor01 = randomColor.nextInt(255);
		int cor02 = randomColor.nextInt(255);
		int cor03 = randomColor.nextInt(255);
		g.setColor(new Color(cor01, cor02, cor03));
		g.fillOval(coordenadas[0], coordenadas[1], 50, 50);
	}
}
