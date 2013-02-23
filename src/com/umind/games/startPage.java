package com.umind.games;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.app.Activity;
import android.widget.Toast;

// http://developer.android.com/training/basics/firstapp/starting-activity.html
// Open new activity for DisplayNewGame with a button for stop/back to menu  

public class startPage extends Activity {
    /** Called when the activity is first created. */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
        case R.id.sound:
           
               	Toast.makeText(startPage.this, "chosen", Toast.LENGTH_SHORT).show();
           
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
    public Seria s = new Seria(0,100,3);
}