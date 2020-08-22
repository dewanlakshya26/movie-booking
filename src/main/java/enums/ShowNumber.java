package enums;

public enum ShowNo {
    AUDI1("1"), AUDI2("2"), AUDI3("3");
    private String audiNo;

    public String getAudiNo() {
        return audiNo;
    }

    ShowNo(String audiNo) {
        this.audiNo = audiNo;
    }
}
