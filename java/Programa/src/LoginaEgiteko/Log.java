package LoginaEgiteko;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class Log extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private erabiltzailea era;
	private logina logina;
	

	/**
	 * Launch the application.
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLog frame = new AdminLog();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	} */

	/**
	 * Create the frame.
	 */
	public Log(erabiltzailea era) {

		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		this.era=era;
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton bezeroakIkusi = new JButton("");
		bezeroakIkusi.setBackground(new Color(255, 255, 255));
		bezeroakIkusi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Bezeroak.bezeroakIkusi bezeroak = new Bezeroak.bezeroakIkusi(era);
					bezeroak.setVisible(true);
					dispose();
			}
		});
		bezeroakIkusi.setIcon(new ImageIcon("C:\\Users\\oierg\\Downloads\\bezeroak2.png"));
		bezeroakIkusi.setBounds(409, 356, 200, 200);
		panel.add(bezeroakIkusi);
		
		JButton langileakIkusi = new JButton("");
		langileakIkusi.setBackground(new Color(255, 255, 255));
		
		langileakIkusi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//JOptionPane.showMessageDialog(contentPane, era.isAdmin(), "OA", JOptionPane.INFORMATION_MESSAGE);
				if (era.isAdmin() == true) {
					Langileak.langileakIkusi langileak = new Langileak.langileakIkusi(era);
					langileak.setVisible(true);
					dispose();
				
				}else {
					JOptionPane.showMessageDialog(contentPane, "Ez zara admin ezin duzu honera sartu", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});	
	
		langileakIkusi.setIcon(new ImageIcon("C:\\Users\\oierg\\Downloads\\langileak2.png"));
		langileakIkusi.setBounds(122, 356, 200, 200);
		panel.add(langileakIkusi);
		
		JButton hornitzaileakIkusi = new JButton("");
		hornitzaileakIkusi.setBackground(new Color(255, 255, 255));
		hornitzaileakIkusi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Hornitzaileak.hornitzaileakIkusi hornitzaileak = new Hornitzaileak.hornitzaileakIkusi(era);
				hornitzaileak.setVisible(true);
				dispose();
			}
		});
		hornitzaileakIkusi.setIcon(new ImageIcon("C:\\Users\\oierg\\Downloads\\hornitzailea2.png"));
		hornitzaileakIkusi.setBounds(685, 356, 200, 200);
		panel.add(hornitzaileakIkusi);
		
		JButton produktuakIkusi = new JButton("");
		produktuakIkusi.setBackground(new Color(255, 255, 255));
		produktuakIkusi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				Produktuak.produktuakIkusi produktuak = new Produktuak.produktuakIkusi(era);
				produktuak.setVisible(true);
				dispose();
			}
		});
		produktuakIkusi.setIcon(new ImageIcon("C:\\Users\\oierg\\Downloads\\produktuak2.png"));
		produktuakIkusi.setBounds(263, 109, 200, 200);
		panel.add(produktuakIkusi);
		
		JButton eskaerakIkusi = new JButton("");
		eskaerakIkusi.setBackground(new Color(255, 255, 255));
		eskaerakIkusi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Eskaerak.eskaerakIkusi eskaerak = new Eskaerak.eskaerakIkusi(era);
				eskaerak.setVisible(true);
				dispose();
			}
		});
		eskaerakIkusi.setIcon(new ImageIcon("C:\\Users\\oierg\\Downloads\\esk2.png"));
		eskaerakIkusi.setBounds(544, 109, 200, 200);
		panel.add(eskaerakIkusi);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 1000, 60);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("X");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atera();
			}
		});
		btnNewButton_1.setBounds(937, 10, 53, 43);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnNewButton_1.setBackground(Color.RED);
		btnNewButton_1.setActionCommand("aplikazioa itxi");
		panel_1.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("ONGI ETORRI");
		lblNewLabel_2.setFont(new Font("Roboto", Font.BOLD, 30));
		lblNewLabel_2.setBounds(10, 7, 379, 49);
		panel_1.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Saioa itxi");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logina logina = new logina();
				logina.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setFont(new Font("Roboto", Font.BOLD, 20));
		btnNewButton.setBounds(790, 18, 142, 33);
		panel_1.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Langileak");
		lblNewLabel_1.setFont(new Font("Roboto", Font.BOLD, 20));
		lblNewLabel_1.setBounds(184, 566, 87, 24);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Bezeroak");
		lblNewLabel_1_1.setFont(new Font("Roboto", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(468, 566, 87, 24);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Hornitzaileak");
		lblNewLabel_1_2.setFont(new Font("Roboto", Font.BOLD, 20));
		lblNewLabel_1_2.setBounds(734, 566, 120, 24);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Produktuak");
		lblNewLabel_1_3.setFont(new Font("Roboto", Font.BOLD, 20));
		lblNewLabel_1_3.setBounds(309, 319, 120, 24);
		panel.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Eskaerak");
		lblNewLabel_1_4.setFont(new Font("Roboto", Font.BOLD, 20));
		lblNewLabel_1_4.setBounds(601, 319, 87, 24);
		panel.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("");
		lblNewLabel_1_5.setIcon(new ImageIcon("C:\\Users\\oierg\\Downloads\\ikonoaZurin.png"));
		lblNewLabel_1_5.setBackground(SystemColor.text);
		lblNewLabel_1_5.setBounds(0, 59, 205, 220);
		panel.add(lblNewLabel_1_5);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADMIN");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(187, 109, 69, 40);
		contentPane.add(lblNewLabel);
	}

	private void setContentPane(JPanel contentPane2) {
		// TODO Auto-generated method stub
		
	}
	
	protected void atera() {
		System.exit(0);
	}
}
