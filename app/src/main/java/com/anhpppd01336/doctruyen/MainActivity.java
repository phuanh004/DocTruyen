package com.anhpppd01336.doctruyen;

import android.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.anhpppd01336.doctruyen.Adapter.ListTruyenAdapter;
import com.anhpppd01336.doctruyen.Data.BaseActivity;
import com.anhpppd01336.doctruyen.Data.DanhSachTruyen;


import java.util.ArrayList;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout mDrawerLayout;

    ListView lvDanhSachTruyen;
    private ListTruyenAdapter mListTruyenAdapter;
    static ArrayList<DanhSachTruyen> danhSachTruyen = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        lvDanhSachTruyen= (ListView) findViewById(R.id.lvDanhSachTruyen);
        addTruyen();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void addTruyen(){
        danhSachTruyen.add(new DanhSachTruyen("BLEACH", "Ichigo Kurosaki có khả năng nhìn thấy những hồn ma.Cuộc sống của cậu thay đổi khi cậu gặp Rukia Kuchiki, một Thần Chết và là thành viên của Âm Giới.\n" +
                "\n" +
                "Khi chiến đấu với một yêu quái chuyên đi săn những người có năng lực tâm linh, Rukia đã cho Ichigo mượn sức mạnh của mình để cậu có thể cứu gia đình mình.Nhưng trước sự ngạc nhiên của Rukia, Ichigo đã hấp thu toàn bộ sức mạnh của cô.\n" +
                "\n" +
                "Khi đã trở thành một Thần Chết, Ichigo nhanh chóng biết được rằng thế giới cậu đang sống chứa đầy những linh hồn nguy hiểm, và cùng với Rukia, người đang từ từ khôi phục lại sức mạnh của mình.\n" +
                "\n" +
                "Công việc của Ichigo lúc này là bảo vệ những người vô tội khỏi lũ yêu quái và giúp đỡ những linh hồn tìm được nơi yên nghỉ..."));
        danhSachTruyen.add(new DanhSachTruyen("TƯỚNG DẠ", "Chuyển thể từ tác phẩm Huyền Huyễn cùng tên, một trong năm tác phẩm nổi tiếng của Miêu Nị. Chuyện phiêu lưu của Ninh Khuyết, một người xuyên việt, thông minh, lạnh lùng, vô sỉ, thủ pháp giết người vô địch, khi đưa Tang Tang (Hạo Thiên) đến Lạn Kha Tự cầu y, đã lãnh ngộ Phật Môn Tứ Đại Thủ Ấn, đột phá thời không, dùng thời gian ngàn năm để trừ sạch trần duyên... Thế giới tu chân được chia làm năm cảnh giới: Sơ Thức, Cảm Thức, Bất Hoặc, Động Huyền, Tri Mệnh. Đột phá được năm cảnh giới phải là Đại Tu Hành Giả có thiên phú kỳ tài..."));
        danhSachTruyen.add(new DanhSachTruyen("AKAKATSUKI!! OTOKOJUKU - SEINEN YO, TAISHI WO IDAKE", "Phần tiếp theo của seri \"sakigake!! otoko'!!\". Nhân vật chính của câu chuyện này là Shishimaru Tsurugi, con trai của Momotaro nhân vật chính trong seri đầu tiên. cùng với đó là hậu duệ của các nhân vật khác, cùng tiếp tục hành trình không mệt mỏi trong ngôi trường Otokojuku"));
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

//    private void selectDrawerItem(MenuItem menuItem) {
//        Fragment fragment = null;
//        Class fragmentClass = null;
//        switch (menuItem.getItemId()) {
//            case R.id.nav_trang_chu:
//                fragmentClass = TrangChuFragment.class;
//                break;
//        }
//
//
//        try {
//            fragment = (Fragment) fragmentClass.newInstance();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//
//
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        fragmentManager.beginTransaction().replace(R.id.fragmentTrangChu, fragment).commit();
//
//
//        menuItem.setChecked(true);
//        setTitle(menuItem.getTitle());
//        mDrawer.closeDrawers();
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_trang_chu) {
            lvDanhSachTruyen= (ListView) findViewById(R.id.lvDanhSachTruyen);
            mListTruyenAdapter = new ListTruyenAdapter(danhSachTruyen, this);
            lvDanhSachTruyen.setAdapter(mListTruyenAdapter);

            lvDanhSachTruyen.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intentThongTinTruyen = new Intent(MainActivity.this, ThongTinTruyen.class);
                    intentThongTinTruyen.putExtra("position",position);
                    startActivity(intentThongTinTruyen);
                }
            });
        } else if (id == R.id.nav_kiem_hiep) {

        } else if (id == R.id.nav_lich_su) {

        } else if (id == R.id.nav_ngon_tinh) {

        } else if (id == R.id.nav_quan_su) {

        } else if (id == R.id.nav_tien_hiep) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}