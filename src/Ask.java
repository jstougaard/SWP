import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;

import java.util.Random;
import java.util.Map;

public class Ask extends ActionSupport {
    private QuickPollModel model;
    private String vote;
    private String message;
	
	public String execute()  {
      model = new QuickPollModel();
      if (model.getQuestion()==null || model.getQuestion().equals(""))
			return "SETUP";
      
      if (vote != null) {
   	   	  model.castVote(vote);
    	  String votedFor = model.getOptions().get(vote);
    	  setMessage("We registered your vote as '"+votedFor+"'");
    	  return "VOTED";
      }
      
      return "ASK";
    }


	public QuickPollModel getModel() {
		return model;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public void setVote(String vote) {
		this.vote = vote;
	}
}
