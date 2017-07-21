package com.example.lvk.lvkplay.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.lvk.lvkplay.R;
import com.example.lvk.lvkplay.fragments.dummy.DummyContent;

import java.util.ArrayList;
import java.util.List;

public class MusicLibraryFragment extends Fragment implements AlbumFragment.OnAlbumListFragmentInteractionListener,ArtistFragment.OnArtistListFragmentInteractionListener,SongFragment.OnSongListFragmentInteractionListener {

    private TabLayout tabLayout;
    private ViewPageAdapter viewPageAdapter;
    private ViewPager viewPager;
    public MusicLibraryFragment() {        // Required empty public constructor

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_music_library, container, false);
        tabLayout=(TabLayout) view.findViewById(R.id.tablayout);
        viewPager=(ViewPager)view.findViewById(R.id.viewpager);
//        tabLayout.setupWithViewPager(viewPager);
        setupWithViewPager(viewPager);
        return view;
    }

    private void setupWithViewPager(ViewPager viewPager){
        ViewPageAdapter viewPageAdapter=new ViewPageAdapter(getFragmentManager());
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

    @Override
    public void onArtistListFragmentInteraction(DummyContent.DummyItem item) {

    }

    @Override
    public void onListFragmentInteraction(com.example.lvk.lvkplay.fragments.dummy.dummy.DummyContent.DummyItem item) {

    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

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
