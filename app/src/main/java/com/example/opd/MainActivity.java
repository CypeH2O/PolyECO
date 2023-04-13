package com.example.opd;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.opd.ui.Calculator.Calculator_activity;
import com.example.opd.ui.News.ExtendenNewsActivity;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.advice_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
// Handle action bar item clicks here. The action bar will
// automatically handle clicks on the Home/Up button, so long
// as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.advice_save) {
            String str = "Hello world";
            Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), str, Snackbar.LENGTH_SHORT);
snackbar.show();

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //установка изначального laypot
        setContentView(R.layout.activity_main);
        ViewPager2 pager = findViewById(R.id.pager);
        //адаптер нужен для перелистывания страниц
        FragmentStateAdapter pageAdapter = new FragmentAdapter(this);
        pager.setAdapter(pageAdapter);


        TabLayout tabLayout = findViewById(R.id.tab_layout);
        //медиатор нужен для анимации нижней панели
        TabLayoutMediator tabLayoutMediator= new TabLayoutMediator(tabLayout, pager, new TabLayoutMediator.TabConfigurationStrategy(){

            @Override
            public void onConfigureTab(TabLayout.Tab tab, int position) {
                switch (position){
                    case 0:
                        tab.setIcon(R.drawable.map);
                        tab.setText("Карта");
                        break;
                    case 1:
                        tab.setIcon(R.drawable.calc);
                        tab.setText("Калькулятор");
                        break;
                    case 2:
                        tab.setIcon(R.drawable.ic_notifications_black_24dp);
                        tab.setText("Новости");
                        break;
                }

            }
        });
        tabLayoutMediator.attach();

    }
    public void StartEcoTest(View view){
        Intent intent = new Intent(this, Calculator_activity.class);
        startActivity(intent);
    }


}