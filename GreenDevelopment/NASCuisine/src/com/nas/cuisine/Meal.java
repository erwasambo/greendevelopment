package com.nas.cuisine;

public class Meal {
	public String id = null; 
	public String name = null; 
	boolean selected  = false;

     public Meal(){
             // TODO Auto-generated constructor stub
     }

     public Meal(String id, String name, boolean selected){
		 this.id = id;
    	 this.name = name;
		 this.selected = selected;
     }

     public boolean isSelected(){
    	 return selected;
     }
     public void setSelected(boolean selected){
    	 this.selected = selected;
     }
     
     @Override
     public String toString(){
             return this.name;
     }
}
