package com.example.androidlearning;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import com.bumptech.glide.Glide;
import com.example.androidlearning.models.FavoriteList;
import com.example.androidlearning.models.Image;

import static org.koin.java.KoinJavaComponent.get;

public class FragmentDialog extends DialogFragment {

    public static FragmentDialog newInstance(int ID ,String url) {
        FragmentDialog frag = new FragmentDialog();
        Bundle args = new Bundle();
        args.putInt("ID",ID);
        args.putString("url", url);
        frag.setArguments(args);
        return frag;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_dialog,container);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final int ID = getArguments().getInt("ID");
        final String url = getArguments().getString("url");

        ImageView imageView = view.findViewById(R.id.iv_fragment_dialog);

        Glide.with(view)
                .load(url)
                .centerCrop()
                .override(600, 600)
                .into(imageView);



        final Button btnFavorite = view.findViewById(R.id.dialog_btn_favorite);
        final Button btnFavoriteRemove = view.findViewById(R.id.dialog_btn_favorite_remove);

        if (get(FavoriteList.class).isFavorite(ID)){
            btnFavorite.setVisibility(View.GONE);
            btnFavoriteRemove.setVisibility(View.VISIBLE);
        }

        btnFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                get(FavoriteList.class).addImage(new Image(ID,url));
                btnFavorite.setVisibility(View.GONE);
                btnFavoriteRemove.setVisibility(View.VISIBLE);
            }
        });



        btnFavoriteRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                get(FavoriteList.class).removeImage(ID);
                btnFavorite.setVisibility(View.VISIBLE);
                btnFavoriteRemove.setVisibility(View.GONE);
            }
        });


        Button btnClose = view.findViewById(R.id.dialog_btn_close);
        btnClose.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

    }
}
