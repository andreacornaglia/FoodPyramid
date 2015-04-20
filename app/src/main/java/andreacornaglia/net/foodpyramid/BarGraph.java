package andreacornaglia.net.foodpyramid;
import java.util.Calendar;
import java.util.Date;

import org.achartengine.ChartFactory;
import org.achartengine.chart.BarChart.Type;
import org.achartengine.model.CategorySeries;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;

import andreacornaglia.net.foodpyramid.DailyFood;
import andreacornaglia.net.foodpyramid.FoodDataLab;


public class BarGraph
{
    public enum foodGroups  {GRAINS, VEGETABLES, FRUITS, DAIRY, PROTEINS, OTHERS} ;
    public enum daysOfWeek {SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY };
    public Intent getIntent(Context context){
//TODO implement getDay(Date date)
        int dayno = getDayNo(new Date());
        DailyFood avgServValues = FoodDataLab.getFoodLab().getAverageFoodServing(dayno);
        int [] y1 = {avgServValues.getmGrainServing(),
                avgServValues.getmVegServing(),
                avgServValues.getmFruitServing(),
                avgServValues.getmDairyServing(),
                avgServValues.getmProteinServing(),
                avgServValues.getmOthers()};
        String [] x = { "Grains", "Veggies", "Fruits", "Dairy", "Proteins", "Others"};
        CategorySeries seriesAvg = new CategorySeries("Average");
        for(int i = 0; i < y1.length; i++){
            seriesAvg.add(x[i], y1[i]);
        }
        int [] y2 = FoodDataLab.idealServingValues;
        CategorySeries seriesIdeal = new CategorySeries("Ideal");
        for (int i = 0; i < y2.length; i++){
            seriesIdeal.add(x[i], y2[i]);
        }
        XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();
        dataset.addSeries(seriesAvg.toXYSeries());
        dataset.addSeries(seriesIdeal.toXYSeries());
        XYSeriesRenderer renderer1 = new XYSeriesRenderer();
        renderer1.setDisplayChartValues(true);
        renderer1.setChartValuesSpacing((float) 0.5);
        renderer1.setColor(Color.BLUE);
        XYSeriesRenderer renderer2 = new XYSeriesRenderer();
        renderer2.setDisplayChartValues(true);
        renderer2.setChartValuesSpacing((float) 0.5);
        renderer2.setColor(Color.GREEN);
        XYMultipleSeriesRenderer mRenderer = new XYMultipleSeriesRenderer();
        mRenderer.addSeriesRenderer(renderer1);
        mRenderer.addSeriesRenderer(renderer2);
        mRenderer.setChartTitle("Your status");
        mRenderer.setXTitle("Food Groups");
        mRenderer.setYTitle("No of Servings");
        mRenderer.setXLabels(0);
        mRenderer.addXTextLabel(1, "      "+ x[0]);
        mRenderer.addXTextLabel(2, "      "+ x[1]);
        mRenderer.addXTextLabel(3, "      "+x[2]);
        mRenderer.addXTextLabel(4, "      "+x[3]);
        mRenderer.addXTextLabel(5, "      "+x[4]);
        mRenderer.addXTextLabel(6, "      "+x[5]);
        mRenderer.setAxisTitleTextSize((float) 48);
        mRenderer.setLabelsTextSize((float) 48);
        mRenderer.setBackgroundColor(Color.WHITE);
        mRenderer.setMargins(new int[] {200, 50, 10, 50});
        mRenderer.setChartTitleTextSize((float) 48);

        Intent intent = ChartFactory.getBarChartIntent(context, dataset, mRenderer, Type.DEFAULT);
        return intent;
    }
    private int getDayNo(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int dayno = cal.get(Calendar.DAY_OF_WEEK);
        return dayno;
    }

}