import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;
import java.util.Random;
import java.util.Map;

public class Setup extends ActionSupport {
    private QuickPollModel model;
    private String question;
	private String message;
    
	public String execute()  {
      model = new QuickPollModel();
      if (question == null)
    	  return "SUCCESS";
      else {
    	  model.setQuestion(question);
    	  return "SAVED";
      }
    }
	
	public void validate() {
		if (question!=null && question.equals(""))
			addFieldError("question", "Please enter a question before saving");
	}


	public QuickPollModel getModel() {
		return model;
	}
	
	public void setQuestion(String question) {
		this.question = question;
	}
	
	
}
