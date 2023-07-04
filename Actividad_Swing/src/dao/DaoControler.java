package dao;

import java.util.ArrayList;

import org.neo4j.driver.Driver;

import connection.Neo4jConnect;
import main.Main;
import model.Author;
import model.MyBook;

public class DaoControler {
	public Driver driver;
	public DaoCreate daoCreate;
	public DaoSelect daoRead;
	public DaoUpdate daoUpdate;
	public DaoDelete daoDelete;
	public DaoRelation daoRelation;

	@SuppressWarnings("resource")
	public DaoControler() {
		driver = Neo4jConnect.getInstance().driver;
		daoCreate = new DaoCreate();
		daoRead = new DaoSelect();
		daoUpdate = new DaoUpdate();
		daoDelete = new DaoDelete();
		daoRelation = new DaoRelation();
	}

	// Metodos CREATE
	public void createAutor(Author author) {
		this.daoCreate.createAutor(author);
		Main.actualizarDatos();
	}

	
	
	public void createLibro(MyBook book) {
		this.daoCreate.createLibro(book);
		Main.actualizarDatos();
	}

	// Metodos DELETE
	public void deleteAutor(Author author) {
		this.daoDelete.deleteAutor( author);
		Main.actualizarDatos();
	}

	public void deleteLibro(MyBook book) {
		this.daoDelete.deleteLibro( book);
		Main.actualizarDatos();
	}

	public void deleteAllAutor() {
		this.daoDelete.deleteAllAutores();
		Main.actualizarDatos();
	}

	public void deleteAllLibro() {
		this.daoDelete.deleteAllLibros();
		Main.actualizarDatos();
	}

	// Metodos SELECT
	
	/**
	 * Imprime Autor
	 */
	public void selectAutor(String nombre) {
		this.daoRead.selectAutor(driver, nombre);
		Main.actualizarDatos();
		
	}

	/**
	 * Imprime titulo
	 * @param titulo
	 */
	public void selectLibro(String titulo) {
		this.daoRead.selectLibro( titulo);
		Main.actualizarDatos();
	}
	
	/**
	 * Imprime todos los nombres de los autores 
	 * @return 
	 */
	public ArrayList<Author> selectAllAutores() {
		return this.daoRead.selectAllAutores();
		//Main.actualizarDatos();
	}
	
	
	
	/**
	 * Imprime todos los libros
	 */
	public  ArrayList<MyBook> selectAllLibros() {
		return this.daoRead.selectAllLibros();
//		Main.actualizarDatos();
	}
	
	

	// Metodos UPDATE
	public void updateAutor(Author buscarAuthor, Author nuevosValores) {
		this.daoUpdate.updateAutor( buscarAuthor,  nuevosValores);
		Main.actualizarDatos();
	}

	public void updateLibro(MyBook buscarBook, MyBook nuevosValores) {
		this.daoUpdate.updateLibro(buscarBook,nuevosValores );
		Main.actualizarDatos();
	}
	
	

	// Metodos RELATION
	public void createRelationAutoLibro(Author author, MyBook book) {
		this.daoRelation.createRelationAutoLibro(author,book );
		Main.actualizarDatos();
	}
	public void deleteRelationAutoLibro(Author author, MyBook book) {
		this.daoRelation.deleteRelationAutoLibro(author,book );
		Main.actualizarDatos();
	}
	
}
