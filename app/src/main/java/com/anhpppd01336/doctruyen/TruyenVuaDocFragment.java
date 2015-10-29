package com.anhpppd01336.doctruyen;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.anhpppd01336.doctruyen.TruyenVuaDoc.ViewPagerAdapter;
import com.astuetz.PagerSlidingTabStrip;


/**
 * A simple {@link Fragment} subclass.
 */
public class TruyenVuaDocFragment extends Fragment {


    public TruyenVuaDocFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_truyen_vua_doc, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ViewPager viewPager = (ViewPager) getActivity().findViewById(R.id.pagerTruyenVuaDoc);
        viewPager.setAdapter(new ViewPagerAdapter(getChildFragmentManager()));
        PagerSlidingTabStrip tabs = (PagerSlidingTabStrip) getActivity().findViewById(R.id.tabsTruyenVuaDoc);
        tabs.setViewPager(viewPager);

    }
}
