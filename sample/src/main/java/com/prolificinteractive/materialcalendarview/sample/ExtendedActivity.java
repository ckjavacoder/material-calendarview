package com.prolificinteractive.materialcalendarview.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.CalendarUtils;
import com.prolificinteractive.materialcalendarview.ExtendedMaterialCalendarView;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateChangedListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class ExtendedActivity extends AppCompatActivity implements OnDateChangedListener {

    private static final DateFormat FORMATTER = SimpleDateFormat.getDateInstance();

    @InjectView(R.id.extended_mcv)
    ExtendedMaterialCalendarView extendedMcv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_extended);
        ButterKnife.inject(this);

        extendedMcv.setOnDateChangedListener(this);

        Calendar worker = CalendarUtils.getInstance();
        worker.add(Calendar.YEAR, -10);
        extendedMcv.getMaterialCalendarView().setMinimumDate(new CalendarDay(worker));
        worker.add(Calendar.YEAR, 20);
        extendedMcv.getMaterialCalendarView().setMaximumDate(new CalendarDay(worker));
    }

    @Override
    public void onDateChanged(MaterialCalendarView widget, CalendarDay date) {
        Toast.makeText(this, FORMATTER.format(date.getDate()), Toast.LENGTH_SHORT).show();
    }
}
