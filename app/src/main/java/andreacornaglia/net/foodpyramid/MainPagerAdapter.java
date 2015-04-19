package andreacornaglia.net.foodpyramid;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MainPagerAdapter extends FragmentPagerAdapter {
    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        if (i == 1) {
            return new VegetableFragment();
        } else if (i == 2){
            return new FruitFragment();
        }
        else {
            return new GrainFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int i) {
        if (i == 1) {
            return "Vegetables";
        } else if (i == 2){
            return "Fruits";
        } else {
            return "Grains";
        }
    }
}
