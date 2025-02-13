package Eskaerak;

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

public class deletUpdEsk extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField idAukeratu;
	private erabiltzailea era;


	
	
	konexioa k = new konexioa();
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pst = null;
	
	
	private JTextField idEskaera;
	private JTextField bezeroa_idBezeroa;
	private JTextField produktua_idProduktua;
	private JTextField helbidea;
	private JTextField eskaeraData;
	private JTextField Egoera;
	
	
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
	public deletUpdEsk(erabiltzailea era) {
		
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
					Eskaerak.eskaerakIkusi eskIku = new Eskaerak.eskaerakIkusi(era);
					eskIku.setVisible(true);
					dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Roboto", Font.BOLD, 20));
		btnNewButton_2.setBackground(SystemColor.activeCaption);
		btnNewButton_2.setBounds(790, 18, 142, 33);
		panel_1_1.add(btnNewButton_2);
		
		JLabel lblNewLabel_2 = new JLabel("Ezabatu/Aldatu eskaerak");
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
		
		idEskaera = new JTextField();
		idEskaera.setColumns(10);
		idEskaera.setBounds(215, 250, 243, 39);
		panel.add(idEskaera);
		
		JLabel lblBezeroa_idBezeroa = new JLabel("Bezeroa_idBezeroa");
		lblBezeroa_idBezeroa.setFont(new Font("Roboto", Font.BOLD, 20));
		lblBezeroa_idBezeroa.setBounds(215, 299, 174, 40);
		panel.add(lblBezeroa_idBezeroa);
		
		JLabel lblidEskaera = new JLabel("ID Eskaera");
		lblidEskaera.setFont(new Font("Roboto", Font.BOLD, 20));
		lblidEskaera.setBounds(215, 216, 111, 40);
		panel.add(lblidEskaera);
		
		JLabel lblproduktua_idProduktua = new JLabel("Produktua_idProduktua");
		lblproduktua_idProduktua.setFont(new Font("Roboto", Font.BOLD, 20));
		lblproduktua_idProduktua.setBounds(215, 384, 227, 40);
		panel.add(lblproduktua_idProduktua);
		
		JLabel lblHelbidea = new JLabel("Helbidea");
		lblHelbidea.setFont(new Font("Roboto", Font.BOLD, 20));
		lblHelbidea.setBounds(546, 216, 84, 40);
		panel.add(lblHelbidea);
		
		JLabel lblEskaeraData = new JLabel("Eskaera data");
		lblEskaeraData.setFont(new Font("Roboto", Font.BOLD, 20));
		lblEskaeraData.setBounds(546, 299, 161, 40);
		panel.add(lblEskaeraData);
		
		JLabel lblEgoera = new JLabel("Egoera");
		lblEgoera.setFont(new Font("Roboto", Font.BOLD, 20));
		lblEgoera.setBounds(546, 384, 103, 40);
		panel.add(lblEgoera);
		
		bezeroa_idBezeroa = new JTextField();
		bezeroa_idBezeroa.setColumns(10);
		bezeroa_idBezeroa.setBounds(215, 335, 243, 39);
		panel.add(bezeroa_idBezeroa);
		
		produktua_idProduktua = new JTextField();
		produktua_idProduktua.setColumns(10);
		produktua_idProduktua.setBounds(215, 423, 243, 39);
		panel.add(produktua_idProduktua);
		
		helbidea = new JTextField();
		helbidea.setColumns(10);
		helbidea.setBounds(546, 250, 243, 39);
		panel.add(helbidea);
		
		eskaeraData = new JTextField();
		eskaeraData.setColumns(10);
		eskaeraData.setBounds(546, 335, 243, 39);
		panel.add(eskaeraData);
		
		Egoera = new JTextField();
		Egoera.setColumns(10);
		Egoera.setBounds(546, 423, 243, 39);
		panel.add(Egoera);
	}
	
	public void deleteBezeroa() {

		String idAukera = idAukeratu.getText();
		
		
		if (idAukera.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Ez duzu eskaerarik aukeratu", "Errore bat izan da", JOptionPane.ERROR_MESSAGE);
		}
		
		try {
			Connection connection_ = k.getConnection_();
			conn = konexioa.getConnection_();
			String sql = "Delete from eskaera where idEskaeraTaula=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, idAukera);
			pst.executeUpdate();
			
			JOptionPane.showMessageDialog(this, "Eskaera ongi ezabatu da!", "Ondo joan da", JOptionPane.INFORMATION_MESSAGE);
			idAukeratu.setText("");
		}catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Eskaera ezabatzean arazo bat egon da.", "Errorea", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	
	public void aldatuBezeroa() {
		
		String idAukera = idAukeratu.getText();
		String eska = idEskaera.getText();
		String idbez = bezeroa_idBezeroa.getText();
		String idpro = produktua_idProduktua.getText();
		String helb = helbidea.getText();
		String eskDat = eskaeraData.getText();
		String ego = Egoera.getText();;
		
		
		if (idAukera.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Ez duzu eskaerarik aukeratu", "Errore bat izan da", JOptionPane.ERROR_MESSAGE);
			if (eska.isEmpty() || idbez.isEmpty() || idpro.isEmpty() || helb.isEmpty() || eskDat.isEmpty() || ego.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Eremu guztiak bete behar dira!", "Errore bat izan da", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
		
		try {
			Connection connection_ = k.getConnection_();
			conn = konexioa.getConnection_();
			String sql = "UPDATE eskaera set idEskaera=? , bezeroa_idBezeroa=?, produktua_idProduktua=?, helbidea=?, eskaeraData=?, egoera=? where idEskaeraTaula=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, eska);
			pst.setString(2, idbez);
			pst.setString(3, idpro);
			pst.setString(4, helb);
			pst.setString(5, eskDat);
			pst.setString(6, ego);
			pst.setString(7, idAukera);
			pst.executeUpdate();
			
			
			idEskaera.setText("");
			bezeroa_idBezeroa.setText("");
			produktua_idProduktua.setText("");
			helbidea.setText("");
			eskaeraData.setText("");
			Egoera.setText("");
			idAukeratu.setText("");
			
			JOptionPane.showMessageDialog(this, "Eskaera ongi aldatu da!", "Ondo joan da", JOptionPane.INFORMATION_MESSAGE);
			idAukeratu.setText("");
		}catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Eskaera aldatzean arazo bat egon da.", "Errorea", JOptionPane.ERROR_MESSAGE);
		}
			
		
	}
	
	protected void atera() {
		System.exit(0);
	}
}