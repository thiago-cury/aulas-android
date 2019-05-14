package thiagocury.eti.br.extablayoutviewpagerfragment.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import thiagocury.eti.br.extablayoutviewpagerfragment.FragItem1;
import thiagocury.eti.br.extablayoutviewpagerfragment.FragItem2;
import thiagocury.eti.br.extablayoutviewpagerfragment.FragItem3;

public class PageAdapter extends FragmentPagerAdapter {

    private int numTabs;

    public PageAdapter(FragmentManager fm, int numTabs) {
        super(fm);
        this.numTabs = numTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new FragItem1();
            case 1:
                return new FragItem2();
            case 2:
                return new FragItem3();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numTabs;
    }
}