package dao;

import java.util.ArrayList;


import org.neo4j.driver.Driver;
import org.neo4j.driver.Record;
import org.neo4j.driver.Result;
import org.neo4j.driver.types.Node;

import connection.Neo4jConnect;
import model.Author;
import model.MyBook;

public class DaoSelect {

	
	/**
	 * Busca a todos los autores y te los devuelve en una ArrayList
	 * @param driver
	 */
	@SuppressWarnings("resource")
	public ArrayList<Author> selectAllAutores() {
		ArrayList <Author> allAuthor = new ArrayList<>();
		
		try (var session = Neo4jConnect.getInstance().driver.session()) {
			Result result = session.run("MATCH (n:Author) RETURN n");
			while (result.hasNext()) {
				Record persona = result.next();
				Node nodo = persona.get("n").asNode();
				var nodoAutor = nodo.asMap();
				
				//System.out.println(nodoAutor.get("id"));
//				System.out.println(nodoAutor.get("name"));
//				System.out.println(nodoAutor.get("surname"));
//				System.out.println(nodoAutor.get("surname2"));
//				System.out.println(nodoAutor.get("country"));
				Author author = new Author(
						nodoAutor.get("name").toString(),
						nodoAutor.get("surname").toString(),
						nodoAutor.get("surname2").toString(),
						nodoAutor.get("country").toString());
				allAuthor.add(author);
//				System.out.println("\t"+nodoAutor.get("name"));
			}
			return allAuthor;
		}
	}
	/**
	 * Busca todos los libros e imprime el titulo
	 * @param driver
	 */
	@SuppressWarnings("resource")
	public ArrayList <MyBook> selectAllLibros() {
		ArrayList <MyBook> allBook = new ArrayList<>();
		
		try (var session = Neo4jConnect.getInstance().driver.session()) {
			Result result = session.run("MATCH (n:Book) RETURN n");
			while (result.hasNext()) {
				Record libro = result.next();
				Node nodoLibro = libro.get("n").asNode();
				var nododesglosado = nodoLibro.asMap();
				MyBook book = new MyBook(
						nodoLibro.get("title").toString(),
						nodoLibro.get("isbn").toString(),
						nodoLibro.get("numPage").toString(),
						nodoLibro.get("genre").toString());
				allBook.add(book);
//				System.out.println("\t"+nodoAutor.get("name"));
			}
			return allBook;
		}
	}
	
	
	/**
	 * Busca un libro por titulo e imprime el titulo y el autor 
	 * @param driver
	 * @param titulo
	 */
	@SuppressWarnings("resource")
	public void selectLibro( String titulo) {
		
		
		try (var session = Neo4jConnect.getInstance().driver.session()) {
			Result result = session.run("MATCH (n:Book) where n.titulo = '" + titulo + "'  RETURN n");
			while (result.hasNext()) {
				Record persona = result.next();
				Node nodo = persona.get("n").asNode();
				var nododesglosado = nodo.asMap();
				System.out.println("Titulo: " + nododesglosado.get("titulo") + " Autor: " + nododesglosado.get("autor"));
			}
		}
	}
	
	/**
	 * Busca a un autor por su nombre e imprime resultado de nombre y edad
	 * @param driver
	 * @param nombre
	 */
	@SuppressWarnings("resource")
	public void selectAutor(Driver driver, String nombre) {
		try (var session = Neo4jConnect.getInstance().driver.session()) {
			Result result = session.run("MATCH (n:Autor) where n.nombre = '" + nombre + "'  RETURN n");
			while (result.hasNext()) {
				Record persona = result.next();
				Node nodo = persona.get("n").asNode();
				var nododesglosado = nodo.asMap();
				System.out.println("Nombre: " + nododesglosado.get("name") + " Edad: " + nododesglosado.get("edad"));
			}
		}
	}
	
	
	
	
	
}