package com.anhpppd01336.doctruyen;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.anhpppd01336.doctruyen.Data.DanhSachTruyenOffline;
import com.anhpppd01336.doctruyen.Data.DanhSachTruyenOnline;
import com.anhpppd01336.doctruyen.Sqlite.DatabaseHandler;
import com.squareup.picasso.Picasso;

public class ThongTinTruyen extends AppCompatActivity {

    TextView tvThongTinTitle, tvThongTinTomTat;
    ImageView imgThongTinBiaTruyen;
    Button btnDocTruyen;
    FloatingActionButton fab;

    private String type, link, title, tomtat, image;
    private DatabaseHandler db = new DatabaseHandler(ThongTinTruyen.this);
    private boolean check, check2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin_truyen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        fab = (FloatingActionButton) findViewById(R.id.fab);

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


//        if (check) {
//            fab.setImageDrawable(getResources().getDrawable(R.drawable.ic_star_24dp));
//            fab.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    db.deleteTruyenVuaDocOnline(title, link);
//                    Snackbar.make(v, "Truyện vừa bị xóa khỏi danh sách yêu thích !", Snackbar.LENGTH_SHORT).show();
//                    check = false;
//                }
//            });
//        }else {
//            fab.setImageDrawable(getResources().getDrawable(R.drawable.ic_star_outline_24dp));
//            fab.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    db.addDataTruyenVuaDocOnline(new DanhSachTruyenOnline(image, title, tomtat, link));
//                    Snackbar.make(v, "Đã thêm vào danh sách yêu thích !", Snackbar.LENGTH_SHORT).show();
//                    check = true;
//                }
//            });
//        }

        btnDocTruyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (type){
                    case "online":
                        Intent intent = new Intent(ThongTinTruyen.this, DocTruyenOnlineActivity.class);
                        intent.putExtra("url", link);
                        startActivity(intent);
                        check = db.isTruyenVuaDocOnlineAvalable(title, link);
                        if (!check) {
                            db.addDataTruyenVuaDocOnline(new DanhSachTruyenOnline(image, title, tomtat, link));
                        }
                        break;
                    case "offline":
                        Intent intentOff = new Intent(ThongTinTruyen.this, DocTruyenOffineActivity.class);
                        intentOff.putExtra("noidungtruyen", link);
                        startActivity(intentOff);
                        check2 = db.isTruyenVuaDocOfflineAvalable(title, image);
                        if (!check2) {
                            db.addDataTruyenVuaDocOffline(new DanhSachTruyenOffline(image, title, tomtat, link));
                        }
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
