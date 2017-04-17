package com.bwie.text.fenghujie20170417;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.bwie.text.fenghujie20170417.adapter.MyBaseAdapter;
import com.bwie.text.fenghujie20170417.adapter.RSimperAdapter;
import com.bwie.text.fenghujie20170417.bean.Bean;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recycler;
    private List<String> list = new ArrayList<>();
    private List<Bean> list_ = new ArrayList<>();
    private ListView listView;
    private Button bt_quanxuan;
    private Button bt_fanxuan;
    private boolean ischeck;
    private boolean bbb;
    private MyBaseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycler = (RecyclerView) findViewById(R.id.recycler);
        listView = (ListView) findViewById(R.id.listView);
        bt_quanxuan = (Button) findViewById(R.id.bt_quanxuan);
        bt_fanxuan = (Button) findViewById(R.id.bt_fanxuan);
        for (int i = 0; i < 20; i++) {
            list.add("item");
        }
        recycler.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));
        recycler.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.HORIZONTAL_LIST));
        recycler.setAdapter(new RSimperAdapter(this,list));
        for (int i = 0; i < 200; i++) {
            list_.add(new Bean(""+i));
        }

        bt_quanxuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //只需要对象
                for (int i = 0; i < list_.size(); i++) {
                    //全选
                    list_.get(i).setIscheck(true);
                }
                //刷新
                adapter.notifyDataSetChanged();
            }
        });
        adapter = new MyBaseAdapter(this, list_);
        listView.setAdapter(adapter);
        setListViewHeightBasedOnChildren(listView);


    }
    //反选
    public void bt_fanxuan(View view) {
        //只需要对象
        for (int i = 0; i < list_.size(); i++) {
            //全选
//            productList.get(i).setChecked(false);
            list_.get(i).setIscheck(!list_.get(i).ischeck());
        }
        //刷新
        adapter.notifyDataSetChanged();

    }

    //获取listView的高度
    public static void setListViewHeightBasedOnChildren(ListView listView) {
        // 获取ListView对应的Adapter
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            // pre-condition
            return;
        }

        int totalHeight = 0;
        for (int i = 0, len = listAdapter.getCount(); i < len; i++) { // listAdapter.getCount()返回数据项的数目
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0); // 计算子项View 的宽高
            totalHeight += listItem.getMeasuredHeight(); // 统计所有子项的总高度
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight
                + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        // listView.getDividerHeight()获取子项间分隔符占用的高度
        // params.height最后得到整个ListView完整显示需要的高度
        listView.setLayoutParams(params);
    }

}
