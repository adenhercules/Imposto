package com.esio.imposto;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class TelaGrafica extends JFrame {
	JMenuBar barraPrin;
	JMenu Inserir,Relatorio, Sair, Contribuinte;
	JMenuItem insIpva, ExibeTodos, Fisica, Juridica;
	JDesktopPane aJanela;
	
	PainelFisica painel1;
	PainelJuridica painel2;
	PainelIpva painel3;
	ArrayList<Estado> Lista = new ArrayList<Estado>();
	
	TelaGrafica(){
		super("Imposto");
		setLayout(new BorderLayout());
		aJanela = new JDesktopPane();
		aJanela.setLayout(new BorderLayout());
		barraPrin = new JMenuBar();
		setJMenuBar(barraPrin);
		Inserir	=	new JMenu("Inserir Informações");
		Relatorio =	new JMenu("Relatorio");
		Sair	=	new JMenu("Sair");
		//Inserindo os Menus na barra principal
		barraPrin.add(Inserir);
		barraPrin.add(Relatorio);
		barraPrin.add(Sair);
		Contribuinte =	new JMenu("Contribuinte");
		insIpva		=	new JMenuItem("IPVA");
		ExibeTodos	=	new JMenuItem("Exibe Impostos");
		Fisica		=	new JMenuItem("Pessoa Fisica");
		Juridica	=	new JMenuItem("Pessoa Juridica");
		//inserindo "Exibe Todos" no "Relatorio"
		Relatorio.add(ExibeTodos);
		//"Contribuinte" e "insIpva" no Menu "Inserir"
		Inserir.add(Contribuinte);
		Inserir.add(insIpva);
		//Inserir "Fisica" e "Juridica" no Menu "Contribuinte"
		Contribuinte.add(Fisica);
		Contribuinte.add(Juridica);
	
		//eventos Insere
		eventosInsere funcao = new eventosInsere();
		Fisica.addActionListener(funcao);
		Juridica.addActionListener(funcao);
		insIpva.addActionListener(funcao);
		Sair.addActionListener(funcao);
		//eventos Exibe todos
		eventosListagem funListagem = new eventosListagem();
		ExibeTodos.addActionListener(funListagem);
	}
	private class eventosListagem implements ActionListener{
		public void actionPerformed(ActionEvent evento) {
			String saida = "\nLISTAGEM IMPOSTO"+"\n\n";
			//int i;
			float total=0;
			for(Estado e: Lista) {
				saida += e.toString()+" Valor Imposto: $"+e.arrecadaImposto()+"\n";
				total += e.arrecadaImposto();
			}
		JOptionPane.showMessageDialog(null, saida+String.format("\nTOTAL IMPOSTO $%5.2f", total));
		}
	}
	private class eventosInsere implements ActionListener{
		public void actionPerformed(ActionEvent evento) {
			getContentPane().removeAll();
			if(evento.getSource()==Fisica) {
				painel1 = new PainelFisica();
				getContentPane().add(painel1);
				
			}else if(evento.getSource()==Juridica) {
				painel2 = new PainelJuridica();
				getContentPane().add(painel2);
				
			}else if(evento.getSource()==insIpva){
				painel3 = new PainelIpva();
				getContentPane().add(painel3);
			
			}//fim else
			revalidate();
			repaint();
		}
	}
	private class PainelFisica extends JPanel{
		JLabel lNome, lRendaBruta, lCpf, lGastoSaude, lGastoEducacao;
		JTextField tNome, tRendaBruta, tCpf, tGastoSaude, tGastoEducacao;
		JButton bOk;
		public PainelFisica() {
			setLayout(new BorderLayout());
			JPanel centro	=	new JPanel(new GridLayout(1,1,10,10));
			JPanel paux		=	new JPanel(new GridLayout(5,1));
			lNome			=	new	JLabel("Nome..............:",SwingConstants.RIGHT);
			lRendaBruta		=	new JLabel("Renda Bruta Anual.:",SwingConstants.RIGHT);
			lCpf			=	new	JLabel("CPF...............:",SwingConstants.RIGHT);
			lGastoSaude		=	new JLabel("Gasto Saude.......:",SwingConstants.RIGHT);
			lGastoEducacao	=	new JLabel("Gasto Educacao....:",SwingConstants.RIGHT);
			tNome		=		new JTextField(10);
			tRendaBruta		=	new JTextField(10);
			tCpf			=	new JTextField(10);
			tGastoSaude		=	new JTextField(10);
			tGastoEducacao	=	new JTextField(10);
			bOk				=	new JButton("Insere Pessoa Fisica");
			paux.add(lNome);			paux.add(tNome);
			paux.add(lRendaBruta);		paux.add(tRendaBruta);
			paux.add(lCpf);				paux.add(tCpf);
			paux.add(lGastoSaude);		paux.add(tGastoSaude);
			paux.add(lGastoEducacao);	paux.add(tGastoEducacao);
			paux.add(bOk);
			centro.add(paux);
			add(centro,BorderLayout.CENTER);
			add(bOk,BorderLayout.SOUTH);
			
			bOk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evento) {
					float renda=0;
					float gastoS=0;
					float gastoE=0;
					try {
						renda =	Float.parseFloat(tRendaBruta.getText());
						gastoS=	Float.parseFloat(tGastoSaude.getText());
						gastoE=	Float.parseFloat(tGastoEducacao.getText());
					}catch(NumberFormatException erro){
						renda=0;
						gastoS=0;
						gastoE=0;
					}
					PessoaFisica fisica = new PessoaFisica(tNome.getText(), renda,tCpf.getText(), gastoS, gastoE);
					Lista.add(fisica);
					JOptionPane.showMessageDialog(null, "Inseriu Pessoa Fisica com sucesso.");
					tNome.setText(""); 	tRendaBruta.setText("");	tCpf.setText("");
					tGastoSaude.setText("");	tGastoEducacao.setText("");
				}
			});//fecha evento do botao OK
			
		}//fecha construtor do painel fisica
	}//fecha class fisica
	private class PainelJuridica extends JPanel{
		JLabel lNome, lRendaBruta, lCgc, lGastoPessoal, lGastoEquipamento;
		JTextField tNome, tRendaBruta, tCgc, tGastoPessoal, tGastoEquipamento;
		JButton bOk;
		public PainelJuridica() {
			setLayout(new BorderLayout());
			JPanel centro = new JPanel(new GridLayout(1,1,10,10));
			JPanel paux	=	new JPanel(new GridLayout(5,2));
			lNome			=	new	JLabel("Nome..............:",SwingConstants.RIGHT);
			lRendaBruta		=	new JLabel("Renda Bruta Anual.:",SwingConstants.RIGHT);
			lCgc			=	new JLabel("CGC...............:",SwingConstants.RIGHT);
			lGastoPessoal	=	new JLabel("Gasto Pessoal.....:",SwingConstants.RIGHT);
			lGastoEquipamento=	new JLabel("Gasto Equipamento.:",SwingConstants.RIGHT);
			tNome			=	new JTextField(10);
			tRendaBruta		=	new JTextField(10);	
			tCgc			=	new JTextField(10);
			tGastoPessoal	=	new JTextField(10);
			tGastoEquipamento=	new JTextField(10);
			bOk				=	new JButton("Inserir Pessoa Juridica");
			paux.add(lNome);			paux.add(tNome);
			paux.add(lRendaBruta);		paux.add(tRendaBruta);
			paux.add(lCgc);				paux.add(tCgc);
			paux.add(lGastoPessoal);	paux.add(tGastoPessoal);
			paux.add(lGastoEquipamento);paux.add(tGastoEquipamento);
			
			centro.add(paux);
			add(centro, BorderLayout.CENTER);
			add(bOk, BorderLayout.SOUTH);
			
			bOk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evento) {
					float renda=0;
					float gastoP=0;
					float gastoE=0;
					try {
						renda=Float.parseFloat(tRendaBruta.getText());
						gastoP=Float.parseFloat(tGastoPessoal.getText());
						gastoE=Float.parseFloat(tGastoEquipamento.getText());
					}catch(NumberFormatException erro){
						renda=0;
						gastoP=0;
						gastoE=0;
					}
					PessoaJuridica juridica = new PessoaJuridica(tNome.getName(),renda,tCgc.getText(),gastoP, gastoE);
					Lista.add(juridica);
					JOptionPane.showMessageDialog(null,"Inseriu Pessoa Juridica com sucesso.");
					tNome.setText("");	tRendaBruta.setText("");
					tCgc.setText("");	tGastoPessoal.setText("");	tGastoEquipamento.setText("");
				}//fecha evento
			});
		}//fecha construtor
	}//fecha classe
	private class PainelIpva extends JPanel{
		JLabel lPlaca, lMarca, lValorAnual;
		JTextField tPlaca, tMarca, tValorAnual;
		JButton bOk;
		public PainelIpva() {
			setLayout(new BorderLayout());
			JPanel centro = new JPanel(new GridLayout(1,1,10,10));
			JPanel paux = new JPanel(new GridLayout(3,1));
			lPlaca = new JLabel("Placa do automovel:",SwingConstants.RIGHT);
			lMarca = new JLabel("Marca do automovel:",SwingConstants.RIGHT);
			lValorAnual=new JLabel("Valor Anual:",SwingConstants.RIGHT);
			tPlaca 		= new JTextField(10);
			tMarca		= new JTextField(10);
			tValorAnual	= new JTextField(10);
			paux.add(lPlaca);	paux.add(tPlaca);
			paux.add(lMarca);	paux.add(tMarca);
			paux.add(lValorAnual);	paux.add(tValorAnual);
			centro.add(paux);
			bOk = new JButton("Inserir IPVA");
			add(centro, BorderLayout.CENTER);
			add(bOk, BorderLayout.SOUTH);
			
			bOk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evento) {
					float valorAnual;
					String TMarca;
					TMarca=tMarca.getText().toUpperCase();
					char marca;
					try {
						marca=TMarca.charAt(0);
					}catch(NumberFormatException erro) {
						marca=' ';
					}
					try {
						valorAnual=Float.parseFloat(tValorAnual.getText());
					}catch(NumberFormatException erro) {
						valorAnual=0;
					}
					Ipva ipva = new Ipva(tPlaca.getText(), marca, valorAnual);
					Lista.add(ipva);
					JOptionPane.showMessageDialog(null,"Inseriu IPVA com sucesso.");
					tPlaca.setText("");	tMarca.setText("");	tValorAnual.setText("");
				}
			});
		}
	}
	public static void main(String[] args) {
		TelaGrafica x = new TelaGrafica();
		x.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		x.setSize(450,320);
		x.setLocationRelativeTo(null);
		x.setVisible(true);
		}
}

