package com.umind.games;

import java.util.ArrayList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import java.util.Collections;
import java.util.List;
import java.util.Random;

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
	public TextView tvShowSeriesGameDescription;
	public Button btnShowNext;
	public Button btnGoSeriesGame;
	private List<Seria> mainGameSeriaList = new ArrayList<Seria>();
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
    	ArrayAdapter<Integer> dataAdapter = new ArrayAdapter<Integer>(this, 
    			android.R.layout.simple_spinner_item, list);
    		dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    		spinner.setAdapter(dataAdapter);
    	spinner.setSelection(3);	
    }
    
    public void generateSeriesForGame(int numberOfSeries){   	
    	int step = 0;
    	int start = 0;
    	int end = 100;
    	Integer max = 9;
    	Integer min = -9;
    	List<Integer> stepList = new ArrayList<Integer>();
    	for (int i = min; i <= max; i++){
    		if (i != 0 ) {stepList.add(i);}
    		
    	}
    	for (int i=0; i < numberOfSeries; i++){
    		//randomize starting point, ending point, step
    		// create Seria object and add it to the mainGameSeriaList List
    		
    		// 1. create random step in range [-9,9]

   			int n = (int)((double)(stepList.size() * Math.random()));
   			step = stepList.get(n);
   			stepList.remove(n);

    		if (step > 0 ){
    			start = 0;
    			end = 100;
    		}
    		else {
    			start = 100;
    			end = 0;
    		}
    		s = new Seria(start, end, step);
    		mainGameSeriaList.add(s);

    	} // end of foreach 
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
    	tvShowSeriesGameDescription = (TextView) findViewById(R.id.descriptionGameView);
    	Integer number = (Integer) spinner.getSelectedItemPosition() +1;
    	 Toast.makeText(this,
    				"Selected " + 
    		                "\n"+ number +" random series selected",    		             
    					Toast.LENGTH_SHORT).show();
    	spinner.setVisibility(View.GONE);
    	btnGoSeriesGame.setVisibility(View.GONE);
    	//tvShowSeries.setVisibility(View.VISIBLE);
    	btnShowNext.setVisibility(View.VISIBLE);
    	tvShowSeriesGameDescription.setVisibility(View.VISIBLE);
    	((Button) findViewById(R.id.bk_one)).setVisibility(View.VISIBLE);
    	((Button) findViewById(R.id.bk_two)).setVisibility(View.VISIBLE);
    	((Button) findViewById(R.id.bk_three)).setVisibility(View.VISIBLE);
    	((Button) findViewById(R.id.bk_four)).setVisibility(View.VISIBLE);
    	((Button) findViewById(R.id.bk_five)).setVisibility(View.VISIBLE);
    	((Button) findViewById(R.id.bk_six)).setVisibility(View.VISIBLE);
    	((Button) findViewById(R.id.bk_seven)).setVisibility(View.VISIBLE);
    	((Button) findViewById(R.id.bk_eight)).setVisibility(View.VISIBLE);
    	((Button) findViewById(R.id.bk_nine)).setVisibility(View.VISIBLE);
    	((Button) findViewById(R.id.bk_zero)).setVisibility(View.VISIBLE);
    /*	
    	((TextView) findViewById(R.id.L1)).setVisibility(View.VISIBLE);
    	((TextView) findViewById(R.id.L2)).setVisibility(View.VISIBLE);
    	((TextView) findViewById(R.id.L3)).setVisibility(View.VISIBLE);
    	((TextView) findViewById(R.id.L4)).setVisibility(View.VISIBLE);
    	((TextView) findViewById(R.id.L5)).setVisibility(View.VISIBLE);
    	((TextView) findViewById(R.id.L6)).setVisibility(View.VISIBLE);
    	((TextView) findViewById(R.id.L7)).setVisibility(View.VISIBLE);
    	((TextView) findViewById(R.id.L8)).setVisibility(View.VISIBLE);
    	((TextView) findViewById(R.id.L9)).setVisibility(View.VISIBLE);
    	
    */	
    	//((Button) findViewById(R.id.bk_one)).getBackground().setColorFilter(0xFFFF0000, PorterDuff.Mode.MULTIPLY);
    	
    	generateSeriesForGame(spinner.getSelectedItemPosition()+1);
    	showSeriesGameDescription();
    	showFirstSeries();
    	
   }
    
    public void showSeriesGameDescription(){
    	tvShowSeriesGameDescription = (TextView) findViewById(R.id.descriptionGameView);
    	tvShowSeriesGameDescription.setTextSize( 20 ); //Float.valueOf((findViewById(R.string.textSizeForDescription).toString()) ) );
    	String line;
    	String prevLines;
    	for (Seria s : mainGameSeriaList) {
    		line = "\n" + s.getFirstElement() + " .. " + s.getStep() + " .. " + s.getLastElement();
    		prevLines = (String) tvShowSeriesGameDescription.getText();
    		tvShowSeriesGameDescription.setText(prevLines + line);
    	}
    }
    
    public void showFirstSeries(){
    	tvShowSeries = (TextView) findViewById(R.id.mainGameView);
    	String vector = "";
    	for (Seria s : mainGameSeriaList) {
    		vector = vector + " " + s.getFirstElement();
    	}
    	// draw the results
    	tvShowSeries.setTextSize( 60 ) ; //Float.valueOf((findViewById(R.string.textSizeForResults).toString() )  )   );
    	tvShowSeries.setText("( " + vector+  " )");
    	tvShowSeries.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.CENTER_VERTICAL);
    }
    
    public void showNext(View view){
    	Log.i("ShowGame.class.showNext "," f:"+s.getFirstElement()+" step:"+s.getStep()+" curr:"+s.getCurrentElement());
    	tvShowSeries = (TextView) findViewById(R.id.mainGameView);
    	String vector = "";
    	for (Seria s : mainGameSeriaList) {
    		vector = vector + " " + s.getNextElement();
    	}
    	
    	// draw the results
    	tvShowSeries.setText("( " +vector+  " )");
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
