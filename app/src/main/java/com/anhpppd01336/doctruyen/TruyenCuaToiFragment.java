package com.anhpppd01336.doctruyen;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.anhpppd01336.doctruyen.TruyenCuaToi.ViewPagerAdapter;
import com.astuetz.PagerSlidingTabStrip;


/**
 * A simple {@link Fragment} subclass.
 */
public class TruyenCuaToiFragment extends Fragment {

//    Button btnDir;
//    TextView tvDir;
//    private static final int PICKFILE_RESULT_CODE = 1;


    public TruyenCuaToiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_truyen_cua_toi, container, false);


    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ViewPager viewPager = (ViewPager) getActivity().findViewById(R.id.pager);
        viewPager.setAdapter(new ViewPagerAdapter(getChildFragmentManager()));
        PagerSlidingTabStrip tabs = (PagerSlidingTabStrip) getActivity().findViewById(R.id.tabs);
        tabs.setViewPager(viewPager);

//        btnDir = (Button)getActivity().findViewById(R.id.btnReadSD);
//        tvDir = (TextView)getActivity().findViewById(R.id.tvDir);
//
//        btnDir.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent fileintent = new Intent(Intent.ACTION_GET_CONTENT);
//                fileintent.setType("file/*");
//                try {
//                    startActivityForResult(fileintent, PICKFILE_RESULT_CODE);
//                } catch (ActivityNotFoundException e) {
//                    Log.e("tag", "No activity can handle picking a file. Showing alternatives.");
//                }
//            }
//        });
    }

//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (data == null)
//            return;
//        switch (requestCode) {
//            case PICKFILE_RESULT_CODE:
//                if (resultCode == Activity.RESULT_OK) {
//                    Typeface customFont = Typeface.createFromAsset(getActivity().getAssets(), "fonts/SanFranciscoRegular.ttf");
//                    String FilePath = data.getData().getPath();
//
//                    File file = new File(FilePath);
//                    StringBuilder text = new StringBuilder();
//
//                    try {
//                        BufferedReader br = new BufferedReader(new FileReader(file));
//                        String line;
//
//                        while ((line = br.readLine()) != null) {
//                            text.append(line);
//                            text.append('\n');
//                        }
//                        br.close();
//                    }
//                    catch (IOException e) {
//                        //You'll need to add proper error handling here
//                    }
//                    tvDir.setText(text.toString());
//                    tvDir.setTypeface(customFont);
//                }
//        }
//    }
}
