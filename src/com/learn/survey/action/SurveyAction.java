package com.learn.survey.action;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.util.ServletContextAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.learn.survey.model.Survey;
import com.learn.survey.model.User;
import com.learn.survey.service.SurveyService;
import com.learn.survey.struts.UserAware;

@Controller
@Scope("prototype")
public class SurveyAction extends BaseAction<Survey> implements UserAware,ServletContextAware{

	private static final long serialVersionUID = -431469521989037556L;
	private List<Survey> surveyList;
	private User user;
	private Integer sid;
	
	private File logoPhoto;
	private String logoPhotoFileName;
	private String logoPhotoContentType;
	
	@Autowired
	private SurveyService surveyService;
	
	private ServletContext sc;
	
	//动态错误页指定
	private String inputPage ;
	
	public String getInputPage() {
		return inputPage;
	}

	public void setInputPage(String inputPage) {
		this.inputPage = inputPage;
	}
	
	
	public String list(){
		this.surveyList = surveyService.findMySurveyList(user);
		return "list";
	}
	
	public String saveSurvey(){
		this.model = surveyService.saveSurvey(user);
		return "designSurvey";
	}
	
	public String designSurvey(){
		this.model = surveyService.findSurveyById(sid);
		return "designSurvey";
	}
	
	public String delSurvey(){
		surveyService.deleteSurvey(sid);
		return "listAction";
	}
	
	public String editSurvey(){
		this.model = surveyService.getSurveyById(sid);
		return "editSurvey";
	}
	
	public String updateSurvey(){
		this.sid = model.getId();
		model.setUser(user);
		surveyService.updateSurvey(model);
		return "designSurveyAction";
	}
	
	/**
	 * 该方法只在updateSurvey之前运行
	 */
	public void prepareUpdateSurvey(){
		inputPage = "/editSurvey.jsp" ;
	}
	
	
	public String clearAnswer(){
		surveyService.clearAnswer(sid);
		return "designSurveyAction";
	}
	
	public String toggleStatus(){
		surveyService.toggleStatus(sid);
		return "designSurveyAction";
	}
	
	public String toAddLogoPage(){
		
		return "addLogoPage";
	}
	
	public String doAddLogo(){
		if(StringUtils.isNotBlank(logoPhotoFileName)){
			String dir = sc.getRealPath("/upload");
			String ext = logoPhotoFileName.substring(logoPhotoFileName.lastIndexOf("."));
			long l = System.nanoTime();
			File newFile = new File(dir,l+ext);
			logoPhoto.renameTo(newFile);
			surveyService.updateLogoPhotoPath(sid,"/upload"+l+ext);
		}
		return "designSurveyAction";
	}
	
	/**
	 * 该方法只在updateSurvey之前运行
	 */
	public void prepareDoAddLogo(){
		inputPage = "/addLogo.jsp" ;
	}
	
	public boolean photoExists(){
		String path = model.getLogoPhotoPath();
		if(StringUtils.isNotBlank(path)){
			String absPaht = sc.getRealPath(path);
			File file = new File(absPaht);
			return file.exists();
		}
		return false;
	}
	

	public List<Survey> getSurveyList() {
		return surveyList;
	}

	public void setSurveyList(List<Survey> surveyList) {
		this.surveyList = surveyList;
	}

	@Override
	public void setUser(User user) {
		this.user = user;
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public File getlogoPhoto() {
		return logoPhoto;
	}

	public void setlogoPhoto(File logoPhoto) {
		this.logoPhoto = logoPhoto;
	}

	public String getLogoPhotoFileName() {
		return logoPhotoFileName;
	}

	public void setLogoPhotoFileName(String logoPhotoFileName) {
		this.logoPhotoFileName = logoPhotoFileName;
	}

	public String getLogoPhotoContentType() {
		return logoPhotoContentType;
	}

	public void setLogoPhotoContentType(String logoPhotoContentType) {
		this.logoPhotoContentType = logoPhotoContentType;
	}

	@Override
	public void setServletContext(ServletContext arg0) {
		this.sc = arg0;
	}
	
	
	
}
