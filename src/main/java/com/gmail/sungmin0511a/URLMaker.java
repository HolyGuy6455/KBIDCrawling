package com.gmail.sungmin0511a;

/**
 * URLMaker
 */
public class URLMaker {
    
    private static URLMaker INSTANCE = new URLMaker();
    private int lstFindList = 1;
    private String Desc = "DESC";
    private String GetUp = null;
    private String GetTname = "C";
    private String GetArea = null;
    private String GetSArea = null;
    private int Kind_type = 2;
    private String Tname = "C";
    private int lstWork = 199122;
    private int lstKind = -1;
    private int lstArea = 220000;
    private int lstSArea = 229999;
    private int rdoFindDate = 1;
    private String txtSDate = "2019-04-02";
    private String txtEDate = "2020-04-02";
    private int rdoFindWord = 1;
    private String txtFindWord = null;

    private URLMaker(){
        // *^^*
    }

    public static URLMaker getInstance() {
        return INSTANCE;
    }

    public void setStartDate(int year, int month, int date) {
        txtSDate = String.format("%d-%d-%d", year,month, date);
    }

    public void setEndDate(int year, int month, int date) {
        txtEDate = String.format("%d-%d-%d", year,month, date);
    }

    public void setLstWork(String str) {
        switch (str) {
            case "전문소방시설공사":
                lstSArea = 199122;
                break;
        
            default:
                break;
        }
    }

    public void setLstKind(String str) {
        // Nothing
    }

    public void setLstArea(String str) {
        switch (str) {
            case "경기":
                lstSArea = 220000;
                break;
        
            default:
                break;
        }
    }

    public void setLstSArea(String str) {
        switch (str) {
            case "관내":
                lstSArea = 229999;
                break;
        
            default:
                break;
        }
    }

    public String getUrl() {
        StringBuilder result = new StringBuilder();
        result.append("https://www.kbid.co.kr");
        result.append("/common");
        result.append("/main_search_result.htm?");
        result.append("lstFindList=");
        if(lstFindList != -1) result.append(lstFindList);
        result.append("&Desc=");
        if(Desc != null) result.append(Desc);
        result.append("&GetUp=");
        if(GetUp != null) result.append(GetUp);
        result.append("&GetTname=");
        if(GetTname != null) result.append(GetTname);
        result.append("&GetArea=");
        if(GetArea != null) result.append(GetArea);
        result.append("&GetSArea=");
        if(GetSArea != null) result.append(GetSArea);
        result.append("&Kind_type=");
        if(Kind_type != -1) result.append(Kind_type);
        result.append("&Tname=");
        if(Tname != null) result.append(Tname);
        result.append("&lstWork=");
        if(lstWork != -1) result.append(lstWork);
        result.append("&lstKind=");
        if(lstKind != -1) result.append(lstKind);
        result.append("&lstArea=");
        if(lstArea != -1) result.append(lstArea);
        result.append("&lstSArea=");
        if(lstSArea != -1) result.append(lstSArea);
        result.append("&rdoFindDate=");
        if(rdoFindDate != -1) result.append(rdoFindDate);
        result.append("&txtSDate=");
        if(txtSDate != null) result.append(txtSDate);
        result.append("&txtEDate=");
        if(txtEDate != null) result.append(txtEDate);
        result.append("&rdoFindWord=");
        if(rdoFindWord != -1) result.append(rdoFindWord);
        result.append("&txtFindWord=");
        if(txtFindWord != null) result.append(txtFindWord);
        return result.toString();
    }
}