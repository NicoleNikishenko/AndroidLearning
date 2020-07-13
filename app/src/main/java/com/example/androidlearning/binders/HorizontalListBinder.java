package com.example.androidlearning.binders;

import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidlearning.models.ImageList;
import com.example.androidlearning.models.Image;
import com.example.androidlearning.R;

import mva2.adapter.ItemBinder;
import mva2.adapter.ItemViewHolder;
import mva2.adapter.ListSection;
import mva2.adapter.MultiViewAdapter;

public class HorizontalListBinder extends ItemBinder<ImageList, HorizontalListBinder.ViewHolder> {

    private ListSection<Image> listSection;
    MultiViewAdapter adapter;

    @Override public ViewHolder createViewHolder(ViewGroup parent) {
        return new ViewHolder(inflate(parent, R.layout.list_item));
    }

    @Override public void bindViewHolder(ViewHolder holder, ImageList item) {
        listSection.addAll(item.getImages());

    }

    @Override
    public void initViewHolder(ViewHolder holder) {
        super.initViewHolder(holder);
        LinearLayoutManager layoutManager = new LinearLayoutManager(holder.rvList.getContext() ,LinearLayoutManager.HORIZONTAL ,false);
        adapter = new MultiViewAdapter();
        holder.rvList.setAdapter(adapter);
        holder.rvList.setLayoutManager(layoutManager);
        adapter.registerItemBinders(new ImageBigBinder());
        listSection = new ListSection<>();
        adapter.addSection(listSection);
    }

    @Override public boolean canBindData(Object item) {
        return item instanceof ImageList;
    }

    @Override public int getSpanSize(int maxSpanCount) {
        return maxSpanCount;
    }

    static class ViewHolder extends ItemViewHolder<ImageList> {
        private RecyclerView rvList;

        ViewHolder(View itemView) {
            super(itemView);
            rvList = itemView.findViewById(R.id.nested_rv);
        }
    }
}
