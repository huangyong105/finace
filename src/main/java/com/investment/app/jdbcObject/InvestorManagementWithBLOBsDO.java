package com.investment.app.jdbcObject;

public class InvestorManagementWithBLOBsDO extends InvestorManagementDO {
    private String idCardPngUp;

    private String idCardPngDown;

    public String getIdCardPngUp() {
        return idCardPngUp;
    }

    public void setIdCardPngUp(String idCardPngUp) {
        this.idCardPngUp = idCardPngUp;
    }

    public String getIdCardPngDown() {
        return idCardPngDown;
    }

    public void setIdCardPngDown(String idCardPngDown) {
        this.idCardPngDown = idCardPngDown;
    }
}