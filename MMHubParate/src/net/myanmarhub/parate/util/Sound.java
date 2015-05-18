package net.myanmarhub.parate.util;

import java.io.IOException;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.view.View;
import android.widget.SeekBar;

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

public class Sound {

	private MediaPlayer mp;
	private SeekBar bar;
	public String[] dhammaList;
	private Context mContext;
	private AssetFileDescriptor currentDes;
	private OnSoundStateListener mOnSoundStateListener;

	public Sound(Context context) {
		super();
		this.mContext = context;
		mp  = new MediaPlayer();
		mp.setOnCompletionListener(new OnCompletionListener() {

			@Override
			public void onCompletion(MediaPlayer mp) {
				if(mOnSoundStateListener != null)
					mOnSoundStateListener.onSoundFinish();
			}
		});
	}

	public void setOnSoundStateListener(OnSoundStateListener  listener){
		this.mOnSoundStateListener = listener;
	}

	public void seekChange(View v) {
		if(mp.isPlaying()){
			bar = (SeekBar)v;
			mp.seekTo(bar.getProgress());
		}

	}

	public Integer[] getSeekbarUpdate(){
		return new Integer[]{mp.getCurrentPosition(), mp.getDuration()};
	}

	public int getMediaDuration(){
		return mp.getDuration();
	}

	public void play(String mp3Name){
		if(mOnSoundStateListener != null)
			mOnSoundStateListener.onSoundStart();
		if(mp.isPlaying()){
			mp.stop();
		}
		try {
			mp.reset();
			currentDes = mContext.getAssets().openFd("mp3/"+mp3Name);
			mp.setDataSource(currentDes.getFileDescriptor(), currentDes.getStartOffset(), currentDes.getLength());
			mp.prepare();
			mp.start();
			currentDes.close();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void pause(){
		if((mp.isPlaying())){
			if(mOnSoundStateListener != null)
				mOnSoundStateListener.onSoundPause();
			mp.pause();
		}
	}
	
	public void stop(){
		mp.reset();
		currentDes = null;
		mOnSoundStateListener.onSoundStop();
	}

	public void resume(String mp3Name){
		if(mOnSoundStateListener != null)
			mOnSoundStateListener.onSoundResume();
		if(currentDes != null){
			mp.start();
		}else{
			play(mp3Name);
		}
	}


	public boolean isPlaying(){
		return mp.isPlaying();
	}

	public interface OnSoundStateListener{
		public void onSoundResume();
		public void onSoundPause();
		public void onSoundStart();
		public void onSoundFinish();
		public void onSoundStop();
	}

}
