package com.learn.survey.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.learn.survey.model.Page;
import com.learn.survey.model.Question;
import com.learn.survey.service.SurveyService;

@Controller
@Scope("prototype")
public class QuestionAction extends BaseAction<Question> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer sid;
	private Integer pid;
	private Integer qid;
	
	@Autowired
	private SurveyService surveyService;
	
	public String selectOneQuestionType(){
		return "questionTypePage";
	}
	
	public String designQuestion(){
		return model.getQuestionType()+"";
	}
	
	public String deleteQuestion(){
		surveyService.deleteQuestion(qid);
		return "designSurveyAction";
	}
	
	public String editQuestion(){
		this.model = surveyService.findQuestionById(qid);
		return model.getQuestionType()+"";
	}
	
	public String saveOrUpdateQuestion(){
		Page p = new Page();
		p.setId(pid);
		model.setPage(p);
		surveyService.saveOrUpdateQuestion(model);
		return "designSurveyAction";
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

	public Integer getQid() {
		return qid;
	}

	public void setQid(Integer qid) {
		this.qid = qid;
	}
	

}
