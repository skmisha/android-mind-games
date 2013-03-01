package com.umind.games;

import android.os.Build;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.support.v4.app.NavUtils;

public class SeriesGame extends Activity {

	public final static String START_OVER = "com.umind.games.START_OVER";
	public Seria s = new Seria(0,100,4);
	public TextView tvShowSeries;
	
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_series_game);
		 if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			 // Show the Up button in the action bar.
			 getActionBar().setDisplayHomeAsUpEnabled(true);
		 }
	}
	
    public void startOver(View view){
    	//Intent intent = new Intent(this, ShowGame.class);
    	//TextView textView = (TextView) findViewById(R.id.edit_message);
    	//intent.putExtra(START_OVER,textView.getText().toString());
    	//startActivity(intent);
    }
    
    public void showNext(View view){
    	Log.i("ShowGame.class.showNext "," f:"+s.getFirstElement()+" step:"+s.getStep()+" curr:"+s.getCurrentElement());
    	tvShowSeries = (TextView) findViewById(R.id.mainGameView);
    	tvShowSeries.setText("( " + s.getNextElement()+ " )");
    	tvShowSeries.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.CENTER_VERTICAL);
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_series_game, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
