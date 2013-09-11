import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name="model")
@ApplicationScoped
public class PollModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Map<String, Integer> votes;
	
	private Map<String, String> optionMap;
	
	private String question;
	
	public Map<String, Integer> getVotesMap() {
		if (votes == null)
			votes = new HashMap<String, Integer>();
		return votes;
	}
	
	public Map<String, String> getOptions() {
		if (optionMap == null) {
			Map<String, String> options = new LinkedHashMap<String, String>();
	        
	        options.put("Yes", "yes");
	        options.put("No", "no");
	        options.put("Don't know", "neither");
	        optionMap = Collections.unmodifiableMap(options);
		}
		return optionMap;
	}
	
	public List<Result> getResults() {
		
		List<Result> list = new ArrayList<Result>();
		int total = getTotal();
		
		for(Map.Entry<String, String> entry : getOptions().entrySet())
			list.add( new Result(entry.getKey(), getVotesFor(entry.getValue()), (float) getVotesFor(entry.getValue())/total));
		
	    return list;
	}
 	
	public void setQuestion(String question) {
		this.question = question;
		resetVotes();
	}
	
	public String getQuestion() {
		if (question == null)
			question = "";
		return question;
	}
	
	public int getVotesFor(String key) {
		Integer votes = (Integer) getVotesMap().get(key);
		if (votes == null) 
			votes = 0;
		return votes;
	}
	
	public synchronized void castVote(String key) {
		if (key == null || key.equals("")) return;
		Integer votes = getVotesFor(key);
	    votes++;
	    getVotesMap().put(key, votes);
	}
	
	public int getTotal() {
		int total = 0;

		for (Map.Entry<String, Integer> entry : getVotesMap().entrySet()) {
			total += entry.getValue()==null ? 0 : entry.getValue();
		}

		return total;
	}
	
	public void resetVotes() {
		votes = null;
	}
	
	public static class Result{
		 
		String label;
		int votes;
		float weight;
 
		public Result(String label, int votes, float weight) {
 
			this.label = label;
			this.votes = votes;
			this.weight = weight;
		}
		
		public String getLabel() {
			return label;
		}
		public int getVotes() {
			return votes;
		}
		public float getWeight() {
			return weight;
		}
	}

}
