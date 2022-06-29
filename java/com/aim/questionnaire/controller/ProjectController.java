package com.aim.questionnaire.controller;

import com.aim.questionnaire.beans.HttpResponseEntity;
import com.aim.questionnaire.common.Constans;
import com.aim.questionnaire.common.utils.DateUtil;
import com.aim.questionnaire.common.utils.UUIDUtil;
import com.aim.questionnaire.dao.entity.ProjectEntity;
import com.aim.questionnaire.service.ProjectService;

import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.RequestDispatcher;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wln on 2018\8\6 0006.
 */
@RestController
public class ProjectController {

    private final Logger logger = LoggerFactory.getLogger(ProjectController.class);

    @Autowired
    private ProjectService projectService;


    /**
     * 查询全部项目的信息
     * @param projectEntity
     * @return
     */
    @RequestMapping(value = "/queryProjectList",method = RequestMethod.POST, headers = "Accept=application/json")
    public HttpResponseEntity queryProjectList(@RequestBody(required = false) ProjectEntity projectEntity) {
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        httpResponseEntity.setCode(Constans.SUCCESS_CODE);
        ProjectEntity projectEntity1 = projectService.queryProjectById(projectEntity);


        httpResponseEntity.setData(projectEntity1);


        return httpResponseEntity;
    }

    @RequestMapping(value = "/createQuestionnaire",method = RequestMethod.POST, headers = "Accept=application/json")
    public void creatQuestionnaire(@RequestBody ProjectEntity projectEntity)

    {

    }

    /**
     * 根据id删除项目
     * @param projectEntity
     * @return
     */


    /**
     * 添加项目
     * @param projectEntity
     * @return
     */
    @RequestMapping(value = "/addProjectInfo",method = RequestMethod.POST, headers = "Accept=application/json")
    public HttpResponseEntity addProjectInfo(@RequestBody ProjectEntity projectEntity) {
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        if (projectService.addProjectInfo(projectEntity, projectEntity.getCreatedBy())==1){
            httpResponseEntity.setCode(Constans.SUCCESS_CODE);
            httpResponseEntity.setMessage(Constans.ADD_MESSAGE);
        }else {
            httpResponseEntity.setCode(Constans.EXIST_CODE);
        }
        return httpResponseEntity;
    }
    @RequestMapping(value = "/queryProjectListByName",method = RequestMethod.POST, headers = "Accept=application/json")
    public HttpResponseEntity queryProjectListByName(@RequestBody(required = false) ProjectEntity projectEntity) {
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();

        httpResponseEntity.setCode(Constans.SUCCESS_CODE);
        List<Object> projects = projectService.queryProjectListByName(projectEntity);
        httpResponseEntity.setData(projects);
        return httpResponseEntity;
    }





    /**
     * 根据项目id修改项目
     * @param projectEntity
     * @return
     */
    @RequestMapping(value = "/modifyProjectInfo",method = RequestMethod.POST, headers = "Accept=application/json")
    public HttpResponseEntity modifyProjectInfo(@RequestBody ProjectEntity projectEntity) {
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        if(projectService.modifyProjectInfo(projectEntity)>=1)
        {
            httpResponseEntity.setCode(Constans.SUCCESS_CODE);

        }
        else
        {
            httpResponseEntity.setCode(Constans.EXIST_CODE);
        }
        return httpResponseEntity;
    }



    /**
     * 查询全部项目的名字接口
     * @return
     */
    @RequestMapping(value = "/queryAllProjectName",method = RequestMethod.POST, headers = "Accept=application/json")
    public HttpResponseEntity queryAllProjectName() {
        System.out.println("进入controller获得列表");
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
          httpResponseEntity.setCode(Constans.SUCCESS_CODE);
        List<Map<String,Object>> list = projectService.queryAllProjectName();


        httpResponseEntity.setData(new PageInfo(list));
        return httpResponseEntity;
    }
    @RequestMapping(value = "/deleteProjectById",method = RequestMethod.POST, headers = "Accept=application/json")
    public HttpResponseEntity deleteProjectById(ProjectEntity projectEntity) {
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();

        projectService.deleteProjectById(projectEntity);
        httpResponseEntity.setCode(Constans.SUCCESS_CODE);
        return httpResponseEntity;
    }

}
