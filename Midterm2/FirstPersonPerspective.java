package Midterm2;

public class FirstPersonPerspective extends VideoGame {
    private int gameModeCount;
    private double sales;

    public FirstPersonPerspective(String projectName, int employeeCount, boolean priority, int gameModeCount, double sales ) {
        super(projectName, employeeCount, priority);

        if (gameModeCount < 0)
            throw new IllegalArgumentException();

        if (sales < 0)
            throw new IllegalArgumentException();

        this.gameModeCount = gameModeCount;
        this.sales = sales;
    }

    public int getGameModeCount() { return gameModeCount; }
    public double getSales() { return sales; }

    public double calculateAverageGameModeSales() {
        return sales / gameModeCount;
    }

    public double calculateReturnOnInvestment(double averageSalary, int months) {
        return sales - calculateCostEstimate(averageSalary, months);
    }
}
