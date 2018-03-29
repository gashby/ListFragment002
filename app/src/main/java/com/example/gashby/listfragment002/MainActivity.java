package com.example.gashby.listfragment002;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.astuetz.PagerSlidingTabStrip;
import com.example.gashby.listfragment002.ItemFragment.OnListFragmentInteractionListener;
import com.example.gashby.listfragment002.dummy.DummyContent;
import com.example.gashby.listfragment002.dummy.GenericPageAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnListFragmentInteractionListener {

    public static String POSITION = "POSITION";
    private ViewPager mPager;
    private PagerSlidingTabStrip tabsStrip;
    private GenericPageAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_fragment);

        // setup viewpager
        mPager = (ViewPager) findViewById(R.id.pager);
        tabsStrip = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        mPagerAdapter = getPagerAdapter(null);
        mPager.setAdapter(mPagerAdapter);
        tabsStrip.setViewPager(mPager);

    }

    public void onListFragmentInteraction(DummyContent.DummyItem item) {
        // The user selected the headline of an article from the HeadlinesFragment
        // Do something here to display that article
    }


    private List<android.support.v4.app.Fragment> buildFragments(Bundle masterData ) {
        List<Fragment> fragments = new ArrayList<Fragment>();

            fragments.add(Fragment.instantiate(this,StudentDetails.class.getName(),masterData));
            fragments.add(Fragment.instantiate(this,StudentInterview.class.getName(),masterData));

        return fragments;
    }


    private GenericPageAdapter getPagerAdapter(Bundle masterObject) {

        int tabIcons[] = {R.drawable.ic_person_black_24dp, R.drawable.ic_insert_comment_black_24dp};
        return new GenericPageAdapter (getSupportFragmentManager(),tabIcons, buildFragments(null), getApplicationContext());
    }




}
