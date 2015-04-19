package andreacornaglia.net.foodpyramid;

import android.util.Log;

public class FoodDataLab {
	
	private static final String TAG = "FoodDataLab";
	
	private static FoodDataLab lab;
	private static int[] mGrains =  {3, 4, 5, 6, 7, 6, 0};
	private static int[] mVeg =     {2, 3, 4, 1, 0, 1, 0};
	private static int[] mFruits =  {0, 1, 2, 0, 1, 1, 0};
	private static int[] mDairy =   {2, 2, 2, 3, 4, 2, 0};
	private static int[] mProteins ={1, 2, 1, 2, 0, 1, 0};
	private static int[] mOthers =  {2, 1, 0, 1, 0,  2, 0};
	
	private int dayIndex;
	
	// Ideal Serving values for the particular user
	// Needs to be set as per the age of an individual
	public static final int[] idealServingValues = {6, 3, 2, 4, 3, 1};
	public enum foodGroups  {GRAINS, VEGETABLES, FRUITS, DAIRY, PROTEINS, OTHERS} ;
	
	
	private FoodDataLab(){
		
	}
	
	public static FoodDataLab getFoodLab(){
		
		if (lab == null){
			lab = new FoodDataLab();
		}
		
		return lab;
		
	}
	
	// the method gives the average of each group till the day of the week
	
	public DailyFood getAverageFoodServing(int dayNo){
		DailyFood avgFood = new DailyFood();
		int totalGrainServing = 0;
		int totalVegServing = 0;
		int totalFruitServing = 0;
		int totalDairyServing = 0;
		int totalProteinsServing = 0;
		int totalOthersServing = 0;
		for (int i = 0; i < dayNo; i++){
			totalGrainServing += mGrains[i];
			totalVegServing += mVeg[i];
			totalFruitServing += mFruits[i];
			totalDairyServing += mDairy[i];
			totalProteinsServing += mProteins[i];
			totalOthersServing += mOthers[i];
		}
		avgFood.setmGrainServing((int) Math.ceil((double)(totalGrainServing/dayNo)));
		Log.d(TAG, totalGrainServing + "  " + ((int) Math.ceil((double)(totalGrainServing/dayNo))) );
		avgFood.setmVegServing((int) Math.ceil((double)(totalVegServing/dayNo)));
		avgFood.setmFruitServing((int) Math.ceil((double)(totalFruitServing/dayNo)));
		avgFood.setmDairyServing((int) Math.ceil((double)(totalDairyServing/dayNo)));
		avgFood.setmProteinServing((int) Math.ceil((double)(totalProteinsServing/dayNo)));
		avgFood.setmOthers((int) Math.ceil((double)(totalOthersServing/dayNo)));
		return avgFood;	
		
	}
	
	

}
