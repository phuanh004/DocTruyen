package com.anhpppd01336.doctruyen.Adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.anhpppd01336.doctruyen.Data.DanhSachTruyen;
import com.anhpppd01336.doctruyen.R;

import java.util.ArrayList;

/**
 * Created by Anh Pham on 01/10/2015.
 */
public class ListTruyenAdapter extends BaseAdapter {

    TextView tvTitle, tvTomTat;
    ImageView imgBiaTruyen;

    private ArrayList<DanhSachTruyen> mListTruyen = new ArrayList<>();
    private Context mContext;

    public ListTruyenAdapter(ArrayList<DanhSachTruyen> mListTruyen, Context mContext) {
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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            LayoutInflater inflater;
            inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_listview_truyen, null);
        }

        tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
        tvTomTat = (TextView) convertView.findViewById(R.id.tvTomTat);
        imgBiaTruyen = (ImageView) convertView.findViewById(R.id.imgBiaTruyen);
        Typeface customFont = Typeface.createFromAsset(mContext.getAssets(), "fonts/MyriadPro.ttf");

        DanhSachTruyen truyen = mListTruyen.get(position);
        tvTitle.setTypeface(customFont);
        if(truyen.getTenTruyen().length()>=22) {
            tvTitle.setText(truyen.getTenTruyen().substring(0,22) + "...");
        }else {
            tvTitle.setText(truyen.getTenTruyen() + "");
        }
        tvTomTat.setText(truyen.getTomTatTruyen().substring(0,150)+"...");
        for(int i=0;i<mListTruyen.size();i++) {
            if (position == i) {
                String uri = "drawable/biatruyen"+ i;
                int imageResource = mContext.getResources().getIdentifier(uri, null, mContext.getPackageName());
                imgBiaTruyen.setImageResource(imageResource);
            }
        }

        return convertView;
    }
}
