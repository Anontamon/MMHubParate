package net.myanmarhub.parate.dao;

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
 * This is a wrapper abstract class for Dhamma table in database.
 * This is just an abstract class and it defines the operations that need to be
 * implemented by the descendant class.
 * 
 */

public abstract class ParateDAO extends GenericDAO<Parate>{

	public ParateDAO(Context context) {
		super(context);
	}
	
	@Override
	protected Parate getObject(Cursor c) {
		Parate parate = new Parate();
		parate.setContent(c.getString(c.getColumnIndex(Parate.TB_CONTENT)));
		parate.setId(c.getLong(c.getColumnIndex(Parate.ID)));
		parate.setName(c.getString(c.getColumnIndex(Parate.TB_NAME)));
		parate.setMp3Path(c.getString(c.getColumnIndex(Parate.TB_MP3PATH)));
		return parate;
	}
	
	public abstract Collection<Parate> getAll();

}
