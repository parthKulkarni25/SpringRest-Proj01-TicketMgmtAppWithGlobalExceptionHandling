package in.ineuron.service;

import java.util.List;

import in.ineuron.model.Tourist;

public interface ITouristMgmtService {
	
	public String registerTourist(Tourist tourist);
	public List<Tourist> fetAllTourist();
	public Tourist findTouristById(Integer tid);
	public String updateTouristById(Tourist tourist);
	public String updateTouristBudgetById(Integer tid,Float hike);
	public String deleteTouristById(Integer tid);

}
