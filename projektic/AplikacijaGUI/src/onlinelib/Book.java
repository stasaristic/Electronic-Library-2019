package onlinelib;


import java.awt.image.BufferedImage;
import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

public class Book implements Serializable {
	
	String title, author, isbn;
	BufferedImage coverFront, coverBack;
	String brojIzdanja;
	
	public Book() {
		title = null;
		author = null;
		isbn = null;
		coverFront = null;
		coverBack = null;
		brojIzdanja = null;
	}
	
	public Book(String brojIzdanja, String title, String author, String isbn, BufferedImage coverFront, BufferedImage coverBack) {
		this.brojIzdanja = brojIzdanja;
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.coverFront = coverFront;
		this.coverBack = coverBack;
	}
	
	@Override
	public String toString() {
		return (title);
	}
	
	
}
