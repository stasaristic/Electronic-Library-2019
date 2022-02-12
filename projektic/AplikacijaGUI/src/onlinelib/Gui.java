package onlinelib;

import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.JTextField;
import java.awt.Button;
import javax.swing.JComboBox;

import javax.swing.JFileChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.System.*;


public class Gui {

	private JFrame frame;
	private JTextField author;
	private JTextField title;
	private JTextField isbn;
	
	static Book book;
	private Library library;
	
	private JFileChooser fc;
	private boolean imageInFront = false;
	private boolean imageInBack = false;
	//private ImageIcon cover;
	static JComboBox comboBox;
	
	private Button btnCover;
	private Button btnShow;
	private Button btnAdd;
	private Button btnRemove;
	private JButton btnFrontCover;
	private JButton btnBackCover;
	
	static BufferedImage cover;
	static BufferedImage coverFront;
	static BufferedImage coverBack;
	static BufferedImage coverZaPrikaz_Front;
	static BufferedImage coverZaPrikaz_Back;
	
	public static String msg;
	private bookReviewer bR;

	//private int index;
	
	
	private JFrame zaPrikaz;
	private JPanel panel;
	private JLabel pozadina;
	
	static String pathFront;
	static String pathBack;
	static String path;
	
	int brojIzdanja;
	private JTextField brojIzdanjaTF;
	private JLabel lblBrojIzdanja;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui window = new Gui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//main frame
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(222, 184, 135));
		frame.getContentPane().setForeground(new Color(128, 0, 0));
		frame.setBounds(100, 100, 629, 452);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		//labeli
		JLabel lblNewLabel = new JLabel("Author of The Book:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Letter Gothic Std", Font.BOLD, 12));
		lblNewLabel.setForeground(new Color(128, 0, 0));
		lblNewLabel.setBounds(10, 16, 166, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblTitleOfThe = new JLabel("Title of The Book:");
		lblTitleOfThe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitleOfThe.setForeground(new Color(128, 0, 0));
		lblTitleOfThe.setFont(new Font("Letter Gothic Std", Font.BOLD, 12));
		lblTitleOfThe.setBounds(10, 47, 166, 14);
		frame.getContentPane().add(lblTitleOfThe);
		
		JLabel lblEnterIsbn = new JLabel("ISBN:");
		lblEnterIsbn.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterIsbn.setForeground(new Color(128, 0, 0));
		lblEnterIsbn.setFont(new Font("Letter Gothic Std", Font.BOLD, 12));
		lblEnterIsbn.setBounds(10, 78, 166, 14);
		frame.getContentPane().add(lblEnterIsbn);
		
		JLabel lblInsertCoverPhoto = new JLabel("Insert Front Cover:");
		lblInsertCoverPhoto.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsertCoverPhoto.setForeground(new Color(128, 0, 0));
		lblInsertCoverPhoto.setFont(new Font("Letter Gothic Std", Font.BOLD, 12));
		lblInsertCoverPhoto.setBounds(10, 162, 166, 14);
		frame.getContentPane().add(lblInsertCoverPhoto);
		
		JLabel lblChooseBook = new JLabel("Choose Book:");
		lblChooseBook.setHorizontalAlignment(SwingConstants.CENTER);
		lblChooseBook.setForeground(new Color(128, 0, 0));
		lblChooseBook.setFont(new Font("Letter Gothic Std", Font.BOLD, 12));
		lblChooseBook.setBounds(10, 284, 166, 14);
		frame.getContentPane().add(lblChooseBook);
		
		JPanel panelCoo = new JPanel();
		
		JFrame frameCoo = new JFrame();
		frameCoo.getContentPane().setBackground(new Color(135, 206, 235));
		frameCoo.setBounds(100, 100, 522, 274);
		frameCoo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameCoo.getContentPane().setLayout(null);
		frameCoo.add(panelCoo);
		
		panelCoo.setLayout(null);
		
		JLabel label = new JLabel("Latitude of the first City: ");
		label.setBounds(10,20,80,25);
		panelCoo.add(label);
		
		JTextField cooFirstLat = new JTextField();
		cooFirstLat.setBounds(100, 20, 165, 25);
		panelCoo.add(cooFirstLat);
		frameCoo.setVisible(true);
		
		//fields za unos
		author = new JTextField();
		author.setBackground(new Color(245, 222, 179));
		author.setBounds(186, 11, 175, 20);
		frame.getContentPane().add(author);
		author.setColumns(10);
		
		title = new JTextField();
		title.setBackground(new Color(245, 222, 179));
		title.setColumns(10);
		title.setBounds(186, 42, 175, 20);
		frame.getContentPane().add(title);
		
		isbn = new JTextField();
		isbn.setBackground(new Color(245, 222, 179));
		isbn.setColumns(10);
		isbn.setBounds(186, 73, 175, 20);
		frame.getContentPane().add(isbn);
		
		
		//padajuca lista
		comboBox = new JComboBox();
		comboBox.setBackground(new Color(245, 222, 179));
		comboBox.setBounds(186, 278, 175, 22);
		frame.getContentPane().add(comboBox);
		
		
		/*dugmici*/
		
		//DODAVANJE SLIKE 
		btnFrontCover = new JButton("INSERT FRONT COVER");
		btnFrontCover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnFrontCover.setForeground(new Color(128, 0, 0));
		btnFrontCover.setBackground(new Color(205, 133, 63));
		btnFrontCover.setFont(new Font("Letter Gothic Std", Font.BOLD, 12));
		btnFrontCover.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					
					//getImage();
					coverFront = getImage();
					imageInFront = true;
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
						
						//imageIn = true;
				/*zaPrikaz = buildFrame();
						
				JPanel pane = new JPanel() {
				    @Override
				    protected void paintComponent(Graphics g) {
				    	super.paintComponent(g);
				        g.drawImage(cover, 0, 0, null);
				     }
				};

				        frame.add(pane);*/				
			}	
		});
		btnFrontCover.setBounds(186, 158, 175, 23);
		frame.getContentPane().add(btnFrontCover);
		
		btnBackCover = new JButton("INSERT BACK COVER");
		btnBackCover.setForeground(new Color(128, 0, 0));
		btnBackCover.setFont(new Font("Letter Gothic Std", Font.BOLD, 12));
		btnBackCover.setBackground(new Color(205, 133, 63));
		btnBackCover.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					
					//getImage();
					coverBack = getImage();
					imageInBack = true;
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
						
						//imageIn = true;
				/*zaPrikaz = buildFrame();
						
				JPanel pane = new JPanel() {
				    @Override
				    protected void paintComponent(Graphics g) {
				    	super.paintComponent(g);
				        g.drawImage(cover, 0, 0, null);
				     }
				};

				        frame.add(pane);*/				
			}	
		});
		btnBackCover.setBounds(186, 183, 175, 23);
		frame.getContentPane().add(btnBackCover);
		
		//dugme za dodavanje knjige u biblioteku
		btnAdd = new Button("ADD BOOK");
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				add();
			}
		});
		btnAdd.setBackground(new Color(205, 133, 63));
		btnAdd.setFont(new Font("Letter Gothic Std", Font.BOLD, 12));
		btnAdd.setBounds(94, 232, 175, 33);
		frame.getContentPane().add(btnAdd);
		
		
		//dugme za prikaz knjige
		btnShow = new Button("SHOW INFO");
		btnShow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				show();
			}
		});
		btnShow.setBackground(new Color(205, 133, 63));
		btnShow.setFont(new Font("Letter Gothic Std", Font.BOLD, 12));
		btnShow.setBounds(94, 320, 175, 33);
		frame.getContentPane().add(btnShow);
		
		
		//dugme za uklanjanje knjige iz biblioteke
		/*Button*/ btnRemove = new Button("REMOVE BOOK");
		btnRemove.addMouseListener(new MouseAdapter( ) {
			@Override
			public void mouseClicked(MouseEvent e) {
				int Value = showConfirmDialog(null,"Are you sure you want to permanently remove book?");
				if (Value == 0)
					remove();
			}
			private void showMessageDialog() {
				// TODO Auto-generated method stub	
			}
			private int showConfirmDialog(Object object, String string) {
				// TODO Auto-generated method stub
				return 0;
			}
		});
		btnRemove.setBackground(new Color(205, 133, 63));
		btnRemove.setFont(new Font("Letter Gothic Std", Font.BOLD, 12));
		btnRemove.setBounds(383, 232, 175, 33);
		frame.getContentPane().add(btnRemove);
		
		panel = new JPanel();
		panel.setBounds(371, 11, 201, 195);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		pozadina = new JLabel("");
		pozadina.setBounds(0, -11, 210, 211);
		pozadina.setIcon(new ImageIcon(Gui.class.getResource("/library.jpg")));
		panel.add(pozadina);
		
		JLabel lblInsertBackCover = new JLabel("Insert Back Cover:");
		lblInsertBackCover.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsertBackCover.setForeground(new Color(128, 0, 0));
		lblInsertBackCover.setFont(new Font("Letter Gothic Std", Font.BOLD, 12));
		lblInsertBackCover.setBounds(10, 187, 166, 14);
		frame.getContentPane().add(lblInsertBackCover);
		
		brojIzdanjaTF = new JTextField();
		brojIzdanjaTF.setColumns(10);
		brojIzdanjaTF.setBackground(new Color(245, 222, 179));
		brojIzdanjaTF.setBounds(186, 104, 175, 20);
		frame.getContentPane().add(brojIzdanjaTF);
		
		lblBrojIzdanja = new JLabel("BROJ IZDANJA:");
		lblBrojIzdanja.setHorizontalAlignment(SwingConstants.CENTER);
		lblBrojIzdanja.setForeground(new Color(128, 0, 0));
		lblBrojIzdanja.setFont(new Font("Letter Gothic Std", Font.BOLD, 12));
		lblBrojIzdanja.setBounds(10, 107, 166, 14);
		frame.getContentPane().add(lblBrojIzdanja);
		
		
		
		
		
	}
	
	
	/*metode*/
	
	//metoda za prikazivanje
	public void show() {
		/*bR.textArea.setText(null);
		index = comboBox.getSelectedIndex();
		
		if (index <= -1) {
			JOptionPane.showMessageDialog(null, "Nema izabranih knjiga");
		}
		else {*/
			book = (Book)comboBox.getSelectedItem();
			msg = "Author: " + book.author + "\nTitle: " + book.title + "\nISBN: "
					+ book.isbn + "\nBroj izdanja: " +  book.brojIzdanja;
			coverZaPrikaz_Front = book.coverFront;
			coverZaPrikaz_Back = book.coverBack;
			bR = new bookReviewer(book);
			//coverZaPrikaz = book.cover;
			bR.frame.setVisible(true);
		//}
		
	}
	
	
	//metoda za dodavanje knjige
	public void add() {
		if (!title.getText().contentEquals("") && !author.getText().contentEquals("") && 
				!isbn.getText().contentEquals("") && imageInFront && imageInBack) {
			Book book  = new Book(brojIzdanjaTF.getText(), title.getText(), author.getText(), isbn.getText(), coverFront, coverBack);
			comboBox.addItem(book);
			library.addBook(book);
			btnShow.enable();
			library.addBook(book);
			coverFront = null;
			coverBack = null;
			clear();
		}
		else
			JOptionPane.showMessageDialog(null, "Nisu uneti svi podaci!");
	}
	
	
	//metoda za brisanje unosa
	public void clear() {
		title.setText(null);
		author.setText(null);
		isbn.setText(null);
		brojIzdanjaTF.setText(null);
		imageInFront = false;
		imageInBack = false;
	}
	
	
	//metoda za uklanjanje knjige iz biblioteke
	public void remove() {
		Book book = (Book)comboBox.getSelectedItem();
		comboBox.removeItem(book);
		library.removeBook(book);
	}
	
	
	//metoda za trazenje slike
	public BufferedImage getImage() throws IOException {
		path = getImagePath();
		/*JFileChooser temp = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		temp = new JFileChooser();
		BufferedImage cover;
		temp.setDialogTitle("Select an image");
		temp.setAcceptAllFileFilterUsed(false);
		FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG and JPG images", "png", "jpg");
		temp.addChoosableFileFilter(filter);
		String path = "";
		int returnValue = temp.showOpenDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = temp.getSelectedFile();
			
			path = selectedFile.getAbsolutePath();
			
		}*/
		//imageInFront = true;
		//imageInBack = true;
		
		
		
		return  cover = ImageIO.read(new File(path));
	}
	
	
	private static JFrame buildFrame() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(200, 200);
        frame.setVisible(true);
        return frame;
    }
		
	public String getImagePath() {
		JFileChooser temp = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		temp = new JFileChooser();
		BufferedImage cover;
		temp.setDialogTitle("Select an image");
		temp.setAcceptAllFileFilterUsed(false);
		FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG and JPG images", "png", "jpg");
		temp.addChoosableFileFilter(filter);
		String path = "";
		int returnValue = temp.showOpenDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = temp.getSelectedFile();
			
			path = selectedFile.getAbsolutePath();
			
		}
		
		return path;
	}
}


