package com.example.androidlearning;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.androidlearning.binders.FavoriteListBinder;
import com.example.androidlearning.binders.HeaderBinder;
import com.example.androidlearning.binders.HorizontalListBinder;
import com.example.androidlearning.binders.ImageSmallBinder;
import com.example.androidlearning.models.FavoriteList;
import com.example.androidlearning.models.ImageList;
import com.example.androidlearning.models.Image;
import com.example.androidlearning.viewmodels.MyViewModel;
import kotlin.Lazy;
import mva2.adapter.ItemSection;
import mva2.adapter.ListSection;
import mva2.adapter.MultiViewAdapter;

import static org.koin.java.KoinJavaComponent.get;

import static org.koin.android.viewmodel.compat.SharedViewModelCompat.sharedViewModel;

public class FragmentMain extends Fragment {

    private RecyclerView recyclerView;
    private Lazy<MyViewModel> viewModel = sharedViewModel(this, MyViewModel.class);


    public FragmentMain() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // Defines the xml file for the fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }


    // This event is triggered soon after onCreateView().
    // Any view setup should occur here.  E.g., view lookups and attaching view listeners.
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler_view);
        initViews();

    }

    public void initViews(){
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(),8,GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
    //    recyclerView.setHasFixedSize(true);

        // Create Adapter
        MultiViewAdapter adapter = new MultiViewAdapter();
        recyclerView.setAdapter(adapter);
        layoutManager.setSpanSizeLookup(adapter.getSpanSizeLookup());
        adapter.setSpanCount(layoutManager.getSpanCount());

        // Register Binder
        adapter.registerItemBinders(new HeaderBinder(), new FavoriteListBinder(), new HorizontalListBinder(), new ImageSmallBinder());


        // Favorite Section
        ItemSection<String> favoriteHeader = new ItemSection<>();
        favoriteHeader.setItem("Favorite List");
        ItemSection<FavoriteList> favoriteSection = new ItemSection<>();
        favoriteSection.setItem(get(FavoriteList.class));

        //First Section
        ItemSection<String> firstHeader = new ItemSection<>();
        firstHeader.setItem("First Section");
        ItemSection<ImageList> firstSection = new ItemSection<>();
        firstSection.setItem(viewModel.getValue().getFirstSection());


        //Second Section
        ItemSection<String> secondHeader = new ItemSection<>();
        secondHeader.setItem("Second Section");
        ListSection<Image> secondSection = new ListSection<>();
        secondSection.addAll((viewModel.getValue().getSecondSection()).getImages());

        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            // In landscape
            secondSection.setSpanCount(8);
        } else {
            // In portrait
            secondSection.setSpanCount(4);
        }


        // Add Section to the adapter
        adapter.addSection(favoriteHeader);
        adapter.addSection(favoriteSection);
        adapter.addSection(firstHeader);
        adapter.addSection(firstSection);
        adapter.addSection(secondHeader);
        adapter.addSection(secondSection);
    }
}