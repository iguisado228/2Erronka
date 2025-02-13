package Produktuak;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import LoginaEgiteko.erabiltzailea;
import erronka2.konexioa;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class insertProdukt extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField izena;
	private JTextField prezioa;
	private JTextField stock;
	private JTextField deskribapena;
	private JTextField idLangileaField;
	private JTextField idHornitzaileaField;
	private static erabiltzailea era;
	
	konexioa k = new konexioa();
	produktua produktua = null;
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pst = null;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					insertProdukt frame = new insertProdukt();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public insertProdukt() {
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
		
		JLabel lblNewLabel_2 = new JLabel("Insert produktuak");
		lblNewLabel_2.setFont(new Font("Roboto", Font.BOLD, 30));
		lblNewLabel_2.setBounds(26, 7, 250, 49);
		panel_1_1.add(lblNewLabel_2);
		
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
		
		
		izena = new JTextField();
		izena.setBounds(66, 234, 280, 44);
		panel.add(izena);
		izena.setColumns(10);
		
		prezioa = new JTextField();
		prezioa.setColumns(10);
		prezioa.setBounds(66, 431, 280, 44);
		panel.add(prezioa);
		
		stock = new JTextField();
		stock.setColumns(10);
		stock.setBounds(66, 338, 280, 44);
		panel.add(stock);
		
		JLabel lblNewLabel = new JLabel("Deskribapena");
		lblNewLabel.setFont(new Font("Roboto", Font.BOLD, 20));
		lblNewLabel.setBounds(467, 90, 139, 40);
		panel.add(lblNewLabel);
		
		JLabel lblIzena = new JLabel("Izena");
		lblIzena.setFont(new Font("Roboto", Font.BOLD, 20));
		lblIzena.setBounds(66, 184, 57, 40);
		panel.add(lblIzena);
		
		JLabel lblStock = new JLabel("Stock");
		lblStock.setFont(new Font("Roboto", Font.BOLD, 20));
		lblStock.setBounds(66, 288, 57, 40);
		panel.add(lblStock);
		
		JLabel lblPrezioa = new JLabel("Prezioa");
		lblPrezioa.setFont(new Font("Roboto", Font.BOLD, 20));
		lblPrezioa.setBounds(65, 392, 70, 40);
		panel.add(lblPrezioa);
		
		deskribapena = new JTextField();
		deskribapena.setHorizontalAlignment(SwingConstants.LEFT);
		deskribapena.setColumns(10);
		deskribapena.setBounds(467, 123, 374, 169);
		panel.add(deskribapena);
		
		JButton Insert = new JButton("Insert");
		Insert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertProduktua();
			}
		});
		Insert.setFont(new Font("Roboto", Font.BOLD, 20));
		Insert.setBounds(467, 334, 161, 44);
		panel.add(Insert);
		
		idLangileaField = new JTextField();
		idLangileaField.setBounds(66, 130, 280, 44);
		panel.add(idLangileaField);
		idLangileaField.setColumns(10);
		
		JLabel IdLangilea = new JLabel("IdLangilea");
		IdLangilea.setFont(new Font("Roboto", Font.BOLD, 20));
		IdLangilea.setBounds(66, 90, 101, 40);
		panel.add(IdLangilea);
		
		idHornitzaileaField = new JTextField();
		idHornitzaileaField.setBounds(66, 533, 280, 44);
		panel.add(idHornitzaileaField);
		idHornitzaileaField.setColumns(10);
		
		JLabel lblIdhornitzailea = new JLabel("idHornitzailea");
		lblIdhornitzailea.setFont(new Font("Roboto", Font.BOLD, 20));
		lblIdhornitzailea.setBounds(66, 483, 133, 40);
		panel.add(lblIdhornitzailea);
		
	}
	
	public void insertProduktua() {
		
		String IdLangilea = idLangileaField.getText();
		String produktuIzena = izena.getText();
		String produktuPrezioa = prezioa.getText();
		String produktuStock = stock.getText();
		String produktuDeskribapena = deskribapena.getText();
		String IdHornitzailea = idHornitzaileaField.getText();
		
		if (IdHornitzailea.isEmpty() || IdLangilea.isEmpty() || produktuIzena.isEmpty() || produktuPrezioa.isEmpty() || produktuStock.isEmpty() || produktuDeskribapena.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Eremu guztiak bete behar dira!", "Errore bat izan da", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		try {
			double prezioaValue = Double.parseDouble(produktuPrezioa);
			int StockValue = Integer.parseInt(produktuStock);
			int idValue = Integer.parseInt(IdLangilea);
			int hValue = Integer.parseInt(IdHornitzailea);
			
			Connection connection_ = k.getConnection_();
			conn = konexioa.getConnection_();
			String sql = "INSERT INTO produktua (izena, stock, prezioa, deskribapena, langilea_idLangilea, hornitzailea_idHornitzailea) Values (?,?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, produktuIzena);
			pst.setInt(3, StockValue);
			pst.setDouble(2, prezioaValue);
			pst.setString(4, produktuDeskribapena);
			pst.setInt(5, idValue);
			pst.setInt(6, hValue);
			pst.executeUpdate();
			
			
			JOptionPane.showMessageDialog(this, "Produktua ongi gehitu da!", "Ondo joan da", JOptionPane.INFORMATION_MESSAGE);
			izena.setText("");
			prezioa.setText("");
			stock.setText("");
			deskribapena.setText("");
			idLangileaField.setText("");
			idHornitzaileaField.setText("");
			
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(this, "Prezioa eta stock zenbakiak izan behar dira!", "Errorea", JOptionPane.ERROR_MESSAGE);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Errorea " + ex.getMessage() + " produktua sartzean:", "Errorea", JOptionPane.ERROR_MESSAGE);
		}
	}
	private void atera() {
		System.exit(0);
	}
}
