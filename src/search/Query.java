package search;

import java.util.ArrayList;
import java.util.List;

public class Query {
	
	List<String> keywords = new ArrayList<>();
	
	public List<String> getKeywords() {
		return keywords;
	}
	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}
	public WeightObject findWeight(Page p,int n,int pageNumber){
		WeightObject weightObj=new WeightObject();Integer product;Double weight=0.0;
		for(int i=0;i<this.getKeywords().size();i++){
			product=0;
			for(int j=0;j<p.getKeywords().size();j++){
				if(this.getKeywords().get(i).equalsIgnoreCase(p.getKeywords().get(j))){
					product = (n-i)*(n-j);break;
				}
			}
			weight=weight+product;
		}
		weightObj.setTotalWeight(weight);
		weightObj.setPageNumber(pageNumber);
		return weightObj;
	}

}
