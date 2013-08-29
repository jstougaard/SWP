import java.util.HashMap;

import javax.servlet.ServletContext;


public class QuickPollModel {
	private static final String PREFIX = "QUICKPOLL";
	
	private ServletContext context;
	
	public QuickPollModel(ServletContext context) {
		this.context = context;
	}
	
	public void setQuestion(String question) {
		context.setAttribute("question", question);
		resetVotes();
	}
	
	public String getQuestion() {
		String question = (String) context.getAttribute("question");
		if (question == null)
			return "You forgot to setup a question, didn't you?";
		else
			return question;
	}
	
	public int getVotes(String key) {
		Integer votes = (Integer) context.getAttribute(PREFIX+key);
		return votes.intValue();
	}
	
	public void castVote(String key) {
		String voteKey = PREFIX+key;
		int votes = ((Integer)context.getAttribute(voteKey)).intValue();
	    votes++;
	    context.setAttribute(voteKey, new Integer(votes));
	}
	
	public int getTotal() {
		int total = 0;
		while (context.getAttributeNames().hasMoreElements()) {
			String key = context.getAttributeNames().nextElement();
			if (key.startsWith(PREFIX))
				total += (Integer) context.getAttribute(key);
		}
		return total;
	}
	
	public void resetVotes() {
		while (context.getAttributeNames().hasMoreElements()) {
			String key = context.getAttributeNames().nextElement();
			if (key.startsWith(PREFIX))
				context.setAttribute(key, 0);
		}
	}
}
