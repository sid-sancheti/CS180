package Week10.Walkthrough;

import java.util.concurrent.atomic.AtomicInteger;

public class Player {
	private int x;	//x position of the player
	private AtomicInteger y = new AtomicInteger();	//y position of the player
	private int hp;		//health point of the player
    private static Object lock = new Object();
	
	public Player(int x, AtomicInteger y, int hp){
		this.x = x;
		this.y = y;
		this.hp = hp;
	}
	
	public void printPlayer(){
		System.out.printf("x position:\t%d\ny position:\t%s\nhealth point:\t%d\n", x, y, hp);
	}
	
	public synchronized void moveLeft(){
		x--;
	}
	public synchronized void moveRight(){
		x++;
	}
	
	public void moveUp(){
		y.getAndDecrement();
	}
	public void moveDown(){
		y.getAndIncrement();
	}
	
	public void loseHealth(){
        synchronized (lock) {
            hp--;
        }
	}

	public void gainHealth(){
        synchronized (lock) {
            hp++;
        }
	}
	
}

