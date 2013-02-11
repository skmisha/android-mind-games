package com.umind.games;

public class Seria {
	private String description;
	private int firstElement;
	private int lastElement;
	private int step;
	public Seria(int f, int l, int s){
		setFirstElement(f);
		setLastElement(l);
		setStep(s);
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
}
