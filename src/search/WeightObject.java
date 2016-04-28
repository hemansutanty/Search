package search;

public class WeightObject implements Comparable<WeightObject>{
	
	private Double totalWeight;
	private Integer pageNumber;
	public Double getTotalWeight() {
		return totalWeight;
	}
	public void setTotalWeight(Double totalWeight) {
		this.totalWeight = totalWeight;
	}
	public Integer getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}
	
	@Override
	public int compareTo(WeightObject o) {
		// TODO Auto-generated method stub
		double getWeight = o.getTotalWeight();
		//descending order
		 if(getWeight-this.getTotalWeight()==0){
			return 0;
		 }
		else if(getWeight-this.getTotalWeight()<0){
			return -1;
		}
		else{
			return 1;
		}
	}	
}
