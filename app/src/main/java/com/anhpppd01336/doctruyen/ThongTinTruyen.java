package com.anhpppd01336.doctruyen;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.anhpppd01336.doctruyen.Data.BaseActivity;
import com.anhpppd01336.doctruyen.Data.DanhSachTruyen;
import static com.anhpppd01336.doctruyen.MainActivity.danhSachTruyen;

public class ThongTinTruyen extends BaseActivity {

    TextView tvThongTinTitle, tvThongTinTomTat;
    ImageView imgThongTinBiaTruyen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin_truyen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tvThongTinTitle = (TextView) findViewById(R.id.tvThongTinTitle);
        tvThongTinTomTat = (TextView) findViewById(R.id.tvThongTinTomTat);
        imgThongTinBiaTruyen = (ImageView)findViewById(R.id.imgThongTinBiaTruyen);
        int position = getIntent().getExtras().getInt("position");


        tvThongTinTitle.setText(danhSachTruyen.get(position).getTenTruyen());
        tvThongTinTomTat.setText(danhSachTruyen.get(position).getTomTatTruyen());
        String uri = "drawable/biatruyen"+ position;
        int imageResource = getResources().getIdentifier(uri, null, getPackageName());
        imgThongTinBiaTruyen.setImageResource(imageResource);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
