package co.d1egoprog.webservice.client;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;


public class Principal {
	
	private static final String NAMESPACE = "http://server.webservice.d1egoprog.co/";
	private static String URL = "http://192.168.2.XXX:8089/WS/Calculadora?wsdl"; //Cambiar por mi dirección IP
	private static final String METHOD_NAME_SUMAR = "sumar";
	private static final String METHOD_NAME_RESTAR = "restar";
	private static final String METHOD_NAME_MULTIPLICAR = "multiplicar";
	private static final String METHOD_NAME_DIVIDIR = "dividir";
	private static final String SOAP_ACTION = "http://server.webservice.d1egoprog.co/sumar";

	public Principal() {
	}
	
	public static void main(String[] args) throws Exception {

		URL url = new URL(URL);
        QName qname = new QName(NAMESPACE, "Calculadora");
        Service service = Service.create(url, qname);
        Calculadora calculadora = service.getPort(Calculadora.class);
        System.out.println(calculadora.sumar(1, 1));
        
	}

}
