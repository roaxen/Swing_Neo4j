package structure;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;

import dao.DaoControler;
import excepcion.*;
import main.Main;
import view_Author.*;
import view_Libros.ModifyBook;
import view_Libros.NewBook;
import view_Libros.RemoveBook;
import view_Libros.SearchBook;

public class Principal extends JFrame implements ActionListener {

	// Hacemos los atributos finales porque todo lo que creemos
	private int widthframe; // 850 si se puede hacer final ********************************************
	private int heightframe; // 450 si e puede hacer final ********************************************
	private int widthcenter;
	private int heighventer;
	private Button anew, bnew, amodify, bmodify, aremove, bremove, bsearch;
	private JMenuBar menuBar;
	private JMenu firstOP ;
	private JMenuItem op1 ;
	private  JMenuItem op2;
	private DaoControler dao;
	// public static JDialog newAuthor;

	public Principal() {

		this.widthframe = 850;
		this.heightframe = 450;
		dao = new DaoControler();

		// this.newAuthor = new newAuthor(this, true, heightframe, widthframe);
		this.anew = new Button("New");
		anew.addActionListener(this);
		this.amodify = new Button("Modify");
		amodify.addActionListener(this);
		this.aremove = new Button("Remove");
		aremove.addActionListener(this);

		this.bnew = new Button("New");
		bnew.addActionListener(this);
		this.bmodify = new Button("Modify");
		bmodify.addActionListener(this);
		this.bremove = new Button("Remove");
		bremove.addActionListener(this);
		this.bsearch = new Button("Search");
		bsearch.addActionListener(this);

		System_to_run miPc = new System_to_run();

		this.widthcenter = miPc.widthCenterSystem();
		this.heighventer = miPc.heighCenterSystem();

//CREACION DE  UN JMENU PARA PODER CARGAR O O GUARDAR YA LA INFORMACION 

		 menuBar = new JMenuBar();
		 firstOP = new JMenu("File");
		 op1 = new JMenu("Save");
		 op2 = new JMenu("Load");

		 op1.addActionListener(this);
		 op2.addActionListener(this);
		 
		 
		firstOP.add(op1);
		firstOP.add(op2);

		menuBar.add(firstOP);
		setJMenuBar(menuBar);

		// CREACION DEL JPANEL
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(215, 217, 224, 255));

		// tamaño paara los botones de la app

		int FrameHeight = this.heightframe;
		int FrameWidth = this.widthframe;

		int botonHeight = FrameHeight / 10;
		int botonWidth = FrameWidth / 10;

		int fontSize = 40;
		// distancias alrededor de los botones
		int aBottonPaddinLeft = 100;
		int bBottonPaddinLeft = 550;
		int upBottonPadding = 140;
		int spaceUpButton = 60;

		JLabel h1 = new JLabel("LIBRARY");
		h1.setFont(new Font("Serif", Font.BOLD, fontSize));
		h1.setBounds(300, 20, 280, 40);
		// h1.setForeground(Color.RED); // PARA DARLE COLOR
		panel.add(h1);

		JLabel author = new JLabel("Author");
		author.setFont(new Font("Serif", Font.BOLD, fontSize));
		author.setBounds(aBottonPaddinLeft, 80, 280, 40); // tercer numero es la la cantidad de letras * el tamaño
		// author.setForeground(Color.GREEN); // PARA DARLE COLOR
		panel.add(author);

		JLabel books = new JLabel("Books");
		books.setFont(new Font("Serif", Font.BOLD, fontSize));
		books.setBounds(bBottonPaddinLeft, 80, 200, 40);
		// books.setForeground(Color.GREEN); // PARA DARLE COLOR
		panel.add(books);

		// AÑADIR UN BOTON AJUSTES BASICOS --- NOMBRE/COLOR/TAMAÑO Y POSICION

		anew.setBounds(aBottonPaddinLeft + 10, upBottonPadding, botonWidth, botonHeight);
		bnew.setBounds(bBottonPaddinLeft + 10, upBottonPadding, botonWidth, botonHeight);

		upBottonPadding += spaceUpButton;// incremento del padding para el siguiente objeto

		amodify.setBounds(aBottonPaddinLeft + 10, upBottonPadding, botonWidth, botonHeight);
		bmodify.setBounds(bBottonPaddinLeft + 10, upBottonPadding, botonWidth, botonHeight);

		upBottonPadding += spaceUpButton;// incremento del padding para el siguiente objeto

		aremove.setBounds(aBottonPaddinLeft + 10, upBottonPadding, botonWidth, botonHeight);
		bremove.setBounds(bBottonPaddinLeft + 10, upBottonPadding, botonWidth, botonHeight);

		upBottonPadding += spaceUpButton;// incremento del padding para el siguiente objeto

		bsearch.setBounds(bBottonPaddinLeft + 10, upBottonPadding, botonWidth, botonHeight);

		panel.add(anew);
		panel.add(amodify);
		panel.add(aremove);

		panel.add(bnew);
		panel.add(bmodify);
		panel.add(bremove);
		panel.add(bsearch);

		getContentPane().add(panel);

		// AJUSTES BASICOS PARA EL JFRAM

		setSize(widthframe, heightframe); // altura y largo del frame
		setLocation(widthcenter, heighventer); // posicion de donde se ejecuta el frame ** al partirlo entre 4 lo
												// centramos en el centro del monitor
		setVisible(true); // hacer que sea visible el frame
		setDefaultCloseOperation(EXIT_ON_CLOSE); // opcion que va a hacer el boton de cierre
		setTitle("Menu Libray"); // nombre que tendra la pantalla cuando se crea

	}



	public static void visibilityOn() {

		Principal principal = new Principal();
		principal.setVisible(true);
	}

	public static void visibilityOf() { // borrar

		Principal principal = new Principal();
		principal.setVisible(false);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == anew) {

			NewAuthor screen = new NewAuthor(this, true, this.heightframe, this.widthframe);

		}
		if (e.getSource() == amodify) {
			ModifyAuthor screen = new ModifyAuthor(this, true,  this.heightframe+200,  this.widthframe);
		}
		if (e.getSource() == aremove) {

			if (existAuthor() == false) {

				RemoveAuthor screen = new RemoveAuthor(this, true, 200, this.widthframe);

			}
		}
		if (e.getSource() == bnew) {

			// comentamos el if porque ahora es una tabla no realcional 
//			if (existAuthor() == false) {

				NewBook screen = new NewBook(this, true, this.heightframe, this.widthframe);

//			}

		}
		if (e.getSource() == bmodify) {

			
			ModifyBook screen = new ModifyBook(this, true,  this.heightframe+200,  this.widthframe);

		}
		if (e.getSource() == bremove) {

			if (existBook() == false) {

				RemoveBook screen = new RemoveBook(this, true, 200, this.widthframe);
			}
		}
		if (e.getSource() == bsearch) {
			SearchBook sBook = new SearchBook(this, true, heightframe, widthframe);

		}
		if(e.getSource() == op1) {
			

			Object[] exportAuthor = Main.writers.toArray();// pasamoe el contenido de una array dinamica a una array statica porque
													// en una dinamica no funciona el metodo Array.to string
			

			exportAuthor.toString();

			File documento = new File("src/upload/writers.txt");// ruta donde crearemos nuestro fichero

			
		
		}

	}

	public boolean existAuthor() {
		boolean okey = true;
		try {

			if (Main.writers.size() == 0) {

				throw new NoExistAuthor();
			} else {

				okey = false;
			}

		} catch (Exception exist) {

			JOptionPane.showMessageDialog(this, exist.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}

		return okey;

	}

	public boolean existBook() {
		boolean okey = true;
		try {

			if (Main.books.size() == 0) {

				throw new NoExistBook();
			} else {

				okey = false;
			}

		} catch (Exception exist) {

			JOptionPane.showMessageDialog(this, exist.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}

		return okey;

	}
	
	
	public int getWidthframe() {
		return widthframe;
	}

	public void setWidthframe(int widthframe) {
		this.widthframe = widthframe;
	}

	public int getHeightframe() {
		return heightframe;
	}

	public void setHeightframe(int heightframe) {
		this.heightframe = heightframe;
	}

	public int getWidthcenter() {
		return widthcenter;
	}

	public void setWidthcenter(int widthcenter) {
		this.widthcenter = widthcenter;
	}

	public int getHeighventer() {
		return heighventer;
	}

	public void setHeighventer(int heighventer) {
		this.heighventer = heighventer;
	}

}