package Produktuak;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import LoginaEgiteko.erabiltzailea;
import erronka2.konexioa;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class deletProdukt extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField idAukeratu;
	private JTextField izena;
	private JTextField prezioa;
	private JTextField stock;
	private JTextField deskribapena;
	private JTextField idLangileaField;
	private JTextField idHornitzaileaField;
	private erabiltzailea era;

	
	
	konexioa k = new konexioa();
	produktua produktua = null;
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pst = null;
	
	
	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					deletProdukt frame = new deletProdukt(era);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public deletProdukt(erabiltzailea era) {
		
		this.era=era;
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 1000, 600);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(0, 0, 1000, 60);
		panel.add(panel_1_1);
		
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
		
		JButton btnNewButton_2 = new JButton("Atzera joan");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Produktuak.produktuakIkusi iku = new Produktuak.produktuakIkusi(era);
					iku.setVisible(true);
					dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Roboto", Font.BOLD, 20));
		btnNewButton_2.setBackground(SystemColor.activeCaption);
		btnNewButton_2.setBounds(790, 18, 142, 33);
		panel_1_1.add(btnNewButton_2);
		
		JLabel lblNewLabel_2 = new JLabel("Ezabatu/Aldatu produktuak");
		lblNewLabel_2.setBounds(21, 7, 371, 49);
		panel_1_1.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Roboto", Font.BOLD, 30));
		
		JLabel lblNewLabel = new JLabel("Aldatu edo borratu nahi duzun produktuaren Id-a jarri:");
		lblNewLabel.setFont(new Font("Roboto", Font.BOLD, 20));
		lblNewLabel.setBounds(33, 86, 495, 51);
		panel.add(lblNewLabel);
		
		idAukeratu = new JTextField();
		idAukeratu.setBounds(523, 95, 75, 39);
		panel.add(idAukeratu);
		idAukeratu.setColumns(10);
		
		JButton btnDelete = new JButton("Ezabatu");
		btnDelete.setBackground(new Color(255, 255, 255));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (era.isAdmin() == true) {
				deleteProduktua();
			}else {
				JOptionPane.showMessageDialog(contentPane, "Ez zara admin ezin duzu honera sartu", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	});
		btnDelete.setFont(new Font("Roboto", Font.BOLD, 20));
		btnDelete.setBounds(629, 95, 143, 39);
		panel.add(btnDelete);
		
		izena = new JTextField();
		izena.setColumns(10);
		izena.setBounds(30, 306, 280, 44);
		panel.add(izena);
		
		prezioa = new JTextField();
		prezioa.setColumns(10);
		prezioa.setBounds(30, 514, 280, 44);
		panel.add(prezioa);
		
		stock = new JTextField();
		stock.setColumns(10);
		stock.setBounds(33, 410, 280, 44);
		panel.add(stock);
		
		JLabel lblNewLabel_1 = new JLabel("Deskribapena");
		lblNewLabel_1.setFont(new Font("Roboto", Font.BOLD, 20));
		lblNewLabel_1.setBounds(523, 360, 139, 40);
		panel.add(lblNewLabel_1);
		
		JLabel lblIzena = new JLabel("Izena");
		lblIzena.setFont(new Font("Roboto", Font.BOLD, 20));
		lblIzena.setBounds(33, 256, 57, 40);
		panel.add(lblIzena);
		
		JLabel lblStock = new JLabel("Stock");
		lblStock.setFont(new Font("Roboto", Font.BOLD, 20));
		lblStock.setBounds(33, 360, 57, 40);
		panel.add(lblStock);
		
		JLabel lblPrezioa = new JLabel("Prezioa");
		lblPrezioa.setFont(new Font("Roboto", Font.BOLD, 20));
		lblPrezioa.setBounds(33, 464, 70, 40);
		panel.add(lblPrezioa);
		
		deskribapena = new JTextField();
		deskribapena.setHorizontalAlignment(SwingConstants.LEFT);
		deskribapena.setColumns(10);
		deskribapena.setBounds(523, 403, 374, 169);
		panel.add(deskribapena);
		
		idLangileaField = new JTextField();
		idLangileaField.setColumns(10);
		idLangileaField.setBounds(30, 202, 280, 44);
		panel.add(idLangileaField);
		
		JLabel IdLangilea = new JLabel("IdLangilea");
		IdLangilea.setFont(new Font("Roboto", Font.BOLD, 20));
		IdLangilea.setBounds(31, 152, 101, 40);
		panel.add(IdLangilea);
		
		idHornitzaileaField = new JTextField();
		idHornitzaileaField.setColumns(10);
		idHornitzaileaField.setBounds(523, 306, 280, 44);
		panel.add(idHornitzaileaField);
		
		JLabel lblIdhornitzailea = new JLabel("idHornitzailea");
		lblIdhornitzailea.setFont(new Font("Roboto", Font.BOLD, 20));
		lblIdhornitzailea.setBounds(523, 256, 133, 40);
		panel.add(lblIdhornitzailea);
		
		JButton btnUpdate = new JButton("Aldatu");
		btnUpdate.setBackground(new Color(255, 255, 255));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					aldatuProduktua();
				}
		});
		btnUpdate.setFont(new Font("Roboto", Font.BOLD, 20));
		btnUpdate.setBounds(796, 92, 143, 39);
		panel.add(btnUpdate);
	}
	
	public void deleteProduktua() {

		String idAukera = idAukeratu.getText();
		
		
		if (idAukera.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Ez duzu produkturik aukeratu", "Errore bat izan da", JOptionPane.ERROR_MESSAGE);
		}else {
			try {
			Connection connection_ = k.getConnection_();
			conn = konexioa.getConnection_();
			String sql = "Delete from produktua where idProduktua=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, idAukera);
			pst.executeUpdate();
			
			JOptionPane.showMessageDialog(this, "Produktua ongi ezabatu da!", "Ondo joan da", JOptionPane.INFORMATION_MESSAGE);
			idAukeratu.setText("");
		}catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Produktua ezabatzean arazo bat egon da.", "Errorea", JOptionPane.ERROR_MESSAGE);
		}
	}		
}
	
	
	public void aldatuProduktua() {

		String idAukera = idAukeratu.getText();
		String IdLangilea = idLangileaField.getText();
		String produktuIzena = izena.getText();
		String produktuPrezioa = prezioa.getText();
		String produktuStock = stock.getText();
		String produktuDeskribapena = deskribapena.getText();
		String IdHornitzailea = idHornitzaileaField.getText();
		
		
		if (idAukera.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Ez duzu produkturik aukeratu", "Errore bat izan da", JOptionPane.ERROR_MESSAGE);
			if (IdHornitzailea.isEmpty() || IdLangilea.isEmpty() || produktuIzena.isEmpty() || produktuPrezioa.isEmpty() || produktuStock.isEmpty() || produktuDeskribapena.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Eremu guztiak bete behar dira!", "Errore bat izan da", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
		
		try {
			double prezioaValue = Double.parseDouble(produktuPrezioa);
			int StockValue = Integer.parseInt(produktuStock);
			int idValue = Integer.parseInt(IdLangilea);
			int hValue = Integer.parseInt(IdHornitzailea);
			
			Connection connection_ = k.getConnection_();
			conn = konexioa.getConnection_();
			String sql = "UPDATE produktua set izena=?, stock=?, prezioa=?, deskribapena=?, langilea_idLangilea=?, hornitzailea_idHornitzailea=? where idProduktua=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, produktuIzena);
			pst.setInt(2, StockValue);
			pst.setDouble(3, prezioaValue);
			pst.setString(4, produktuDeskribapena);
			pst.setInt(5, idValue);
			pst.setInt(6, hValue);
			pst.setString(7, idAukera);
			pst.executeUpdate();
			
			
			izena.setText("");
			prezioa.setText("");
			stock.setText("");
			deskribapena.setText("");
			idLangileaField.setText("");
			idHornitzaileaField.setText("");
			idAukeratu.setText("");
			
			JOptionPane.showMessageDialog(this, "Produktua ongi ezabatu da!", "Ondo joan da", JOptionPane.INFORMATION_MESSAGE);
			idAukeratu.setText("");
		}catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Produktua ezabatzean arazo bat egon da.", "Errorea", JOptionPane.ERROR_MESSAGE);
		}
			
		
	}
	
	protected void atera() {
		System.exit(0);
	}
}
	
	
	
	
	
	
	
	

