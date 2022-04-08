package com.daelim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.daelim.data.ListData;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<ListData> listData;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        listView = findViewById(R.id.listview);
        initListData();




        listView.setAdapter(new BaseAdapter() {

            Context context = getApplicationContext();
            LayoutInflater layoutgInflater = LayoutInflater.from(context); // XML RESOURC를 메모리에 올려주는

            @Override
            public int getCount() { // 총 ListData Array 크기 얻기
                return listData.size();
            }

            @Override
            public ListData getItem(int i) { // ListData 객체 얻기
                return listData.get(i);
            }

            @Override
            public long getItemId(int i) { // ListData ID 얻기
                return i;
            }

            @Override
            public View getView(int index, View converView, ViewGroup viewGroup) {
                View view = layoutInflater.inflate(R.layout.custom_layout_listview, null);

                ImageView imageView = (ImageView) view.findViewById(R.id.cloth_image);
                TextView tv_name = (TextView) view.findViewById(R.id.cloth_name);
                TextView tv_price = (TextView) view.findViewById(R.id.cloth_price);

                imageView.setImageResource(listData.get(index).getId());
                tv_name.setText(listData.get(index).getName());
                tv_price.setText(listData.get(index).getPrice());

                return view;
            }
        });

    }

    public void initListData() {
        listData = new ArrayList<>();
        listData.add(new ListData(R.drawable.gucci_black_tshirt,"오버사이즈 구찌 빈티지 로고 코튼 티셔츠","700,000원"));
        listData.add(new ListData(R.drawable.gucci_cardi,"케이블 니트 V 넥 스웨터","1,280,000원"));
        listData.add(new ListData(R.drawable.gucci_tra,"테크니컬 저지 재킷","1,650,000원"));
        listData.add(new ListData(R.drawable.gucci_watch,"[G-타임리스] 시계, 38mm","1,400,000원"));
        listData.add(new ListData(R.drawable.gucci_choker,"구찌 스크립트 초커","1,300,000원"));
        listData.add(new ListData(R.drawable.gucci_men_sandle,"남성 GG 캔버스 슬라이드 샌들","620,000원"));
        listData.add(new ListData(R.drawable.gucci_perfume,"[구찌 블룸] 프로푸모 디 피오리, 100ml, 오 드 퍼퓸","201,000원"));

    }

}
