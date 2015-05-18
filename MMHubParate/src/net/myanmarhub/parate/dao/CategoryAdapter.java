/**
 * 
 */
package net.myanmarhub.parate.dao;

import java.util.ArrayList;
import java.util.Collection;

import net.myanmarhub.parate.R;
import net.myanmarhub.parate.domain.Parate;
import net.myanmarhub.widget.MMTextView;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
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
 */
public class CategoryAdapter extends BaseAdapter {
	
	private ArrayList<Parate> list = new ArrayList<Parate>();
	private Context mContext;
	private ViewHolder holder;
	
	public CategoryAdapter(Context context, Collection<Parate> list) {
		if(list != null) this.list = new ArrayList<Parate>(list);
		this.mContext = context;
	}
	
	public ArrayList<Parate> getList() {
		return list;
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getCount()
	 */
	@Override
	public int getCount() {
		return list.size();
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getItem(int)
	 */
	@Override
	public Parate getItem(int position) {
		return list.get(position);
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getItemId(int)
	 */
	@Override
	public long getItemId(int position) {
		return list.get(position).getId();
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getView(int, android.view.View, android.view.ViewGroup)
	 */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;
		if(v == null){
			v = LayoutInflater.from(mContext).inflate(R.layout.slidemenu_category_item, null);
			holder = new ViewHolder();
			v.setTag(holder);
			holder.lblName = (MMTextView) v.findViewById(R.id.slidemenu_category_item_lblName);
		}else{
			holder = (ViewHolder) v.getTag();
		}
		holder.lblName.setText(getItem(position).getName());
		return v;
	}
	
	private class ViewHolder{
		public MMTextView lblName;
	}

}
