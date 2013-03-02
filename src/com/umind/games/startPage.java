package com.umind.games;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

// http://developer.android.com/training/basics/firstapp/starting-activity.html
// Open new activity for DisplayNewGame with a button for stop/back to menu  

// write a class for setting a game: choose number of series and their (f,l,step)
//when game begins show description for each seria at the top and also show the first vector

public class startPage extends Activity {
    /** Called when the activity is first created. */
	public final static String EXTRA_MESSAGE_START_A_GAME = "com.umind.games.EXTRA_MESSAGE_START_A_GAME";
	public final static String EXTRA_MESSAGE_MATH_GAME    = "com.umind.games.EXTRA_MESSAGE_MATH_GAME";
	public final static String EXTRA_MESSAGE_MEMORY_GAME  = "com.umind.games.EXTRA_MESSAGE_MEMORY_GAME";
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);    
    	setContentView(R.layout.main);
    	//setContentView(R.layout.layout2);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    
    public void seriesGame(View view){
    	Intent intent = new Intent(this, SeriesGame.class);
    	TextView textView = (TextView) findViewById(R.id.edit_message);
    	intent.putExtra(EXTRA_MESSAGE_START_A_GAME,textView.getText().toString());
    	startActivity(intent);
    	//will have to change the button to point to game chooser activity    	
    }
    
    public void mathGame(View view){
    	Intent intent = new Intent(this, MathGame.class);
    	TextView textView = (TextView) findViewById(R.id.edit_message);
    	intent.putExtra(EXTRA_MESSAGE_MATH_GAME,textView.getText().toString());
    	startActivity(intent);
    }
    
    public void memoryGame (View view){
    	Intent intent = new Intent(this, MemoryGame.class);
    	TextView textView = (TextView) findViewById(R.id.edit_message);
    	intent.putExtra(EXTRA_MESSAGE_MEMORY_GAME,textView.getText().toString());
    	startActivity(intent);
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
        case R.id.sound:         
             Toast.makeText(startPage.this, "Chosen", Toast.LENGTH_SHORT).show();
             SeriesGame sg = new SeriesGame();
             sg.startOver(null);
            return true;
        case R.id.about:
        	Toast.makeText(startPage.this, "This is all that there is for now", Toast.LENGTH_LONG).show();
            return true;
        default:
            return super.onOptionsItemSelected(item);
        }
    }
    

    
}