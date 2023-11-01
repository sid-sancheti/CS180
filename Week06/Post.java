package Week06;

public class Post {
	private User poster;
	private String message;
	
	public Post(User poster, String message) {
		this.poster = poster;
		this.message = message;
	}
	
	public void setPoster(User poster) { this.poster = poster; }
	public User getPoster() { return poster; }
	
	public void setMessage(String message) { this.message = message; }
	public String getMessage() { return message; }
	
	
}
