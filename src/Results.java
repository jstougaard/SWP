import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;
import java.util.Random;
import java.util.Map;

public class Results extends ActionSupport {
    private QuickPollModel model;
	private String message;
	private String vote;
	
	public String execute()  {
		model = new QuickPollModel();
		if (model.getQuestion()==null || model.getQuestion().equals(""))
			return "SETUP";
		
		if (model.getTotal()==0)
    	  return "EMPTY";
      
	  return "SUCCESS";
    }

    public QuickPollModel getModel() {
    	return model;
    }

    

}
