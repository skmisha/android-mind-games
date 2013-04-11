package com.umind.games;

import java.util.HashMap;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.GridLayout;
import android.widget.GridLayout.LayoutParams;
import android.widget.TableRow;
import android.widget.TextView;


public class ResultDisplay extends Activity{
	@SuppressLint("UseSparseArrays")
	private HashMap<Integer,TextView> displayHM = new HashMap<Integer,TextView>();
	private static int maxIndexOfTextViewOnDisplay=1;
	public ResultDisplay(){}
	public ResultDisplay(int number){		
    	for (int i=1; i<=number; i++){
    		addTextViewToDisplay();
    		/*GridLayout GLayout = (android.widget.GridLayout) findViewById(R.id.resultGridLayout);
       	 	TextView resultTV = new TextView(getBaseContext() );     			 
       	 	resultTV.setText("  ");
       	 	resultTV.setId(i);
       	    android.widget.TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(LayoutParams.WRAP_CONTENT, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL);     	    
       	    resultTV.setLayoutParams(layoutParams);
       	    resultTV.setTextSize(60);
       	    resultTV.setBackgroundColor(Color.GRAY);
       	    resultTV.setTextColor(Color.BLACK);
       	    ((GridLayout) GLayout).addView(resultTV);
       	    displayHM.put(Integer.valueOf(i),resultTV);
       	    */
       	}
       }
	public void setTextOnTV(Integer idNumber,String str)
	{	 	
		if (displayHM.containsKey(idNumber))
		{
			//get TextView from HashMap, update the text and put it back
			TextView tv = displayHM.get(idNumber);
			tv.setText(str);
			displayHM.put(idNumber, tv);
		}
		else  //add new TextView and add it to the display
		{
			addTextViewToDisplay();
		}
	}
	
	private void addTextViewToDisplay()
	{
		GridLayout GLayout = (android.widget.GridLayout) findViewById(R.id.resultGridLayout);
   	 	TextView resultTV = new TextView(getBaseContext() );  			 
   	 	resultTV.setText("  ");
   	 	resultTV.setId(maxIndexOfTextViewOnDisplay);
   	    android.widget.TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(LayoutParams.WRAP_CONTENT, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL);     	    
   	    resultTV.setLayoutParams(layoutParams);
   	    resultTV.setTextSize(60);
   	    resultTV.setBackgroundColor(Color.GRAY);
   	    resultTV.setTextColor(Color.BLACK);
   	    ((GridLayout) GLayout).addView(resultTV);
   	    displayHM.put(Integer.valueOf(maxIndexOfTextViewOnDisplay),resultTV);
   	    maxIndexOfTextViewOnDisplay++;
	}
	 
	public int getMaxIndexOfTextViewOnDisplay()
	{
		return maxIndexOfTextViewOnDisplay;
	}
		
	}

// Display is the list of all TextViews in the result pane