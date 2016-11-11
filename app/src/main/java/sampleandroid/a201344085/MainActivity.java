package sampleandroid.a201344085;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    Button btn1;
    CheckBox ck1;
    int count1 = 0;
    LinearLayout MyLayout1;
    RatingBar MyRatingBar1;
    RadioButton rbtn1;
    RadioButton rbtn2;
    CalendarView cal1;
    long now = System.currentTimeMillis();
    Date date = new Date(now);

    SimpleDateFormat CurDateFormat = new SimpleDateFormat("yyyy년MM월dd일");
/*    SimpleDateFormat CurYearFormat = new SimpleDateFormat("yyyy");
    SimpleDateFormat CurMonthFormat = new SimpleDateFormat("mm");
    SimpleDateFormat CurDayFormat = new SimpleDateFormat("dd");*/
    String strCurDate = CurDateFormat.format(date);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button)findViewById(R.id.button);
        ck1 = (CheckBox)findViewById(R.id.checkBox);
        MyLayout1 = (LinearLayout)findViewById(R.id.activity_main);
        MyRatingBar1 = (RatingBar)findViewById(R.id.ratingBar);
        rbtn1 = (RadioButton)findViewById(R.id.radioButton);
        rbtn2 = (RadioButton)findViewById(R.id.radioButton2);
        cal1 = (CalendarView)findViewById(R.id.calendarView);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Hello World",Toast.LENGTH_SHORT).show();
            }
        });

        ck1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = "";
                if(ck1.isChecked()){
                    str += ck1.getText() + " ";
                    MyLayout1.setBackgroundColor(Color.rgb(0,0,255));
                }
                else MyLayout1.setBackgroundColor(Color.WHITE);

                if(str.equals("")) Toast.makeText(getApplicationContext(), "선택이 해제되었습니다",Toast.LENGTH_SHORT).show();
                else Toast.makeText(getApplicationContext(), str+"를 선택하였습니다",Toast.LENGTH_SHORT).show();
            }
        });

        MyRatingBar1.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(getApplicationContext(), MyRatingBar1.getRating()+"점 입니다",Toast.LENGTH_SHORT).show();
            }
        });

        rbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rbtn1.isChecked()) Toast.makeText(getApplicationContext(), "남자입니다" ,Toast.LENGTH_SHORT).show();
                else Toast.makeText(getApplicationContext(), "여자입니다",Toast.LENGTH_SHORT).show();
            }
        });

        rbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rbtn2.isChecked()) Toast.makeText(getApplicationContext(), "여자입니다" ,Toast.LENGTH_SHORT).show();
                else Toast.makeText(getApplicationContext(), "남자입니다",Toast.LENGTH_SHORT).show();
            }
        });

        cal1.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                month = month+1;
                 String now = year+"년"+month+"월"+dayOfMonth+"일";
                if(strCurDate == now) Toast.makeText(getApplicationContext(), "오늘입니다",Toast.LENGTH_SHORT).show();
                else Toast.makeText(getApplicationContext(), year+"년"+month+"월"+dayOfMonth+"일 입니다",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
