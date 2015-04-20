package andreacornaglia.net.foodpyramid;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;

/**
 * Created by durga on 4/18/15.
 */
public class MyPyramidActivity extends FragmentActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        //IdealPyramidView pyramidView = new IdealPyramidView(this, FoodDataLab.idealServingValues[0],FoodDataLab.idealServingValues[1],FoodDataLab.idealServingValues[2],FoodDataLab.idealServingValues[3],FoodDataLab.idealServingValues[4],FoodDataLab.idealServingValues[5]);
        IdealPyramidView pyramidView = new IdealPyramidView(this, FoodDataLab.idealServingValues[0],FoodDataLab.idealServingValues[1],FoodDataLab.idealServingValues[2],FoodDataLab.idealServingValues[3],FoodDataLab.idealServingValues[4],FoodDataLab.idealServingValues[5]);
        setContentView(pyramidView);
    }
}
