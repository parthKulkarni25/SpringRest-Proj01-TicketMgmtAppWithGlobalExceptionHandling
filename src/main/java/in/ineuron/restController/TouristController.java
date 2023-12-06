package in.ineuron.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.exception.TouristNotFoundException;
import in.ineuron.model.Tourist;
import in.ineuron.service.ITouristMgmtService;

@RestController
@RequestMapping("/api/tourist")
public class TouristController {

	@Autowired
	private ITouristMgmtService service;
	
	@PostMapping("/reg")
	public ResponseEntity<String> enrollTourist(@RequestBody Tourist tourist){
		
		String	body= service.registerTourist(tourist);
		return new ResponseEntity<String>(body,HttpStatus.OK);
		
	}
	
	@GetMapping("/fetchTourists")
	public ResponseEntity<List<Tourist>> getAllTourist(){
		
			List<Tourist> tourists = service.fetAllTourist();
			return new ResponseEntity<List<Tourist>>(tourists,HttpStatus.OK);
		
		
	}
	@GetMapping("/find/{tid}")
	public ResponseEntity<Tourist> geTouristById(@PathVariable Integer tid){
		
			Tourist tourist = service.findTouristById(tid);
			return new ResponseEntity<Tourist>(tourist,HttpStatus.OK);
		
			
	}
	
	@PutMapping("/modify")
	public ResponseEntity<String> updateTourist(@RequestBody Tourist tourist){
		
		
			String body= service.updateTouristById(tourist);
			return new ResponseEntity<String>(body,HttpStatus.OK);
		
	}
	
	@PatchMapping("/budgetModify/{tid}/{hike}")
	public ResponseEntity<String> updateTouristBudgetById(@PathVariable Integer tid,@PathVariable Float hike){		
			String body= service.updateTouristBudgetById(tid, hike);
			return new ResponseEntity<String>(body,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteTourist/{tid}")
	public ResponseEntity<String> deleteTouristById(@PathVariable Integer tid){
		
			String body= service.deleteTouristById(tid);
			return new ResponseEntity<String>(body,HttpStatus.OK);
		
		
	}
	
}
