package Langileak;

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

public class insertLan extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nan;
	private JTextField izena;
	private JTextField abizena;
	private JTextField lanPostua;
	private JTextField admin;
	private JTextField telefonoa;
	private JTextField helbidea;
	private JTextField postaKodea;
	private JTextField erabiltzaileIzena;
	private JTextField pasahitza;
	private erabiltzailea era;
	
	konexioa k = new konexioa();
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pst = null;


	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					insertLan frame = new insertLan();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	 * Create the frame.
	 */
	public insertLan(erabiltzailea era) {
		
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
		
		JLabel lblNewLabel_2 = new JLabel("Insert langileak");
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
		
		
		nan = new JTextField();
		nan.setBounds(119, 119, 280, 44);
		panel.add(nan);
		nan.setColumns(10);
		
		izena = new JTextField();
		izena.setColumns(10);
		izena.setBounds(119, 212, 280, 44);
		panel.add(izena);
		
		abizena = new JTextField();
		abizena.setColumns(10);
		abizena.setBounds(119, 302, 280, 44);
		panel.add(abizena);
		
		JLabel lblLanPostua = new JLabel("Lan postua");
		lblLanPostua.setFont(new Font("Roboto", Font.BOLD, 20));
		lblLanPostua.setBounds(118, 358, 139, 40);
		panel.add(lblLanPostua);
		
		JLabel lblIzena = new JLabel("Izena");
		lblIzena.setFont(new Font("Roboto", Font.BOLD, 20));
		lblIzena.setBounds(118, 173, 57, 40);
		panel.add(lblIzena);
		
		JLabel lblnan = new JLabel("NAN");
		lblnan.setFont(new Font("Roboto", Font.BOLD, 20));
		lblnan.setBounds(119, 82, 57, 40);
		panel.add(lblnan);
		
		JLabel lblAbizena = new JLabel("Abizena");
		lblAbizena.setFont(new Font("Roboto", Font.BOLD, 20));
		lblAbizena.setBounds(119, 266, 84, 40);
		panel.add(lblAbizena);
		
		lanPostua = new JTextField();
		lanPostua.setHorizontalAlignment(SwingConstants.LEFT);
		lanPostua.setColumns(10);
		lanPostua.setBounds(119, 394, 280, 44);
		panel.add(lanPostua);
		
		admin = new JTextField();
		admin.setBounds(119, 485, 280, 44);
		panel.add(admin);
		admin.setColumns(10);
		
		JLabel admin = new JLabel("Admin");
		admin.setFont(new Font("Roboto", Font.BOLD, 20));
		admin.setBounds(119, 447, 66, 40);
		panel.add(admin);
		
		telefonoa = new JTextField();
		telefonoa.setBounds(577, 119, 280, 44);
		panel.add(telefonoa);
		telefonoa.setColumns(10);
		
		JLabel telefonoa = new JLabel("Telefonoa");
		telefonoa.setFont(new Font("Roboto", Font.BOLD, 20));
		telefonoa.setBounds(577, 82, 133, 40);
		panel.add(telefonoa);
		
		helbidea = new JTextField();
		helbidea.setColumns(10);
		helbidea.setBounds(577, 212, 280, 44);
		panel.add(helbidea);
		
		postaKodea = new JTextField();
		postaKodea.setColumns(10);
		postaKodea.setBounds(577, 302, 280, 44);
		panel.add(postaKodea);
		
		erabiltzaileIzena = new JTextField();
		erabiltzaileIzena.setColumns(10);
		erabiltzaileIzena.setBounds(577, 394, 280, 44);
		panel.add(erabiltzaileIzena);
		
		pasahitza = new JTextField();
		pasahitza.setColumns(10);
		pasahitza.setBounds(577, 485, 280, 44);
		panel.add(pasahitza);
		
		JLabel lblHelbidea = new JLabel("Helbidea");
		lblHelbidea.setFont(new Font("Roboto", Font.BOLD, 20));
		lblHelbidea.setBounds(577, 173, 84, 40);
		panel.add(lblHelbidea);
		
		JLabel lblPostakodea = new JLabel("Posta kodea");
		lblPostakodea.setFont(new Font("Roboto", Font.BOLD, 20));
		lblPostakodea.setBounds(577, 266, 133, 40);
		panel.add(lblPostakodea);
		
		JLabel lblErabiltzaileIzena = new JLabel("Erabiltzaile izena");
		lblErabiltzaileIzena.setFont(new Font("Roboto", Font.BOLD, 20));
		lblErabiltzaileIzena.setBounds(577, 358, 161, 40);
		panel.add(lblErabiltzaileIzena);
		
		JLabel lblPasahitza = new JLabel("Pasahitza");
		lblPasahitza.setFont(new Font("Roboto", Font.BOLD, 20));
		lblPasahitza.setBounds(577, 447, 103, 40);
		panel.add(lblPasahitza);
		
		JButton Insert = new JButton("Insert");
		Insert.setBounds(577, 546, 161, 44);
		panel.add(Insert);
		Insert.setBackground(new Color(255, 255, 255));
		Insert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertProduktua();
			}
		});
		Insert.setFont(new Font("Roboto", Font.BOLD, 20));
		
	}
	
	public void insertProduktua() {
		
		String nana = nan.getText();
		String lanIzena = izena.getText();
		String lanAbizena = abizena.getText();
		String postua = lanPostua.getText();
		String ad = admin.getText();
		String telefon = telefonoa.getText();
		String helb = helbidea.getText();
		String kodea = postaKodea.getText();
		String erabIzena = erabiltzaileIzena.getText();
		String pass = pasahitza.getText();;
		
		if (nana.isEmpty() || lanIzena.isEmpty() || lanAbizena.isEmpty() || postua.isEmpty() || ad.isEmpty() || telefon.isEmpty() || helb.isEmpty() || kodea.isEmpty() || erabIzena.isEmpty() || pass.isEmpty()){
			JOptionPane.showMessageDialog(this, "Eremu guztiak bete behar dira!", "Errore bat izan da", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		try {
			
			Connection connection_ = k.getConnection_();
			conn = konexioa.getConnection_();
			String sql = "INSERT INTO langilea (nan, izena, abizena, lanPostua, admin, telefonoa, helbidea, postaKodea, erabiltzaileIzena, pasahitza) Values (?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, nana);
			pst.setString(2, lanIzena);
			pst.setString(3, lanAbizena);
			pst.setString(4, postua);
			pst.setString(5, ad);
			pst.setString(6, telefon);
			pst.setString(7, helb);
			pst.setString(8, kodea);
			pst.setString(9, erabIzena);
			pst.setString(10, pass);
			pst.executeUpdate();
			
			
			JOptionPane.showMessageDialog(this, "Langilea ongi gehitu da!", "Ondo joan da", JOptionPane.INFORMATION_MESSAGE);
			nan.setText("");
			izena.setText("");
			abizena.setText("");
			lanPostua.setText("");
			admin.setText("");
			telefonoa.setText("");
			helbidea.setText("");
			postaKodea.setText("");
			erabiltzaileIzena.setText("");
			pasahitza.setText("");
			
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Errorea " + ex.getMessage() + " langilea sartzean:", "Errorea", JOptionPane.ERROR_MESSAGE);
		}
	}
	private void atera() {
		System.exit(0);
	}
}
