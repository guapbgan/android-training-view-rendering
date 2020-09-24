package com.example.demo11_viewrendering;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class MyView extends View {
    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private Paint paint = new Paint();
    private static final String DESCRIPTION = "aaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbbbbbvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvccccccccccccc";

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        canvas.translate(50,300);//可以移動整個Canvas
//        canvas.rotate(40);//順時針轉,根據原點
        canvas.rotate(40, 500,500);//順時針轉,根據指定點

//        canvas.scale(1.5f,0.8f);//放大縮小
        paintBackground(canvas);
        paint1(canvas);
        paint2(canvas);
        paint3(canvas);
        paint4(canvas);
        paint5(canvas);
        paint6(canvas);
    }

    private void paint6(Canvas canvas) {
        paint.setColor(Color.BLACK);
        paint.setTextSize(40);
        Path path = new Path();
        path.moveTo(0,0);

        path.quadTo(1000,-50, 800, 1800);

        canvas.drawTextOnPath(DESCRIPTION, path, 0,0, paint);
    }

    private void paint5(Canvas canvas) {
        for(int i = 0; i < 10; i++){
            paint.setColor(Color.argb(255, 0, 255 - 25 * i, 0 + 25 * i));
            paint.setStrokeWidth(4.0f);
            paint.setStyle(Paint.Style.STROKE);
            Path path = new Path();
            path.moveTo(150,150);
            path.quadTo(500,-150 + 50 * i,850,150);//可畫出貝氏曲線,x1 y1為中間參考點，x2 y2為終點
            canvas.drawPath(path, paint);
        }


    }

    private void paint4(Canvas canvas) {
        paint.setColor(Color.RED);
        Path path = new Path();
        path.moveTo(150,150);
        path.lineTo(150,350);
        path.lineTo(550,150);
        path.lineTo(550,350);
        path.close(); //會從終點連回起點
        canvas.drawPath(path,paint);
    }

    private void paint3(Canvas canvas) {
        paint.setColor(Color.GRAY);
        paint.setStrokeWidth(16.0f);

        paint.setStrokeCap(Paint.Cap.BUTT);
        canvas.drawLine(100,100,100,500, paint);
        canvas.drawLine(100,500,500,500, paint);
        paint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawLine(140,60,140,460, paint);
        canvas.drawLine(140,460,540,460, paint);
        paint.setStrokeCap(Paint.Cap.SQUARE);
        canvas.drawLine(180,20,180,420, paint);
        canvas.drawLine(180,420,580,420, paint);
    }

    private void paint2(Canvas canvas) {
        paint.setColor(Color.RED);
        RectF rectF = new RectF();
        rectF.set(50,450,400,600);
        canvas.drawArc(rectF,0,90,false,paint);
        canvas.drawArc(rectF,0,90,true,paint);

        rectF.set(50,650,400,800);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(4.0f);
        canvas.drawArc(rectF,0,90,false, paint);
        canvas.drawArc(rectF,180,90,true, paint);
    }

    private void paint1(Canvas canvas) {
        paint.setColor(Color.BLUE);
        canvas.drawCircle(100, 100, 100, paint);
        paint.setAntiAlias(true);
        canvas.drawCircle(300, 100, 100, paint);

        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE); //筆順
        paint.setStrokeWidth(8.0f);
        RectF rectF = new RectF();

        rectF.set(50, 50, 400, 200);
        canvas.drawOval(rectF, paint);

        rectF.set(50, 250, 400, 200);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawOval(rectF, paint);

//        rectF.set(50, 450, 400, 200);
//        paint.setStyle(Paint.Style.STROKE); //筆順
//
//        canvas.drawRect(rectF, paint);
    }

    private void paintBackground(Canvas canvas) {
        paint.setColor(Color.YELLOW);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawPaint(paint);
    }
}
