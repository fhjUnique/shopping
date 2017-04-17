package com.bwie.text.fenghujie20170417.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.bwie.text.fenghujie20170417.R;
import com.bwie.text.fenghujie20170417.bean.Bean;

import java.util.List;

/**
 * Created by dell on 2017/4/17.
 */
public class MyBaseAdapter extends BaseAdapter {
    private Context context;
    private List<Bean> list;

    public MyBaseAdapter(Context context, List<Bean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        final ViewHold hold;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.list_item, null);
            hold = new ViewHold();
            hold.list_text = (TextView) convertView.findViewById(R.id.text_list);
            hold.list_cb = (CheckBox) convertView.findViewById(R.id.cb_list);
            convertView.setTag(hold);
        } else {
            hold = (ViewHold) convertView.getTag();
        }
        hold.list_text.setText(list.get(position).getText_name());
        hold.list_cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //判断一下当前是否选中
                boolean checked = hold.list_cb.isChecked();
                list.get(position).setIscheck(checked);
            }
        });
        //设置是否选中
        hold.list_cb.setChecked(list.get(position).ischeck());
        return convertView;
    }

    class ViewHold {
        TextView list_text;
        CheckBox list_cb;
    }
}
