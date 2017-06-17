package com.learn.survey.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.learn.survey.model.Page;
import com.learn.survey.model.Survey;
import com.learn.survey.service.SurveyService;

@Controller
@Scope("prototype")
public class PageAction extends BaseAction<Page> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2853791273405239972L;
	
	private Integer sid;
	
	private Integer pid;
	
	@Autowired
	private SurveyService surveyService;
	
	public String addPage(){
		return "addPage";
	}
	
	public String delPage(){
		surveyService.deletePage(pid);
		return "designSurveyAction";
	}
	
	public String saveOrUpdatePage(){
		Survey survey = new Survey();
		survey.setId(sid);
		model.setSurvey(survey);
		surveyService.saveOrUpdatePage(model);
		return "designSurveyAction";
	}
	
	public String editPage(){
		this.model = surveyService.getPageById(pid);
		return "editPage";
	}
	
	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}
	
	

}
