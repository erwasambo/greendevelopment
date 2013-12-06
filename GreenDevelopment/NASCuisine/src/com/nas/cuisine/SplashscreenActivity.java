package com.nas.cuisine;




import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.view.animation.AnimatorProxy;

public class SplashscreenActivity extends Activity {
	
	ImageView mylogo;
    AnimatorProxy imgProxy;
    PathEvaluator mEvaluator = new PathEvaluator();
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);  

		mylogo = (ImageView) findViewById(R.id.imgsubmitsurvy);
        imgProxy = AnimatorProxy.wrap(mylogo);
		
		// Set up the path we're animating along
		AnimatorPath path = new AnimatorPath();
		path.moveTo(0, 100);
		path.lineTo(0, -300);
		path.curveTo(100, 333, 222, -900, 20, -10);
		
		 // Set up the animation
        final ObjectAnimator anim = ObjectAnimator.ofObject(this, "buttonLoc",
                new PathEvaluator(), path.getPoints().toArray());
        anim.setDuration(1500);
        anim.start();
		
        Thread Timer = new Thread(){
        	
        	@Override
			public void run(){
        		try{
        			
        			sleep(4000);
        			startActivity(new Intent(SplashscreenActivity.this, LoginActivity.class));
        			
        		}
        		
        		catch (InterruptedException e){
        			e.printStackTrace();
        		}
        		finally{
        			finish();
        		}
        	}
        };
        Timer.start();
  
	}

    /**
     * We need this setter to translate between the information the animator
     * produces (a new "PathPoint" describing the current animated location)
     * and the information that the button requires (an xy location). The
     * setter will be called by the ObjectAnimator given the 'buttonLoc'
     * property string.
     */
    public void setButtonLoc(PathPoint newLoc) {
    	imgProxy.setTranslationX(newLoc.mX);
    	imgProxy.setTranslationY(newLoc.mY);
    }
    
    
}
