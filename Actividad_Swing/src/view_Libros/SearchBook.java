package view_Libros;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.Main;
import model.Author;
import model.MyBook;
import structure.System_to_run;

public class SearchBook extends JDialog implements ActionListener {

	private Button back, createAuthor_Book, deleteAuthor_Book;
	private JComboBox<Author> listAuthor;
	private JComboBox<MyBook> listBook;	
	private JComboBox<String> genre;
	
	private Author selectAuthor;
	private MyBook selectBook;

	public SearchBook(JFrame owner, String title, boolean modal) {
		super(owner, title, modal);
		dialogInit();
	}

	public SearchBook(JFrame owner, boolean modal, int height, int width) {

		this(owner, "Search Book", modal);

		setSize(width, height+400);// + 400  --> 100 de la copia de book + 300 par las nuevas lineas de aqui 
		
		
		// localizacion encima del jframe
		System_to_run miPc = new System_to_run();
		setLocation(miPc.widthCenterSystem(), miPc.heighCenterSystem());

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(215, 217, 224, 255));
		getContentPane().add(panel); // se crea esta linea en el JFrame

		int fontSize = 20;
		int labelPaddingLeft = 20;
		int upBottonPadding = 20;
		int spaceUpButton = 80;

		int heightText = 30;
		int textPaddingLeft = labelPaddingLeft + 200;
		int upTextPadding = 25;
		int widthText = width - textPaddingLeft - labelPaddingLeft;

		int botonHeight = height / 10;
		int botonWidth = width / 10;

		this.back = new Button("Go back ");
		this.createAuthor_Book = new Button(" Crear ");
		this.deleteAuthor_Book = new Button(" Eliminar ");
		
		createAuthor_Book.addActionListener(this);
		deleteAuthor_Book.addActionListener(this);
	
		//cancel.addActionListener(this);
		//this.accept = new Button("Accept");
		//accept.addActionListener(this);

		// ---------listAuthor = new JComboBox<Author>();
		
		
		// ------------------ 1 fila  titulo  ****************************************

		JLabel titleAuthor_Book = new JLabel("Arista Author - Book");
		titleAuthor_Book.setFont(new Font("Serif", Font.BOLD, fontSize));
		titleAuthor_Book.setBounds(width/2 - 100, upBottonPadding, 280, 40); // tercer numero es la la cantidad de letras * el tamaño
		// author.setForeground(Color.GREEN); // PARA DARLE COLOR
		panel.add(titleAuthor_Book);
		

		upBottonPadding += spaceUpButton;
		upTextPadding += spaceUpButton;
		
		
		
		// ------------------ 2 fila ****************************************

		JLabel author = new JLabel("Author: ");
		author.setFont(new Font("Serif", Font.BOLD, fontSize));
		author.setBounds(labelPaddingLeft, upBottonPadding, 160, 40);
		
		panel.add(author);
		
		listAuthor = new JComboBox<Author>();

		listAuthor.setBounds(textPaddingLeft, upTextPadding, widthText, heightText);

		for (int i = 0; i < Main.writers.size(); i++) {

			listAuthor.addItem(Main.writers.get(i));
		}
		panel.add(listAuthor);

		upBottonPadding += spaceUpButton;
		upTextPadding += spaceUpButton;
		
		
		// ------------------ 3 fila  ****************************************

		JLabel book = new JLabel("Book: ");
		book.setFont(new Font("Serif", Font.BOLD, fontSize));
		book.setBounds(labelPaddingLeft, upBottonPadding, 160, 40); 
		// tercer numero es la la cantidad de letras * elç // tamaño
		// author.setForeground(Color.GREEN); // PARA DARLE COLOR

		panel.add(book);
			
		listBook = new JComboBox<MyBook>();

		listBook.setBounds(textPaddingLeft, upTextPadding, widthText, heightText);

		for (int i = 0; i < Main.books.size(); i++) {

			listBook.addItem(Main.books.get(i));
		}
		panel.add(listBook);
		

		
		upBottonPadding += spaceUpButton;
		upTextPadding += spaceUpButton;
		
		
		
		createAuthor_Book.setBounds(textPaddingLeft+ 300, upTextPadding, botonWidth, botonHeight);
		deleteAuthor_Book.setBounds(textPaddingLeft, upTextPadding, botonWidth, botonHeight);

		panel.add(createAuthor_Book);
		panel.add(deleteAuthor_Book);


		
		upBottonPadding += spaceUpButton;
		upTextPadding += spaceUpButton;
		
		


		JLabel titleBook_Genero = new JLabel("Arista Book - Genero NO IMPLE");
		titleBook_Genero.setFont(new Font("Serif", Font.BOLD, fontSize));
		titleBook_Genero.setBounds(width/2 - 100, upBottonPadding, 280, 40); // tercer numero es la la cantidad de letras * el tamaño
		// author.setForeground(Color.GREEN); // PARA DARLE COLOR
		panel.add(titleBook_Genero);
		

		upBottonPadding += spaceUpButton;
		upTextPadding += spaceUpButton;
		
		// ------------------ a�adir mas aqui si se quiere ejemplo abajo  ******************************
//
//		JLabel titleBook_Genero = new JLabel("Arista Book - Genero NO IMPLE");
//		titleBook_Genero.setFont(new Font("Serif", Font.BOLD, fontSize));
//		titleBook_Genero.setBounds(width/2 - 100, upBottonPadding, 280, 40); // tercer numero es la la cantidad de letras * el tamaño
//		// author.setForeground(Color.GREEN); // PARA DARLE COLOR
//		panel.add(titleBook_Genero);
//		
//
//		upBottonPadding += spaceUpButton;
//		upTextPadding += spaceUpButton;
//		
		
// ------------------------- Seccion botones inferiores 
		
		back.setBounds(textPaddingLeft, upTextPadding, botonWidth, botonHeight);
		//accept.setBounds(textPaddingLeft + 300, upTextPadding, botonWidth, botonHeight);

		panel.add(back);
	//	panel.add(accept);
		setVisible(true);


	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		 selectAuthor = (Author)listAuthor.getSelectedItem();
		 selectBook = (MyBook)listBook.getSelectedItem();
		
		 if (e.getSource() == createAuthor_Book) {
			 Main.dao.createRelationAutoLibro(selectAuthor, selectBook);
			 
		 }
		 else if (e.getSource() == deleteAuthor_Book) {
			 Main.dao.deleteRelationAutoLibro(selectAuthor, selectBook);

		 }
		
		 
	}
}
