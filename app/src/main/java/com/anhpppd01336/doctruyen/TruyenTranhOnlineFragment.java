package com.anhpppd01336.doctruyen;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.anhpppd01336.doctruyen.Adapter.TruyenChuOnlineAdapter;
import com.anhpppd01336.doctruyen.Xml.XmlTruyenTranhOnline;

import static com.anhpppd01336.doctruyen.Xml.XmlTruyenTranhOnline.arrTruyen;


/**
 * A simple {@link Fragment} subclass.
 */
public class TruyenTranhOnlineFragment extends ListFragment {


    public TruyenTranhOnlineFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_truyen_tranh_online, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ProgressDialog progress = ProgressDialog.show(getActivity(), "", "Đang tải ...", true);
        ConnectivityManager connManager = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo mWifi = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

        if (mWifi.isConnected()) {
            String finalUrl = "http://blogtruyen.com/rss/home.html";
            XmlTruyenTranhOnline obj = new XmlTruyenTranhOnline(finalUrl);
            obj.fetchXML();

            while (obj.parsingComplete) ;
            progress.dismiss();
            TruyenChuOnlineAdapter truyenChuOnlineAdapter = new TruyenChuOnlineAdapter(arrTruyen, getActivity());
            getListView().setAdapter(truyenChuOnlineAdapter);

            getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Bundle bundle = new Bundle();
                    bundle.putString("title", arrTruyen.get(position).getTenTruyen());
                    bundle.putString("tomtat", arrTruyen.get(position).getTomTatTruyen());
                    bundle.putString("image", arrTruyen.get(position).getBiaTruyen());
                    bundle.putString("link", arrTruyen.get(position).getLinkTruyen());
                    bundle.putString("type", "online");


                    Intent intentThongTinTruyen = new Intent(getActivity(), ThongTinTruyen.class);
                    intentThongTinTruyen.putExtras(bundle);
                    startActivity(intentThongTinTruyen);
                }
            });
        }else {
            progress.dismiss();
            Toast.makeText(getActivity(), "Xin vui lòng bật mạng !", Toast.LENGTH_SHORT).show();
        }
    }
}
