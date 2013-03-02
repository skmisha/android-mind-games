package com.umind.games;

import java.util.ArrayList;
import java.util.List;
import android.os.Build;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v4.app.NavUtils;

public class SeriesGame extends Activity {

	public final static String START_OVER = "com.umind.games.START_OVER";
	public Seria s = new Seria(0,100,4);
	public TextView tvShowSeries;
	public Button btnShowNext;
	public Button btnGoSeriesGame;
	private Spinner spinner;
	
	
	
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_series_game);
		addItemsOnSpinner();
		addListenerOnSpinnerItemSelection();
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
    
    public void addItemsOnSpinner(){
    	spinner = (Spinner) findViewById(R.id.chooseSeriesNumberSpnr);
    	List<Integer> list = new ArrayList<Integer>();
    	list.add(1);	list.add(2);   	list.add(3);   	list.add(4);
    	list.add(5);	list.add(6);   	list.add(7);   	list.add(8);
    	ArrayAdapter<Integer> dataAdapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item, list);
    		dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    		spinner.setAdapter(dataAdapter);
    }
    
    public void addListenerOnSpinnerItemSelection() {
    	spinner = (Spinner) findViewById(R.id.chooseSeriesNumberSpnr);
    	spinner.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }
    
    public void goSeriesGame (View view){
    	spinner = (Spinner) findViewById(R.id.chooseSeriesNumberSpnr);
    	tvShowSeries = (TextView) findViewById(R.id.mainGameView);
    	btnShowNext = (Button) findViewById(R.id.showNextBtn);
    	btnGoSeriesGame = (Button) findViewById(R.id.GoSeriesGameBtn);
    	
    	 Toast.makeText(this,
    				"Starting series game : " + 
    		                "\n"+ String.valueOf(spinner.getSelectedItem()) +" random series selected",    		             
    					Toast.LENGTH_SHORT).show();
    	spinner.setVisibility(View.GONE);
    	btnGoSeriesGame.setVisibility(View.GONE);
    	tvShowSeries.setVisibility(View.VISIBLE);
    	btnShowNext.setVisibility(View.VISIBLE);
    	
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
