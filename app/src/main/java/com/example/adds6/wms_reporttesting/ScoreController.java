package com.example.adds6.wms_reporttesting;

/**
 * Created by adds6 on 2017-11-27.
 */

public class ScoreController {

    // 생성자 정보
    static String UserID;
    static int NumberOfSocre;

    public ScoreController(String userID, int numberOfSocre){
        this.UserID = userID;
        this.NumberOfSocre = numberOfSocre;

        ConverWarn(UserID, NumberOfSocre);

    }

    public void ConverWarn(String userID, int numberOfSocre){

        // 30점을 넘는지 계산한다.
        if(numberOfSocre < 30) {
            UpdateScoreInfo(userID, numberOfSocre);
        }

        else {
            // Warning Controller로 연결 한다.
            // 해당 사용자의 Warning을 1증가시킨다

            // ★★★★★★ Warning이나 Expel을 부여할 때 사용자의 벌점을 0으로 만들어야 한다.

            // Warning Controller wc = new WarningController(userID);
        }

    }

    public void UpdateScoreInfo(String userID, int numberOfSocre){
        // DB에 저장하는 코드 필요
        System.out.println("DB 저장 사용자(300):"+userID);
        System.out.println("DB 저장 점수:"+numberOfSocre);
    }

}
