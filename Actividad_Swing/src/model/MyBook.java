package model;

public class MyBook {

	private String title, isbn, numPage, genre;
//	private Author author;

	public MyBook(String title, /* Object object, */ String isbn, String numPage, String genre) {

		this.title = title;
//		this.author = (Author) object;
		this.isbn = isbn;
		this.numPage = numPage;
		this.genre = genre;
	}

	public boolean equals(MyBook a) {
		if (
//				a.getAuthor().equals(author) && 
		a.getGenre().trim().equalsIgnoreCase(genre.trim()) && a.getIsbn().trim().equalsIgnoreCase(isbn.trim())
				&& a.getNumPage().trim().equalsIgnoreCase(numPage.trim())
				&& a.getTitle().trim().equalsIgnoreCase(title.trim())) {

			return true;

		} else {

			return false;
		}

	}

	public String toString() {
		return title + ", Genero: "+genre+", " +numPage + " pag, ISBN: " + isbn ;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getNumPage() {
		return numPage;
	}

	public void setNumPage(String numPage) {
		this.numPage = numPage;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String country) {
		this.genre = country;
	}

//	public Author getAuthor() {
//		return author;
//	}
//
//	public void setAuthor(Author author) {
//		this.author = author;
//	}
}
