package Bezeroak;

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

public class deletBez extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField idAukeratu;
	private erabiltzailea era;


	
	
	konexioa k = new konexioa();
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pst = null;
	
	
	private JTextField nan;
	private JTextField izena;
	private JTextField abizena;
	private JTextField telefonoa;
	private JTextField helbidea;
	private JTextField helbideElektr;
	private JTextField erabiltzaileIzena;
	private JTextField pasahitza;
	
	
	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					deletBez frame = new deletBez();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	 * Create the frame.
	 */
	public deletBez(erabiltzailea era) {
		
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
		
		JLabel lblNewLabel_2 = new JLabel("Ezabatu/Aldatu bezeroak");
		lblNewLabel_2.setBounds(21, 7, 371, 49);
		panel_1_1.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Roboto", Font.BOLD, 30));
		
		JLabel lblNewLabel = new JLabel("Aldatu edo ezabatu nahi duzun bezeroaren Id-a jarri:");
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
				deleteBezeroa();
			}
		});
		btnDelete.setFont(new Font("Roboto", Font.BOLD, 20));
		btnDelete.setBounds(629, 95, 143, 39);
		panel.add(btnDelete);
		
		JButton btnUpdate = new JButton("Aldatu");
		btnUpdate.setBackground(new Color(255, 255, 255));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aldatuBezeroa();
			}
		});
		btnUpdate.setFont(new Font("Roboto", Font.BOLD, 20));
		btnUpdate.setBounds(796, 92, 143, 39);
		panel.add(btnUpdate);
		
		nan = new JTextField();
		nan.setColumns(10);
		nan.setBounds(192, 218, 243, 39);
		panel.add(nan);
		
		JLabel lblIzena = new JLabel("Izena");
		lblIzena.setFont(new Font("Roboto", Font.BOLD, 20));
		lblIzena.setBounds(192, 267, 57, 40);
		panel.add(lblIzena);
		
		JLabel lblnan = new JLabel("NAN");
		lblnan.setFont(new Font("Roboto", Font.BOLD, 20));
		lblnan.setBounds(192, 184, 57, 40);
		panel.add(lblnan);
		
		JLabel lblAbizena = new JLabel("Abizena");
		lblAbizena.setFont(new Font("Roboto", Font.BOLD, 20));
		lblAbizena.setBounds(192, 352, 84, 40);
		panel.add(lblAbizena);
		
		JLabel lblHelbidea = new JLabel("Helbidea");
		lblHelbidea.setFont(new Font("Roboto", Font.BOLD, 20));
		lblHelbidea.setBounds(523, 184, 84, 40);
		panel.add(lblHelbidea);
		
		JLabel lblErabiltzaileIzena = new JLabel("Erabiltzaile izena");
		lblErabiltzaileIzena.setFont(new Font("Roboto", Font.BOLD, 20));
		lblErabiltzaileIzena.setBounds(523, 267, 161, 40);
		panel.add(lblErabiltzaileIzena);
		
		JLabel lblPasahitza = new JLabel("Pasahitza");
		lblPasahitza.setFont(new Font("Roboto", Font.BOLD, 20));
		lblPasahitza.setBounds(523, 352, 103, 40);
		panel.add(lblPasahitza);
		
		izena = new JTextField();
		izena.setColumns(10);
		izena.setBounds(192, 303, 243, 39);
		panel.add(izena);
		
		abizena = new JTextField();
		abizena.setColumns(10);
		abizena.setBounds(192, 391, 243, 39);
		panel.add(abizena);
		
		telefonoa = new JTextField();
		telefonoa.setColumns(10);
		telefonoa.setBounds(192, 480, 243, 39);
		panel.add(telefonoa);
		
		helbidea = new JTextField();
		helbidea.setColumns(10);
		helbidea.setBounds(523, 218, 243, 39);
		panel.add(helbidea);
		
		helbideElektr = new JTextField();
		helbideElektr.setColumns(10);
		helbideElektr.setBounds(523, 480, 243, 39);
		panel.add(helbideElektr);
		
		erabiltzaileIzena = new JTextField();
		erabiltzaileIzena.setColumns(10);
		erabiltzaileIzena.setBounds(523, 303, 243, 39);
		panel.add(erabiltzaileIzena);
		
		pasahitza = new JTextField();
		pasahitza.setColumns(10);
		pasahitza.setBounds(523, 391, 243, 39);
		panel.add(pasahitza);
		
		JLabel lblTelefonoa = new JLabel("Telefonoa");
		lblTelefonoa.setFont(new Font("Roboto", Font.BOLD, 20));
		lblTelefonoa.setBounds(192, 444, 139, 33);
		panel.add(lblTelefonoa);
		
		JLabel lblHelbideElektr = new JLabel("Helbide elektronikoa");
		lblHelbideElektr.setFont(new Font("Roboto", Font.BOLD, 20));
		lblHelbideElektr.setBounds(523, 440, 209, 40);
		panel.add(lblHelbideElektr);
	}
	
	public void deleteBezeroa() {

		String idAukera = idAukeratu.getText();
		
		
		if (idAukera.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Ez duzu bezerorik aukeratu", "Errore bat izan da", JOptionPane.ERROR_MESSAGE);
		}
		
		try {
			Connection connection_ = k.getConnection_();
			conn = konexioa.getConnection_();
			String sql = "Delete from bezeroa where idBezeroa=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, idAukera);
			pst.executeUpdate();
			
			JOptionPane.showMessageDialog(this, "Bezeroa ongi ezabatu da!", "Ondo joan da", JOptionPane.INFORMATION_MESSAGE);
			idAukeratu.setText("");
		}catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Bezeroa ezabatzean arazo bat egon da.", "Errorea", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	
	public void aldatuBezeroa() {
		
		String idAukera = idAukeratu.getText();
		String nana = nan.getText();
		String lanIzena = izena.getText();
		String lanAbizena = abizena.getText();
		String telefon = telefonoa.getText();
		String helb = helbidea.getText();
		String erabIzena = erabiltzaileIzena.getText();
		String pass = pasahitza.getText();;
		String elektr = helbideElektr.getText();
		
		
		if (idAukera.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Ez duzu bezerorik aukeratu", "Errore bat izan da", JOptionPane.ERROR_MESSAGE);
			if (nana.isEmpty() || lanIzena.isEmpty() || lanAbizena.isEmpty()|| telefon.isEmpty() || helb.isEmpty() || erabIzena.isEmpty() || pass.isEmpty() || elektr.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Eremu guztiak bete behar dira!", "Errore bat izan da", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
		
		try {
			Connection connection_ = k.getConnection_();
			conn = konexioa.getConnection_();
			String sql = "UPDATE bezeroa set nan=? , izena=?, abizena=?, telefonoa=?, helbidea=?, erabiltzaileIzena=?, pasahitza=?, helbideElektronikoa=? where idBezeroa=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, nana);
			pst.setString(2, lanIzena);
			pst.setString(3, lanAbizena);
			pst.setString(4, telefon);
			pst.setString(5, helb);
			pst.setString(6, erabIzena);
			pst.setString(7, pass);
			pst.setString(8, elektr);
			pst.setString(9, idAukera);
			pst.executeUpdate();
			
			
			nan.setText("");
			izena.setText("");
			abizena.setText("");
			telefonoa.setText("");
			helbidea.setText("");
			erabiltzaileIzena.setText("");
			pasahitza.setText("");
			helbideElektr.setText("");
			idAukeratu.setText("");
			
			JOptionPane.showMessageDialog(this, "Bezeroa ongi aldatu da!", "Ondo joan da", JOptionPane.INFORMATION_MESSAGE);
			idAukeratu.setText("");
		}catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Bezeroa aldatzean arazo bat egon da.", "Errorea", JOptionPane.ERROR_MESSAGE);
		}
			
		
	}
	
	protected void atera() {
		System.exit(0);
	}
}