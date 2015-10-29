package com.anhpppd01336.doctruyen.TruyenVuaDoc;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.anhpppd01336.doctruyen.Adapter.TruyenChuOnlineAdapter;
import com.anhpppd01336.doctruyen.Data.DanhSachTruyenOnline;
import com.anhpppd01336.doctruyen.R;
import com.anhpppd01336.doctruyen.Sqlite.DatabaseHandler;
import com.anhpppd01336.doctruyen.ThongTinTruyen;

import java.util.ArrayList;


public class TruyenVuaDocOnlineFragment extends ListFragment {

    private ArrayList<DanhSachTruyenOnline> danhSachTruyenOnlines;

    public TruyenVuaDocOnlineFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_truyen_vua_doc_online, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        DatabaseHandler db = new DatabaseHandler(getActivity());
        danhSachTruyenOnlines = db.getAllDataTruyenVuaDocOnline();
        TruyenChuOnlineAdapter truyenChuOnlineAdapter = new TruyenChuOnlineAdapter(danhSachTruyenOnlines, getActivity());
        getListView().setAdapter(truyenChuOnlineAdapter);

        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle = new Bundle();
                bundle.putString("title", danhSachTruyenOnlines.get(position).getTenTruyen());
                bundle.putString("tomtat", danhSachTruyenOnlines.get(position).getTomTatTruyen());
                bundle.putString("image", danhSachTruyenOnlines.get(position).getBiaTruyen());
                bundle.putString("link", danhSachTruyenOnlines.get(position).getLinkTruyen());
                bundle.putString("type", "online");


                Intent intentThongTinTruyen = new Intent(getActivity(), ThongTinTruyen.class);
                intentThongTinTruyen.putExtras(bundle);
                startActivity(intentThongTinTruyen);
            }
        });
    }
}
