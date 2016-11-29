package co.d1egoprog.android.camera;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import co.d1egoprog.util.Utilities;

public class InitialActivity extends Activity {

	private Button b1, b2;
	private ImageView iv;

	private File masterPath;
	private File appPath;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.initial);

		initAppDataStorage();

		b1 = (Button) findViewById(R.id.button);
		iv = (ImageView) findViewById(R.id.imageView);

		b1.setOnClickListener(new InitialCameraListener(this));
	}

	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		Bitmap bp = (Bitmap) data.getExtras().get("data");
		iv.setImageBitmap(bp);

		storeBitmapImage(this.getApplicationContext(), bp, 100, Utilities.getDayHourString() + ".jpg");

	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}

	/**
	 * Metodo que Inicializa los parametros para el almacenamiento de la
	 * aplicacion
	 */
	private void initAppDataStorage() {
		PrintWriter pw;
		File initFile;
		masterPath = Utilities.DEFAULT_DIRECTORY;
		appPath = new File(masterPath, "camera/");
		try {
			initFile = new File(appPath, "initFile");
			appPath.mkdirs();
			pw = new PrintWriter(initFile);
			pw.write(appPath.getAbsolutePath());
			pw.close();
			Utilities.createFile(getApplicationContext(), initFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return;
	}

	public boolean storeBitmapImage(Context mContext, Bitmap image, int quality, String expName) {
		File imagen = new File(Utilities.DEFATUL_APP_DIRECTORY.getAbsolutePath(), expName);
		Utilities.createFile(mContext, imagen);
		FileOutputStream fileOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream(imagen.getAbsolutePath());
			BufferedOutputStream bos = new BufferedOutputStream(fileOutputStream);
			image.compress(CompressFormat.JPEG, quality, bos);
			bos.flush();
			bos.close();
			fileOutputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return true;
	}

}
