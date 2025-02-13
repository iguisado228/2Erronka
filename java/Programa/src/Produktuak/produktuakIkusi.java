package Produktuak;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import java.awt.CardLayout;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import LoginaEgiteko.ErabiltzaileKudeaketa;
import LoginaEgiteko.Log;
import LoginaEgiteko.erabiltzailea;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JComboBox;

public class produktuakIkusi extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private erabiltzailea era;
	private JTable produktuTaula;

	/**
	 * Launch the application.
	 *//*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					produktuakIkusi frame = new produktuakIkusi(era);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	*/
	
	
	private void kargatuProduktuak() {
		
		produktuakErakutsi produktuakErakutsi = new produktuakErakutsi();
		List<produktua> produktuak = produktuakErakutsi.produktuakErakutsi();
		
		DefaultTableModel model = (DefaultTableModel) produktuTaula.getModel();
		model.setRowCount(0);
		
		for (produktua pr : produktuak) {
			model.addRow(new Object[] {pr.getIdProduktua(), pr.getIzena(), pr.getStock(), pr.getPrezioa(), pr.getDeskribapena()});
		}
		
	}	
	

	/**
	 * Create the frame.
	 */
	public produktuakIkusi(erabiltzailea era) {
		
		this.era = era;
		setResizable(false);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(0, 0, 1000, 600);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(0, 0, 1000, 60);
		panel_1.add(panel_1_1);
		
		JButton btnNewButton_1 = new JButton("X");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atera();
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnNewButton_1.setBackground(Color.RED);
		btnNewButton_1.setActionCommand("aplikazioa itxi");
		btnNewButton_1.setBounds(937, 10, 53, 43);
		panel_1_1.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("Produktuak");
		lblNewLabel_2.setFont(new Font("Roboto", Font.BOLD, 30));
		lblNewLabel_2.setBounds(10, 7, 379, 49);
		panel_1_1.add(lblNewLabel_2);
		
		JButton btnNewButton_2 = new JButton("Atzera joan");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Log log = new Log(era);
				log.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Roboto", Font.BOLD, 20));
		btnNewButton_2.setBackground(SystemColor.activeCaption);
		btnNewButton_2.setBounds(790, 18, 142, 33);
		panel_1_1.add(btnNewButton_2);
		
		JButton btnDU_Joan_1 = new JButton("Delete/Update");
		btnDU_Joan_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Produktuak.deletProdukt del = new Produktuak.deletProdukt(era);
				del.setVisible(true);
				dispose();
			}
		});
		btnDU_Joan_1.setFont(new Font("Roboto", Font.BOLD, 20));
		btnDU_Joan_1.setBackground(Color.WHITE);
		btnDU_Joan_1.setBounds(619, 26, 167, 27);
		panel_1_1.add(btnDU_Joan_1);
		
		JButton btnInsertJoan = new JButton("Insert");
		btnInsertJoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Produktuak.insertProdukt ins = new Produktuak.insertProdukt();
					ins.setVisible(true);
					dispose();
			}
		});
		btnInsertJoan.setFont(new Font("Roboto", Font.BOLD, 20));
		btnInsertJoan.setBackground(Color.WHITE);
		btnInsertJoan.setBounds(447, 26, 167, 27);
		panel_1_1.add(btnInsertJoan);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 100, 980, 451);
		panel_1.add(scrollPane);
		
		
		/*produktuakErakutsi pr = new produktuakErakutsi();
		pr.produktuakErakutsi();*/
		produktuTaula = new JTable();
		produktuTaula.setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] {"idProduktua", "Izena", "Stock", "Prezioa", "Deskribapena"}
		));
		scrollPane.setViewportView(produktuTaula);

		kargatuProduktuak();
	}
	
	/*produktuakErakutsi produktuakIkusi = new produktuakErakutsi();
	produktua produktua2 = new produktua();
	/*produktua2.setIdProduktua(idProduktua);
	produktua2.setIzena(izena);
	
	produktua pr = produktuakIkusi.produktuakErakutsi(produktua2);
	*/
	
	
	public void atera() {
		System.exit(0);
	}
}
