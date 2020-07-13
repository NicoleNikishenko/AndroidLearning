package com.example.androidlearning.binders;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.example.androidlearning.models.Image;
import com.example.androidlearning.MainActivity;
import com.example.androidlearning.R;
import mva2.adapter.ItemBinder;
import mva2.adapter.ItemViewHolder;

public class ImageBigBinder extends ItemBinder<Image, ImageBigBinder.viewHolder> {


    @Override
    public viewHolder createViewHolder(ViewGroup parent) {
        return new viewHolder(inflate(parent, R.layout.image_big_item));
    }

    @Override
    public boolean canBindData(Object item) {
        return item instanceof Image;
    }


    @Override public int getSpanSize(int maxSpanCount) {
        return maxSpanCount;
    }


    @Override
    public void bindViewHolder(final viewHolder holder, final Image image) {
        Glide.with(holder.view)
                .load(image.getUrl())
                .centerCrop()
                .into(holder.imageView);

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.showImageDialog(image.getID() ,image.getUrl());
            }
        });
    }

    static class viewHolder extends ItemViewHolder<Image> {

        ImageView imageView;
        View view;

        public viewHolder(final View itemView) {
            super(itemView);
            view = itemView;
            imageView = itemView.findViewById(R.id.iv_image);
        }
    }

}

