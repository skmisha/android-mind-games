package com.umind.games;

public class Seria {
	private String description;
	private int firstElement;
	private int lastElement;
	private int step;
	private int currentElement;
	private int index=0;
	
	public Seria(int f, int l, int s){
		setFirstElement(f);
		setLastElement(l);
		setStep(s);
	}
	
	public int getNextElement(){
		index++;
		return (currentElement+step);
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
