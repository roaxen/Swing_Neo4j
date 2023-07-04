package view_Libros;

import javax.swing.*;

import color.GrisMetal;
import main.Main;
import model.Author;
import model.MyBook;
import structure.System_to_run;

import java.awt.*;
import java.awt.event.*;

public class ModifyBook extends JDialog implements ActionListener {

	private JLabel selectLabel, titleLabel, isbnLabel, numPageLabel, genreLabel;
	private JComboBox<MyBook> listBook;
	private JTextField titleField, isbnField, numPageField, genreField;
	private Button cancelButton, acceptButton, loadButton;
	private MyBook selectBook;
	private JPanel panel;

	public ModifyBook(JFrame owner, String title, boolean modal) {
		super(owner, title, modal);
		dialogInit();
	}

	public ModifyBook(JFrame owner, boolean modal, int height, int width) {

		this(owner, "***********", modal);

		this.panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new GrisMetal());
		getContentPane().add(panel);

		// Componentes para la selección de autor
		selectLabel = new JLabel("Selecciona un Libro:");
		listBook = new JComboBox<MyBook>();
		loadButton = new Button("Cargar");

		// Componentes para la modificación de autor
		titleLabel = new JLabel("title:");
		isbnLabel = new JLabel("ISBN:");
		numPageLabel = new JLabel("numPage: ");
		genreLabel = new JLabel("genre:");

		titleField = new JTextField();
		isbnField = new JTextField();
		numPageField = new JTextField();
		genreField = new JTextField();

		// Componentes para los botones de acción
		cancelButton = new Button("Cancelar");
		acceptButton = new Button("Aceptar");

		cancelButton.addActionListener(this);
		acceptButton.addActionListener(this);
		loadButton.addActionListener(this);

		setSize(width, height);
		structureJPanel();

		System_to_run miPc = new System_to_run();
		this.setLocation(miPc.widthCenterSystem() + 200, miPc.heighCenterSystem() / 2);

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
		int botonHeightLoad = 40;
		int botonWidthLoad = 70;

		int botonHeight = super.getHeight() / 10;
		int botonWidth = super.getWidth() / 10;

		selectLabel.setFont(new Font("Serif", Font.BOLD, fontSize));
		selectLabel.setBounds(labelPaddingLeft, upBottonPadding, 200, 40);

		listBook.setBounds(textPaddingLeft, upTextPadding, widthText, heightText);

		for (int i = 0; i < Main.books.size(); i++) {

			listBook.addItem(Main.books.get(i));
		}
		upBottonPadding += spaceUpButton;
		upTextPadding += spaceUpButton;

		loadButton.setBounds(textPaddingLeft + 200, 70, botonWidthLoad, botonHeightLoad);

		upBottonPadding += spaceUpButton;
		upTextPadding += spaceUpButton;

		titleLabel.setFont(new Font("Serif", Font.BOLD, fontSize));
		titleLabel.setBounds(labelPaddingLeft, upBottonPadding, 100, 40);

		titleField.setBounds(textPaddingLeft, upTextPadding, widthText, heightText);

		upBottonPadding += spaceUpButton;
		upTextPadding += spaceUpButton;

		// ------------------ tercera FILA ****************************************
		isbnLabel.setFont(new Font("Serif", Font.BOLD, fontSize));
		isbnLabel.setBounds(labelPaddingLeft, upBottonPadding, 160, 40);
		// author.setForeground(Color.GREEN); // PARA DARLE COLOR

		isbnField.setBounds(textPaddingLeft, upTextPadding, widthText, heightText);

		upBottonPadding += spaceUpButton;
		upTextPadding += spaceUpButton;

		// ------------------ SEGUNDA FILA ****************************************
		numPageLabel.setFont(new Font("Serif", Font.BOLD, fontSize));
		numPageLabel.setBounds(labelPaddingLeft, upBottonPadding, 200, 40);
		// author.setForeground(Color.GREEN); // PARA DARLE COLOR

		numPageField.setBounds(textPaddingLeft, upTextPadding, widthText, heightText);

		upBottonPadding += spaceUpButton;
		upTextPadding += spaceUpButton;

		// ------------------ cuarta FILA ****************************************
		genreLabel.setFont(new Font("Serif", Font.BOLD, fontSize));
		genreLabel.setBounds(labelPaddingLeft, upBottonPadding, 160, 40);
		// author.setForeground(Color.GREEN); // PARA DARLE COLOR

		genreField.setBounds(textPaddingLeft, upTextPadding, widthText, heightText);

		upBottonPadding += spaceUpButton;
		upTextPadding += spaceUpButton;

		cancelButton.setBounds(textPaddingLeft, upTextPadding, botonWidth, botonHeight);
		acceptButton.setBounds(textPaddingLeft + 300, upTextPadding, botonWidth, botonHeight);

		panel.add(selectLabel);
		panel.add(listBook);
		panel.add(loadButton);

		panel.add(titleLabel);
		panel.add(titleField);
		panel.add(isbnLabel);
		panel.add(isbnField);
		panel.add(numPageLabel);
		panel.add(numPageField);
		panel.add(genreLabel);
		panel.add(genreField);

		panel.add(cancelButton);
		panel.add(acceptButton);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == loadButton) {

			// Obtener la posición seleccionada del JComboBox y cargar los valores
			int selectedPosition = listBook.getSelectedIndex();
			selectBook = (MyBook) listBook.getSelectedItem();
			titleField.setText(selectBook.getTitle());
			isbnField.setText(selectBook.getIsbn());
			numPageField.setText(selectBook.getNumPage());
			genreField.setText(selectBook.getGenre());

		} else if (e.getSource() == acceptButton) {

			if (selectBook != null) {
				String title = titleField.getText();
				String isbn = isbnField.getText();
				String numPage = numPageField.getText();
				String genre = genreField.getText();

				MyBook bookModify = new MyBook(title, isbn, numPage, genre);

				Main.dao.updateLibro(selectBook, bookModify);
				dispose();
			} else {
				JOptionPane.showConfirmDialog(null, "Tienes que cargar la información de algún Libro", "Error",
				JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);

			}

		} else if (e.getSource() == cancelButton) {
			// Cerrar la ventana si se presiona el botón de cancelar
			dispose();
		}
	}

}
