package com.obelix.anpiemed.ui.home;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.example.anpiemed.R;
import com.example.anpiemed.databinding.ActivityHomeBinding;
import com.obelix.anpiemed.ui.menu.AboutFragment;
import com.obelix.anpiemed.ui.menu.ContactFragment;
import com.obelix.anpiemed.ui.menu.MediaFragment;
import com.google.android.material.navigation.NavigationView;
import org.jetbrains.annotations.NotNull;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private static final String TAG = "Home";
    ActivityHomeBinding binding;
    NavController navController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_home);

        setBottomNavigation();
        setNavigationDrawer();


    }

    private void setNavigationDrawer() {
        ActionBarDrawerToggle toggle =
                new ActionBarDrawerToggle(this,binding.drawerLayout,
                binding.toolBar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        binding.drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        binding.navView.setNavigationItemSelectedListener(this);
        binding.navView.bringToFront();
        binding.navView.setCheckedItem(R.id.homeActivity);


    }

    void setBottomNavigation(){
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

    @Override
    public void onBackPressed() {
        if(binding.drawerLayout.isDrawerOpen(GravityCompat.START)){
            binding.drawerLayout.closeDrawer(GravityCompat.START);
        }else {

        }
        super.onBackPressed();
    }

    /**
     * Called when an item in the navigation menu is selected.
     *
     * @param item The selected item
     * @return true to display the item as the selected item
     */
    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.homeActivity:
                startActivity( new Intent(this, HomeActivity.class));
                break;
            case R.id.aboutFragment:
                loadFragment(new AboutFragment());
                break;
            case R.id.mediaFragment:
                loadFragment(new MediaFragment());
                break;
            case R.id.contactFragment:
                loadFragment(new ContactFragment());
                break;
        }
        binding.drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}