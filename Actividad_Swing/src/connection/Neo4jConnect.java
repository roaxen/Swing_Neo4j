package connection;



import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.io.IOUtils.AutoCloseables;



public class Neo4jConnect extends AutoCloseables{

	public static Neo4jConnect instance;
	private final static String user = "neo4j";
	private static String pass = "f6CHEVGpL2H7uqjn_afPv46HdBygr8Vwu7kX2j5BcdQ";
	private static String uri = "neo4j+s://9f739527.databases.neo4j.io";

	public Driver driver;

	public static Neo4jConnect getInstance() {
		if (instance == null) {
			instance = new Neo4jConnect();
		}
		return instance;
	}

	public Neo4jConnect() {

		this.driver = GraphDatabase.driver(uri, AuthTokens.basic(user, pass));

		try {
			driver.verifyConnectivity();
			System.out.println("Conexion establecida con Neo4j.");
		} catch (Exception e) {
			System.err.println("No se pudo conectar a la base de datos: " + e.getMessage());
			System.exit(0);
		}
	}

	public void neo4jClose() {
			driver.close();
			instance = null;
	}

}

