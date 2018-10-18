package com.example.ubantu.neverfeelalone;

public class Questions {

    public String mQuestions[] = {
            "What is your Gender?",
            "What is your sexual orientation?",
            "How would you describe your body/weight?",
            "Are you a virgin?",
            "Is prostitution legal where you live?",
            "Would you pay for sex?",
            "Are you depressed?",
            "WHAT IS 8?",
            "WHAT IS 9?",
            "WHAT IS 10",
            ""


    };

    private String mChoices[][] = {

            {"MALE","FEMALE","TRASGENDER MALE","TRANSGENDER FEMALE"},
            {"STRAIGHT","BISEXUAL","GAY/LESBAIN","NONE OF THESE"},
            {"NORMAL WEIGHT","UNDER WEIGHT","OVER WEIGHT","NONE OF THESE"},
            {"YES","NO","DON'T KNOW"," "},
            {"YES","NO","DON'T KNOW","I DON'T CARE"},
            {"NO I CAN'T","NO, I SHOULDN'T","YES,I'LL LOVE TO","YES, WHY NOT"},
            {"MAY BE","MAY NOT BE","SURE","NO"},
            {"number 8","number 2","number 3","number 4"},
            {"number 1111","number 2","number 3","number 4"},
            {"number 9","number 2","number 3","number 4"},
            {"","","",""}

    };

    public String getQuestion (int a){
        String question = mQuestions[a];
        return question;
    }

    public  String getChoice1(int a){
        String choice = mChoices[a][0];
        return  choice;
    }

    public  String getChoice2(int a){
        String choice = mChoices[a][1];
        return  choice;
    }

    public  String getChoice3(int a){
        String choice = mChoices[a][2];
        return  choice;
    }

    public  String getChoice4(int a){
        String choice = mChoices[a][3];
        return  choice;
    }



}
