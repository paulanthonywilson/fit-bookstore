package bookshop;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Pounds {
    private BigDecimal value;

    public Pounds(BigDecimal value) {

        this.value = value.setScale(2, RoundingMode.HALF_EVEN);
    }

    public static Pounds inPounds(double value) {
        return new Pounds(new BigDecimal(value));
    }

    public String toString() {
        return value.toString();
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        return value.equals(((Pounds) o).value);

    }

    public int hashCode() {
        return value.hashCode();
    }

    public Pounds plus(Pounds addMe) {
        return new Pounds(value.add(addMe.value));
    }


}
