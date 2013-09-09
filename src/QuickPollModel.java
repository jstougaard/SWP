import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.opensymphony.xwork2.ActionContext;


public class QuickPollModel {
	
	private Map<String, Object> data;
	
	public Map<String, String> optionMap;

    
    public Map<String, Object> getDataMap() {
    	if (data==null)
    		data = ActionContext.getContext().getApplication();
    	return data;
    }
	
	public Map<String, String> getOptions() {
		if (optionMap == null) {
			Map<String, String> options = new LinkedHashMap<String, String>();
	        
	        options.put("yes", "Yes");
	        options.put("no", "No");
	        options.put("neither", "Don't know");
	        optionMap = Collections.unmodifiableMap(options);
		}
		return optionMap;
	}
	
	public void setQuestion(String question) {
		getDataMap().put("question", question);
		resetVotes();
	}
	
	public String getQuestion() {
		if (!getDataMap().containsKey("question"))
			return "";
		else
			return (String) getDataMap().get("question");
	}
	
	public Map<String, Integer> getVotes() {
		Map<String, Integer> votes = new LinkedHashMap<String, Integer>();
		for(Map.Entry<String, String> entry : getOptions().entrySet())
			votes.put(entry.getValue(), (Integer)getVotesFor(entry.getKey())); 
		return votes;
	}
	
	public int getVotesFor(String key) {
		Integer votes = (Integer) getVotesMap().get(key);
		if (votes==null)
			return 0;
		return votes.intValue();
	}
	
	public synchronized void castVote(String key) {
		if (key == null || key.equals("")) return;
		Integer votes = getVotesFor(key);
	    votes++;
	    HashMap<String, Integer> map = getVotesMap();
	    map.put(key, votes);
	    getDataMap().put("votesmap", map);
	    
	}
	
	public int getTotal() {
		int total = 0;
		Set<Map.Entry<String, Integer>> entrySet = getVotesMap().entrySet();
		if (entrySet != null) {
			for (Map.Entry<String, Integer> entry : entrySet) {
				total += entry.getValue()==null ? 0 : entry.getValue();
			}
		}
		return total;
	}
	
	public void resetVotes() {
		getDataMap().put("votesmap", null);
	}
	
	private HashMap<String, Integer> getVotesMap() {
		HashMap<String, Integer> map = (HashMap<String, Integer>) getDataMap().get("votesmap");
		if (map == null)
			map = new HashMap<String, Integer>();
		return map;
	}
}

