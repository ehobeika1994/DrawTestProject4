package org.me.myandroidstuff;

import android.app.Activity;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

public class DrawTestProject4Activity extends Activity 
{
	private LinearLayout aviewgroup;
	private GPView aview;
	private Button startButton;
	private Button stopButton;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        aviewgroup = (LinearLayout)findViewById(R.id.topView);
        aview = new GPView(this);
        
        aviewgroup.addView(aview);
        
        Thread thread = new Thread(aview);
        thread.start();
    }
	
}