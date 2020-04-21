package f_mendez07.blogspot.com.petagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import f_mendez07.blogspot.com.petagram.adapter.PageAdapter;
import f_mendez07.blogspot.com.petagram.fragment.MainRecyclerViewFragment;
import f_mendez07.blogspot.com.petagram.fragment.PerfilRecyclerViewFragment;
import f_mendez07.blogspot.com.petagram.menu.MenuAcercaDe;
import f_mendez07.blogspot.com.petagram.menu.MenuContacto;

import static androidx.appcompat.widget.Toolbar.*;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        miToolBar();

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        setUpViewPager();


    }

    public void miToolBar(){
        Toolbar miActionBarMain = findViewById(R.id.miToolBar);
        miActionBarMain.inflateMenu(R.menu.menu_opciones);

        final ImageButton imgbActionTb = miActionBarMain.findViewById(R.id.imgbActionTb);

        imgbActionTb.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Mascotas favoritas",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), MascotasCincoFav.class);
                startActivity(intent);
                //finish();
            }
        });

        miActionBarMain.setOnMenuItemClickListener(new OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch(item.getItemId()){
                    case R.id.action_contacto:
                        Intent intent1 = new Intent(MainActivity.this, MenuContacto.class);
                        startActivity(intent1);
                        break;
                    case R.id.action_acerca:
                        Intent intent2 = new Intent(MainActivity.this, MenuAcercaDe.class);
                        startActivity(intent2);
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
    }


    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new MainRecyclerViewFragment());
        fragments.add(new PerfilRecyclerViewFragment());
        return fragments;
    }

    public void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),1,agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_tap_casa);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_tap_perro);

    }



}
