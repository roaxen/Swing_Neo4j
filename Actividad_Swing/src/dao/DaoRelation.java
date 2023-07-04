package dao;

import org.neo4j.driver.Query;
import org.neo4j.driver.Result;

import connection.Neo4jConnect;
import model.Author;
import model.MyBook;

public class DaoRelation {

	public void createRelationAutoLibro(Author author, MyBook book) {
		

		try (var session = Neo4jConnect.getInstance().driver.session()) {

			var query = new Query("MATCH (n:Author "
					+ "{name: '"+ author.getName()+"'}), "
					+ "(m:Book "
					+ "{title: "+ book.getTitle()+"})"
					+ " CREATE (n)-[:publico]->(m)");
			System.out.println(query);
			Result respuesta = session.run(query);
			System.out.println("resultado : "+ respuesta);
			System.out.println("Se ha creado el Arista ");

		} catch (Exception e) {
			
			System.err.println("Ha ocurrido un error al crear al Autor");
		}
	}

public void deleteRelationAutoLibro(Author author, MyBook book) {
		

		try (var session = Neo4jConnect.getInstance().driver.session()) {

			var query = new Query("MATCH (n:Author "
					+ "{name: '"+ author.getName()+"'})"
					+ "-[r:publico]->(m:Book "
					+ "{title: "+ book.getTitle()+"})"
					+ " DELETE r");
			System.out.println(query);
			// MATCH (n:Author {name: 'autor'})-[r:publico]->(m:Book {title: "libro1"}) 
			
			Result respuesta = session.run(query);
			System.out.println("resultado : "+ respuesta);
			System.out.println("Se ha creado el Arista ");

		} catch (Exception e) {
			
			System.err.println("Ha ocurrido un error al eliminar la relacion");
		}
	}


}
