package co.d1egoprog.android.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Clase que loggea los eventos lanzados
 * Los guarda en un archivo de Texto
 * 
 * @author Diego Alberto Rincon
 * @email diegoprog@hotmail.com
 * @date 18/06/2011
 */
public class Logger {


    /**
     * File Writer que Crea el archivo para guardar el Log 
     */
    private FileWriter fichero;

    /**
     * File que sirve para conocer la ruta del archivo de manera publica 
     */
    private File nombreFichero;

    /**
     * Constructor por Defecto donde se inicializa el Archivo de Texto
     */
    public Logger(File path){
	    try {
	    	File directory = new File(path, Utilities.getDayString() + "/");
	    	directory.mkdirs();
	    	nombreFichero = new File(directory, "Log-" + Utilities.getDayString());
			fichero = new FileWriter(nombreFichero, true);
	    } catch (IOException e) {
	        System.out.println(getTime() + "Error al crear el Archivo de Log");
	    }
    }

    /**
     * Crea la Cadena de Tiempo y fecha en el JtextField
     * @return Cadena de Texto con Fecha y Hora
     */
    public String getTime(){
        Calendar cal = new GregorianCalendar();
        int ano = cal.get(Calendar.YEAR);
        int mes = cal.get(Calendar.MONTH);
        int dia = cal.get(Calendar.DAY_OF_MONTH);
        int hora =cal.get(Calendar.HOUR_OF_DAY);
        int minutos = cal.get(Calendar.MINUTE);
        int segundos = cal.get(Calendar.SECOND);
        return ano + "/" + mes + "/" + dia  + " - " + hora  + ":" + minutos + ":" + segundos + " : ";
    }

    /**
     * Crea la Cadena de Tiempo y fecha en el Archivo de Texto
     * @return Cadena de Texto con Fecha y Hora
     */
    public String getTimeFile(){
            Calendar cal = new GregorianCalendar();
            int ano = cal.get(Calendar.YEAR);
            int mes = cal.get(Calendar.MONTH);
            int dia = cal.get(Calendar.DAY_OF_MONTH);
            int hora =cal.get(Calendar.HOUR_OF_DAY);
            int minutos = cal.get(Calendar.MINUTE);
            int segundos = cal.get(Calendar.SECOND);
            return "-" + ano + "-" + mes + "-" + dia  + "-" + hora  + "-" + minutos + "-" + segundos;
    }

    /**
     * Metodo que agrega la hora a la cadena del mensaje pasado por el aplicativo
     * @param cadena Cadena de Caracteres a Logear
     */
    public void log(String cadena){
        try {
        	fichero.append(getTime() + cadena + " \n");
        	fichero.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return;
    }

    /**
     * Clase que Cierra el archivo escribe en el mismo y cierra el flujo de datos
     */
    public void close(){
        try {
                fichero.flush();
                fichero.close();
        } catch (IOException e) {
                e.printStackTrace();
        }
    }

	/**
	 * @return the nombreFichero
	 */
	public File getNombreFichero() {
		return nombreFichero;
	}

	/**
	 * @param nombreFichero the nombreFichero to set
	 */
	public void setNombreFichero(File nombreFichero) {
		this.nombreFichero = nombreFichero;
	}

}
