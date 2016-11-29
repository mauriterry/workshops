import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongoInsert {

	public MongoInsert() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String args[]) {
		try {
			MongoClient conexion = new MongoClient("localhost", 27017);
			MongoDatabase base = conexion.getDatabase("test");
			
			
			
			Document documento = new Document("palabra","Quijote")
	                					.append("letras", 8)
	                					.append("Tipo", "Sustantivo");
					
			base.getCollection("quijote").insertOne(documento);;
			System.out.println("Document inserted successfully");
			conexion.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}

}
