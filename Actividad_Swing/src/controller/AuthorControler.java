package controller;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import excepcion.DuplicateObject;
import excepcion.EmptyFields;
import main.Main;
import model.Author;

public class AuthorControler {

	private JDialog call;

	public AuthorControler(JDialog call) {

		this.call = call;
	}

	public void CreateAuthor(Author author) {

		controlAuthor(author);

	}

	public void removeAuthor(Author author) {

//		int index = indexAuthor(author);
//
//		Main.writers.remove(index);
		
	 
		
		Main.dao.deleteAutor(author);
		
		//BookControler ct = new BookControler();
		
		//ct.removeAuthorBook(author);
		// elimina el libro que esta asociado al author -- por el momento no lo haremos es no relacional

	}

	public void controlAuthor(Author author) {

		String name = author.getName();
		String surname = author.getSurname();
		String surname2 = author.getSurname2();
		String country = author.getCountry();
		Boolean okey;
		try {

			if (name.equalsIgnoreCase("") || surname.equalsIgnoreCase("") || surname2.equalsIgnoreCase("")
					|| country.equalsIgnoreCase("")) {

				throw new EmptyFields();
			} else {

				okey = compareAuthor(author);

				if (okey == true) {
					//Main.writers.add(author);
					Main.dao.createAutor(author);
					call.dispose(); // sirve para cerrar la ventana, el Jdialog
				}
			}

		} catch (EmptyFields e) {

			JOptionPane.showMessageDialog(call, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

			System.out.println(e.getMessage());
		}

	}

	public boolean compareAuthor(Author author) {

		boolean creacion = true;

		for (int i = 0; i < Main.writers.size(); i++) {

			try {

				if (Main.writers.get(i).equals(author)) {// metodo equals sobrescrito

					creacion = false;
					throw new DuplicateObject();

				} else {
					creacion = true;
				}

			} catch (DuplicateObject e) {

				JOptionPane.showMessageDialog(call, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				System.out.println(e.getMessage());

			}

		}
		return creacion;

	}

	public int indexAuthor(Object object) {

		Integer position = null;

		for (int i = 0; i < Main.writers.size(); i++) {

			if (Main.writers.get(i).equals(object)) {// metodo equals sobrescrito

				position = i;

			}

		}
		return position;

	}

}
