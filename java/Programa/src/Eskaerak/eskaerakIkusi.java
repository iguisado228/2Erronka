package Eskaerak;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

/*import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;*/
import LoginaEgiteko.erabiltzailea;
import erronka2.konexioa;

/*import org.apache.pdfbox.pdmodel.common.PDRectangle;*/





public class eskaerakIkusi extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private erabiltzailea era;
	private JTable eskaeraTaula;
	private JTextField idAukeratu;

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
	
	private void eskaerakKargatu() {
		eskaerakErakutsi eskaerakErakutsi = new eskaerakErakutsi();
		List <eskaera> eskaerak = eskaerakErakutsi.eskaerakErakutsi();
		DefaultTableModel model =  (DefaultTableModel) eskaeraTaula.getModel();
		model.setRowCount(0);
		
		for (eskaera es : eskaerak) {
			model.addRow(new Object[] {es.getIdEskaeraTaula(), es.getIdEskaera(), es.getBezeroa_idBezeroa(), es.getProduktua_idProduktua(), es.getHelbidea(), es.getEskaeraData(), es.getEgoera()});
		}
	}

	
	
	public eskaerakIkusi(erabiltzailea era) {
		
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
		
		JLabel lblNewLabel_2 = new JLabel("Eskaerak");
		lblNewLabel_2.setFont(new Font("Roboto", Font.BOLD, 30));
		lblNewLabel_2.setBounds(26, 7, 142, 49);
		panel_1_1.add(lblNewLabel_2);
		
		JButton btnNewButton_2 = new JButton("Atzera joan");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginaEgiteko.Log Log = new LoginaEgiteko.Log(era);
				Log.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Roboto", Font.BOLD, 20));
		btnNewButton_2.setBackground(SystemColor.activeCaption);
		btnNewButton_2.setBounds(790, 18, 142, 33);
		panel_1_1.add(btnNewButton_2);
		
		JButton btnFakturaSortu = new JButton("Faktura");
		btnFakturaSortu.setBackground(new Color(255, 255, 255));
		btnFakturaSortu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pdfSortu();
			}
		});
		btnFakturaSortu.setFont(new Font("Roboto", Font.BOLD, 20));
		btnFakturaSortu.setBounds(613, 24, 167, 27);
		panel_1_1.add(btnFakturaSortu);
		
		idAukeratu = new JTextField();
		idAukeratu.setColumns(10);
		idAukeratu.setBounds(547, 22, 53, 31);
		panel_1_1.add(idAukeratu);
		
		JButton btnDU_Joan = new JButton("Delete/Update");
		btnDU_Joan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (era.isAdmin() == true) {
					Eskaerak.deletUpdEsk esk = new Eskaerak.deletUpdEsk(era);
					esk.setVisible(true);
					dispose();
				}else {
					JOptionPane.showMessageDialog(contentPane, "Ez zara admin ezin duzu honera sartu", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnDU_Joan.setFont(new Font("Roboto", Font.BOLD, 20));
		btnDU_Joan.setBackground(Color.WHITE);
		btnDU_Joan.setBounds(358, 27, 167, 27);
		panel_1_1.add(btnDU_Joan);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 100, 980, 451);
		panel_1.add(scrollPane);
		
		eskaeraTaula = new JTable();
		eskaeraTaula.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"idEskaeraTaula", "idEskaera", "bezeroa_idBezeroa", "produktua_idProduktua", "Helbidea", "Eskaera data", "Egoera"
			}
		));
		scrollPane.setViewportView(eskaeraTaula);
		eskaerakKargatu();
	}
	
	
	 public void pdfSortu() {
		 
		 String idAukera = idAukeratu.getText();
		 
		 if (idAukera.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Ez duzu bezerorik aukeratu", "Errore bat izan da", JOptionPane.ERROR_MESSAGE);
				return;
			}else {
				try {
					List <eskaera> eskaerak = new ArrayList<>();
					Connection conn = null;
					ResultSet rs = null;
					PreparedStatement pst = null;
					
					konexioa k = new konexioa();
					conn = k.getConnection_();
					
					String sql = "Select * from eskaera where idEskaeraTaula=?";
					pst = conn.prepareStatement(sql);
					int idAukeraInt=Integer.parseInt(idAukera);
					pst.setInt(1, idAukeraInt);
					//pst.executeUpdate();
					rs = pst.executeQuery();
					
					System.out.println("IdAukera da: "+idAukeraInt);
					
					while (rs.next()) {
						eskaera es = new eskaera (rs.getInt("idEskaeraTaula"), rs.getInt("idEskaera"), 
								rs.getInt("bezeroa_idBezeroa"), rs.getInt("produktua_idProduktua"), 
								rs.getDate("eskaeraData"), rs.getString("helbidea"), rs.getString("egoera"));
						
						eskaerak.add(es);
					}
					System.out.println("arraya: "+eskaerak);
					
					 if (eskaerak.isEmpty()) {
						 JOptionPane.showMessageDialog(this, "Ez da aurkitu eskaerarik ID horrekin", "Errorea", JOptionPane.ERROR_MESSAGE);
					      return;
					 }
					 for (eskaera es : eskaerak) {	
						 try {
					    		
					    		//SORTZEN DUGU DOKUMENTU BERRI BAT.
								PDDocument dokumentua = new PDDocument();
								
								//SORTZEN DUGU ORRI BERRI BAT
								PDPage orria = new PDPage(PDRectangle.A4);
								dokumentua.addPage(orria);
								
								//PDFaren kontenidoa zein izango den esaten diogu.
								PDPageContentStream edukia=new PDPageContentStream(dokumentua, orria);
								edukia.setLeading(20f);
								
								//EDUKIA ALDATU BEHAR DUGUN BAKOITZENA EGIN BEHAR DUGU
								//KASU HONETAN IZENBURUA JARTZEN DUGU
								edukia.beginText();
								edukia.setFont(PDType1Font.COURIER_BOLD, 42);
								edukia.newLineAtOffset(20, orria.getMediaBox().getHeight()-(52));
								edukia.showText("FAKTURA"+es.getIdEskaeraTaula());
								edukia.endText();
								
								edukia.beginText();
								edukia.setFont(PDType1Font.HELVETICA, 16);
								edukia.newLineAtOffset(20, orria.getMediaBox().getHeight() - 100);
								edukia.showText("Bezeroaren ID-a: " + es.getBezeroa_idBezeroa());
								edukia.newLine();
								edukia.showText("Produktuaren ID-a: " + es.getProduktua_idProduktua());
								edukia.newLine();
								edukia.showText("Helbidea: " + es.getHelbidea());
								edukia.newLine();
								edukia.showText("Egoera: " + es.getEgoera());
								edukia.endText();
								
								//EDUKIA ALDATZEN BUKATUTAKOAN ITXI EGITEN DUGU
								edukia.close();
								
								//DOKUMENTUA GORDETZEN DUGU
								dokumentua.save(es.getIdEskaeraTaula()+ "_Faktura"+".pdf");
								dokumentua.close();
								JOptionPane.showMessageDialog(contentPane, "Faktura sortu da", "Faktura", JOptionPane.INFORMATION_MESSAGE); 
								
						 	}catch (Exception e) {
						 			e.printStackTrace();
						 				JOptionPane.showMessageDialog(contentPane, "Gaizki joan da.", "Error", JOptionPane.ERROR_MESSAGE); 
						 	}
					 }
					
				}catch (Exception e){
		    		e.printStackTrace();
		    		JOptionPane.showMessageDialog(contentPane, "Gaizki joan da.", "Error", JOptionPane.ERROR_MESSAGE);	
		    }
		}
	 }
	
	protected void atera() {
		System.exit(0);
	}
}
				
