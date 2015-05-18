/**
 * 
 */
package net.myanmarhub.parate;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.view.View;

import net.myanmarhub.parate.domain.Parate;
import net.myanmarhub.parate.util.Sound;
import net.myanmarhub.parate.util.Sound.OnSoundStateListener;

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
public class MediaService extends Service {

	public static volatile boolean isRunning = false;
	private Sound sound;
	private final IBinder mBinder = new MyBinder();
	private Parate currentParate;
	private NotificationManager notiManager;

	@Override
	public IBinder onBind(Intent intent) {
		return mBinder;
	}

	public class MyBinder extends Binder {
		MediaService getService() {
			return MediaService.this;
		}
	}

	public void setOnSoundStateListener(OnSoundStateListener listener){
		sound.setOnSoundStateListener(listener);
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		isRunning = true;
		init();
		return START_STICKY;
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		cancelNoti();
	}

	public boolean isPlaying(){
		return sound.isPlaying();
	}

	private void init(){
		sound = new Sound(getBaseContext());
		notiManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
	}

	public void pauseAudio(){
		cancelNoti();
		sound.pause();
	}

	public void stopAudio(){
		cancelNoti();
		sound.stop();
	}

	public void resumeAudio(Parate parate){
		if(parate != null){
			currentParate = parate;
			showNoti();
			sound.resume(parate.getMp3Path());
		}
	}

	public void playAudio(Parate parate){
		currentParate = parate;
		showNoti();
		sound.play(parate.getMp3Path());
	}

	public Integer[] getSeekbarUpdate(){
		return sound.getSeekbarUpdate();
	}

	public Parate getCurrentParate() {
		return currentParate;
	}

	public void seekChange(View v){
		sound.seekChange(v);
	}

	private void showNoti(){
		// Build notification
		Intent notiIntent = new Intent("NOTI_AUDIO_STOP");
		PendingIntent pIntent = PendingIntent.getBroadcast(this, 0, notiIntent, 0);
		NotificationCompat.Builder notiBuilder = new NotificationCompat.Builder(
				this).setContentTitle("MMHub Parate is Playing...")
				.setContentText("Click here to stop.")
				.setSmallIcon(R.drawable.ic_launcher)
				.setContentIntent(pIntent);

		Notification noti = notiBuilder.build();
		// Hide the notification after its selected
		noti.flags |= Notification.FLAG_NO_CLEAR;
		notiManager.notify(0, noti); 
	}

	public void cancelNoti(){
		notiManager.cancel(0);
	}
}
