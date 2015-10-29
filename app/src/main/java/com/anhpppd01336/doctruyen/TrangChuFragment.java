package com.anhpppd01336.doctruyen;


import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.anhpppd01336.doctruyen.Adapter.TruyenChuOfflineAdapter;
import com.anhpppd01336.doctruyen.Data.DanhSachTruyenOffline;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class TrangChuFragment extends ListFragment {

    public static ArrayList<DanhSachTruyenOffline> danhSachTruyen = new ArrayList<>();


    public TrangChuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_trang_chu, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        addTruyen();
        TruyenChuOfflineAdapter mListTruyenAdapter = new TruyenChuOfflineAdapter(danhSachTruyen, getActivity());
        getListView().setAdapter(mListTruyenAdapter);

        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle = new Bundle();
                bundle.putString("title", danhSachTruyen.get(position).getTenTruyen());
                bundle.putString("tomtat", danhSachTruyen.get(position).getTomTatTruyen());
                bundle.putString("image", danhSachTruyen.get(position).getBiaTruyen());
                bundle.putString("link", danhSachTruyen.get(position).getNoiDungTruyen());
                bundle.putString("type", "offline");
                Log.e("a", danhSachTruyen.get(position).getNoiDungTruyen());

                Intent intentThongTinTruyen = new Intent(getActivity(), ThongTinTruyen.class);
                intentThongTinTruyen.putExtras(bundle);
                startActivity(intentThongTinTruyen);
            }
        });
    }

    private void addTruyen(){
        danhSachTruyen.clear();
        danhSachTruyen.add(new DanhSachTruyenOffline("file:///android_asset/biaTruyen/chuatechivuong.jpg", "CHÚA TỂ CHI VƯƠNG CHƯƠNG 1", tomTat("chuatechivuongc1"), noiDung("chuatechivuongc1")));
        danhSachTruyen.add(new DanhSachTruyenOffline("file:///android_asset/biaTruyen/biatruyen1.png", "TƯỚNG DẠ", "", ""));
        danhSachTruyen.add(new DanhSachTruyenOffline("file:///android_asset/biaTruyen/biatruyen2.png", "c", "c", "c"));
    }

    private String tomTat(String ten) {
        String noidung = "";
        AssetManager am = getActivity().getAssets();
        InputStream is;
        try {
            is = am.open("tomtattruyen/" + ten);
            noidung = readTextFile(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return noidung;
    }

    private String noiDung(String ten) {
        String noidung = "";
        AssetManager am = getContext().getAssets();
        InputStream is;
        try {
            is = am.open("noidungtruyen/" + ten);
            noidung = readTextFile(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return noidung;
    }

    public String readTextFile(InputStream inputStream) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        byte buf[] = new byte[1024];
        int len;
        try {
            while ((len = inputStream.read(buf)) != -1) {
                outputStream.write(buf, 0, len);
            }
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {

        }
        return outputStream.toString();
    }
}
