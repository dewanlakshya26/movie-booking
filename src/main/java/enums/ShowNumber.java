package enums;

public enum ShowNumber {
    AUDI1("1"), AUDI2("2"), AUDI3("3");
    private String audiNumber;

    public String getAudiNo() {
        return audiNumber;
    }

    ShowNumber(String audiNo) {
        this.audiNumber = audiNo;
    }
}
