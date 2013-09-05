package swp;

import java.io.Serializable;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="game")
@SessionScoped
public class GameSession implements Serializable {

	private int secret;
    
	private int guesses;
	
	private Integer number;
    
	private String name;
	
	private String message;

	@ManagedProperty("#{hiscore}")
	transient private Hiscore hiscore;
    
	@PostConstruct
	public void init() {
		secret = new Random().nextInt(100) + 1;
		guesses = 0;
		number = null;
		setMessage("Guess a number between 1 and 100");
		hiscore.newPlay();
	}
	
	public String makeGuess() {
		guesses++;
		if (number > secret) {
			setMessage("Your guess is too large, guess again");
			return "WRONG";
		} else if (number < secret) {
			setMessage("Your guess is too small, guess again");
			return "WRONG";
		} else if (hiscore.getHolder() == null || guesses < hiscore.getRecord()) {
			return "HISCORE";
		} else {
			return "GUESSED";
		}
	}
	
	public String register() {
		hiscore.setHiscore(name, guesses);
		return "DONE";
	}
	
	public String again() {
		init();
		return "AGAIN";
	}
	
	public Integer getNumber() {
		return number;
	}
	
	public void setNumber(Integer number) {
		this.number = number;
	}
	
	public int getSecret() {
		return secret;
	}

	public void setSecret(int secret) {
		this.secret = secret;
	}

	public int getGuesses() {
		return guesses;
	}

	public void setGuesses(int guesses) {
		this.guesses = guesses;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public void setHiscore(Hiscore hiscore) {
		this.hiscore = hiscore;
	}
}
