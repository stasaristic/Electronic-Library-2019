package onlinelib;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Color;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

import java.awt.Panel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class bookReviewer {

	JFrame frame;
	private Book book;
	JTextArea textArea;
	JButton btnClose;
	JLabel slicica;
	JPanel panelFront;
	JPanel panelBack;
	Graphics g;
	ImageIcon icon;
	BufferedImage slikaZaPrikaz;
	Book knjigaZaPrikaz = (Book) Gui.comboBox.getSelectedItem();
	
	private JLabel slicicaB;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	//String msgZaPrikaz;
	//private JLabel slicica;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Book book = new Book();
					bookReviewer window = new bookReviewer(book);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public bookReviewer(Book book) {
		this.book = book;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(222, 184, 135));
		frame.setBounds(100, 100, 960, 533);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//dugme zatvaranje prozora
		btnClose = new JButton("CLOSE");
		btnClose.setFont(new Font("Letter Gothic Std", Font.BOLD, 18));
		btnClose.setBackground(new Color(205, 133, 63));
		btnClose.setForeground(new Color(139, 0, 0));
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//frame.dispose();
				frame.setVisible(false);
			}	
		});
		btnClose.setBounds(318, 286, 303, 85);
		frame.getContentPane().add(btnClose);

		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setForeground(new Color(139, 0, 0));
		textArea.setBackground(new Color(250, 235, 215));
		textArea.setFont(new Font("Letter Gothic Std", Font.BOLD, 16));
		textArea.setBounds(320, 11, 299, 243);
		textArea.append(Gui.msg);
		//textArea.disable();
		frame.getContentPane().add(textArea);
		
		panelFront = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(book.coverFront, 300, 400, null);
            }
        };
		panelFront.setBounds(10, 11, 300, 400);
		frame.getContentPane().add(panelFront);
		panelFront.setLayout(null);
		panelFront.paintComponents(g);
		
		knjigaZaPrikaz = (Book)Gui.comboBox.getSelectedItem();
		//slikaZaPrikaz = knjigaZaPrikaz.cover;
		slicica = new JLabel(Gui.pathFront);
		slicica.setIcon(new ImageIcon(Gui.coverZaPrikaz_Front));
		slicica.setBounds(0, 0, 300, 400);
		panelFront.add(slicica);
		
		panelBack = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(book.coverBack, 300, 400, null);
            }
        };
		panelBack.setBounds(629, 11, 300, 400);
		frame.getContentPane().add(panelBack);
		panelBack.setLayout(null);
		panelBack.paintComponents(g);
		
		slicicaB = new JLabel(Gui.pathBack);
		slicicaB.setBounds(0, 0, 300, 400);
		slicicaB.setIcon(new ImageIcon(Gui.coverZaPrikaz_Back));
		panelBack.add(slicicaB);
		
		JLabel lblNewLabel_1_1 = new JLabel("            BACK BOOK COVER");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(new Color(128, 0, 0));
		lblNewLabel_1_1.setFont(new Font("Letter Gothic Std", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(629, 422, 300, 49);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		lblNewLabel_1 = new JLabel("           FRONT BOOK COVER");
		lblNewLabel_1.setForeground(new Color(139, 0, 0));
		lblNewLabel_1.setFont(new Font("Letter Gothic Std", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 422, 300, 49);
		frame.getContentPane().add(lblNewLabel_1);
			
		
	}
}
