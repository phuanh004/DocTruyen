package com.anhpppd01336.doctruyen;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.anhpppd01336.doctruyen.Data.BaseActivity;
import com.anhpppd01336.doctruyen.Data.DanhSachTruyenOnline;
import com.anhpppd01336.doctruyen.Sqlite.DatabaseHandler;
import com.squareup.picasso.Picasso;

public class ThongTinTruyen extends BaseActivity {

    TextView tvThongTinTitle, tvThongTinTomTat;
    ImageView imgThongTinBiaTruyen;
    Button btnDocTruyen;

    private String type, link, title, tomtat, image;
    private DatabaseHandler db = new DatabaseHandler(ThongTinTruyen.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin_truyen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        tvThongTinTitle = (TextView) findViewById(R.id.tvThongTinTitle);
        tvThongTinTomTat = (TextView) findViewById(R.id.tvThongTinTomTat);
        imgThongTinBiaTruyen = (ImageView)findViewById(R.id.imgThongTinBiaTruyen);
        btnDocTruyen = (Button) findViewById(R.id.btnDocTruyen);

        Bundle bundle = getIntent().getExtras();
        type = bundle.getString("type");
        link = bundle.getString("link");
        title = bundle.getString("title");
        image = bundle.getString("image");
        tomtat = bundle.getString("tomtat");

        tvThongTinTitle.setText(title);
        tvThongTinTomTat.setText(tomtat);
        Picasso.with(this).load(image).into(imgThongTinBiaTruyen);
        if (db.isTruyenVuaDocOnlineAvalable(title,link)) {
            fab.setImageDrawable(getResources().getDrawable(R.drawable.ic_star_24dp));
            db.deleteTruyenVuaDocOnline(title,link);
        }else {
            fab.setImageDrawable(getResources().getDrawable(R.drawable.ic_star_outline_24dp));
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    db.addDataTruyenVuaDocOnline(new DanhSachTruyenOnline(image,title,tomtat,link));
                }
            });
        }

        btnDocTruyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (type){
                    case "online":
                        Intent intent = new Intent(ThongTinTruyen.this, DocTruyenOnlineActivity.class);
                        intent.putExtra("url", link);
                        startActivity(intent);
                        break;
                }
            }
        });
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
