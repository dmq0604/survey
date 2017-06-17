package com.learn.survey.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.survey.dao.BaseDao;
import com.learn.survey.model.Answer;
import com.learn.survey.model.Page;
import com.learn.survey.model.Question;
import com.learn.survey.model.Survey;
import com.learn.survey.model.User;
import com.learn.survey.service.SurveyService;

@Service("surveyService")
public class SurveyServiceImpl implements SurveyService {
	
	@Autowired
	private BaseDao<Survey> surveyDao;
	@Autowired
	private BaseDao<Page> pageDao;
	@Autowired
	private BaseDao<Answer> answerDao;
	@Autowired
	private BaseDao<Question> questionDao;
	

	@Override
	public List<Survey> findMySurveyList(User user) {
		String hql = "from Survey s where s.user.id=?";
		return surveyDao.getEntityByHQL(hql, user.getId());
	}

	@Override
	public Survey saveSurvey(User user) {
		Survey s = new Survey();
		s.setUser(user);
		Page page = new Page();
		page.setSurvey(s);
		s.getPages().add(page);
		surveyDao.saveEntity(s);
		pageDao.saveEntity(page);
		return s;
	}

	@Override
	public Survey findSurveyById(Integer sid) {
		Survey survey = this.getSurveyById(sid);
		for(Page page:survey.getPages()){
			page.getQuestions().size();
		}
		return survey;
	}

	@Override
	public Survey getSurveyById(Integer sid) {
		return  surveyDao.getEntity(sid);
	}

	@Override
	public void updateSurvey(Survey model) {
		surveyDao.updateEntity(model);
	}

	@Override
	public void saveOrUpdatePage(Page model) {
		pageDao.saveOrUpdateEntity(model);
	}

	@Override
	public Page getPageById(Integer pid) {
		return pageDao.getEntity(pid);
	}

	@Override
	public void deleteQuestion(Integer qid) {
		String answerHql = "delete from Answer a where a.questionId=?";
		answerDao.batchEntityByHQL(answerHql, qid);
		String questionHql = "delete from Question q where q.id=?";
		questionDao.batchEntityByHQL(questionHql, qid);
	}

	@Override
	public void deletePage(Integer pid) {
		String hql = "delete from Answer a where a.questionId in (select id from question q where q.page.id=?)";
		answerDao.batchEntityByHQL(hql, pid);
		hql = "delete from question q where q.page.id=?";
		questionDao.batchEntityByHQL(hql, pid);
		hql = "delete from page p where p.id=?";
		pageDao.batchEntityByHQL(hql, pid);
	}

	@Override
	public void deleteSurvey(Integer sid) {
		//delete answers
		String hql = "delete from Answer a where a.surveyId = ?" ;
		answerDao.batchEntityByHQL(hql,sid);
		
		//hibernate在写操作中,不允许两级以上的链接.
		//hql = "delete from Question q where q.page.survey.id = ?" ;
		hql = "delete from Question q where q.page.id in (select p.id from Page p where p.survey.id = ?)" ;
		questionDao.batchEntityByHQL(hql, sid);
		
		//delete page
		hql = "delete from Page p where p.survey.id = ? " ;
		pageDao.batchEntityByHQL(hql, sid);
		
		//delete survey
		hql = "delete from Survey s where s.id = ?" ;
		surveyDao.batchEntityByHQL(hql, sid);
	}

	@Override
	public Question findQuestionById(Integer qid) {
		return questionDao.getEntity(qid);
	}

	@Override
	public void saveOrUpdateQuestion(Question model) {
		questionDao.saveOrUpdateEntity(model);
	}

	@Override
	public void clearAnswer(Integer sid) {
		String hql = "delete from Answer where surveyId=?";
		answerDao.batchEntityByHQL(hql, sid);
	}

	@Override
	public void toggleStatus(Integer sid) {
		Survey s=this.getSurveyById(sid);
		String hql = "update Survey s set s.closed = ? where s.id = ?" ;
		surveyDao.batchEntityByHQL(hql,!s.isClosed(),sid);
	}

	@Override
	public void updateLogoPhotoPath(Integer sid, String path) {
		String hql = "update Survey s set s.logoPhotoPath=? where s.id=?";
		surveyDao.batchEntityByHQL(hql,path, sid);
	}

}
