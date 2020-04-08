package com.gmail.sungmin0511a;

public class PostingURLMaker {
    int CurSelPage;
    String BidNo;
    int BidNoSeq;
    // String AesENC="c2e520fbe11fd177d4a04f1e3e410413";
    // String lstResultFields=null;
    // String txtResultSearchWord=null;

    public int getCurSelPage() {
        return CurSelPage;
    }

    public void setCurSelPage(int curSelPage) {
        CurSelPage = curSelPage;
    }

    public String getBidNo() {
        return BidNo;
    }

    public void setBidNo(String bidNo) {
        BidNo = bidNo;
    }

    public String getUrl() {
        StringBuilder result = new StringBuilder();
        result.append("https://www.kbid.co.kr");
        result.append("/common");
        result.append("/bid_contents_result.htm?");
        result.append("CurSelPage=");
        if(CurSelPage != -1) result.append(CurSelPage);
        result.append("BidNo=");
        if(BidNo != null) result.append(BidNo);
        result.append("BidNoSeq=");
        if(BidNoSeq != -1) result.append(BidNoSeq);

        return result.toString();
    }

}