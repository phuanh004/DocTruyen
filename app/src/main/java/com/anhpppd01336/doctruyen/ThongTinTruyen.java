package com.anhpppd01336.doctruyen;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.anhpppd01336.doctruyen.Data.BaseActivity;
import com.squareup.picasso.Picasso;

import static com.anhpppd01336.doctruyen.TrangChuFragment.danhSachTruyen;

public class ThongTinTruyen extends BaseActivity {

    TextView tvThongTinTitle, tvThongTinTomTat;
    ImageView imgThongTinBiaTruyen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin_truyen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvThongTinTitle = (TextView) findViewById(R.id.tvThongTinTitle);
        tvThongTinTomTat = (TextView) findViewById(R.id.tvThongTinTomTat);
        imgThongTinBiaTruyen = (ImageView)findViewById(R.id.imgThongTinBiaTruyen);
        Bundle bundle = getIntent().getExtras();

        tvThongTinTitle.setText(bundle.getString("title"));
        tvThongTinTomTat.setText(bundle.getString("tomtat"));
        Picasso.with(this).load(bundle.getString("image")).into(imgThongTinBiaTruyen);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id==android.R.id.home){
            ThongTinTruyen.this.finish();
        }

        return super.onOptionsItemSelected(item);
    }

}
