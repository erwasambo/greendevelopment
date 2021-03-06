package com.nas.cuisine;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
 
public class MealsArrayAdapter extends ArrayAdapter<Meal> {

    private Context context;
    private TextView respondentName;
    private List<Meal> meals = new ArrayList<Meal>();
 
    public MealsArrayAdapter(Context context, int viewResourceId, List<Meal> objects) {
        super(context, viewResourceId, objects);
        this.context = context;
        this.meals = objects;
    }
 


	public int getCount() {
        return this.meals.size();
    }
 
    public Meal getItem(int index) {
        return this.meals.get(index);
    }
 
    private class ViewHolder {
    	   TextView idselection;
    	   CheckBox item;
    }
    
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
    	View row = convertView;
        if (row == null) {
           LayoutInflater inflater = (LayoutInflater) this.getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.meallistview_item, parent, false);
            
            holder = new ViewHolder();
            holder.idselection = (TextView) row.findViewById(R.id.txtmeal);
            holder.item = (CheckBox) row.findViewById(R.id.checkBox1);
            row.setTag(holder);
            
            holder.item.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					CheckBox cb = (CheckBox) v;
					Meal mMeal = (Meal) cb.getTag();
					mMeal.setSelected(cb.isChecked());
				}
			});
        }else{
        	holder = (ViewHolder) row.getTag();
        }
        // Get item
        Meal meal = meals.get(position);

        // Get reference to TextView - respondent_name 
        holder.idselection.setText(meal.name);
        holder.item.setChecked(meal.isSelected());
        holder.item.setTag(meal);

        return row;
    }
}


