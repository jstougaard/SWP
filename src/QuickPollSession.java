import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="poll")
@SessionScoped
public class QuickPollSession {
	
	private String vote;
	private String message;
	
	@ManagedProperty("#{model}")
	transient private PollModel model;
	
	@PostConstruct
	public void init() {
	}
	
	public void checkSetup() throws IOException {
        if (model.getQuestion() == null || model.getQuestion().equals("")) {
        	setMessage("You need to setup a question first");
        	FacesContext.getCurrentInstance().getExternalContext().redirect("setup.jsf");
        }
    }
	
	public String setup() {
		if (!model.getQuestion().equals("")) {
			setMessage("");
			return "SUCCESS";
		} else {
			setMessage("You need to setup a question");
			return "WRONG";
		}
	}
	
	public String castVote() {
		if (vote!=null && !vote.equals("")) {
			model.castVote(vote);
			setMessage("Thank you for voting");
			vote = null;
			return "VOTED";
		} else
			return "WRONG";
	}
	
	public String getVote() {
		return vote;
	}
	public void setVote(String vote){
		this.vote = vote;
	}
	
	public String getMessage() {
		String msg = message;
		message = null; // message is read once only
		return msg;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public void setModel(PollModel model) {
		this.model = model;
	}

}
