package com.aim.questionnaire.controller;


import com.aim.questionnaire.beans.HttpResponseEntity;
import com.aim.questionnaire.common.Constans;
import com.aim.questionnaire.common.utils.DateUtil;
import com.aim.questionnaire.common.utils.UUIDUtil;
import com.aim.questionnaire.dao.entity.ProjectEntity;
import com.aim.questionnaire.dao.entity.QuestionnaireEntity;
import com.aim.questionnaire.dao.entity.UserEntity;
import com.aim.questionnaire.service.ProjectService;

import com.aim.questionnaire.service.QuestionnaireService;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.web.servlet.Cookie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class QuestionnaireController {
    private final Logger logger = LoggerFactory.getLogger(QuestionnaireController.class);
    @Autowired
    private QuestionnaireService questionnaireService;

    @RequestMapping(value = "/addQuestionnaire", method = RequestMethod.POST, headers = "Accept=application/json")
    public HttpResponseEntity addProjectInfo(@RequestBody QuestionnaireEntity questionnaireEntity) {
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        if (questionnaireService.addQuestionnaire(questionnaireEntity) != null) {
            httpResponseEntity.setCode(Constans.SUCCESS_CODE);
            List<Object> list = questionnaireService.queryQuestionListByProjectId(questionnaireEntity.getProjectId());
            System.out.println("在控制层" + questionnaireEntity.getProjectId());
            List<Object> newList = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                if (i >= 5)
                    break;
                newList.add(list.get(i));
                QuestionnaireEntity q = (QuestionnaireEntity) newList.get(i);

            }
            httpResponseEntity.setData(newList);


            httpResponseEntity.setMessage(Constans.ADD_MESSAGE);
        } else {
            httpResponseEntity.setCode(Constans.EXIST_CODE);
        }
        return httpResponseEntity;


    }

    @RequestMapping(value = "/modifyQuestionnaire", method = RequestMethod.POST, headers = "Accept=application/json")
    public HttpResponseEntity modifyQuestionnaire(@RequestBody QuestionnaireEntity questionnaireEntity) {


        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        String id = questionnaireService.addQuestionnaire(questionnaireEntity);
        if (id != null) {
            httpResponseEntity.setCode(Constans.SUCCESS_CODE);

            httpResponseEntity.setData(id);
           /* List<Object> list = questionnaireService.queryQuestionListByProjectId(questionnaireEntity.getProjectId());
            List<Object> newList = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                if (i >= 5)
                    break;
                newList.add(list.get(i));
                QuestionnaireEntity q = (QuestionnaireEntity) newList.get(i);
            }
            httpResponseEntity.setData(newList);*/


            httpResponseEntity.setMessage(Constans.ADD_MESSAGE);
        } else {
            httpResponseEntity.setCode(Constans.EXIST_CODE);
        }
        return httpResponseEntity;

    }

    @Autowired
    ProjectService projectService;

    @RequestMapping(value = "/queryAllQuestionnaireByCreated", method = RequestMethod.POST, headers = "Accept=application/json")
    public HttpResponseEntity queryAllQuestionnaireByCreated(@RequestBody UserEntity userEntity) {
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();


        List<Object> list = questionnaireService.queryAllQuestionnaireByCreated(userEntity);

        httpResponseEntity.setData(list);
        for (int i = 0; i < list.size(); i++) {
            QuestionnaireEntity q = (QuestionnaireEntity) list.get(i);
        }
        if (list.size() > 0) {
            httpResponseEntity.setCode(Constans.SUCCESS_CODE);


        } else {
            httpResponseEntity.setCode(Constans.EXIST_CODE);
        }
        return httpResponseEntity;


    }

    @RequestMapping(value = "/addSendQuestionnaire", method = RequestMethod.POST, headers = "Accept=application/json")
    public HttpResponseEntity addSendQuestionnaire(@RequestBody QuestionnaireEntity questionnaireEntity) {
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();

        if (questionnaireService.sendQuestionnaireByEmail(questionnaireEntity) > 0) {
            httpResponseEntity.setCode(Constans.SUCCESS_CODE);
        }
        else
        {
            httpResponseEntity.setCode(Constans.EXIST_CODE);
        }
        return httpResponseEntity;
    }

    @RequestMapping(value = "/queryQuestionnaireById")
    public HttpResponseEntity queryQuestionnaireById(@RequestBody QuestionnaireEntity q) {
        QuestionnaireEntity questionnaireEntity = questionnaireService.getQuestionnaireById(q.getQuestionId());
        HttpResponseEntity h = new HttpResponseEntity();
        System.out.println("在控制器" + questionnaireEntity.getQuestion());
        if (questionnaireEntity != null) {
            h.setCode(Constans.SUCCESS_CODE);
            h.setData(questionnaireEntity);
        } else
            h.setCode(Constans.EXIST_CODE);
        return h;
    }
    @RequestMapping(value = "/deleteQuestionnaireById", method = RequestMethod.POST, headers = "Accept=application/json")
    public HttpResponseEntity deleteQuestionnaireById(@RequestBody QuestionnaireEntity questionnaireEntity)
    {
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        if(questionnaireService.deleteQuestionnaireById(questionnaireEntity.getId())>=1)
        {
           httpResponseEntity.setCode(Constans.SUCCESS_CODE);
           httpResponseEntity.setMessage(Constans.DELETE_MESSAGE);

        }
        else
            httpResponseEntity.setCode(Constans.EXIST_CODE);
        return httpResponseEntity;
    }
}



