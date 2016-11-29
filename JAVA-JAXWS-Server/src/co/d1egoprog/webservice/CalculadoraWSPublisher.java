package co.d1egoprog.webservice;

import javax.xml.ws.Endpoint;

public class CalculadoraWSPublisher {

		 public static void main(String[] args) {  
		  Endpoint.publish("http://localhost:8089/WS/Calculadora",new CalculadoraImpl());  
		 }  
}
