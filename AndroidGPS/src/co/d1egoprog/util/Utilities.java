package co.d1egoprog.util;

import java.io.File;
import java.util.Calendar;
import java.util.GregorianCalendar;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;

/**
 * Utilidades Necesarias
 * 
 * @author Diego Alberto Rincon
 * @email diegoprog@hotmail.com 25/06/2011
 */
public class Utilities {
	
	public static File DEFAULT_DIRECTORY =  Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
	public static File DEFATUL_APP_DIRECTORY = new File(DEFAULT_DIRECTORY, "camera");
	
	
    /**
     * Metodo que persiste un archivo basado en un puntero
     * @param context Contexto del Archivo
     * @param file Archivo a Guardar
     */
    public static void createFile(Context context, File file){
    	MediaScannerConnection.scanFile(context,
                new String[] { file.toString() }, null,
                new MediaScannerConnection.OnScanCompletedListener() {
            public void onScanCompleted(String path, Uri uri) {
            }
        });
    }
    
    /**
     * Metodo que crea un mensaje de informacion en pantalla de android
     * @param context contexto de la aplicacion
     * @param message mensaje a desplegar
     */
    public static void messageBox(Context context, String message){
        AlertDialog.Builder alertbox = new AlertDialog.Builder(context);
        alertbox.setMessage(message);
        alertbox.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
            }
        });
        alertbox.show();
    }
    
    /**
     * Crea la Cadena de Tiempo y fecha en el Archivo de Texto
     * @return Cadena de Texto con Fecha y Hora
     */
    public static String getDayString(){
            Calendar cal = new GregorianCalendar();
            int ano = cal.get(Calendar.YEAR);
            int mes = cal.get(Calendar.MONTH);
            int dia = cal.get(Calendar.DAY_OF_MONTH);
            return ano + "-" + mes + "-" + dia;
    }
    
    /**
     * Crea la Cadena de Tiempo, fecha y hora en el Archivo de Texto
     * @return Cadena de Texto con Fecha y Hora
     */
    public static String getDayHourString(){
            Calendar cal = new GregorianCalendar();
            int ano = cal.get(Calendar.YEAR);
            int mes = cal.get(Calendar.MONTH);
            int dia = cal.get(Calendar.DAY_OF_MONTH);
            int hora =cal.get(Calendar.HOUR_OF_DAY);
            int minutos = cal.get(Calendar.MINUTE);
            int segundos = cal.get(Calendar.SECOND);
            return ano + "-" + mes + "-" + dia  + " - " + hora  + minutos + segundos ;
    }

}
