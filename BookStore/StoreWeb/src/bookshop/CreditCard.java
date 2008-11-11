package bookshop;

public class CreditCard {
    private String number;
    private String securityCode;
    private String expiry;

    public String getNumber() {
        return number;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public String getExpiry() {
        return expiry;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    public void setExpiry(String expiry) {
        this.expiry = expiry;
    }

    public String getMaskedNumber() {
        if (number == null || number.length() != 16) return "";
        return "XXXXXXXXXXXX" + number.substring(number.length() - 4, number.length());
    }
}
