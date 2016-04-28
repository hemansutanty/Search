package search;

import java.util.ArrayList;
import java.util.List;

public class Page {
	
	List<String> keywords = new ArrayList<>();
	List<Page> childPages = new ArrayList<>();
	public List<String> getKeywords() {
		return keywords;
	}
	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}
	/**
	 * @return the childPages
	 */
	public List<Page> getChildPages() {
		return childPages;
	}
	/**
	 * @param childPages the childPages to set
	 */
	public void setChildPages(List<Page> childPages) {
		this.childPages = childPages;
	}
	public void addChildPage(Page p){
		childPages.add(p);
	}
}
