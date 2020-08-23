package com.booking.enums;

   public enum ShowNumber {
        AUDI1("1"), AUDI2("2"), AUDI3("3");
        private String showNumber;

        public String getAudiNo() {
            return showNumber;
        }

        ShowNumber(String audiNo) {
            this.showNumber = audiNo;
        }
    }



