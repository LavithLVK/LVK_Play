package com.example.lvk.lvkplay.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
//import android.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toolbar;

import com.example.lvk.lvkplay.R;

import java.util.ArrayList;
import java.util.List;

public class MusicLibraryFragment extends Fragment {


    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    public MusicLibraryFragment() {        // Required empty public constructor

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_music_library, container, false);
        Activity activity=getActivity();
//        toolbar=(Toolbar)view.findViewById(R.id.toolbar_library);
//        activity.setActionBar(toolbar);
//        activity.getActionBar().setDisplayHomeAsUpEnabled(true);
        viewPager=(ViewPager)view.findViewById(R.id.viewpager);
            setupWithViewPager(viewPager);
            tabLayout = (TabLayout) view.findViewById(R.id.tablayout);
            tabLayout.setupWithViewPager(viewPager);
        return view;
    }

    private void setupWithViewPager(ViewPager viewPager){
        ViewPageAdapter viewPageAdapter = new ViewPageAdapter(getFragmentManager());
        viewPageAdapter.addFragment(new ArtistFragment(),"ARTISTS");
        viewPageAdapter.addFragment(new AlbumFragment(),"ALBUMS");
        viewPageAdapter.addFragment(new SongFragment(),"SONGS");
        viewPager.setAdapter(viewPageAdapter);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }



    private class ViewPageAdapter extends FragmentStatePagerAdapter {
        FragmentManager fragmentManager;
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPageAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.fragmentManager=fragmentManager;
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment,String title){
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

}
