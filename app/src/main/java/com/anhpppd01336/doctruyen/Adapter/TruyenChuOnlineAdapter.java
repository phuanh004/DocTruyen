package com.anhpppd01336.doctruyen.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.anhpppd01336.doctruyen.Data.DanhSachTruyenOnline;
import com.anhpppd01336.doctruyen.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Anh Pham on 21/10/2015.
 */
public class TruyenChuOnlineAdapter extends BaseAdapter {
    TextView tvTitle, tvTomTat;
    ImageView imgBiaTruyen;

    private ArrayList<DanhSachTruyenOnline> mListTruyen = new ArrayList<>();
    private Context mContext;

    public TruyenChuOnlineAdapter(ArrayList<DanhSachTruyenOnline> mListTruyen, Context mContext) {
        this.mListTruyen = mListTruyen;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mListTruyen.size();
    }

    @Override
    public Object getItem(int position) {
        return mListTruyen.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            LayoutInflater inflater;
            inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_listview_truyen, null);
        }

        Typeface customFont = Typeface.createFromAsset(mContext.getAssets(), "fonts/MyriadPro.ttf");
        tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
        tvTitle.setTypeface(customFont);
        tvTomTat = (TextView) convertView.findViewById(R.id.tvTomTat);
        imgBiaTruyen = (ImageView) convertView.findViewById(R.id.imgBiaTruyen);

        DanhSachTruyenOnline truyen = mListTruyen.get(position);
        if(truyen.getTenTruyen().length()>=22) {
            tvTitle.setText(truyen.getTenTruyen().substring(0,22) + "...");
        }else {
            tvTitle.setText(truyen.getTenTruyen() + "");
        }
        tvTomTat.setText(truyen.getTomTatTruyen());
        Picasso.with(mContext).load(truyen.getBiaTruyen()).into(imgBiaTruyen);
//        Log.e("adapter "+position,truyen.getBiaTruyen());

        return convertView;
    }
}
