package co.d1egoprog.webservice.client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface Calculadora {

	@WebMethod
	public String sumar(@WebParam(name = "numero1")Integer numero1, @WebParam(name = "numero2")Integer numero2);

	@WebMethod
	public String restar(@WebParam(name = "numero1")Integer numero1, @WebParam(name = "numero2")Integer numero2);

	@WebMethod
	public String multiplicar(@WebParam(name = "numero1")Integer numero1, @WebParam(name = "numero2")Integer numero2);

	@WebMethod
	public String dividir(@WebParam(name = "numero1")Double numero1, @WebParam(name = "numero2")Double numero2);
}
