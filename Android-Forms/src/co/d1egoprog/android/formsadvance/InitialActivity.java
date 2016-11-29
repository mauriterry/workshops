package co.d1egoprog.android.formsadvance;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;
import java.util.Properties;

import co.d1egoprog.android.formsadvance.listener.InitialCancelListener;
import co.d1egoprog.android.formsadvance.listener.InitialLoginListener;
import co.d1egoprog.android.util.Logger;
import co.d1egoprog.android.util.User;
import co.d1egoprog.android.util.Utilities;

public class InitialActivity extends Activity {

    private Button cancel;
    private Button login;

    private EditText username;
    private EditText password;

    private File masterPath;
    private File appPath;
    private File systemPath;
    private File dataPath;
    private File logPath;

    private Properties loginFile;
    private Hashtable<String, User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.initial);

        initAppDataStorage();
        //Log.d("TAG", "Paso por aqui");
        //initExternalFiles();
        //initUsers();

        setLogin((Button) findViewById(R.id.button));
        setCancel((Button) findViewById(R.id.button2));

        setUsername((EditText) findViewById(R.id.editText));
        setPassword((EditText) findViewById(R.id.editText));

        getCancel().setOnClickListener(new InitialCancelListener(this));
        getLogin().setOnClickListener(new InitialLoginListener(this));

    }

    /**
     *
     */
    public void initUsers(){
        int number = Integer.parseInt((String)loginFile.get("users.number"));
        //logger.log(number + " usuarios en la lista");
        users = new Hashtable<String, User>();

        for (int i=1; i<=number;i++){
            String username = (String)loginFile.get("user" + i +".login");
            String password = (String)loginFile.get("user" + i +".password");
            String role = (String)loginFile.get("user" + i +".role");
            User user = new User(username, password, role);
            users.put(username, user);
            //logger.log("Usuario " + i + " " + username + " cargado exitosamente en base de datos interna");
        }

        return;
    }

    /**
     * Lee los archivo iniciales de Seguridad
     * Inicializa el Log del Aplicativo
     */
    private void initExternalFiles(){
        loginFile = new Properties();
        try {
            loginFile.load(new FileInputStream(new File(systemPath, "users.properties")));
            //logger.log("Archivo de Permisos Cargado Exitosamente");
        } catch (IOException e) {
            //logger.log("Error al leer el archivo de Permisos");
        }

        return;
    }

    /**
     * Metodo que Inicializa los parametros para el almacenamiento de la aplicacion
     */
    private void initAppDataStorage(){
        PrintWriter pw;
        File initFile;
        masterPath = Utilities.DEFAULT_DIRECTORY;
        appPath = new File(masterPath, "forms/");

        try {
            systemPath = new File(appPath, "system/");
            initFile = new File(systemPath, "initFile");
            systemPath.mkdirs();
            pw = new PrintWriter(initFile);
            pw.write(systemPath.getAbsolutePath());
            pw.close();
            Utilities.createFile(getApplicationContext(), initFile);
/*
            dataPath = new File(appPath, "data/");
            initFile = new File(dataPath, "initFile");
            dataPath.mkdirs();
            pw = new PrintWriter(initFile);
            pw.write(dataPath.getAbsolutePath());
            pw.close();
            Utilities.createFile(getApplicationContext(), initFile);

            logPath = new File(systemPath, "log/");
            initFile = new File(logPath, "initFile");
            logPath.mkdirs();
            pw = new PrintWriter(initFile);
            pw.write(logPath.getAbsolutePath());
            pw.close();
            Utilities.createFile(getApplicationContext(), initFile);


            Logger log = new Logger(logPath);
*/
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return;
    }

    public Button getCancel() {
        return cancel;
    }

    public void setCancel(Button cancel) {
        this.cancel = cancel;
    }

    public Button getLogin() {
        return login;
    }

    public void setLogin(Button login) {
        this.login = login;
    }

    public EditText getUsername() {
        return username;
    }

    public void setUsername(EditText username) {
        this.username = username;
    }

    public EditText getPassword() {
        return password;
    }

    public void setPassword(EditText password) {
        this.password = password;
    }
}
