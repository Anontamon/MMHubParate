package com.actionbarsherlock.widget;

import android.content.Context;
import android.graphics.Typeface;

public class Utils {
	
//	public static void share(Context context, String title){
//		Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
//		sharingIntent.setType("text/plain");
//		sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, context.getString(R.string.share_subject));
//		sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, title +
//				" \nCheck this out at:\nhttps://play.google.com/store/apps/details?id=" + context.getPackageName());
//		context.startActivity(Intent.createChooser(sharingIntent, "Share via"));
//		
//	}


	public static Typeface getFont(Context context){
		return Typeface.createFromAsset(context.getAssets(), "fonts/hub.ttf");
	}
	
	
}
