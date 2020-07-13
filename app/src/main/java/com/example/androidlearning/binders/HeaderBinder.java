package com.example.androidlearning.binders;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.androidlearning.R;

import mva2.adapter.ItemBinder;
import mva2.adapter.ItemViewHolder;

public class HeaderBinder extends ItemBinder<String, HeaderBinder.ViewHolder> {
    @Override
    public ViewHolder createViewHolder(ViewGroup parent) {
        return new ViewHolder(inflate(parent, R.layout.header_item));
    }

    @Override
    public void bindViewHolder(ViewHolder holder, String item) {
        holder.header.setText(item);
    }

    @Override public int getSpanSize(int maxSpanCount) {
        return maxSpanCount;
    }

    @Override
    public boolean canBindData(Object item) {
        return item instanceof String;
    }

    public static class ViewHolder extends ItemViewHolder<String> {

        private TextView header;
        public ViewHolder(View itemView) {
            super(itemView);
            header = itemView.findViewById(R.id.tv_header);
        }
    }
}
