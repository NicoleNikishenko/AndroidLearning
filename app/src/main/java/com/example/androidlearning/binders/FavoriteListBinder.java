package com.example.androidlearning.binders;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.androidlearning.models.FavoriteList;
import com.example.androidlearning.R;
import mva2.adapter.ItemBinder;
import mva2.adapter.ItemViewHolder;

import mva2.adapter.MultiViewAdapter;

import static org.koin.java.KoinJavaComponent.get;

public class FavoriteListBinder extends ItemBinder<FavoriteList, FavoriteListBinder.ViewHolder> {

    static Boolean isInit = false;
    static MultiViewAdapter adapter = new MultiViewAdapter();

    @Override public ViewHolder createViewHolder(ViewGroup parent) {
        return new ViewHolder(inflate(parent, R.layout.list_item));
    }

    @Override public void bindViewHolder(ViewHolder holder, FavoriteList item) {

    }

    @Override
    public void initViewHolder(ViewHolder holder) {
        super.initViewHolder(holder);

        LinearLayoutManager layoutManager = new LinearLayoutManager(holder.rvList.getContext() ,LinearLayoutManager.HORIZONTAL ,false);
        holder.rvList.setAdapter(adapter);
        holder.rvList.setLayoutManager(layoutManager);
        adapter.registerItemBinders(new ImageBigBinder());
        if (!isInit){
            adapter.addSection(get(FavoriteList.class).getListFirstSection());
            isInit = true;
        }
        get(FavoriteList.class).initList();

    }

    @Override public boolean canBindData(Object item) {
        return item instanceof FavoriteList;
    }

    @Override public int getSpanSize(int maxSpanCount) {
        return maxSpanCount;
    }

    static class ViewHolder extends ItemViewHolder<FavoriteList> {

        private RecyclerView rvList;

        ViewHolder(View itemView) {
            super(itemView);
            rvList = itemView.findViewById(R.id.nested_rv);
        }
    }
}
