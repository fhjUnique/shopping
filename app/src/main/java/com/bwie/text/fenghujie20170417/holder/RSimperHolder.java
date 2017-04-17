package com.bwie.text.fenghujie20170417.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.bwie.text.fenghujie20170417.R;

/**
 * Created by dell on 2017/4/17.
 */

public class RSimperHolder extends RecyclerView.ViewHolder {

    public final TextView text_recy;

    public RSimperHolder(View itemView) {
        super(itemView);
        text_recy = (TextView) itemView.findViewById(R.id.text_recy);
    }
}
