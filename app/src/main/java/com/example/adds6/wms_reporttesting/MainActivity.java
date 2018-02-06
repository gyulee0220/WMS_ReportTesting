package com.example.adds6.wms_reporttesting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    // 신고 내용을 저장하는 변수
    String ReportText;

    // UI 객체 생성
    EditText editText;
    EditText editSeatNumber;
    RadioGroup radiogroup;

    // 사용자가 누구인지 저장
    static String userID = "aa";

    // ReportCatgory 정수값 변환 용 자료 구조
    ArrayList<String> categoryList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // UI 연결 파트
        ReportText = new String();
        editText = findViewById(R.id.Reporting); // 추가 입력 사항 저장
        radiogroup = findViewById(R.id.radio1);
        editSeatNumber = findViewById(R.id.SeatNum);


        Button.OnClickListener reportListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (view.getId() == R.id.ReportTransper) {

                    ReportText = editText.getText().toString(); // 신고 내용 저장

                    int category = radiogroup.getCheckedRadioButtonId();
                    RadioButton reportCategoty = findViewById(category);

                    // 카테고리 정수값으로 변환해야한다!
                    String tmp = reportCategoty.getText().toString();
                    int ReporyCategory = categoryList.indexOf(tmp);

                    String Baduser = userID;

                    System.out.println("ReporyController 전송");
                    System.out.println("신고 번호:"+ReporyCategory);
                    System.out.println("신고 내용:"+ReportText);

                    SendBadUserInfo(ReporyCategory, Baduser, ReportText);

                }
            }
        };

        // 버튼 설정
        Button rt = findViewById(R.id.ReportTransper);
        rt.setOnClickListener(reportListener);

        // 카테고리 자료구조
        categoryList.add("소란행위"); // 0 : 소란행위
        categoryList.add("담배"); // 1 : 담배
        categoryList.add("쓰레기"); // 2 : 쓰레기
        categoryList.add("기물파손"); // 3 : 기물파손
        categoryList.add("음식물섭취"); // 4 : 음식물섭취
        categoryList.add("자리오래비움"); // 5 : 자리오래비움

    }

    public void SendBadUserInfo(int ReporyCategory, String SeatNumber, String ReportText){

        ReportController rc = new ReportController(ReporyCategory, SeatNumber, ReportText);

        // 결과 값 노출 용 함수
        //System.out.println("불량사용자:"+rc.BadUserID);
        //System.out.println("부여 전 벌점:"+rc.NumberOfScore);
        //System.out.println("신고 카테고리:"+rc.ReportCategory);
        //System.out.println("신고 내용:"+rc.ReportText);

    }
}
