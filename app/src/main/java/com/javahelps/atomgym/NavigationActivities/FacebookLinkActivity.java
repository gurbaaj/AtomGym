package com.javahelps.atomgym.NavigationActivities;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.javahelps.atomgym.R;

public class FacebookLinkActivity extends AppCompatActivity implements View.OnClickListener{
    ActionBar actionBar;
    Button fbLink;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facebook_link);
        fbLink = (Button)findViewById(R.id.button_fb_link);
        fbLink.setOnClickListener(this);
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()){
        case android.R.id.home:
            this.finish();
    }
        return true;
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(getApplicationContext(),"Linking to Facebook",Toast.LENGTH_SHORT).show();
    }
}
