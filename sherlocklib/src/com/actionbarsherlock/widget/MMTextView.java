package com.actionbarsherlock.widget;

import android.content.Context;
import android.text.Html;
import android.util.AttributeSet;
import android.widget.TextView;

public class MMTextView extends TextView {

	public MMTextView(Context context) {
		super(context);
		if(!isInEditMode()){
			this.setTypeface(Utils.getFont(context));
		}
	}

	public MMTextView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		if(!isInEditMode()){
			this.setTypeface(Utils.getFont(context));
		}
	}

	public MMTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		if(!isInEditMode()){
			this.setTypeface(Utils.getFont(context));
		}
	}
	
	@Override
	public void setText(CharSequence text, BufferType type) {
		if(!isInEditMode()){
			super.setText(Html.fromHtml(MMTokenizer.factory(text.toString())), type);
		}else{
			super.setText(MMTokenizer.factory(text.toString()), type);
		}
	}
}
