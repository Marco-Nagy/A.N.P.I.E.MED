package com.example.latestnews.ui.home;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.example.latestnews.R;
import com.example.latestnews.databinding.ActivityHomeBinding;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
public class HomeActivity extends AppCompatActivity {
    private static final String TAG = "Home";
    ActivityHomeBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home);


        binding.bottomNavigation.add(new MeowBottomNavigation.Model(1,R.drawable.chart_icon));
        binding.bottomNavigation.add(new MeowBottomNavigation.Model(2,R.drawable.group));
        binding.bottomNavigation.add(new MeowBottomNavigation.Model(3,R.drawable.light_icon));
        binding.bottomNavigation.add(new MeowBottomNavigation.Model(4,R.drawable.language));
        binding.bottomNavigation.add(new MeowBottomNavigation.Model(5,R.drawable.bible_icon));
        binding.bottomNavigation.add(new MeowBottomNavigation.Model(6,R.drawable.archive_icon));
        binding.bottomNavigation.setOnShowListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {

                switch (model.getId()){
                    case 1:
                        loadFragment(new ArtFragment());
                        break;
                    case 2:
                        loadFragment(new CultureFragment());
                        break;
                    case 3:
                        loadFragment(new StudiesFragment());
                        break;
                    case 4:
                        loadFragment(new LinguisticsFragment());
                        break;
                    case 5:
                        loadFragment(new BibliothecaFragment());
                        break;
                    case 6:
                        loadFragment(new ArciveFragment());
                        break;

                }
                return null;
            }
        });

        binding.bottomNavigation.show(1,true);
        binding.bottomNavigation.setOnClickMenuListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {

                Toast.makeText(HomeActivity.this, "you Clicked"+model.getId(), Toast.LENGTH_SHORT).show();

                return null;
            }
        });
        binding.bottomNavigation.setOnReselectListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {
                Toast.makeText(HomeActivity.this, "you Reselected"+model.getId(), Toast.LENGTH_SHORT).show();
                return null;
            }
        });

    }
    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainerView,fragment)
                .commit();
    }
}