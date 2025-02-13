package Hornitzaileak;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Bezeroak.bezeroa;
import Bezeroak.bezeroakErakutsi;
import LoginaEgiteko.erabiltzailea;
import Produktuak.produktua;
import Produktuak.produktuakErakutsi;
import Produktuak.produktuakIkusi;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class hornitzaileakIkusi extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private erabiltzailea era;
	private JTable hornitzaileTaula;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					produktuakIkusi frame = new produktuakIkusi();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/
	
	private void hornitzaileakKargatu(erabiltzailea era) {
		hornitzaileakErakutsi hornitzaileakErakutsi= new hornitzaileakErakutsi();
		List <hornitzailea> hornitzaileak = hornitzaileakErakutsi.hornitzaileakErakutsi();
		
		DefaultTableModel model = (DefaultTableModel) hornitzaileTaula.getModel();
		model.setRowCount(0);
		
		for (hornitzailea ho : hornitzaileak) {
			model.addRow(new Object[] {ho.getIdHornitzailea(), ho.getNAN(), ho.getIzena(), ho.getAbizena(), ho.getTelefonoa(), ho.getHelbidea(), 
					ho.getErabiltzaileIzena(), ho.getPasahitza()});
		}
	}

	/**
	 * Create the frame.
	 */
	public hornitzaileakIkusi(erabiltzailea era) {
		this.era=era;
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
		
		JLabel lblNewLabel_2 = new JLabel("Hornitzaileak");
		lblNewLabel_2.setFont(new Font("Roboto", Font.BOLD, 30));
		lblNewLabel_2.setBounds(26, 7, 206, 49);
		panel_1_1.add(lblNewLabel_2);
		
		JButton btnNewButton_2 = new JButton("Atzera joan");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginaEgiteko.Log Log = new LoginaEgiteko.Log(era);
				Log.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Roboto", Font.BOLD, 20));
		btnNewButton_2.setBackground(SystemColor.activeCaption);
		btnNewButton_2.setBounds(790, 18, 142, 33);
		panel_1_1.add(btnNewButton_2);
		
		JButton btnDU_Joan = new JButton("Delete/Update");
		btnDU_Joan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (era.isAdmin() == true) {
					Hornitzaileak.deletHor ho = new Hornitzaileak.deletHor(era);
					ho.setVisible(true);
					dispose();
				}else {
					JOptionPane.showMessageDialog(contentPane, "Ez zara admin ezin duzu honera sartu", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnDU_Joan.setBounds(613, 24, 167, 27);
		panel_1_1.add(btnDU_Joan);
		btnDU_Joan.setFont(new Font("Roboto", Font.BOLD, 20));
		btnDU_Joan.setBackground(Color.WHITE);
		
		JButton btnInsertJoan = new JButton("Insert");
		btnInsertJoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (era.isAdmin() == true) {
					Hornitzaileak.insertHor hor = new Hornitzaileak.insertHor(era);
					hor.setVisible(true);
					dispose();	
				}else {
					JOptionPane.showMessageDialog(contentPane, "Ez zara admin ezin duzu honera sartu", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnInsertJoan.setFont(new Font("Roboto", Font.BOLD, 20));
		btnInsertJoan.setBackground(Color.WHITE);
		btnInsertJoan.setBounds(441, 24, 167, 27);
		panel_1_1.add(btnInsertJoan);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 100, 980, 451);
		panel_1.add(scrollPane);
		
		hornitzaileTaula = new JTable();
		hornitzaileTaula.setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] {
				"idHornitzailea", "NAN", "Izena", "Abizena", "Telefonoa", "Helbidea", "erabiltzaileIzena", "Pasahitza"
			}
		));
		scrollPane.setViewportView(hornitzaileTaula);
		hornitzaileakKargatu(era);
	}
	
	public void atera() {
		System.exit(0);
	}
	
}
