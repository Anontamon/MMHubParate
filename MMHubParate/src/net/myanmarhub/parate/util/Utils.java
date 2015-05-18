package net.myanmarhub.parate.util;

import android.content.Context;
import android.graphics.Typeface;

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

public class Utils {

	public static Typeface getFont(Context context){
		return Typeface.createFromAsset(context.getAssets(), "fonts/hub.ttf");
	}
	
	
}
