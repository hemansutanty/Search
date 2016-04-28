package search;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindSearchResults {
		
	

	public static void main(String[] args) {
		
		List<Page> pages = new ArrayList<Page>();
		List<Query> queries = new ArrayList<Query>();
		WeightObject weight;
		//Input 
		/*String[] input={"P Ford Car Review","P Review Car","P Review Ford",
						"P Toyota Car","P Honda Car","P Car","Q Ford","Q Car",
						"Q Review","Q Ford Review","Q Ford Car","Q cooking French"};*/
		String[] input2 = {"P Ford Car","PP Review Car","PP Review Ford","P Toyota Car","PP Car","Q Ford","Q Car","Q Review"};
		int lastParent = -1;
		for(int i=0;i<input2.length;i++){
			//List<Page> childPages = new ArrayList<>();
			if(input2[i].substring(0, 0+2).equals("P ")){
				Page newPage = new Page();
				List<String> keywords = new ArrayList<String>();
				String[] keys = input2[i].split("\\s");
				for(String key:keys){
					if(!key.equalsIgnoreCase("P")){
						//System.out.print(key+"\t");
						keywords.add(key);
					}
					
				}
				//System.out.println();
				newPage.setKeywords(keywords);
				pages.add(newPage);
				lastParent++;
			}
			else if(input2[i].substring(0, 0+2).equals("PP")){
				Page newPage = new Page();
				List<String> keywords = new ArrayList<String>();
				String[] keys = input2[i].split("\\s");
				for(String key:keys){
					if(!key.equalsIgnoreCase("P")){
						//System.out.print(key+"\t");
						keywords.add(key);
					}
					
				}
				//System.out.println();
				newPage.setKeywords(keywords);
				pages.get(lastParent).addChildPage(newPage);
				
			}
			else if(input2[i].charAt(0)=='Q'){
				Query newQuery = new Query();
				List<String> keywords = new ArrayList<String>();
				String[] keys = input2[i].split("\\s");
				for(String key:keys){
					if(!key.equalsIgnoreCase("Q")){
						//System.out.print(key+"\t");
						keywords.add(key);
					}
				}
				newQuery.setKeywords(keywords);
				queries.add(newQuery);
				//System.out.println();
			}
		}
	
		for(int i=0;i<queries.size();i++){
			List<WeightObject> wtobjects = new ArrayList<WeightObject>();
			for(int j=0;j<pages.size();j++){
				//System.out.println(queries.get(i).getKeywords()+"\t"+pages.get(j).getKeywords());
				
				weight = queries.get(i).findWeight(pages.get(j),8,j);
				wtobjects.add(weight);
				for(int k=0;k<pages.get(j).getChildPages().size();k++){
					WeightObject childWeight = queries.get(i).findWeight(pages.get(j).getChildPages().get(k), 8, j);
					Double percentWeight = (10/100.0)*childWeight.getTotalWeight();
					weight.setTotalWeight(weight.getTotalWeight()+percentWeight);
				}
				
			}
			Collections.sort(wtobjects);
			System.out.print("Q"+(i+1)+":");
			for(int k=0;k<5 && k<wtobjects.size() && wtobjects.get(k).getTotalWeight()!=0;k++){
				System.out.print("P"+(wtobjects.get(k).getPageNumber()+1)+"\t");
			}
			System.out.println();
		}
		
	}

}
