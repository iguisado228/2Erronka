package LoginaEgiteko;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.Cursor;

public class logina extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtErabiltzailea;
	private JPasswordField txtPasahitza;
	private JPanel panel_1;
	private final Action action = new SwingAction();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					logina frame = new logina();
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
	public logina() {
		setLocationByPlatform(true);
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
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 11, 31));
		panel_1.setBounds(738, 59, 262, 541);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(0, 109, 262, 257);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\oierg\\Downloads\\erronka2ikonoa.png"));
		
		JLabel lblNewLabel_3 = new JLabel("Saioa hasi");
		lblNewLabel_3.setFont(new Font("Roboto", Font.BOLD, 33));
		lblNewLabel_3.setBounds(50, 113, 232, 41);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1 = new JLabel("Pasahitza:");
		lblNewLabel_1.setBounds(50, 378, 128, 40);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Roboto", Font.PLAIN, 25));
		
		JLabel lblNewLabel = new JLabel("Erabiltzailea:");
		lblNewLabel.setBounds(50, 239, 173, 40);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 25));
		
		JButton btnNewButton_1 = new JButton("Sartu");
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(new Color(0, 11, 31));
		btnNewButton_1.setBounds(405, 427, 143, 48);
		panel.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sartu();
			}
		});
		btnNewButton_1.setFont(new Font("Roboto", Font.BOLD, 18));
		
		txtErabiltzailea = new JTextField();
		txtErabiltzailea.setFont(new Font("Roboto", Font.PLAIN, 18));
		txtErabiltzailea.setForeground(new Color(0, 0, 0));
		txtErabiltzailea.setBounds(50, 289, 280, 44);
		panel.add(txtErabiltzailea);
		txtErabiltzailea.setColumns(10);
		
		txtPasahitza = new JPasswordField();
		txtPasahitza.setToolTipText("");
		txtPasahitza.setFont(new Font("Roboto", Font.BOLD, 20));
		txtPasahitza.setBounds(50, 428, 280, 44);
		panel.add(txtPasahitza);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 1000, 60);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnNewButton = new JButton("X");
		btnNewButton.setBounds(937, 10, 53, 43);
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setActionCommand("aplikazioa itxi");
		panel_2.add(btnNewButton);
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atera();
			}
		});
	}

	protected void atera() {
		System.exit(0);
	}

	public void sartu() {
		String erabiltzailea = txtErabiltzailea.getText();
		String pasahitza = String.valueOf(txtPasahitza.getPassword());
		
		ErabiltzaileKudeaketa erabilKudeatu = new ErabiltzaileKudeaketa();
		
		erabiltzailea erabiltzailea2 = new erabiltzailea(erabiltzailea, pasahitza,false);
		erabiltzailea2.setErabiltzaileIzena(erabiltzailea);
		erabiltzailea2.setPasahitza(pasahitza);
		
		erabiltzailea era = erabilKudeatu.erabiltzaileaLortu(erabiltzailea2);
		
		if(era!=null) {
			Log log = new Log(era);
			log.setVisible(true);
			dispose();
			
			/*if(erabiltzailea2.isAdmin() == true) {
				AdminLog admin1 = new AdminLog();
				admin1.setVisible(true);t
			}else if(erabiltzailea2.isAdmin() == false) {
				LangileaLog langilea = new LangileaLog();
				langilea.setVisible(true);
			}*/
			
			
		}else {
			JOptionPane.showMessageDialog(contentPane, "Gaizki joan da.", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	public Color getPanel_1Background() {
		return panel_1.getBackground();
	}
	public void setPanel_1Background(Color background) {
		panel_1.setBackground(background);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
