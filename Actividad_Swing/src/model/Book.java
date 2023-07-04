package model;

public class Book {

	private String title,  isbn,numPage,country;
	private Author author;

	public Book(String title, Author author, String isbn, String numPage, String country) {
		
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.numPage = numPage;
		this.country = country;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}
	
	
	
}
