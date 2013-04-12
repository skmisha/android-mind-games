package com.umind.games;

import java.util.ArrayList;
import java.util.List;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SeriesGame extends Activity {

	public final static String START_OVER = "com.umind.games.START_OVER";
	public Seria s = new Seria(0,100,4);
	public TextView tvShowSeries;
	public TextView tvShowSeriesGameDescription;
	public Button btnShowNext;
	public Button btnGoSeriesGame;
	private List<Seria> mainGameSeriaList = new ArrayList<Seria>();
	private ResultDisplay display = new ResultDisplay();
	//private Integer currentResultLabel;	
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
    	list.add(5);	list.add(6);   	list.add(7);   	//list.add(8);
    	ArrayAdapter<Integer> dataAdapter = new ArrayAdapter<Integer>(this, 
    			android.R.layout.simple_spinner_item, list);
    		dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    		spinner.setAdapter(dataAdapter);
    	spinner.setSelection(3);	
    	//TODO : set selection from last choise 
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
    // this method is creating and drawing the game
    public void goSeriesGame (View view){
    	spinner = (Spinner) findViewById(R.id.chooseSeriesNumberSpnr);
    	Integer number = (Integer) spinner.getSelectedItemPosition() +1;
    	tvShowSeries = (TextView) findViewById(R.id.mainGameView);
    	btnShowNext = (Button) findViewById(R.id.showNextBtn);
    	btnGoSeriesGame = (Button) findViewById(R.id.GoSeriesGameBtn);
    	tvShowSeriesGameDescription = (TextView) findViewById(R.id.descriptionGameView);
    	
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

    	//creates Series with specific value for the game
    	generateSeriesForGame(spinner.getSelectedItemPosition()+1);
    	
    	//places description of the game on the place
    	showSeriesGameDescription();
    	
    	showFirstSeries();
    	
   }

    
    public void showFirstSeries()
    {
    	Log.i("SeriaGame.class.showFirstSeries","started");
    	Integer idNumber=1;
    	for (Seria s : mainGameSeriaList) 
    	{
    		Log.i("SeriaGame.class.showFirstSeries","create tv for Seria "+idNumber);
    		TextView tv = (TextView) new TextView (this);
    		Log.i("SeriesGame.class.showFirstSeries","Seria s set to  "+s.getFirstElement());
    		display.setTextOnTV(tv, idNumber, ((Integer) s.getFirstElement()).toString());
    		GridLayout gl = (GridLayout) findViewById(R.id.resultGridLayout);
    		gl.addView(tv);
    		Log.i("SeriaGame.class.showFirstSeries","added view to resultGridLayout successfully");
    		idNumber++;
    	}
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
