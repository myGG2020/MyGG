package com.techtown.gg;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textView);
        SpannableString content = new SpannableString("우리 집 댕댕이는요");
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        textView.setText(content);


        Calendar cal = Calendar.getInstance();
        final DatePickerDialog dialog = new DatePickerDialog(this, listner, 2020, 1, 1);

        EditText b_day = findViewById(R.id.bd_input);
        b_day.setText(cal.get(Calendar.YEAR)+ "-" + (cal.get(Calendar.MONTH)+1) + "-" + cal.get(Calendar.DATE));

        b_day.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
            }
        });
    }

    private DatePickerDialog.OnDateSetListener listner = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int yy, int mm, int dd) {
            EditText b_day = findViewById(R.id.bd_input);
            b_day.setText(String.format("%d-%d-%d", yy,mm+1,dd));
        }
    };
}