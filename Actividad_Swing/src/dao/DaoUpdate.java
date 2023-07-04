package dao;

import org.neo4j.driver.Driver;
import org.neo4j.driver.Query;

import connection.Neo4jConnect;
import model.Author;
import model.MyBook;

public class DaoUpdate {

	public void updateAutor(Author buscarAuthor, Author nuevosValores) {

		try (var session = Neo4jConnect.getInstance().driver.session()) {
			var query = new Query("MATCH (n:Author) WHERE "
					+ "n.country = '"+buscarAuthor.getCountry()+"' AND"
					+ " n.name = '"+buscarAuthor.getName()+"' AND "
					+ "n.surname = '"+buscarAuthor.getSurname()+"' AND "
					+ "n.surname2 = '"+buscarAuthor.getSurname2()+"'"
					+ "SET n.country = '"+nuevosValores.getCountry()+"', "
					+ "n.name = '"+nuevosValores.getName()+"', "
					+ "n.surname = '"+nuevosValores.getSurname()+"', "
					+ "n.surname2 = '"+nuevosValores.getSurname2()+"' RETURN n"
					+ "");
			session.run(query);
		} catch (Exception e) {
			System.err.println("ERROR");
		}
	}

	public void updateLibro(MyBook buscarBook, MyBook nuevosValores) {

		try (var session = Neo4jConnect.getInstance().driver.session()) {
			var query = new Query("MATCH (n:Book) WHERE "
					+ "n.title = "+buscarBook.getTitle()+" AND"
					+ " n.isbn = "+buscarBook.getIsbn()+" AND "
					+ "n.numPage ="+buscarBook.getNumPage()+" AND "
					+ "n.genre = "+buscarBook.getGenre()+""
					+ "SET n.title = '"+nuevosValores.getTitle()+"', "
					+ "n.isbn = '"+nuevosValores.getIsbn()+"', "
					+ "n.numPage = '"+nuevosValores.getNumPage()+"', "
					+ "n.genre = '"+nuevosValores.getGenre()+"' RETURN n");
			System.out.println(query);
			session.run(query);
		} catch (Exception e) {
			System.err.println("ERROR");
		}
	}
}
