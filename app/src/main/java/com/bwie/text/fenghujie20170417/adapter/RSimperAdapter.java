package com.bwie.text.fenghujie20170417.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bwie.text.fenghujie20170417.R;
import com.bwie.text.fenghujie20170417.holder.RSimperHolder;

import java.util.List;

/**
 * Created by dell on 2017/4/17.
 */

public class RSimperAdapter extends RecyclerView.Adapter<RSimperHolder> {
    private Context context;
    private List<String> list;

    public RSimperAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RSimperHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recy_, parent, false);
        RSimperHolder holder = new RSimperHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RSimperHolder holder, final int position) {
        holder.text_recy.setText(list.get(position));
        holder.text_recy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "条目"+position, Toast.LENGTH_SHORT).show();
            }
        });
        holder.text_recy.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage("item"+position);
                builder.show();
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
