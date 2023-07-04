package view_Libros;

import model.*;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.BookControler;
import structure.System_to_run;

public class NewBook extends JDialog implements ActionListener {

	private Button cancel, accept;
//	private JComboBox<Author> listAuthor;
	private JLabel title, /*author,*/ numpag, genre, isbn;
	private JTextField consoleTitle, consoleIsbn, consoleNumpag, consoleGenre;

	private JPanel panel;

	public NewBook(JFrame owner, String title, boolean modal) {
		super(owner, title, modal);
		dialogInit();
	}

	public NewBook(JFrame owner, boolean modal, int height, int width) {

		this(owner, "New Book", modal);

		this.panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(215, 217, 224, 255));
		getContentPane().add(panel); // se crea esta linea en el JFrame

		this.title = new JLabel("Title: ");
//		this.author = new JLabel("Author: ");
		this.isbn = new JLabel("ISBN: ");
		this.numpag = new JLabel("Number of pages: ");
		this.genre = new JLabel("Genre: ");

		this.consoleTitle = new JTextField();
		this.consoleIsbn = new JTextField();
		this.consoleNumpag = new JTextField();
		this.consoleGenre = new JTextField();

		this.cancel = new Button("Cancel");
		this.accept = new Button("Accept");

		cancel.addActionListener(this);
		accept.addActionListener(this);

		setSize(width, height + 100);// mas 100 para añadir una columna mas que en new Author
		structureJPanel();

		// localizacion encima del jframe
		System_to_run miPc = new System_to_run();

		this.setLocation(miPc.widthCenterSystem() + 200, miPc.heighCenterSystem() / 2);

		this.setVisible(true);

	}

	public void structureJPanel() {

		int fontSize = 20;
		int labelPaddingLeft = 20;
		int upBottonPadding = 20;
		int spaceUpButton = 80;

		int heightText = 30;
		int textPaddingLeft = labelPaddingLeft + 200;
		int upTextPadding = 25;
		int widthText = super.getWidth() - textPaddingLeft - labelPaddingLeft;

		int botonHeight = super.getHeight() / 10;
		int botonWidth = super.getWidth() / 10;

		// ------------------ PRIMERA FILA ****************************************

		title.setFont(new Font("Serif", Font.BOLD, fontSize));
		title.setBounds(labelPaddingLeft, upBottonPadding, 100, 40);
		// tercer numero es la la cantidad de letras * el tamaño
		// author.setForeground(Color.GREEN); // PARA DARLE COLOR

		consoleTitle.setBounds(textPaddingLeft, upTextPadding, widthText, heightText);
//
//		upBottonPadding += spaceUpButton;
//		upTextPadding += spaceUpButton;

		// ------------------ SEGUNDA FILA ****************************************

//		author.setFont(new Font("Serif", Font.BOLD, fontSize));
//		author.setBounds(labelPaddingLeft, upBottonPadding, 160, 40);
		// tercer numero es la la cantidad de letras * el tamaño
		// author.setForeground(Color.GREEN); // PARA DARLE COLOR

//		listAuthor = new JComboBox<Author>();
//
//		listAuthor.setBounds(textPaddingLeft, upTextPadding, widthText, heightText);
//
//		for (int i = 0; i < Main.writers.size(); i++) {
//
//			listAuthor.addItem(Main.writers.get(i));
//		}

		upBottonPadding += spaceUpButton;
		upTextPadding += spaceUpButton;

		// ------------------ TERCERA FILA ****************************************

		isbn.setFont(new Font("Serif", Font.BOLD, fontSize));
		isbn.setBounds(labelPaddingLeft, upBottonPadding, 280, 40);
		// tercer numero es la la cantidad de letras * el tamaño
		// author.setForeground(Color.GREEN); // PARA DARLE COLOR

		consoleIsbn.setBounds(textPaddingLeft, upTextPadding, widthText, heightText);

		upBottonPadding += spaceUpButton;
		upTextPadding += spaceUpButton;

		// ------------------ QUARTA FILA ****************************************

		numpag.setFont(new Font("Serif", Font.BOLD, fontSize));
		numpag.setBounds(labelPaddingLeft, upBottonPadding, 280, 40);
		// tercer numero es la la cantidad de letras * el tamaño
		// author.setForeground(Color.GREEN); // PARA DARLE COLOR

		consoleNumpag.setBounds(textPaddingLeft, upTextPadding, widthText, heightText);

		upBottonPadding += spaceUpButton;
		upTextPadding += spaceUpButton;

		// ------------------ QUINTA FILA ****************************************

		genre.setFont(new Font("Serif", Font.BOLD, fontSize));
		genre.setBounds(labelPaddingLeft, upBottonPadding, 280, 40);
		// tercer numero es la la cantidad de letras * el tamaño
		// author.setForeground(Color.GREEN); // PARA DARLE COLOR

		consoleGenre.setBounds(textPaddingLeft, upTextPadding, widthText, heightText);

		upTextPadding += spaceUpButton;

		// ------------------ BOTONES FILA ****************************************

		cancel.setBounds(textPaddingLeft, upTextPadding, botonWidth, botonHeight);
		accept.setBounds(textPaddingLeft + 300, upTextPadding, botonWidth, botonHeight);

		// JLABEL
		panel.add(title);
//		panel.add(author);
		panel.add(isbn);
		panel.add(numpag);
		panel.add(genre);

		// JTextField
		panel.add(consoleTitle);
//		panel.add(listAuthor);
		panel.add(consoleIsbn);
		panel.add(consoleNumpag);
		panel.add(consoleGenre);

		// Jbutton
		panel.add(cancel);
		panel.add(accept);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == cancel) {

			// estaria bien poner un mensaje emerjente ue avise de que no se va a guardar la
			// informacion por el momento solo se cierra

			this.processWindowEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));

			// llama a el proceso de windows y actua como si le diesemos a la X para cerra
			// la ventana

		}
		if (e.getSource() == accept) {
			MyBook book = new MyBook(
					consoleTitle.getText(),
					consoleIsbn.getText(), 
					consoleNumpag.getText(), 
					consoleGenre.getText());
			
			BookControler ct = new BookControler(this);
			// se le envia por parametro el JDialog que lo llama para que sepa donde tiene
			// que aparecer en el caso de que captura un errors
			
		
				ct.CreateBook(book);
			
			

			
		
			//****************** DA ERROR COMPROBAR EL PORQUE */******************
		}

	}

}
