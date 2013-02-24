package com.umind.games;

public class Seria {
	private String description;
	private int firstElement;
	private int lastElement;
	private int step;
	private int currentElement;
	private int index=0;
	
	public final static String SERIA_COMPLETED="-";
	public Seria(int f, int l, int s){
		setFirstElement(f);
		setLastElement(l);
		setStep(s);
		setCurrentElement(firstElement);
	}
	
	public int getIndex(){
		return index;
	}
	public boolean isNextIsLast(){
		if ( (currentElement + step) >= lastElement) {
			return true;
		}
		else 
			return false;
	}
	public String getNextElement(){
		int next = getCurrentElement()+getStep();
		if (isNextIsLast()){
			return SERIA_COMPLETED;
		}
		else {
			index++;
			setCurrentElement(next);
			return ""+next;
		}
		
	}
	public void setStep(int s){
		step=s;
	}
	public void setLastElement(int l){
		lastElement=l;
	}
	public void setFirstElement(int f){
		firstElement=f;
	}
	public int getStep(){
		return step;
	}
	public int getFirstElement(){
		return firstElement;
	}
	public int getLastElement(){
		return lastElement;
	}
	public String getDescription(){
		return description;
	}
	public void setCurrentElement(int c){
		currentElement=c;
	}
	public int getCurrentElement(){
		return currentElement;
	}
}
