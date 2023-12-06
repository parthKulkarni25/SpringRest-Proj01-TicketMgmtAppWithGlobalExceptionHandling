package in.ineuron.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.dao.ITouristMgmtDAO;
import in.ineuron.exception.TouristNotFoundException;
import in.ineuron.model.Tourist;

@Service
public class TouristMgmtServiceImpl implements ITouristMgmtService {

	@Autowired
	private ITouristMgmtDAO dao;
	
	@Override
	public String registerTourist(Tourist tourist) {
		
		Integer tid = dao.save(tourist).getTid();
		return "Tourist Registered with tid :: "+tid ;
	}

	@Override
	public List<Tourist> fetAllTourist() {
		List<Tourist> list = dao.findAll();
		list.sort((t1,t2) ->t1.getTid().compareTo(t2.getTid()));
		
		return list;
	}

	@Override
	public Tourist findTouristById(Integer tid) {
		
		Optional<Tourist> optional = dao.findById(tid);
		
		if(optional.isPresent()) {
			return optional.get();
		}else
			throw new TouristNotFoundException("Tourist not found");
	}

	@Override
	public String updateTouristById(Tourist tourist) {
		
		Optional<Tourist> optional = dao.findById(tourist.getTid());
		if(optional.isPresent()) {
			dao.save(tourist);
			return "details updated..";
		}else
			throw new TouristNotFoundException("Tourist not found");
	}

	@Override
	public String updateTouristBudgetById(Integer tid, Float hike) {
		Optional<Tourist> optional = dao.findById(tid);
		if (optional.isPresent()) {
			Tourist tourist = optional.get();
			Double budget = tourist.getBudget()+ (tourist.getBudget()+(hike/100));
			tourist.setBudget(budget);
			dao.save(tourist);
			return "details updated..";
		}else
			throw new TouristNotFoundException("Tourist not found");
	
		
		
	}

	@Override
	public String deleteTouristById(Integer tid) {
		Optional<Tourist> optional = dao.findById(tid);
		if (optional.isPresent()) {
			dao.deleteById(tid);
			return "details deleted..";
		}else
			throw new TouristNotFoundException("Tourist not found");
	}

}
