package com.learn.survey.service;

import java.util.List;

import com.learn.survey.model.Page;
import com.learn.survey.model.Question;
import com.learn.survey.model.Survey;
import com.learn.survey.model.User;

public interface SurveyService {

	public List<Survey> findMySurveyList(User user);

	public Survey saveSurvey(User user);

	public Survey findSurveyById(Integer sid);

	public Survey getSurveyById(Integer sid);

	public void updateSurvey(Survey model);

	public void saveOrUpdatePage(Page model);

	public Page getPageById(Integer pid);

	public void deleteQuestion(Integer qid);

	public void deletePage(Integer pid);

	public void deleteSurvey(Integer sid);

	public Question findQuestionById(Integer qid);

	public void saveOrUpdateQuestion(Question model);

	public void clearAnswer(Integer sid);

	public void toggleStatus(Integer sid);

	public void updateLogoPhotoPath(Integer sid, String string);

}
