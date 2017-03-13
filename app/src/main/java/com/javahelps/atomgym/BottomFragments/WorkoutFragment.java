package com.javahelps.atomgym.BottomFragments;


import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.javahelps.atomgym.Adapter.CustomSwipeAdapter;
import com.javahelps.atomgym.R;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 */
public class WorkoutFragment extends Fragment implements OnDateSelectedListener{

    private ViewPager viewPager;
    private CustomSwipeAdapter adapter;
    private MaterialCalendarView calendarView;
    private final Calendar calendar = Calendar.getInstance();
    private Drawable todayDrawable,feeDayDrawable;
    private ArrayList<CalendarDay> feeDays;
    CalendarDay thisDate;
    TextView monthName;
    SimpleDateFormat sdf;
    Button btnDiet;

    public WorkoutFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final Context context = getActivity();
        View view = inflater.inflate(R.layout.fragment_workout, container, false);
        // Instantiating Resources
        viewPager = (ViewPager)view.findViewById(R.id.view_pager);
        calendarView = (MaterialCalendarView)view.findViewById(R.id.calendarView);
        monthName = (TextView)view.findViewById(R.id.calendar_months);
        btnDiet = (Button)view.findViewById(R.id.btnDiet);
        calendarView.setTopbarVisible(false);//Disable TopBar
        calendarView.setPagingEnabled(false);//Disable Swiping

//FeesDay list and Highlighter
        feeDayDrawable = getResources().getDrawable(R.drawable.fee_day_highlight);
        feeDays = new ArrayList<>();
        feeDays.add(CalendarDay.from(2017,0,10));
        feeDays.add(CalendarDay.from(2017,1,10));
        feeDays.add(CalendarDay.from(2017,2,10));
        feeDays.add(CalendarDay.from(2017,3,10));
        feeDays.add(CalendarDay.from(2017,4,10));
        feeDays.add(CalendarDay.from(2017,5,10));
        feeDays.add(CalendarDay.from(2017,6,10));
        feeDays.add(CalendarDay.from(2017,7,10));
        feeDays.add(CalendarDay.from(2017,8,10));
        feeDays.add(CalendarDay.from(2017,9,10));
        feeDays.add(CalendarDay.from(2017,10,10));
        feeDays.add(CalendarDay.from(2017,11,10));
        calendarView.addDecorator(new DayViewDecorator() {
            @Override
            public boolean shouldDecorate(CalendarDay day) {
                day.copyTo(calendar);
                return feeDays.contains(day);
            }

            @Override
            public void decorate(DayViewFacade view) {
                view.addSpan(new ForegroundColorSpan(ContextCompat.getColor(getContext(), R.color.colorWhite)));
                    view.setBackgroundDrawable(feeDayDrawable);
            }
        });





        switch (calendar.get(Calendar.MONTH)){
            case Calendar.JANUARY:
                monthName.setText("January");
                break;
            case Calendar.FEBRUARY:
                monthName.setText("February");
                break;
            case Calendar.MARCH:
                monthName.setText("March");
                break;
            case Calendar.APRIL:
                monthName.setText("April");
                break;
            case Calendar.MAY:
                monthName.setText("May");
                break;
            case Calendar.JUNE:
                monthName.setText("June");
                break;
            case Calendar.JULY:
                monthName.setText("July");
                break;
            case Calendar.AUGUST:
                monthName.setText("August");
                break;
            case Calendar.SEPTEMBER:
                monthName.setText("September");
                break;
            case Calendar.OCTOBER:
                monthName.setText("October");
                break;
            case Calendar.NOVEMBER:
                monthName.setText("November");
                break;
            case Calendar.DECEMBER:
                monthName.setText("December");
                break;
        }

        // for selecting current date
        calendar.add(Calendar.DATE, 7);
        calendarView.setCurrentDate(CalendarDay.from(calendar), true);
        calendarView.setDateSelected(CalendarDay.today(), true);

        //Setting current day
        todayDrawable = getResources().getDrawable(R.drawable.current_day_highlight);
        thisDate = CalendarDay.today();
        calendarView.addDecorator(new DayViewDecorator() {
            @Override
            public boolean shouldDecorate(CalendarDay day) {
                day.copyTo(calendar);
                return thisDate!=null && day.equals(thisDate);
            }

            @Override
            public void decorate(DayViewFacade view) {
                view.setBackgroundDrawable(todayDrawable);
            }
        });

        adapter = new CustomSwipeAdapter(context);
        viewPager.setAdapter(adapter);


        //View Pager Item Set
        calendarView.setOnDateChangedListener(this);

        //To show previous and next preview
        viewPager.setPadding(80, 0, 100, 0);
        viewPager.setOffscreenPageLimit(6);
        viewPager.setClipToPadding(false);
        viewPager.setPageMargin(-200);

        //Carousel Effect View Pager
        viewPager.setPageTransformer(false, new ViewPager.PageTransformer() {
            @Override
            public void transformPage(View page, float position) {
                // do transformation here
                final float normalizedposition = Math.abs(Math.abs(position) - 1);
                page.setScaleX(normalizedposition / 2 + 0.7f);
                page.setScaleY(normalizedposition / 2 + 0.62f);
            }
        });

        //Button Diet

        btnDiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"t" ,Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    @Override
    public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
        sdf = new SimpleDateFormat("EEE");
        String today = sdf.format(date.getDate());
        switch (today.toLowerCase()){
            case "mon":
                viewPager.setCurrentItem(0);
                break;
            case "tue":
                viewPager.setCurrentItem(1);
                break;
            case "wed":
                viewPager.setCurrentItem(2);
                break;
            case "thu":
                viewPager.setCurrentItem(3);
                break;
            case "fri":
                viewPager.setCurrentItem(4);
                break;
            case "sat":
                viewPager.setCurrentItem(5);
                break;
        }
    }
}
