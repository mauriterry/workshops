import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Vector;

public class GetQuijote {
	public static void main(String[] args) {
		byte pag = 1;
		while (pag <= 35) {
			try {
				String pagina = "http://www.elmundo.es/quijote/capitulo.html?cual=" + pag;
				PrintWriter writer = new PrintWriter("Capitulo"+pag+".txt", "UTF-8");
				URL url = new URL(pagina);
				InputStreamReader reader = new InputStreamReader(url.openStream());
				BufferedReader in = new BufferedReader(reader);
				String inputLine;
				pag++;
				Vector<String> v = new Vector<String>();
				while ((inputLine = in.readLine()) != null) {
					v.add(inputLine);
				}
				
				for (int i = 0; i < v.size(); i++) {
					System.out.println(v.get(i));
					writer.println(v.get(i));
				}
				
				writer.close();
				in.close();

			} catch (Exception ex) {
				ex.printStackTrace();
			}

		}
	}
}