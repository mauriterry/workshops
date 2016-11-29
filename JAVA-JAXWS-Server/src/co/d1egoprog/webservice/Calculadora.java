package co.d1egoprog.webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface Calculadora {

	@WebMethod
	public String sumar(Integer numero1, Integer numero2);

	@WebMethod
	public String restar(Integer numero1, Integer numero2);

	@WebMethod
	public String multiplicar(Integer numero1, Integer numero2);

	@WebMethod
	public String dividir(Double numero1, Double numero2);
}
