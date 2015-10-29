package com.anhpppd01336.doctruyen.TruyenVuaDoc;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.anhpppd01336.doctruyen.Adapter.TruyenChuOfflineAdapter;
import com.anhpppd01336.doctruyen.Data.DanhSachTruyenOffline;
import com.anhpppd01336.doctruyen.R;
import com.anhpppd01336.doctruyen.Sqlite.DatabaseHandler;
import com.anhpppd01336.doctruyen.ThongTinTruyen;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TruyenVuaDocOfflineFragment extends ListFragment {

    private ArrayList<DanhSachTruyenOffline> danhSachTruyenOfflines;


    public TruyenVuaDocOfflineFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_truyen_vua_doc_offline, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        DatabaseHandler db = new DatabaseHandler(getActivity());
        danhSachTruyenOfflines = db.getAllDataTruyenVuaDocOffline();
        TruyenChuOfflineAdapter truyenChuOnlineAdapter = new TruyenChuOfflineAdapter(danhSachTruyenOfflines, getActivity());
        getListView().setAdapter(truyenChuOnlineAdapter);

        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle = new Bundle();
                bundle.putString("title", danhSachTruyenOfflines.get(position).getTenTruyen());
                bundle.putString("tomtat", danhSachTruyenOfflines.get(position).getTomTatTruyen());
                bundle.putString("image", danhSachTruyenOfflines.get(position).getBiaTruyen());
                bundle.putString("link", danhSachTruyenOfflines.get(position).getNoiDungTruyen());
                bundle.putString("type", "offline");


                Intent intentThongTinTruyen = new Intent(getActivity(), ThongTinTruyen.class);
                intentThongTinTruyen.putExtras(bundle);
                startActivity(intentThongTinTruyen);
            }
        });
    }
}
