package com.javahelps.atomgym.Adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.javahelps.atomgym.R;

/**
 * Created by Gurpreet on 01-03-2017.
 */

public class CustomSwipeAdapter extends PagerAdapter {

    private int[] imageResources = {R.drawable.chest, R.drawable.triceps,R.drawable.back,R.drawable.biceps,R.drawable.shoulders,R.drawable.thigh};
    private Context ctx;
    private LayoutInflater layoutInflater;


    public CustomSwipeAdapter(Context ctx){

        this.ctx = ctx;
    }


    @Override
    public int getCount() {
        return imageResources.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == (LinearLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {

        layoutInflater = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = layoutInflater.inflate(R.layout.swipe_layout,container,false);

        ImageView imageView = (ImageView)itemView.findViewById(R.id.imageView);
        TextView textView = (TextView)itemView.findViewById(R.id.imageName);

        final String[] setName={"Chest","Triceps","Back","Biceps","Shoulders","Thigh"};

        imageView.setImageResource(imageResources[position]);
        textView.setText(setName[position]);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (position){
                    case 0:
                        Toast.makeText(ctx,"" + setName[position],Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(ctx,"" + setName[position],Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(ctx,"" + setName[position],Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(ctx,"" + setName[position],Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        Toast.makeText(ctx,""+ setName[position],Toast.LENGTH_SHORT).show();
                        break;
                    case 5:
                        Toast.makeText(ctx,"" + setName[position],Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });


        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }
}
