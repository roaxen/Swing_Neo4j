package dao;

import org.neo4j.driver.Query;


import connection.Neo4jConnect;
import model.Author;
import model.MyBook;

public class DaoCreate {

	public void createAutor(Author author) {

		try (var session = Neo4jConnect.getInstance().driver.session()) {

			var query = new Query("CREATE (n:Author{"
					+ "name:'" + author.getName() + "',"
					+ "surname:'" + author.getSurname() + "',"
					+ "surname2:'" + author.getSurname2() + "',"
					+ "country:'" + author.getCountry() +"'})");
			System.out.println(query);
			session.run(query);
			System.out.println("Se ha creado el Autor con nombre " + author.getName());

		} catch (Exception e) {
			
			System.err.println("Ha ocurrido un error al crear al Autor");
		}
	}

	public void createLibro(MyBook book) {

		try (var session = Neo4jConnect.getInstance().driver.session()) {

			var query = new Query("CREATE (n:Book{"
					+ "title:'" + book.getTitle() + "',"
					+ "isbn:'" + book.getIsbn() + "',"
					+ "numPage:'" + book.getNumPage() + "',"
					+ "genre:'" + book.getGenre() +"'})");
			session.run(query);
			System.out.println("Se ha creado el libro con titulo " + book.getTitle());

		} catch (Exception e) {
			System.err.println("Ha ocurrido un error al crear el libro");
		}
	}
}