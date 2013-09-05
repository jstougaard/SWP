package swp;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
public class Hiscore {
	
	private int plays;
	
	private String holder;
	
	private int record;
	
	public synchronized void newPlay() {
		plays++;
	}

	public synchronized void setHiscore(String name, int guesses) {
   		if (holder == null || guesses < record) {
   			holder = name;
   			record = guesses;
   		}
	}

	public int getPlays() {
		return plays;
	}

	public void setPlays(int plays) {
		this.plays = plays;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public int getRecord() {
		return record;
	}

	public void setRecord(int record) {
		this.record = record;
	}
}
