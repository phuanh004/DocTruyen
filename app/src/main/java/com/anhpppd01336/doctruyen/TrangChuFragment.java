package com.anhpppd01336.doctruyen;


import android.content.Intent;
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

import com.anhpppd01336.doctruyen.Adapter.ListTruyenAdapter;
import com.anhpppd01336.doctruyen.Data.DanhSachTruyen;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class TrangChuFragment extends ListFragment {

    public static ArrayList<DanhSachTruyen> danhSachTruyen = new ArrayList<>();


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
        ListTruyenAdapter mListTruyenAdapter = new ListTruyenAdapter(danhSachTruyen, getActivity());
        getListView().setAdapter(mListTruyenAdapter);

        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle = new Bundle();
                bundle.putString("title",danhSachTruyen.get(position).getTenTruyen());
                bundle.putString("tomtat", danhSachTruyen.get(position).getTomTatTruyen());
                bundle.putString("image", danhSachTruyen.get(position).getBiaTruyen());

                Intent intentThongTinTruyen = new Intent(getActivity(), ThongTinTruyen.class);
                intentThongTinTruyen.putExtras(bundle);
                startActivity(intentThongTinTruyen);
            }
        });
    }

    private void addTruyen(){
        danhSachTruyen.clear();
        danhSachTruyen.add(new DanhSachTruyen("file:///android_asset/biaTruyen/biatruyen0.png","BLEACH", "Ichigo Kurosaki có khả năng nhìn thấy những hồn ma.Cuộc sống của cậu thay đổi khi cậu gặp Rukia Kuchiki, một Thần Chết và là thành viên của Âm Giới.\n" +
                "\n" +
                "Khi chiến đấu với một yêu quái chuyên đi săn những người có năng lực tâm linh, Rukia đã cho Ichigo mượn sức mạnh của mình để cậu có thể cứu gia đình mình.Nhưng trước sự ngạc nhiên của Rukia, Ichigo đã hấp thu toàn bộ sức mạnh của cô.\n" +
                "\n" +
                "Khi đã trở thành một Thần Chết, Ichigo nhanh chóng biết được rằng thế giới cậu đang sống chứa đầy những linh hồn nguy hiểm, và cùng với Rukia, người đang từ từ khôi phục lại sức mạnh của mình.\n" +
                "\n" +
                "Công việc của Ichigo lúc này là bảo vệ những người vô tội khỏi lũ yêu quái và giúp đỡ những linh hồn tìm được nơi yên nghỉ..."));
        danhSachTruyen.add(new DanhSachTruyen("file:///android_asset/biaTruyen/biatruyen1.png","TƯỚNG DẠ", "Chuyển thể từ tác phẩm Huyền Huyễn cùng tên," + " một trong năm tác phẩm nổi tiếng của Miêu Nị." + " Chuyện phiêu lưu của Ninh Khuyết, một người xuyên việt, " + "thông minh, lạnh lùng, vô sỉ, thủ pháp giết người vô địch, " + "khi đưa Tang Tang (Hạo Thiên) đến Lạn Kha Tự cầu y, đã lãnh ngộ Phật Môn Tứ Đại Thủ Ấn, " + "đột phá thời không, dùng thời gian ngàn năm để trừ sạch trần duyên... Thế giới tu chân được chia làm năm cảnh giới: Sơ Thức, Cảm Thức, Bất Hoặc, Động Huyền, Tri Mệnh. Đột phá được năm cảnh giới phải là Đại Tu Hành Giả có thiên phú kỳ tài..."));
        danhSachTruyen.add(new DanhSachTruyen("file:///android_asset/biaTruyen/biatruyen2.png","AKAKATSUKI!! OTOKOJUKU - SEINEN YO, TAISHI WO IDAKE", "Phần tiếp theo của seri \"sakigake!! otoko'!!\". Nhân vật chính của câu chuyện này là Shishimaru Tsurugi, con trai của Momotaro nhân vật chính trong seri đầu tiên. cùng với đó là hậu duệ của các nhân vật khác, cùng tiếp tục hành trình không mệt mỏi trong ngôi trường Otokojuku"));
    }
}
