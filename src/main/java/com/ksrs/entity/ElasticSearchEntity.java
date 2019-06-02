package com.ksrs.entity;

public class ElasticSearchEntity {

    /** 省份**/
    private String province;
    /** 有固话的公司数量**/
    private long haveTelephone;
    /**有手机的公司数量 **/
    private long haveCellphone;
    /**既有手机又有固话的公司数量 **/
    private long telePhoneAndCellPhone;
    /**固话号码的个数 **/
    private long telephoneCount;
    /**手机号码的个数 **/
    private long cellphoneCount;
    /** 坏的固话号码个数**/
    private long badTelephoneCount;
    /** 坏的手机号码个数**/
    private long badCellphoneCount;
    /** 统计日期**/
    private String countTime;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public long getHaveTelephone() {
        return haveTelephone;
    }

    public void setHaveTelephone(long haveTelephone) {
        this.haveTelephone = haveTelephone;
    }

    public long getHaveCellphone() {
        return haveCellphone;
    }

    public void setHaveCellphone(long haveCellphone) {
        this.haveCellphone = haveCellphone;
    }

    public long getTelePhoneAndCellPhone() {
        return telePhoneAndCellPhone;
    }

    public void setTelePhoneAndCellPhone(long telePhoneAndCellPhone) {
        this.telePhoneAndCellPhone = telePhoneAndCellPhone;
    }

    public long getTelephoneCount() {
        return telephoneCount;
    }

    public void setTelephoneCount(long telephoneCount) {
        this.telephoneCount = telephoneCount;
    }

    public long getCellphoneCount() {
        return cellphoneCount;
    }

    public void setCellphoneCount(long cellphoneCount) {
        this.cellphoneCount = cellphoneCount;
    }

    public long getBadTelephoneCount() {
        return badTelephoneCount;
    }

    public void setBadTelephoneCount(long badTelephoneCount) {
        this.badTelephoneCount = badTelephoneCount;
    }

    public long getBadCellphoneCount() {
        return badCellphoneCount;
    }

    public void setBadCellphoneCount(long badCellphoneCount) {
        this.badCellphoneCount = badCellphoneCount;
    }

    public String getCountTime() {
        return countTime;
    }

    public void setCountTime(String countTime) {
        this.countTime = countTime;
    }
}
