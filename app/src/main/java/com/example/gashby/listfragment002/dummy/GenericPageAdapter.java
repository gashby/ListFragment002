package com.example.gashby.listfragment002.dummy;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.astuetz.PagerSlidingTabStrip;
import com.example.gashby.listfragment002.R;

import java.util.List;

/**
 * Created by gashby on 04.03.2018.
 */

public class GenericPageAdapter extends FragmentStatePagerAdapter implements PagerSlidingTabStrip.IconTabProvider {

    private int tabIcons[] = {R.drawable.ic_launcher_foreground}; // Viewpager Tab Items
    private Context context;
    private List<Fragment> pageViewItemList;


    public GenericPageAdapter(FragmentManager fm, int tabIcons[], List<Fragment> pageViewItemList, Context context) {
        super(fm);
        this.context = context;
        this.tabIcons = tabIcons;
        this.pageViewItemList = pageViewItemList;
    }

    @Override
    public Fragment getItem(int position) {
        return pageViewItemList.get(position);
    }

    @Override
    public int getCount() {
        return pageViewItemList.size();
    }

    @Override
    public int getPageIconResId(int position) {
        return this.tabIcons[position];
    }


    public void add(Class<Fragment> c, String title, Bundle b) {
        pageViewItemList.add(Fragment.instantiate(context, c.getName(), b));
    }
}
