package com.umind.games;

import android.R;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;

public class CustomOnItemSelectedListener implements OnItemSelectedListener {
	 
	  public void onItemSelected(AdapterView<?> parent, View view, int pos,long id) {
		  Integer number = (Integer) parent.getItemAtPosition(pos);
		Toast.makeText(parent.getContext(), 
			number + " series were selected",
			Toast.LENGTH_SHORT).show();
	  }
	 
	  @Override
	  public void onNothingSelected(AdapterView<?> arg0) {
		  Toast.makeText(arg0.getContext(), 
					"Default value is 3",
					Toast.LENGTH_LONG).show();
	  }
	 }