package io.ashwin.springboot.response;

public class TopicResponse {

	private int appStatus;
	private String status;
	private String successMessage;
	public String getSuccessMessage() {
		return successMessage;
	}
	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}
	private Object leagueResponse;
	public int getAppStatus() {
		return appStatus;
	}
	public void setAppStatus(int appStatus) {
		this.appStatus = appStatus;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Object getLeagueResponse() {
		return leagueResponse;
	}
	public void setLeagueResponse(Object topicResponse) {
		this.leagueResponse = topicResponse;
	}
	
	
}
