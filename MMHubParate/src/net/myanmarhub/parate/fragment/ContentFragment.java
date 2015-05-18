package net.myanmarhub.parate.fragment;

import net.myanmarhub.parate.MainActivity;
import net.myanmarhub.parate.R;
import net.myanmarhub.parate.domain.Parate;
import net.myanmarhub.widget.MMTextView;
import android.app.Activity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.SeekBar;

import com.actionbarsherlock.app.SherlockFragment;

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
 */

public class ContentFragment extends SherlockFragment{

	private MMTextView lblText;
	private ImageButton ibPlay, ibFontUp, ibFontDown;
	private SeekBar seekBar;
	private Parate currentParate;
	private OnAudioRequest mAudioRequest;
	private float fontSize;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.frag_content, null);
		findViews(v);
		if(savedInstanceState != null){
			currentParate = (Parate)savedInstanceState.getSerializable("parate");
			if(currentParate != null){
				setContent(currentParate);
			}
		}
		return v;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		try{
			mAudioRequest = (OnAudioRequest) activity;
		}catch(ClassCastException e){
			throw new RuntimeException("MainActivity needs to implement OnAudioRequest.");
		}
	}

	private void findViews(View v){
		lblText = (MMTextView) v.findViewById(R.id.frag_content_lblText);
		fontSize = lblText.getTextSize();
		lblText.setMovementMethod(new ScrollingMovementMethod());
		ibPlay = (ImageButton) v.findViewById(R.id.frag_content_btnPlay);
		ibPlay.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if(((String)v.getTag()).equals("0")){
					mAudioRequest.onAudioRequested(currentParate);
					ibPlay.setImageResource(android.R.drawable.ic_media_pause);
					v.setTag("1");
					seekBar.setEnabled(true);
				}else if(((String)v.getTag()).equals("1")){
					mAudioRequest.onAudioPause();
					ibPlay.setImageResource(android.R.drawable.ic_media_play);
					seekBar.setEnabled(false);
				}
			}
		});
		
		ibFontDown = (ImageButton) v.findViewById(R.id.frag_content_ibFontMinus);
		ibFontDown.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				fontSize -= 1f;
				lblText.setTextSize(TypedValue.COMPLEX_UNIT_DIP,fontSize);
			}
		});
		
		ibFontUp = (ImageButton) v.findViewById(R.id.frag_content_ibFontPlus);
		ibFontUp.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				fontSize += 1f;
				lblText.setTextSize(TypedValue.COMPLEX_UNIT_DIP,fontSize);
			}
		});
		
		seekBar = (SeekBar) v.findViewById(R.id.frag_content_seekbar);
		seekBar.setProgress(0);
		seekBar.setOnSeekBarChangeListener((MainActivity)getActivity());
	}

	public void setContent(Parate parate){
		currentParate = parate;
		lblText.setText(parate.getContent());
		lblText.scrollTo(0, 0);
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putSerializable("parate", currentParate);
	}

	public void setMediaDuration(int mediaDuration) {
		seekBar.setMax(mediaDuration);
	}

	public void updateSeekbar(Integer[] seekbarUpdate) {
		if(seekBar != null){
			seekBar.setMax(seekbarUpdate[1]);
			seekBar.setProgress(seekbarUpdate[0]);
		}
	}

	public void manageState(boolean isPlay){
		ibPlay.setTag((isPlay)?"1":"0");
		ibPlay.setImageResource((isPlay)?android.R.drawable.ic_media_pause:android.R.drawable.ic_media_play);
		seekBar.setEnabled(isPlay);
	}

	public interface OnAudioRequest{
		public void onAudioRequested(Parate parate);
		public void onAudioPause();
	}

	public void resetSeekbar() {
		seekBar.setProgress(0);
	}

}
