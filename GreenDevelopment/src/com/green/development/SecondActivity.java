package com.green.development;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SecondActivity extends Activity
{
	@Override
	protected void onCreate( Bundle savedInstanceState )
	{
		super.onCreate( savedInstanceState );
		setContentView( R.layout.second );
		((Button)findViewById( R.id.BackButton )).setOnClickListener( new OnClickListener()
		{
			@Override
			public void onClick( View v )
			{
				goBack();
			}
		});
	}

	private void goBack()
	{
		finish();
		overridePendingTransition( R.anim.slide_in_right, R.anim.slide_out_right );
	}

	@Override
	public boolean onKeyUp( int keyCode, KeyEvent event )
	{
		if( keyCode == KeyEvent.KEYCODE_BACK )
		{
			goBack();
			return true;
		}
		return super.onKeyUp( keyCode, event );
	}
}
