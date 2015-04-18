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
        } else {
            return new FruitFragment();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int i) {
        if (i == 1) {
            return "Vegetables";
        } else {
            return "Fruits";
        }
    }
}
