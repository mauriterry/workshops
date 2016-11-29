package co.d1egoprog.androidsqllite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteIntermediate extends SQLiteOpenHelper {

	public SQLiteIntermediate(Context context) {
		super(context, Variables.DB_NAME, null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		StringBuilder sb = new StringBuilder("create table ").append(Variables.DB_TABLE_PEOPLE).append("(");
		sb.append(Variables.DB_ATTR_PEOPLE_ID).append(" integer  primary key, ");
		sb.append(Variables.DB_ATTR_PEOPLE_NAME).append(" text ");
		sb.append(")");
		db.execSQL(sb.toString());
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		StringBuilder sb = new StringBuilder("DROP TABLE IF EXISTS ").append(Variables.DB_TABLE_PEOPLE);
		db.execSQL(sb.toString());
		onCreate(db);
	}

	public Cursor getData(String table, String control, String controlValue) {
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor res = db.rawQuery("select * from " + table + " where "+ control + " = ?; ", new String[] {controlValue});
		return res;
	}
	
	public int getNumberOfRowsControl() {
		SQLiteDatabase db = this.getReadableDatabase();
		int numRows = (int) DatabaseUtils.queryNumEntries(db, Variables.DB_TABLE_PEOPLE);
		return numRows;
	}

	public boolean insertDataPeople(Integer id, String name) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues contentValues = new ContentValues();
		contentValues.put(Variables.DB_ATTR_PEOPLE_ID, id);
		contentValues.put(Variables.DB_ATTR_PEOPLE_NAME, name);
		db.insert(Variables.DB_TABLE_PEOPLE, null, contentValues);
		return true;
	}

	public boolean updateDataPeople(Integer id, String name){
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues contentValues = new ContentValues();
		contentValues.put(Variables.DB_ATTR_PEOPLE_ID, id);
		contentValues.put(Variables.DB_ATTR_PEOPLE_NAME, name);
		db.update(Variables.DB_TABLE_PEOPLE, contentValues, Variables.DB_ATTR_PEOPLE_ID + " = ? ", new String[] { id.toString() });
		return true;
	}

	

}
