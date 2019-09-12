package com.kumararaja.techaptitude.Utilities;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;

public class RoundedImage {

    Context context;
    Bitmap bitmap,squaredBitmap;
    Canvas canvas;
    Paint paint;
    int size,x,y;
    float r;
    BitmapShader shader;

    public RoundedImage(Context context){
        this.context=context;

    }

    public Bitmap transform(Bitmap source){
        try {
            size=Math.min(source.getWidth(),source.getHeight());
            x=(source.getWidth()-size)/2;
            y=(source.getHeight()-size)/2;
            squaredBitmap=Bitmap.createBitmap(source,x,y,size,size);
            bitmap=Bitmap.createBitmap(size,size,squaredBitmap.getConfig());
            canvas=new Canvas(bitmap);
            paint=new Paint();
            shader=new BitmapShader(squaredBitmap,BitmapShader.TileMode.CLAMP,BitmapShader.TileMode.CLAMP);
            paint.setShader(shader);
            paint.setAntiAlias(true);
            r=size/2f;
            canvas.drawCircle(r,r,r,paint);
            return bitmap;
        } catch (Exception ignored){

        } return bitmap;//BitmapFactory.decodeResource(context.getResources(),R.drawable.);
    }
}
