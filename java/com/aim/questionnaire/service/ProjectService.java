package com.aim.questionnaire.service;

import com.aim.questionnaire.common.utils.DateUtil;
import com.aim.questionnaire.common.utils.UUIDUtil;
import com.aim.questionnaire.dao.ProjectEntityMapper;
import com.aim.questionnaire.dao.entity.ProjectEntity;
import com.aim.questionnaire.dao.entity.QuestionnaireEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by wln on 2018\8\6 0006.
 */
@Service
public class ProjectService {

    @Autowired
    private ProjectEntityMapper projectEntityMapper;


    /**
     * 添加项目
     * @param projectEntity
     * @return
     */
    public int addProjectInfo(ProjectEntity projectEntity,String user) {
        Map<String, Object> map = new HashMap();
        map.put("id", UUIDUtil.getOneUUID());
        map.put("userId", projectEntity.getUserId());
        map.put("projectName", projectEntity.getProjectName());
        map.put("projectContent", projectEntity.getProjectContent());
        map.put("createdBy", projectEntity.getCreatedBy());
        map.put("creationDate", DateUtil.getMyTime(String.valueOf(System.currentTimeMillis())));
        map.put("lastUpdatedBy", projectEntity.getLastUpdatedBy());
        map.put("lastUpdateDate", DateUtil.getMyTime(String.valueOf(System.currentTimeMillis())));
        return projectEntityMapper.addProjectInfo(map);
    }


    /**
     * 修改项目
     * @param projectEntity
     * @return
     */
    public int modifyProjectInfo(ProjectEntity projectEntity) {
       
        HashMap<String,Object> map = new HashMap<>();
        map.put("id",projectEntity.getId());
        map.put("projectContent",projectEntity.getProjectContent());

        map.put("projectName",projectEntity.getProjectName());
        return projectEntityMapper.updateByPrimaryKey(map);
    }

    /**
     * 删除项目
     * @param projectEntity
     * @return
     */
    public int deleteProjectById(ProjectEntity projectEntity) {
       projectEntityMapper.deleteProjectById(projectEntity.getId());
        return 0;
    }

    /**
     * 查询项目列表
     * @param projectEntity
     * @return
     */
    @Autowired
    QuestionnaireService questionnaireService;
    public ProjectEntity queryProjectById(ProjectEntity projectEntity) {
       ProjectEntity projectEntity1 = projectEntityMapper.queryProjectById(projectEntity.getId());



       List<Object> questionnaireList = questionnaireService.queryQuestionListByProjectId(projectEntity.getId());


       projectEntity1.setQuestionnaireList(questionnaireList);

        return projectEntity1;
    }

    /**
     * 查询全部项目的名字接口
     * @return
     */
    public List<Map<String,Object>> queryAllProjectName() {

        List<Map<String,Object>> list = projectEntityMapper.queryAllProjectName();
        return null;
    }/**
     * 根据name查询项目
     * @return
     */
    public List<Object> queryProjectListByName(ProjectEntity projectEntity) {
        List<Object> resultList = new ArrayList<>();
        List<Map<String, Object>> list = projectEntityMapper.queryProjectListByName(projectEntity);
        for (Map<String, Object> m: list){
            if(m.get("createdBy").equals(projectEntity.getCreatedBy())){
                ProjectEntity p = new ProjectEntity();
                p.setProjectContent((String) m.get("projectContent"));
                p.setProjectName((String)m.get("projectName"));
                p.setId((String)m.get("id"));
                resultList.add(p);
            }
        }
        return resultList;
    }

}
