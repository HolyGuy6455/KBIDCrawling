package com.gmail.sungmin0511a;


public class PostingDocument {
    String num;
    String catal;
    String hyperLink;
    String subject;

    String type;
    String baseCost;
    String estimateCost;
    String rangeOfFluctuation;
    // String rangeOfFluctuationMax;
    // String rangeOfFluctuationMin;
    String entreaty;



    Boolean read;
    Boolean proposition;

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getCatal() {
        return catal;
    }

    public void setCatal(String catal) {
        this.catal = catal;
    }

    public String getHyperLink() {
        return hyperLink;
    }

    public void setHyperLink(String hyperLink) {
        this.hyperLink = hyperLink;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Boolean getRead() {
        return read;
    }

    public void setRead(Boolean read) {
        this.read = read;
    }

    public Boolean getProposition() {
        return proposition;
    }

    public void setProposition(Boolean proposition) {
        this.proposition = proposition;
    }


    
}