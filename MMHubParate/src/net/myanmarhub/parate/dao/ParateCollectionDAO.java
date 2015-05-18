package net.myanmarhub.parate.dao;

import java.util.ArrayList;
import java.util.Collection;

import net.myanmarhub.parate.domain.Parate;
import android.content.Context;
import android.database.Cursor;

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
 * @author Tin Htoo Aung (Myanmar Hub)
 *
 * This class extends ParateDAO and implements operations to retreieve data from database
 */

public class ParateCollectionDAO extends ParateDAO {

	public ParateCollectionDAO(Context context) {
		super(context);
	}

	@Override
	public Collection<Parate> getAll() {
		Cursor cursor = null;
		ArrayList<Parate> list = new ArrayList<Parate>();
		try{
			cursor = db.query(Parate.TABLE, new String[]{"*"}, 
					null, null, null, null, null);
				while(cursor.moveToNext()){
					list.add(getObject(cursor));
				}
				list.add(0, list.remove(list.size() - 1));
			return list;
		}finally{
			cursor.close();
		}
	}

}
