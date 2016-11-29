package co.d1egoprog.webservice.server;

import javax.xml.ws.Endpoint;

public class CalculadoraWSPublisher {

		 public static void main(String[] args) {  
		  Endpoint.publish("http://192.168.2.147:8089/WS/Calculadora",new CalculadoraImpl());  
		 }  
}
