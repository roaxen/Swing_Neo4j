package dao;

import org.neo4j.driver.Driver;
import org.neo4j.driver.Query;

import connection.Neo4jConnect;
import model.Author;
import model.MyBook;

public class DaoDelete {

	@SuppressWarnings("resource")
	public void deleteAllAutores() {

		try (var session = Neo4jConnect.getInstance().driver.session()) {
			var query = new Query("MATCH(n:Autor) DETACH DELETE n");
			session.run(query);
			System.out.println("Se han borrado todos los nodos Persona");
		}
	}
	
	

	
	@SuppressWarnings("resource")
	public void deleteAllLibros() {

		try (var session = Neo4jConnect.getInstance().driver.session()) {
			var query = new Query("MATCH(n:Libro) DETACH DELETE n");
			session.run(query);
			System.out.println("Se han borrado todos los nodos 'Libro'");
		}
	}

	@SuppressWarnings("resource")
	public void deleteAutor( Author author) {

		try (var session = Neo4jConnect.getInstance().driver.session()) {
			var query = new Query("MATCH (n:Author)"
					+ " where n.name = '"+author.getName()+"'"
					+ " AND n.surname = '"+author.getSurname()+"'"
					+ " AND n.surname2 = '"+author.getSurname2()+"' "
					+ "AND n.country = '"+author.getCountry()+"' DETACH delete n");
			System.out.println(query);
			session.run(query);
			System.out.println("Se ha borrado el nodo Autor");
		}
	}
	
	@SuppressWarnings("resource")
	public void deleteLibro( MyBook book) {

		try (var session = Neo4jConnect.getInstance().driver.session()) {
			var query = new Query("MATCH (n:Book) "
					+ "where n.title = "+book.getTitle()
					+ " AND n.isbn = "+book.getIsbn()
					+ " AND n.numPage = "+book.getNumPage()
					+ "AND n.genre = "+book.getGenre()+" DETACH delete n");
			
			System.out.println(query);
			session.run(query);
			System.out.println("Se ha borrado el nodo Libro ");
		}
	}
}