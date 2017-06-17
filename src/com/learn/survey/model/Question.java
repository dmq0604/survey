package com.learn.survey.model;

import org.apache.commons.lang3.StringUtils;

public class Question {

	//
	private Integer id;
	// 题型0-8
	private int questionType;
	//
	private String title;
	// 选项
	private String options;
	
	private String[] optionArr;

	// 其他项
	private boolean other;

	// 其他项样式:0-无 1-文本框 2-下拉列表
	private int otherStyle;

	// 其他项下拉选项
	private String otherSelectOptions;
	
	private String[] otherSelectOptionArr;

	// 矩阵式行标题集
	private String matrixRowTitles;
	
	private String[] matrixRowTitleArr;

	// 矩阵式列标题集
	private String matrixColTitles;
	
	private String[] matrixColTitleArr;
	
	// 矩阵是下拉选项集
	private String matrixSelectOptions;
	
	private String[] matrixSelectOptionArr;

	//建立从Question到Page之间多对一关联关系
	private Page page;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getQuestionType() {
		return questionType;
	}

	public void setQuestionType(int questionType) {
		this.questionType = questionType;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOptions() {
		return options;
	}

	public void setOptions(String options) {
		this.options = options;
		if(StringUtils.isNotBlank(options)){
			this.optionArr = options.split(",");
		}
	}

	public boolean isOther() {
		return other;
	}

	public void setOther(boolean other) {
		this.other = other;
	}

	public int getOtherStyle() {
		return otherStyle;
	}

	public void setOtherStyle(int otherStyle) {
		this.otherStyle = otherStyle;
	}

	public String getOtherSelectOptions() {
		return otherSelectOptions;
	}

	public void setOtherSelectOptions(String otherSelectOptions) {
		this.otherSelectOptions = otherSelectOptions;
		if(StringUtils.isNotBlank(otherSelectOptions)){
			this.otherSelectOptionArr = otherSelectOptions.split(",");
		}
	}

	public String getMatrixRowTitles() {
		return matrixRowTitles;
	}

	public void setMatrixRowTitles(String matrixRowTitles) {
		this.matrixRowTitles = matrixRowTitles;
		if(StringUtils.isNotBlank(matrixRowTitles)){
			this.matrixRowTitleArr = matrixRowTitles.split(",");
		}
	}

	public String getMatrixColTitles() {
		return matrixColTitles;
	}

	public void setMatrixColTitles(String matrixColTitles) {
		this.matrixColTitles = matrixColTitles;
		if(StringUtils.isNotBlank(matrixColTitles)){
			this.matrixColTitleArr = matrixColTitles.split(",");
		}
	}

	public String getMatrixSelectOptions() {
		return matrixSelectOptions;
	}

	public void setMatrixSelectOptions(String matrixSelectOptions) {
		this.matrixSelectOptions = matrixSelectOptions;
		if(StringUtils.isNotBlank(matrixSelectOptions)){
			this.matrixSelectOptionArr = matrixSelectOptions.split(",");
		}
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String[] getOptionArr() {
		return optionArr;
	}

	public void setOptionArr(String[] optionArr) {
		this.optionArr = optionArr;
	}

	public String[] getOtherSelectOptionArr() {
		return otherSelectOptionArr;
	}

	public void setOtherSelectOptionArr(String[] otherSelectOptionArr) {
		this.otherSelectOptionArr = otherSelectOptionArr;
	}

	public String[] getMatrixRowTitleArr() {
		return matrixRowTitleArr;
	}

	public void setMatrixRowTitleArr(String[] matrixRowTitleArr) {
		this.matrixRowTitleArr = matrixRowTitleArr;
	}

	public String[] getMatrixColTitleArr() {
		return matrixColTitleArr;
	}

	public void setMatrixColTitleArr(String[] matrixColTitleArr) {
		this.matrixColTitleArr = matrixColTitleArr;
	}

	public String[] getMatrixSelectOptionArr() {
		return matrixSelectOptionArr;
	}

	public void setMatrixSelectOptionArr(String[] matrixSelectOptionArr) {
		this.matrixSelectOptionArr = matrixSelectOptionArr;
	}
	
}
