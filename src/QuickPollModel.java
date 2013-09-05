import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.servlet.ServletContext;


public class QuickPollModel {
	
	private ServletContext context;
	
	public static final Map<String, String> optionMap;
    static {
        Map<String, String> options = new TreeMap<String, String>();
        
        options.put("a_yes", "Yes");
        options.put("b_no", "No");
        options.put("c_neither", "Don't know");
        optionMap = Collections.unmodifiableMap(options);
    }
	
	public QuickPollModel(ServletContext context) {
		this.context = context;
	}
	
	public Map<String, String> getOptionMap() {
		return optionMap;
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
		Integer votes = (Integer) getVotesMap().get(key);
		if (votes==null)
			return 0;
		return votes.intValue();
	}
	
	public synchronized void castVote(String key) {
		Integer votes = getVotes(key);
	    votes++;
	    HashMap<String, Integer> map = getVotesMap();
	    map.put(key, votes);
	    context.setAttribute("votesmap", map);
	    
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
		context.setAttribute("votesmap", null);
	}
	
	private HashMap<String, Integer> getVotesMap() {
		HashMap<String, Integer> map = (HashMap<String, Integer>) context.getAttribute("votesmap");
		if (map == null)
			map = new HashMap<String, Integer>();
		return map;
	}
}
