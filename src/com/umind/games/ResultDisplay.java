package com.umind.games;

import java.util.HashMap;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.GridLayout.LayoutParams;
import android.widget.TableRow;
import android.widget.TextView;


public class ResultDisplay extends Activity{
	@SuppressLint("UseSparseArrays")
	private HashMap<Integer,TextView> displayHM = new HashMap<Integer,TextView>();
	private static int maxIndexOfTextViewOnDisplay=1;
	public ResultDisplay()
	{
		Log.i("resultDisplay.class.constructor","started");
	}
/*	public ResultDisplay(int number)
	{		
    	for (int i=1; i<=number; i++)
    	{
    		addTextViewToDisplay();
       	}
    }
	*/
	public void setTextOnTV(TextView tv,Integer idNumber,String str)
	{	 		
		if (displayHM.containsKey(idNumber))
		{
			Log.i("setTextOnTV","display contains key:"+idNumber+" with value:"+str);
			//get TextView from HashMap, update the text and put it back
			tv = displayHM.get(idNumber);
		}
		else  //add new TextView and add it to the display
		{
			Log.i("ResultDisplay.class.setTextOnTV","display doesn't contain key:"+idNumber+" with value:"+str);
			Log.i("ResultDisplay.class.setTextOnTV","will add the key and value pair");
			tv = addTextViewToDisplay(tv);			
		}
		tv.setText(str);
		displayHM.put(idNumber, tv);
	}
	
	public String getTextOnTV(Integer idNumber)
	{
		String str;
		if (displayHM.containsKey(idNumber))
		{
			TextView tv = displayHM.get(idNumber);
			str = tv.getText().toString();
			return str;
		}
		else 
		{
			str="";
			return str;
		}
	}
	
	private TextView addTextViewToDisplay(TextView tv)
	{
	 Log.i("ResultDisplay.class.addTextViewToDisplay","started");
		//setContentView(R.layout.activity_series_game);
	 Log.i("ResultDisplay.class.addTextViewToDisplay","will run findViewById for GridLayout of the result");
   	 	//TextView resultTV = (TextView) findViewById(R.id.mainGameView);
   	 Log.i("ResultDisplay.class.addTextViewToDisplay","initialized TextView to mainGameView, going to set text");
   	 	tv.setText("  ");
   	 	tv.setId(maxIndexOfTextViewOnDisplay);
   	 Log.i("ResultDisplay.class.addTextViewToDisplay","setting layout params to apply it later");
   	    android.widget.TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(LayoutParams.WRAP_CONTENT, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL);     	    
   	    tv.setLayoutParams(layoutParams);
   	 Log.i("ResultDisplay.class.addTextViewToDisplay","applied params");
   	    tv.setTextSize(60);
   	    tv.setBackgroundColor(Color.GRAY);
   	    tv.setTextColor(Color.BLACK);
   	 Log.i("ResultDisplay.class.addTextViewToDisplay","going to add textview to gridview");
   	    //((ViewGroup) v).addView(resultTV);
   	 Log.i("ResultDisplay.class.addTextViewToDisplay","going to put to display hm index:"+maxIndexOfTextViewOnDisplay+" and temp textview");
   	    displayHM.put(Integer.valueOf(maxIndexOfTextViewOnDisplay),tv);
   	    maxIndexOfTextViewOnDisplay++;
   	    return tv;
	}
	 
	public int getMaxIndexOfTextViewOnDisplay()
	{
		return maxIndexOfTextViewOnDisplay;
	}
		
}

// Display is the list of all TextViews in the result pane