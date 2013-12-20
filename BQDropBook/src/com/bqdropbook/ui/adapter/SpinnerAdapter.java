package com.bqdropbook.ui.adapter;

import com.bqdropbook.ui.activities.R;

import android.content.Context;
import android.widget.ArrayAdapter;

public class SpinnerAdapter {
	
	public SpinnerAdapter(Context context){
		ArrayAdapter adapter = ArrayAdapter.createFromResource(context, 
				R.array.library_spinner, android.R.layout.simple_spinner_item); 
	}
	
	
}
