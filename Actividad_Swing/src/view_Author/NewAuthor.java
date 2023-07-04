package view_Author;

import java.awt.Button;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


import color.GrisMetal;
import controller.AuthorControler;
import model.Author;
import structure.System_to_run;

public class NewAuthor extends JDialog implements ActionListener {

	private Button cancel, accept;
	private JLabel name, surname, surname2, country;
	private JTextField consoleName, consoleSurname, consoleSurname2, consoleCountry;
	private JPanel panel;

	public NewAuthor(JFrame owner, String title, boolean modal) {
		super(owner, title, modal);
		dialogInit();
	}

	public NewAuthor(JFrame owner, boolean modal, int height, int width) {

		this(owner, "New Author", modal);

		this.panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new GrisMetal());
		getContentPane().add(panel); // se crea esta linea en el JFrame

		this.name = new JLabel("Name: ");
		this.surname = new JLabel("Surname: ");
		this.surname2 = new JLabel("Second Surname: ");
		this.country = new JLabel("Country: ");

		this.consoleName = new JTextField();
		this.consoleSurname = new JTextField();
		this.consoleSurname2 = new JTextField();
		this.consoleCountry = new JTextField();

		this.cancel = new Button("Cancel");
		this.accept = new Button("Accept");

		cancel.addActionListener(this);
		accept.addActionListener(this);

		setSize(width, height);
		structureJPanel();

		// localizacion encima del jframe
		System_to_run miPc = new System_to_run();

		this.setLocation(miPc.widthCenterSystem() + 200, miPc.heighCenterSystem() / 2);
		// al poner +200 y /2 estamos desplazando el jpanel lo bastante para que cuando
		// lo creemos se siga viendo el jfram

		setVisible(true);
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

		name.setFont(new Font("Serif", Font.BOLD, fontSize));
		name.setBounds(labelPaddingLeft, upBottonPadding, 100, 40);
		// tercer numero es la la cantidad de letras * el tamaño
		// author.setForeground(Color.GREEN); // PARA DARLE COLOR

		consoleName.setBounds(textPaddingLeft, upTextPadding, widthText, heightText);

		upBottonPadding += spaceUpButton;
		upTextPadding += spaceUpButton;

		// ------------------ SEGUNDA FILA ****************************************
		surname.setFont(new Font("Serif", Font.BOLD, fontSize));
		surname.setBounds(labelPaddingLeft, upBottonPadding, 160, 40);
		// author.setForeground(Color.GREEN); // PARA DARLE COLOR

		consoleSurname.setBounds(textPaddingLeft, upTextPadding, widthText, heightText);

		upBottonPadding += spaceUpButton;
		upTextPadding += spaceUpButton;

		// ------------------ TERCERA FILA ****************************************

//	JLabel surname2 = new JLabel("Second Surname: ");
		surname2.setFont(new Font("Serif", Font.BOLD, fontSize));
		surname2.setBounds(labelPaddingLeft, upBottonPadding, 280, 40);
		// author.setForeground(Color.GREEN); // PARA DARLE COLOR

		consoleSurname2.setBounds(textPaddingLeft, upTextPadding, widthText, heightText);

		upBottonPadding += spaceUpButton;
		upTextPadding += spaceUpButton;

		// ------------------ QUARTA FILA ****************************************

		// JLabel country = new JLabel("Country: ");
		country.setFont(new Font("Serif", Font.BOLD, fontSize));
		country.setBounds(labelPaddingLeft, upBottonPadding, 280, 40);
		// author.setForeground(Color.GREEN); // PARA DARLE COLOR

		consoleCountry.setBounds(textPaddingLeft, upTextPadding, widthText, heightText);

		upTextPadding += spaceUpButton;

		// ------------------ BOTONES FILA ****************************************

		cancel.setBounds(textPaddingLeft, upTextPadding, botonWidth, botonHeight);
		accept.setBounds(textPaddingLeft + 300, upTextPadding, botonWidth, botonHeight);

		// JLABEL
		panel.add(name);
		panel.add(surname);
		panel.add(surname2);
		panel.add(country);

		// JTextField
		panel.add(consoleName);
		panel.add(consoleSurname);
		panel.add(consoleSurname2);
		panel.add(consoleCountry);

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

			
			Author author = new Author(consoleName.getText(),
					consoleSurname.getText(), 
					consoleSurname2.getText(), 
					consoleCountry.getText());
			
			//Main.dao.createAutor(author); // borrar
			
			
			
			//  FUNCIONA CONTROLER QUE TIENE EL SWING  -- implementacion de este metodo 
			
			AuthorControler ct = new AuthorControler(this);
			// se le envia por parametro el JDialog que lo llama para que sepa donde tiene que aparecer en el caso de que captura un error
			
			ct.CreateAuthor(author);
			// mirar como hacer para que cuando se cre el autor de cierre la pestaña *******

			
		}

	}

}
