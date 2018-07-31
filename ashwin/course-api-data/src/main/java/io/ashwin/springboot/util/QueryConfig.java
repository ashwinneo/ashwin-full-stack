package io.ashwin.springboot.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:query.properties")
public class QueryConfig {

	@Value("${getAllLeagues}")
	private String getAllLeagues;
	
	@Value("${getLeagueByName}")
	private String getLeagueByName;
	
	@Value("${createLeague}")
	private String createLeague;

	@Value("${editLeague}")
	private String editLeague;
	
	@Value("${deleteLeague}")
	private String deleteLeague;
	
	@Value("${getTeamInfoByName}")
	private String getTeamInfoByName;
	
	@Value("${getLeague}")
	private String getLeague;
	
	@Value("${updateTeamInfo}")
	private String updateTeamInfo;

	@Value("${registerAccount}")
	private String registerAccount;
	
	@Value("${getLoginDetails}")
	private String getLoginDetails;
	
	@Value("${updatePassword}")
	private String updatePassword;

	@Value("${updateProfile}")
	private String updateProfile;
	
	@Value("${getManagerInfo}")
	private String getManagerInfo;
	
	public String getGetManagerInfo() {
		return getManagerInfo;
	}

	public void setGetManagerInfo(String getManagerInfo) {
		this.getManagerInfo = getManagerInfo;
	}

	public String getUpdateProfile() {
		return updateProfile;
	}

	public void setUpdateProfile(String updateProfile) {
		this.updateProfile = updateProfile;
	}

	public String getUpdatePassword() {
		return updatePassword;
	}

	public void setUpdatePassword(String updatePassword) {
		this.updatePassword = updatePassword;
	}

	public String getGetLoginDetails() {
		return getLoginDetails;
	}

	public void setGetLoginDetails(String getLoginDetails) {
		this.getLoginDetails = getLoginDetails;
	}

	public String getRegisterAccount() {
		return registerAccount;
	}

	public void setRegisterAccount(String registerAccount) {
		this.registerAccount = registerAccount;
	}
	
	public String getUpdateTeamName() {
		return updateTeamName;
	}

	public void setUpdateTeamName(String updateTeamName) {
		this.updateTeamName = updateTeamName;
	}

	@Value("${updateTeamName}")
	private String updateTeamName;
	
	public String getUpdateTeamInfo() {
		return updateTeamInfo;
	}

	public void setUpdateTeamInfo(String updateTeamInfo) {
		this.updateTeamInfo = updateTeamInfo;
	}

	public String getGetTeamSquad() {
		return getTeamSquad;
	}

	public void setGetTeamSquad(String getTeamSquad) {
		this.getTeamSquad = getTeamSquad;
	}

	@Value("${getTeamSquad}")
	private String getTeamSquad;
	
	public String getGetLeague() {
		return getLeague;
	}

	public void setGetLeague(String getLeague) {
		this.getLeague = getLeague;
	}

	public String getGetTeamInfoByName() {
		return getTeamInfoByName;
	}

	public void setGetTeamInfoByName(String getTeamInfoByName) {
		this.getTeamInfoByName = getTeamInfoByName;
	}

	public String getDeleteLeague() {
		return deleteLeague;
	}

	public void setDeleteLeague(String deleteLeague) {
		this.deleteLeague = deleteLeague;
	}

	public String getEditLeague() {
		return editLeague;
	}

	public void setEditLeague(String editLeague) {
		this.editLeague = editLeague;
	}

	public String getCreateLeague() {
		return createLeague;
	}

	public void setCreateLeague(String createLeague) {
		this.createLeague = createLeague;
	}

	public String getGetLeagueByName() {
		return getLeagueByName;
	}

	public void setGetLeagueByName(String getLeagueByName) {
		this.getLeagueByName = getLeagueByName;
	}

	public String getGetAllLeagues() {
		return getAllLeagues;
	}

	public void setGetAllLeagues(String getAllLeagues) {
		this.getAllLeagues = getAllLeagues;
	}
	
	
}
