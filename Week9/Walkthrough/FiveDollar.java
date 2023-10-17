package Week9.Walkthrough;

public class FiveDollar extends DollarBill {
    public FiveDollar() {
        super(5, "Abraham Lincoln");
    }

    public boolean acceptedVending() {
        return true;
    }
}
