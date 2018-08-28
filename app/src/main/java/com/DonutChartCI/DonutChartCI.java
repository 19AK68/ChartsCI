package com.DonutChartCI;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;

import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import com.example.ak.user.chartsci.R;

import java.util.ArrayList;

public class DonutChartCI extends View {



    private float radius;

    Paint paint;
    Paint shadowPaint;

    Path myPath;
    Path shadowPath;

    RectF outterCircle;
    RectF innerCircle;
    RectF shadowRectF;

    int CHART_FULL_CIRCLE ;

    int CHART_INCOMPLECTE_CIRCLE  ;



    float prDrawCircle;

    float sumTotalMortgage;
    float sumMarketVaule;




    public DonutChartCI(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.DonutChartCI,
                0, 0


        );

        try {
            radius = a.getDimension(R.styleable.DonutChartCI_radius, 180.0f);
        } finally {
            a.recycle();
        }

        paint = new Paint();
        paint.setDither(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setColor(0xffffffff);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(radius / 14.0f);

        shadowPaint = new Paint();
        shadowPaint.setColor(0xffffffff);
        shadowPaint.setStyle(Paint.Style.STROKE);
        shadowPaint.setAntiAlias(true);
        shadowPaint.setStrokeWidth(6.0f);
        shadowPaint.setMaskFilter(new BlurMaskFilter(4, BlurMaskFilter.Blur.SOLID));

        myPath = new Path();
        shadowPath = new Path();


        outterCircle = new RectF();
        innerCircle = new RectF();
        //  shadowRectF = new RectF();

        float adjust = (.019f * radius);
//        shadowRectF.set(adjust, adjust, radius*2-adjust, radius*2-adjust);

        adjust = .038f * radius;
        outterCircle.set(adjust, adjust, radius * 2 - adjust, radius * 2 - adjust);

        adjust = .276f * radius;
        innerCircle.set(adjust, adjust, radius * 2 - adjust, radius * 2 - adjust);




    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);





        // draw shadow
        paint.setShader(null);
        float adjust = (.0095f * radius);
        paint.setShadowLayer(8, adjust, -adjust, 0xffffffff);
        drawDonut(canvas, paint, 0, 359.9f);


        if(CHART_INCOMPLECTE_CIRCLE==1 ){
            float fDrawCircle = (float) (-267.25*prDrawCircle); //267.25
            float fDrawCicle2 = (float) (-267.25-fDrawCircle);
            // green TotalEquity
            setGradient(0xfff4f9ec, 0xfff4f9ec); //#f4f9ec 0xff98CA47

            drawDonut(canvas, paint,(45.0f+92.75f+fDrawCircle*-1), -fDrawCicle2);// drawDonut(canvas,paint, 0,-prTotalEquity);


            setGradient(0xffffffff, 0xff98CA47); //#f4f9ec 0xff98CA47

            drawDonut(canvas, paint, (45.0f+92.75f),-fDrawCircle);// drawDonut(canvas,paint, 0,-prTotalEquity);





            setGradient(0xffffffff, 0xffffffff); //setGradient(0xff4AB6C1,0xff2182AD);
            drawDonut(canvas, paint, 45.0f, 92.75f);

        }

        if(CHART_FULL_CIRCLE==2) {
            float sumTotalEquity  = sumMarketVaule- sumTotalMortgage ;

            float prTotalEquity = ((sumMarketVaule/ sumTotalMortgage) -1 )*180.0f;
            float prTotalMortgage =  (1- prTotalEquity )*180.0f;
            float prMarketVaule =   (sumMarketVaule/sumMarketVaule)*180.0f;






            // green TotalEquity
            setGradient(0xff84BC3D,0xff98CA47);
            drawDonut(canvas,paint, 180,-prTotalEquity);

            //red

            setGradient(0xffe04a2f,0xffFF8C00);
            drawDonut(canvas,paint, 0,180.0f);
           // drawDonut(canvas,paint, prTotalEquity,(180-prTotalEquity));
//
//
//
            setGradient(0xff000000,0xff000000);
            drawDonut(canvas,paint, ((180+prTotalEquity))*-1,prTotalMortgage);

//        // blue
//        setGradient(0xff4AB6C1,0xff2182AD);
//        drawDonut(canvas,paint, 120,60);
//
//        // yellow
//        setGradient(0xffFFFF00,0xfffed325);
//        drawDonut(canvas,paint, 180,180);
        }

    }



    public void drawDonut(Canvas canvas, Paint paint, float start, float sweep) {

        myPath.reset();
        myPath.arcTo(outterCircle, start, sweep, false);
        myPath.arcTo(innerCircle, start + sweep, -sweep, false);
        myPath.close();
        canvas.drawPath(myPath, paint);
    }

    public void setGradient(int sColor, int eColor) {
        paint.setShader(new RadialGradient(radius, radius, radius - 5,
                new int[]{sColor, eColor},
                new float[]{.6f, .95f}, Shader.TileMode.CLAMP));
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int desiredWidth = (int) radius * 2;
        int desiredHeight = (int) radius * 2;

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int width;
        int height;

        //70dp exact
        if (widthMode == MeasureSpec.EXACTLY) {
            width = widthSize;
        } else if (widthMode == MeasureSpec.AT_MOST) {
            //wrap content
            width = Math.min(desiredWidth, widthSize);
        } else {
            width = desiredWidth;
        }

        //Measure Height
        if (heightMode == MeasureSpec.EXACTLY) {
            height = heightSize;
        } else if (heightMode == MeasureSpec.AT_MOST) {
            height = Math.min(desiredHeight, heightSize);
        } else {
            height = desiredHeight;
        }

        //MUST CALL THIS
        setMeasuredDimension(width, height);
    }



    public void setSumTotalMortgage(float sumTotalMortgage) {
        this.sumTotalMortgage = sumTotalMortgage;
    }

    public void setSumMarketVaule(float sumMarketVaule) {
        this.sumMarketVaule = sumMarketVaule;
    }

    public void setCHART_FULL_CIRCLE(int CHART_FULL_CIRCLE) {
        this.CHART_FULL_CIRCLE = CHART_FULL_CIRCLE;
    }

    public void setCHART_INCOMPLECTE_CIRCLE(int CHART_INCOMPLECTE_CIRCLE) {
        this.CHART_INCOMPLECTE_CIRCLE = CHART_INCOMPLECTE_CIRCLE;
    }

    public void setPrDrawCircle(float prDrawCircle) {
        this.prDrawCircle = prDrawCircle;
    }

}


