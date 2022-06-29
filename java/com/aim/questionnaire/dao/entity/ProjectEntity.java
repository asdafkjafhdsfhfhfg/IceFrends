package com.aim.questionnaire.dao.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ProjectEntity   {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project_info.id
     *
     * @mbg.generated
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project_info.user_id
     *
     * @mbg.generated
     */
    private String userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project_info.project_name
     *
     * @mbg.generated
     */
    private String projectName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project_info.project_content
     *
     * @mbg.generated
     */
    private String projectContent;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project_info.created_by
     *
     * @mbg.generated
     */
    private String createdBy;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project_info.creation_date
     *
     * @mbg.generated
     */
    private Date creationDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project_info.last_updated_by
     *
     * @mbg.generated
     */
    private String lastUpdatedBy;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project_info.last_update_date
     *
     * @mbg.generated
     */
    private Date lastUpdateDate;

    public QuestionnaireEntity getQuestionnaireEntity() {
        return questionnaireEntity;
    }

    public void setQuestionnaireEntity(QuestionnaireEntity questionnaireEntity) {
        this.questionnaireEntity = questionnaireEntity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_info.id
     *
     * @return the value of project_info.id
     *
     * @mbg.generated
     */
    private QuestionnaireEntity questionnaireEntity;
    private List<Object> questionnaireList;
    public String getId() {
        return id;
    }


    public List<Object> getQuestionnaireList() {
        return questionnaireList;
    }

    public void setQuestionnaireList(List<Object> questionnaireList) {
        this.questionnaireList = questionnaireList;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_info.id
     *
     * @param id the value for project_info.id
     *
     * @mbg.generated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_info.user_id
     *
     * @return the value of project_info.user_id
     *
     * @mbg.generated
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_info.user_id
     *
     * @param userId the value for project_info.user_id
     *
     * @mbg.generated
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_info.project_name
     *
     * @return the value of project_info.project_name
     *
     * @mbg.generated
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_info.project_name
     *
     * @param projectName the value for project_info.project_name
     *
     * @mbg.generated
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_info.project_content
     *
     * @return the value of project_info.project_content
     *
     * @mbg.generated
     */
    public String getProjectContent() {
        return projectContent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_info.project_content
     *
     * @param projectContent the value for project_info.project_content
     *
     * @mbg.generated
     */
    public void setProjectContent(String projectContent) {
        this.projectContent = projectContent == null ? null : projectContent.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_info.created_by
     *
     * @return the value of project_info.created_by
     *
     * @mbg.generated
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_info.created_by
     *
     * @param createdBy the value for project_info.created_by
     *
     * @mbg.generated
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_info.creation_date
     *
     * @return the value of project_info.creation_date
     *
     * @mbg.generated
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_info.creation_date
     *
     * @param creationDate the value for project_info.creation_date
     *
     * @mbg.generated
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_info.last_updated_by
     *
     * @return the value of project_info.last_updated_by
     *
     * @mbg.generated
     */
    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_info.last_updated_by
     *
     * @param lastUpdatedBy the value for project_info.last_updated_by
     *
     * @mbg.generated
     */
    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy == null ? null : lastUpdatedBy.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_info.last_update_date
     *
     * @return the value of project_info.last_update_date
     *
     * @mbg.generated
     */
    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_info.last_update_date
     *
     * @param lastUpdateDate the value for project_info.last_update_date
     *
     * @mbg.generated
     */
    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }
}