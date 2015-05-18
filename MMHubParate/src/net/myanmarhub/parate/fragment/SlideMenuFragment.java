/**
 * 
 */
package net.myanmarhub.parate.fragment;

import java.util.ArrayList;
import java.util.LinkedList;

import net.myanmarhub.parate.R;
import net.myanmarhub.parate.dao.CategoryAdapter;
import net.myanmarhub.parate.dao.ParateCollectionDAO;
import net.myanmarhub.parate.domain.Parate;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ListView;

import com.actionbarsherlock.app.SherlockFragment;

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
public class SlideMenuFragment extends SherlockFragment implements OnItemClickListener{

	private ListView categoryList;
	private OnDataLoadListener mDataloadFinishListener;
	private onCategoryClickListener mCategoryClickListener;
	private DataTask dataTask;
	private static ArrayList<Parate> cacheData;
	private static boolean isDataLoading = false;
	private CheckBox chkLoop, chkAuto; 
	private SharedPreferences prefs;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.slidemenu, null);
		prefs = getActivity().getSharedPreferences("prefs", Context.MODE_PRIVATE);
		findViews(v);
		return v;
	}
	
	@Override
	public void onPause() {
		super.onPause();
		if(dataTask != null){
			dataTask.cancel(true);
			isDataLoading = false;
		}
	}
	
	@Override
	public void onResume() {
	super.onResume();
		if(cacheData == null && dataTask == null && !isDataLoading){
			dataTask = new DataTask();
			dataTask.execute("");
		}
	}
	

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		try{
			mDataloadFinishListener = (OnDataLoadListener) activity;
		}catch(ClassCastException e){
			throw new RuntimeException("MainActivity needs to implement OnDataloadListener.");
		}
		try{
			mCategoryClickListener = (onCategoryClickListener) activity;
		}catch(ClassCastException e){
			throw new RuntimeException("MainActivity needs to implement onCategoryClickListener.");
		}
		
	}
	
	
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
	}
	
	private void findViews(View parent){
		categoryList = (ListView) parent.findViewById(R.id.slidemenu_categorylist);
		categoryList.setOnItemClickListener(this);
		if(cacheData != null)categoryList.setAdapter(new CategoryAdapter(getActivity(), cacheData));
		chkAuto = (CheckBox) parent.findViewById(R.id.slidemenu_chkAutoPlay);
		chkAuto.setChecked(prefs.getBoolean("isAutoPlay", true));
		chkAuto.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				getActivity().getSharedPreferences("prefs", Context.MODE_PRIVATE).edit()
				.putBoolean("isAutoPlay", isChecked).commit();
			}
		});
		chkLoop = (CheckBox) parent.findViewById(R.id.slidemenu_chkLoop);
		chkAuto.setChecked(prefs.getBoolean("isLoop", true));
		chkLoop.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				getActivity().getSharedPreferences("prefs", Context.MODE_PRIVATE).edit()
				.putBoolean("isLoop", isChecked).commit();
			}
		});
	}

	@Override
	public void onItemClick(AdapterView<?> adapter, View v, int position, long id) {
		mCategoryClickListener.onCategoryClicked(((Parate)adapter.getItemAtPosition(position)), position);
	}
	
	public boolean isDataLoading(){
		return isDataLoading;
	}

	private class DataTask extends AsyncTask<String, Integer, CategoryAdapter>{

		@Override
		protected void onPreExecute() {
			mDataloadFinishListener.preDataLoad();
		}

		@Override
		protected CategoryAdapter doInBackground(String... params) {
			isDataLoading = true;
			ParateCollectionDAO dao = new ParateCollectionDAO(getActivity());
			try{
				return new CategoryAdapter(getActivity(), dao.getAll());
			}finally{
				dao.release();
			}
		}

		@Override
		protected void onPostExecute(CategoryAdapter result) {
			isDataLoading = false;
			categoryList.setAdapter(result);
			cacheData = result.getList();
			mDataloadFinishListener.onDataLoadFinish((result != null)?new LinkedList<Parate>(cacheData):null);
			dataTask = null;
		}
	}
	
	public interface OnDataLoadListener{
		public void preDataLoad();
		public void onDataLoadFinish(LinkedList<Parate> data);
	}
	
	public interface onCategoryClickListener{
		public void onCategoryClicked(Parate parate, long position);
	}
}
