package Week6;

public class TeaTest {

	public static void main(String[] args) {
		Tea tea = new Tea("Black Tea", 6.5, "Black", 200);
		
		System.out.println(tea);
		
		tea.restock(20);
	}

}
