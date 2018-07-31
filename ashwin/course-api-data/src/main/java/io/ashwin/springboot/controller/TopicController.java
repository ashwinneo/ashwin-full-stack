package io.ashwin.springboot.controller;

import io.ashwin.springboot.request.SignUpRequest;
import io.ashwin.springboot.request.TeamInfo;
import io.ashwin.springboot.request.Topic;
import io.ashwin.springboot.topic.TopicService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicService;
	
//	@RequestMapping("league/{league}/{name}")
	@RequestMapping("league")
//	public Object getTopics(@RequestParam String league , Topic topic){
//	public Object getTopics(@PathVariable(name = "league", required = false) String league,@PathVariable(name = "name", required = false) String name, Topic topic){
	public Object getTopics(@RequestParam(value = "league", required=false) String  league,@RequestParam(value = "name", required=false) String name, Topic topic){
		
			return topicService.getTopicById(league ,name, topic);
			
	}
	

	@RequestMapping("leagues")
	public Object getLeagueById(){
		//return topicService.getTopics();
		Object topic = null;
		topic = topicService.getTopics();
		return topic;
	}
	
//	@RequestMapping(value="/topics" , method=RequestMethod.POST)
	@PostMapping(value="/createLeague")
	public Object addTopic(@RequestBody Topic topic){
//		Object obj = topicService.validateEmpty(topic);
//		if(obj instanceof ErrorResponse){
//			return obj;
//			
//		}else{
			return topicService.addTopic(topic);
		//}
	}
	
//	@RequestMapping(method=RequestMethod.PUT, value="topics/{id}")
	@PutMapping(value="editLeague")
	public Object updateTopic(@RequestBody Topic topic , @RequestParam(value = "id", required=false) String  id){
		return topicService.updateTopic(id , topic);
	}
	
	@DeleteMapping(value="/deleteLeague")
		public Object deleteTopic(@RequestParam(value = "id", required=false) String id){
			
		return topicService.deleteTopic(id);
	}

	@RequestMapping("teamInfo")
	public Object getTeamInfo(@RequestParam(value = "name", required=false) String name){
		return topicService.getTeamInfo(name);
	}
	
	@PostMapping(value= "signUp")
	public Object registerAccount(@RequestBody SignUpRequest signUpRequest){
		
		return topicService.registerAccount(signUpRequest);
	}
	
	@RequestMapping("getLoginDetails")
	public Object getLoginDetails(@RequestParam(value = "userId" , required=false) String userId, @RequestParam(value = "password" , required=false) String password, @RequestParam(value = "emailId" , required=false) String emailId) {
		
		return topicService.getLoginDetails(userId,password,emailId);
	}
	
	@PutMapping(value = "updateUserDetails")
	public Object updatePassword(@RequestBody SignUpRequest signUpRequest ,@RequestParam(value = "id", required=false)  String id){
		
		return topicService.updatePassword(signUpRequest,id);
	}
	
	@RequestMapping("getLeague")
	public Object getLeague() {
		
		return topicService.getLeague();
	}
	
	private static String UPLOADED_FOLDER = "E://temp//";

	
	@RequestMapping("getTeamSquad")
	public Object getTeamSquad(@RequestParam(value="teamName") String teamName) {
		return this.topicService.getTeamSquad(teamName);
	}
	
	@PostMapping("/upload") // //new annotation since 4.3
    public Object singleFileUpload(@RequestBody SignUpRequest signUpRequest,@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {
		
		return topicService.uploadImage(signUpRequest,file,redirectAttributes);
		
//        if (file.isEmpty()) {
//            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
//            return "redirect:uploadStatus";
//        }
//
//        try {
//
//            // Get the file and save it somewhere
//            byte[] bytes = file.getBytes();
//            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
//            Files.write(path, bytes);
//            System.out.println("path" + "--->" + path);
//            redirectAttributes.addFlashAttribute("message",
//                    "You successfully uploaded '" + file.getOriginalFilename() + "'");
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return "redirect:/uploadStatus";
    }
	
	@RequestMapping("getManagerDetails")
	public Object getManagerDetails(@RequestParam("name") String name) {
		return topicService.getManagerDetails(name);
	}
	
	@PutMapping("updateTeamInfo")
	public Object updateTeamInfo(@RequestBody TeamInfo teamInfo){
		return topicService.updateTeamInfo(teamInfo);
	}
	
	@PutMapping("updateTeamName")
	public Object updateTeamName(@RequestBody Topic topic) {
		return topicService.updateTeamName(topic);
	}
}
