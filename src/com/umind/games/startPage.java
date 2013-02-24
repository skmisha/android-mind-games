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

public class startPage extends Activity {
    /** Called when the activity is first created. */
	public final static String EXTRA_MESSAGE = "com.umind.games.EXTRA_MESSAGE";
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    public void startGame(View view){
    	Intent intent = new Intent(this, ShowGame.class);
    	TextView textView = (TextView) findViewById(R.id.edit_message);
    	intent.putExtra(EXTRA_MESSAGE,textView.getText().toString());
    	startActivity(intent);
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
        case R.id.sound:
           
               	Toast.makeText(startPage.this, "Chosen", Toast.LENGTH_SHORT).show();
               	ShowGame sg = new ShowGame();
               	sg.startOver(null);
           
            return true;
        case R.id.about:
        	Toast.makeText(startPage.this, "This is all that there is for now", Toast.LENGTH_LONG).show();
            return true;
        default:
            return super.onOptionsItemSelected(item);
        }
    }
    

    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);    
    	setContentView(R.layout.main);
    }
    
}