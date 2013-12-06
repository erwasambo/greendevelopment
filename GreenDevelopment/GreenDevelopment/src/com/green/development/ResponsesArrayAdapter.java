package com.green.development;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
 
public class ResponsesArrayAdapter extends ArrayAdapter<Response> {

    private Context context;
    private ImageView responseIcon;
    private TextView respondentName;
    private List<Response> responses = new ArrayList<Response>();
 
    public ResponsesArrayAdapter(Context context, int viewResourceId,
            List<Response> objects) {
        super(context, viewResourceId, objects);
        this.context = context;
        this.responses = objects;
    }
 
    public int getCount() {
        return this.responses.size();
    }
 
    public Response getItem(int index) {
        return this.responses.get(index);
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
            row = inflater.inflate(R.layout.managelistview_item, parent, false);
            
            holder = new ViewHolder();
            holder.idselection = (TextView) row.findViewById(R.id.txtrespondent);
            holder.item = (CheckBox) row.findViewById(R.id.checkBox1);
            row.setTag(holder);
            
            holder.item.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					CheckBox cb = (CheckBox) v;
					Response resp = (Response) cb.getTag();
					resp.setSelected(cb.isChecked());
					//resp.setSelected(cb.isChecked());
				}
			});
        }else{
        	holder = (ViewHolder) row.getTag();
        }
        
        
        // Get item
        Response response = responses.get(position);

        // Get reference to TextView - respondent_name 
        holder.idselection.setText(response.name);
        holder.item.setChecked(response.isSelected());
        holder.item.setTag(response);
        
        // Get reference to ImageView
        responseIcon = (ImageView) row.findViewById(R.id.imgRespondent);
        String imgFilePath = response.resourceFilePathId; // this is something like "/storage/emulated/0/greendev/Q0DSL1T.jpg";
        
        File imgFile  = new File(imgFilePath);
        if(imgFile.exists()){
    		
    		Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
    		 responseIcon.setImageBitmap(myBitmap);
    		
    	}


        return row;
    }
}


