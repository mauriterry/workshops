package co.d1egoprog.webservice.server;

import javax.jws.WebService;

@WebService(endpointInterface = "co.d1egoprog.webservice.server.Calculadora")
public class CalculadoraImpl {

	public String sumar(Integer numero1, Integer numero2) {
		Integer resultado = numero1 + numero2;
		System.out.println("El resultado de la suma "+numero1+"+"+numero2+" es: " + resultado);
		return "El resultado de la suma "+numero1+"+"+numero2+" es: " + resultado;
	}

	public String restar(Integer numero1, Integer numero2) {
		Integer resultado = numero1 - numero2;
		System.out.println("El resultado de la resta "+numero1+"-"+numero2+" es: " + resultado);
		return "El resultado de la resta "+numero1+"-"+numero2+" es: " + resultado;
	}

	public String multiplicar(Integer numero1, Integer numero2) {
		Integer resultado = numero1 * numero2;
		System.out.println("El resultado de la multiplicacion "+numero1+"*"+numero2+" es: " + resultado);
		return "El resultado de la multiplicacion "+numero1+"*"+numero2+" es: " + resultado;
	}

	public String dividir(Double numero1, Double numero2) {
		Double resultado = numero1 /numero2;
		System.out.println("El resultado de la division "+numero1+"/"+numero2+" es: " + resultado);
		return "El resultado de la division "+numero1+"/"+numero2+" es: " + resultado;
	}
}
