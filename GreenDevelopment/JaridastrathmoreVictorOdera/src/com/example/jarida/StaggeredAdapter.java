package com.example.jarida;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.jarida.loader.ImageLoader;
import com.example.jarida.views.ScaleImageView;


public class StaggeredAdapter extends ArrayAdapter<String> {

	private ImageLoader mLoader;

	public StaggeredAdapter(Context context, int textViewResourceId,
			String[] objects) {
		super(context, textViewResourceId, objects);
		mLoader = new ImageLoader(context);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		ViewHolder holder;

		if (convertView == null) {
			LayoutInflater layoutInflator = LayoutInflater.from(getContext());
			convertView = layoutInflator.inflate(R.layout.row_staggered_demo,
					null);
			holder = new ViewHolder();
			holder.imageView = (ScaleImageView) convertView .findViewById(R.id.imageView1);
			
			convertView.setTag(holder);
		}

		holder = (ViewHolder) convertView.getTag();
		holder.imageView.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Toast.makeText(getContext(), "Hey buddy?", Toast.LENGTH_LONG).show();
				/*HomeActivity.startActivity(new Intent("com.jarida.ulipo.activity_main"));*/
				v.getContext().startActivity( new Intent( v.getContext(), NewsPaperViewActivity.class ) );
			}
			
		});
		mLoader.DisplayImage(getItem(position), holder.imageView);
		
		return convertView;
	}

	static class ViewHolder {
		ScaleImageView imageView;
	}
}

