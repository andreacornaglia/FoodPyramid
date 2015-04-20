package andreacornaglia.net.foodpyramid;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.os.Build;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;

/**
 * Created by durga on 4/18/15.
 */
public class IdealPyramidView extends SurfaceView implements  SurfaceHolder.Callback
{
    Context mContext;
    SurfaceHolder holder;
    int xMax;
    int yMax;
    int carbValues;
    int vegetables;
    int fruits;
    int dairy;
    int meat;
    int fats;

    public IdealPyramidView(Context ctx, int carbs, int vegs, int fruits, int dairy, int meat, int fats)
    {
        super(ctx);
        mContext = ctx;
        holder = getHolder();
        holder.addCallback(this);
        carbValues = carbs;
        vegetables = vegs;
        this.fruits = fruits;
        this.dairy = dairy;
        this.meat = meat;
        this.fats = fats;

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder)
    {
        Canvas canvas =  holder.lockCanvas();
        onDraw(canvas);
        holder.unlockCanvasAndPost(canvas);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        yMax = canvas.getHeight();
        xMax  = canvas.getWidth();
        int splitheight = yMax/4;

        canvas.drawColor(Color.WHITE);
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(10);
        paint.setStyle(Paint.Style.STROKE);
        //for triangle
        Path path = new Path();
        path.moveTo(0 , yMax);
        path.lineTo(xMax, yMax);
        path.lineTo(xMax/2, 0);
        path.lineTo(0, yMax);
        canvas.drawPath(path, paint);

        //region 1
        path.moveTo(xMax/8, 3*yMax/4);
        path.lineTo((7*xMax)/ 8, 3 * yMax/4);
        canvas.drawPath(path, paint);


        //region 2
        path.moveTo(xMax/4 , yMax/2);
        path.lineTo((3*xMax)/4, yMax/2);
        canvas.drawPath(path, paint);

        //region 3
        path.moveTo((3*xMax)/8 , yMax/4);
        path.lineTo((5*xMax)/8, yMax/4);
        canvas.drawPath(path, paint);

        //region 5 split
        path.moveTo(xMax/2, 3 * yMax/4);
        path.lineTo(xMax / 2, yMax / 2);
        canvas.drawPath(path, paint);

        //region 6 split
        path.moveTo(xMax/2,  yMax/2);
        path.lineTo(xMax/2, yMax/4);
        canvas.drawPath(path, paint);


        //region 1 height


        int[] carbicons = {R.drawable.carbs_bread, R.drawable.carbs_grain, R.drawable.carbs_noodles, R.drawable.carbs_rice};
        int[] vegicons = {R.drawable.veggies_broccoli, R.drawable.veggies_carrot, R.drawable.veggies_carrot, R.drawable.veggies_mushrooms, R.drawable.veggies_onion, R.drawable.veggies_pepper};
        int[] fruitsicons = {R.drawable.fruits_apple, R.drawable.fruits_grapes, R.drawable.fruits_watermelon};
        int[] milkicons = {R.drawable.dairy_milk, R.drawable.dairy_cheese, R.drawable.dairy_smoothie};
        int[] meaticons = {R.drawable.meat_hazelnut, R.drawable.meat_fish};
        int[] faticons = {R.drawable.sweets_cake, R.drawable.sweets_candy, R.drawable.sweets_icecream};

        Bitmap bmp;
        int height = yMax - 20;
        int width = 0;
        height = yMax - 20;
        int imageWidth = 144;

        for(int i =0; i < carbValues; i++)
        {
            bmp = BitmapFactory.decodeResource(getResources(), carbicons[i%carbicons.length]);
            width =  20;
            if(i > FoodDataLab.idealServingValues[0])
            {
                width = 7 * xMax / 8 + 10;
            }
            canvas.drawBitmap(bmp, imageWidth * i + width, height - (bmp.getHeight()), null);
        }
       height = 3 * yMax/4 - 20;
        int count = 0;
        width = xMax/8 + 10;
        for(int i =0; i < vegetables; i++)
        {
            bmp = BitmapFactory.decodeResource(getResources(), vegicons[i%vegicons.length]);
            if(i > FoodDataLab.idealServingValues[1])
            {
                width = 3 * xMax / 4 + 10;
            }
            canvas.drawBitmap(bmp, imageWidth * i + width, height - (bmp.getHeight()), null);
        }
        height = 3 * yMax/4 - 20;
        width = xMax/2;
        for(int i =0; i < fruits; i ++)
        {
            bmp = BitmapFactory.decodeResource(getResources(), fruitsicons[i%fruitsicons.length]);
            if(i > FoodDataLab.idealServingValues[2])
            {
                width = 3 * xMax / 4 + 20;
            }
            canvas.drawBitmap(bmp, imageWidth * i + width, height - (bmp.getHeight()), null);
        }
        height = yMax/2 - 20;
        width = xMax/4;
        dairy = 2;
        for(int i =0; i < dairy; i ++)
        {
            bmp = BitmapFactory.decodeResource(getResources(), milkicons[i%milkicons.length]);
            if(i > FoodDataLab.idealServingValues[3])
            {
                width = 3 * xMax / 4 + 10;
            }
            canvas.drawBitmap(bmp, imageWidth * i + width, height - (bmp.getHeight()), null);
        }
//
//
        width = xMax/2 + 10;
        meat = 2;
        for(int i =0; i < meat; i ++)
        {
            bmp = BitmapFactory.decodeResource(getResources(), meaticons[i%meaticons.length]);
            if(i > FoodDataLab.idealServingValues[4])
            {
                width = 5 * xMax / 8 + 10;
            }
           canvas.drawBitmap(bmp, imageWidth * i  + width, height - (bmp.getHeight()), null);
        }
        height = yMax/4 - 20;
        width = 3 * (xMax/8) + 20;
        for(int i =0; i < fats; i ++)
        {
            bmp = BitmapFactory.decodeResource(getResources(), faticons[i%faticons.length]);

            if(i > FoodDataLab.idealServingValues[5])
            {
                width =  xMax / 2 + 10;
            }
            canvas.drawBitmap(bmp, imageWidth * i + 1 + width, height - (bmp.getHeight()), null);
        }



//        i = 1;
//        path.moveTo(cwidth - (splitheight * (i + 1)), cheight - (splitheight * (i + 1)));
//        path.lineTo(cwidth - (splitheight * i), cheight - (splitheight * i));
//        path.lineTo(cwidth - (splitheight * (i + 1)), cheight - (splitheight * (i + 1)));
//        path.lineTo(splitheight * (i + 1), cheight - (splitheight * (i + 1)));
//        path.lineTo(splitheight, cheight);




//        for(int i =0; i < 3; i++)
//        {
//            path.lineTo(splitheight * i, splitheight * i);
//            path.lineTo(cwidth - (splitheight * i), splitheight * i);
//            path.lineTo(cwidth - (splitheight * (i + 1)), splitheight * (i + 1));
//            path.lineTo(splitheight * (i + 1), splitheight * (i + 1));
//            canvas.drawPath(path, paint);
//        }
        path.close();
    }

//    public Dictionary<String, RegionArea> Regions(int maxX, int maxY)
//    {
//        HashMap<String, RegionArea> regionsMap = new HashMap<String, RegionArea>();
//        regionsMap.put("Carbohydrates", new RegionArea(new Point(z));
//        //regionsMap.put("Vegetables", )
//
//
//    }


}
