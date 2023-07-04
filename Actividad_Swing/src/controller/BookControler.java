package controller;


import model.MyBook;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import excepcion.DuplicateObject;
import excepcion.EmptyFields;
import main.Main;
import model.Author;

public class BookControler {

	private JDialog call;

	public BookControler(JDialog call) {

		this.call = call;
	}
	public BookControler() {

	
	}

	public void CreateBook(MyBook book) {

		

		controlBook(book);

	}

	public void removeBook(MyBook book) {

//		int index = indexBook(object);
//
//		Main.books.remove(index);
		Main.dao.deleteLibro(book);
	}
//
//	public void removeAuthorBook(Object object) {
//
//		for (int i = 0; i < Main.books.size(); i++) {
//
//			if (Main.books.get(i).getAuthor().equals(object)) {// metodo equals sobrescrito
//				
//				Main.books.remove(Main.books.get(i));
//				i--;
//			}
//
//		}
//	}

	public void controlBook(MyBook book) {

		String title = book.getTitle();
		String isbn = book.getIsbn();
		String numPage = book.getNumPage();
		String country = book.getGenre();
		Boolean okey ;

		try {

			if (title.equalsIgnoreCase("") || isbn.equalsIgnoreCase("") || numPage.equalsIgnoreCase("")
					|| country.equalsIgnoreCase("")) {
				okey = false;
				throw new EmptyFields();
			} else {

				okey = compareBook(book);

				if (okey == true) {
					
					//Main.books.add(book);
					Main.dao.createLibro(book);
					
					Main.genre.add(book.getGenre());
					call.dispose();
				}
			}

		} catch (EmptyFields e) {

			JOptionPane.showMessageDialog(call, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

			System.out.println(e.getMessage());
		}

	}

	public boolean compareBook(MyBook book) {

		boolean creacion = true;

		for (int i = 0; i < Main.books.size(); i++) {

			try {
				if (Main.books.get(i).equals(book)) {

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

	public int indexBook(Object object) {

		Integer position = null;

		for (int i = 0; i < Main.books.size(); i++) {

			if (Main.books.get(i).equals(object)) {// metodo equals sobrescrito

				position = i;

			}

		}
		return position;

	}

}