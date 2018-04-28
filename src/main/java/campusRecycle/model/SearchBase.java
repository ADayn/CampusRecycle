package campusRecycle.model;

import java.util.*;

public class SearchBase {
	private List<HashSet<String>> words;
	private List<Searchable> objs;
	
	
	public SearchBase(){
		objs=new LinkedList<Searchable>();
		words=new LinkedList<HashSet<String>>();
	}
	
	public void add(List<Searchable> objs) {
		for(Searchable obj : objs) {
			String text=obj.getSearchableText();
			StringTokenizer st=new StringTokenizer(text);
			HashSet<String> hs=new HashSet<String>();
			while(st.hasMoreTokens()) {
				hs.add(st.nextToken());
			}
			this.objs.add(obj);
			this.words.add(hs);
		}
	}
	
	public void search(String keywords, double meet_ratio_threshold) {
		int len=words.size();
		
	}
}
