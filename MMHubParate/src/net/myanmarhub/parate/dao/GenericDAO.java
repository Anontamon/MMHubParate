package net.myanmarhub.parate.dao;

import java.io.IOException;

import net.myanmarhub.parate.util.DatabaseHelper;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * 
 *  Copyright information
 * 
 * You may modify and reuse any parts of code or the whole project in 
 * your non-commercial app. However, you may not redistribute under 
 * Myanmar Hub's name or its alias. The resources used in this project are owned
 * properties of Myanmar Hub and will not be used to redistribute. Selling 
 * to use this source code is strongly prohibited.
 *
 * @author Tin Htoo Aung
 *
 * This is a wrapper abstract class for database implementation. This class make use of DatabaseHelper class
 * to connect database. This is a abstract class so you need to implement your own class by extending
 * this.
 * 
 * NOTE THAT : It is essential to call release() method on the instance of the descendent of this class
 * for performance.
 */

public abstract class GenericDAO<T> {

	private DatabaseHelper dbHelper;
	protected SQLiteDatabase db;
	protected Context mContext;
	
	/**
	 * Constructor
	 * @param context context form the current activity or service.
	 */
	public GenericDAO(Context context) {
		dbHelper = new DatabaseHelper(context);
		db = open();
		mContext = context;
	}
	
	/**
	 * Get the context for easy access
	 * @return context use in regard of connecting database
	 */
	public Context getContext() {
		return mContext;
	}
	
	/**
	 * Open database defined in Databasehelper. Please change the value of DB_NAME with your
	 * database name in Databasehelper class. Put your db directly under asset folder
	 * @return Sqlitedatabase that is ready to use.
	 * @throws SQLException
	 */
	private SQLiteDatabase open() throws SQLException{
		
		try {

			dbHelper.createDataBase();

		} catch (IOException ioe) {

			ioe.printStackTrace();

		}

		try {

			dbHelper.openDataBase();

		}catch(SQLException sqle){

			sqle.printStackTrace();

		}
		
		return dbHelper.getDatabase();
	}
	
	
	/**
	 * Do housekeeping of database after it has been use. 
	 * Do not forget to call this method after.
	 */
	public void release(){
		db.close();
		dbHelper.close();
	}
	
	/**
	 * This method needs to be implemented for translation from database record
	 * to actual java plain object. This is a method for serialing database record.
	 * @param c Open cursor returned form database. Please note that cursor is not threadsafe.
	 * @return T object of interest
	 */
	protected abstract T getObject(Cursor c);
}
