package Week6;
/**
 * @author Siddharth Sancheti, Section 33
 */
public class State {
    private String capital;
    private int population;

    public State(String capital, int population) {
        this.capital = capital;
        this.population = population;
    }

    public String getCapital() { return capital; }
	private int getPopulation() { return population; }

    public void setCapital(String capital) { this.capital = capital; }
    public void setPopulation(int population) { this.population = population; }
}
