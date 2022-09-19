package com.example.chota.myInfo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.chota.R;
import com.example.chota.conn.CommonConn;
import com.google.gson.Gson;

public class BanActivity extends AppCompatActivity {
    RecyclerView recview_ok;
    MemberVO vo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ban);

        Intent intent = getIntent();
        recview_ok = findViewById(R.id.recview_ok);

        recview_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vo.setGrade_class_code(intent.getStringExtra("grade_class_code"));
                vo.setSchool_id(intent.getStringExtra("school_id"));
                String data = new Gson().toJson(vo);
                CommonConn banlistconn = new CommonConn("banlist", BanActivity.this);
                banlistconn.addParams("data", data);
                banlistconn.excuteConn(new CommonConn.ConnCallback() {
                    @Override
                    public void onResult(boolean isResult, String data) {

                    }
                });
            }
        });

    }
}