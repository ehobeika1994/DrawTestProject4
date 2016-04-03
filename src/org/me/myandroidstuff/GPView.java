package org.me.myandroidstuff;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Message;
import android.view.View;

public class GPView extends View implements Runnable
{
	private Canvas canvas;
    private Bitmap bitmap;
    private Paint myPaint;
    private int radius;
    private boolean up;
 
    public GPView(Context context) 
    {
        super(context);
        radius = 30;
        up = true;
    }    
 
    protected void onSizeChanged(int curw, int curh, int oldw, int oldh) 
    {
        if (bitmap != null) 
        {
            bitmap .recycle();
        }
        canvas= new Canvas();
        bitmap = Bitmap.createBitmap(curw, curh, Bitmap.Config.ARGB_8888);
        canvas.setBitmap(bitmap);
    }
    public void destroy() 
    {
        if (bitmap != null) 
        {
            bitmap.recycle();
        }
    }
    public void onDraw(Canvas canvas) 
    {
      //draw onto the canvas
        myPaint = new Paint();
        myPaint.setStrokeWidth(3);
        myPaint.setColor(Color.rgb(249, 74, 50));
        canvas.drawCircle(170, 140, radius, myPaint);
        canvas.drawColor(Color.TRANSPARENT);
        
        Thread bthread = new Thread(this);
        bthread.start();
              
    }

	@Override
	public void run() 
	{
		// TODO Auto-generated method stub
		if (radius < 60 && up == true)
		{
			radius = radius + 1;
		}
		else if (radius == 60)
		{
			up = false;
			radius = radius - 1;
		}
		else if (radius > 30 && up == false)
		{
			radius = radius -1;			
		}
		else if (radius == 30)
		{
			up = true;
		}
		
		handler.sendEmptyMessage(0);
	}
	
	private Handler handler = new Handler()
	{
		public void handleMessage(Message msg)
		{
			invalidate();
		}
	};

} // End of class
