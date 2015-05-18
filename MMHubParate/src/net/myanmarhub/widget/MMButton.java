package net.myanmarhub.widget;

import net.myanmarhub.parate.util.MMTokenizer;
import net.myanmarhub.parate.util.Utils;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

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

public class MMButton extends Button {

	public MMButton(Context context) {
		super(context);
		if(!isInEditMode()){
			this.setTypeface(Utils.getFont(context));
		}
	}

	public MMButton(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		if(!isInEditMode()){
			this.setTypeface(Utils.getFont(context));
		}
	}

	public MMButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		if(!isInEditMode()){
			this.setTypeface(Utils.getFont(context));
		}
	}
	
	@Override
	public void setText(CharSequence text, BufferType type) {
		super.setText(MMTokenizer.factory(text.toString()), type);
	}
	
}
