package com.example.androidlearning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import com.example.androidlearning.viewmodels.MyViewModel;
import static org.koin.android.viewmodel.compat.ViewModelCompat.getViewModel;

public class MainActivity extends AppCompatActivity {

    static FragmentManager fm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyViewModel viewModel = getViewModel(this, MyViewModel.class);

        // Begin the transaction
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        // Replace the contents of the container with the new fragment
        ft.replace(R.id.fragment_placeholder, new FragmentMain());
        // or ft.add(R.id.your_placeholder, new FooFragment());
        // Complete the changes added above
        ft.commit();

        fm = getSupportFragmentManager();


    }



    public static void showImageDialog(int ID ,String url) {
        FragmentDialog dialogFragment = FragmentDialog.newInstance(ID ,url);
        dialogFragment.show(fm, "fragment_edit_name");
    }


}