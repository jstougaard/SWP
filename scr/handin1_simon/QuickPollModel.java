package handin1_simon;
import java.util.HashMap;

import javax.servlet.ServletContext;


public class QuickPollModel{

	private ServletContext context;
	private String latestVote;
	private HashMap<String, Integer> votesMap;
	private int yesVotes = 0;
	private int noVotes = 0;
	private int totalVotes = 0;
	
	public QuickPollModel(ServletContext context){
		this.context = context;
		votesMap = new HashMap<>();
	}
	
	//Return question
	public String getQuestion(){
		return (String)context.getAttribute("question");
	}
	
	public void setQuestion(String question){		
		context.setAttribute("question", question);
	}

	public void setVote(String vote) {
		if(vote.equals("yes")){ 
			votesMap.put("yes", yesVotes + 1);
		}    
	    else if (vote.equals("no")) {
	    	votesMap.put("no", noVotes + 1);
	    }		
		
		totalVotes++;
		latestVote = vote;		
	}
	
	public String getLatestVote()
	{
		return latestVote;
	}
	
	public int drawBarLength(int votes, int totalVotes){
		if(totalVotes == 0){
			return 0;
		}
		else return 300*votes/totalVotes;
	}
	
	public int getTotalVotes(){
		return yesVotes + noVotes;	
	}
	
	
	public int getYesVotes(){
		if(!votesMap.containsKey("yes")) return 0;	
		else return votesMap.get("yes");
		
	}
	
	public int getNoVotes(){
		if(!votesMap.containsKey("no")) return 0;	
		else return votesMap.get("no");
	}
}
