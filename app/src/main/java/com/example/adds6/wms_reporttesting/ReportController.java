package com.example.adds6.wms_reporttesting;

import android.os.AsyncTask;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by adds6 on 2017-11-25.
 */

public class ReportController {

    // 신고 정보에 대한 기본 변수들 (정적 변수로 선언해야 한다.)
    static int ReportCategory = 0;
    static int SeatNumber = 0;
    static String ReportText = null;

    // DB 참조 후 알수 있는 정보
    static String BadUserID = null;
    static int NumberOfScore=0;

    // 점수 계산 후 알 수 있는 정보
    static int AfterNumberOfScore = 0;

    // Constructor
    public ReportController(int reportCategory, String baduser, String ReportText){
        this.ReportCategory = reportCategory;
        this.BadUserID = baduser;
        this.ReportText = ReportText;

        System.out.println("객체 생성");
        System.out.println("신고 번호:"+ReportCategory);
        System.out.println("좌석 번호:"+BadUserID);
        System.out.println("신고 내용:"+ReportText);
        System.out.println(" ");
        System.out.println("신고자 찾기");

        SearchUser(SeatNumber);

        System.out.println("벌점"+NumberOfScore);

        AddScore(BadUserID, NumberOfScore);
    }

    // ************    DB 참조 부분    ***************

    // SQLite 참조하기



    // 가상 함수
    // 좌석 번호를 이용해 불량 사용자에 대해 조사를 한다.
    public void SearchUser(int SeatNumber){

        //PHPdata userInfo = new PHPdata();
        //userInfo.execute("http://kdk3776.cafe24.com/userInfo.php");

        if (SeatNumber == 100) {
            BadUserID = null;  // 불량 사용지 UserID가 300이라고 가정
            NumberOfScore = 13; // 해당 불량 사용자의 벌점이 13점이었다고 가정한다.
        }
    }

    public void AddScore(String badUserID, int nunberOfScore) {

        System.out.println("계산 전 카테고리"+ReportCategory);
        System.out.println("더하기전"+nunberOfScore);

        switch (ReportCategory){
            case 0:  // 소란행위
                AfterNumberOfScore=nunberOfScore+3;
                break;

            case 1:  // 담배
                AfterNumberOfScore=nunberOfScore+10;
                break;

            case 2:  // 쓰레기
                AfterNumberOfScore=nunberOfScore+5;
                break;

            case 3:  // 기물파손
                AfterNumberOfScore=nunberOfScore+5;
                break;

            case 4:  // 음식물 섭취
                AfterNumberOfScore=nunberOfScore+5;
                break;

            case 5:  // 자리오래비움
                AfterNumberOfScore=nunberOfScore+3;
                break;

        }

        System.out.println("합계 점수:"+AfterNumberOfScore);

        ScoreController sc = new ScoreController(badUserID,AfterNumberOfScore);
    }

    // 0 : 소란행위 (3점)
    // 1 : 담배  (10점)
    // 2 : 쓰레기  (5점)
    // 3 : 기물파손  (5점)
    // 4 : 음식물섭취  (5점)
    // 5 : 자리오래비움  (3점)

}
/*
public class PHPdata extends AsyncTask<String, String, String> {

    // 메소드 이름 필수 정의
    public String doInBackground(String... urls) {

        BufferedReader bufferedReader;

        try {

            // 앞에서 생성한 URL 객체에 대해 url 값을 전달
            URL url = new URL(urls[0]);

            // Http URL 과 연결하기 위한 객체 생성 코드
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            if (conn != null) {

                //연결된 코드가 리턴되면
                if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    int i = 0;
                    for (; ; ) {
                        //웹상에 보이는 텍스트를 라인단위로 읽어 저장
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            System.out.println("End of file :" + i);
                            break;
                        }
                        System.out.println("Success read php : " + line);
                        i++;
                        ResultJson += line;
                    }
                    bufferedReader.close();
                }
                conn.disconnect();
            } else {
                System.out.println("Fail to connect php");
            }
        } catch (Exception e) {
            return null;
        }

        return ResultJson;

    }

}*/