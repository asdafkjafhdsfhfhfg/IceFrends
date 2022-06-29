package com.aim.questionnaire.service;

import com.aim.questionnaire.common.utils.DateUtil;
import com.aim.questionnaire.common.utils.UUIDUtil;
import com.aim.questionnaire.dao.QuestionnaireEntityMapper;
import com.aim.questionnaire.dao.entity.AnswerEntity;
import com.aim.questionnaire.dao.entity.QuestionnaireEntity;
import com.aim.questionnaire.dao.entity.UserEntity;
import org.apache.ibatis.annotations.MapKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class QuestionnaireService {
    @Autowired
    private QuestionnaireEntityMapper questionnaireEntityMapper;

    public int modifyQuestionnaire(QuestionnaireEntity questionnaireEntity) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", questionnaireEntity.getId());
        map.put("projectId", questionnaireEntity.getProjectId());
        map.put("questionName", questionnaireEntity.getQuestionName());
        map.put("questionContent", questionnaireEntity.getQuestionContent());
        map.put("dataId", questionnaireEntity.getDataId());
        map.put("qustionList", questionnaireEntity.getQuestion());
        map.put("questionTitle", questionnaireEntity.getQuestionTitle());
        map.put("startTime", questionnaireEntity.getStartTime());
        map.put("endTime", questionnaireEntity.getEndTime());
        map.put("createdBy", questionnaireEntity.getCreatedBy());
        map.put("creationDate", DateUtil.getMyTime(String.valueOf(System.currentTimeMillis())));
        map.put("lastUpdatedBy", questionnaireEntity.getLastUpdatedBy());
        map.put("lastUpdateDate", questionnaireEntity.getLastUpdateDate());
        map.put("questionStop", questionnaireEntity.getQuestionStop());
        return questionnaireEntityMapper.modifyQuestionnaire(map);

    }

    public String addQuestionnaire(QuestionnaireEntity questionnaireEntity) {
        HashMap<String, Object> map = new HashMap<>();

        if (questionnaireEntity.getId() != null) {
            map.put("id", questionnaireEntity.getId());

        } else {
            map.put("id", UUIDUtil.getOneUUID());
        }
        map.put("projectId", questionnaireEntity.getProjectId());
        map.put("questionName", questionnaireEntity.getQuestionName());
        map.put("questionContent", questionnaireEntity.getQuestionContent());
        map.put("dataId", questionnaireEntity.getDataId());
        map.put("questionList", questionnaireEntity.getQuestion());
        map.put("questionTitle", questionnaireEntity.getQuestionTitle());
        map.put("startTime", questionnaireEntity.getStartTime());
        map.put("endTime", questionnaireEntity.getEndTime());
        map.put("createdBy", questionnaireEntity.getCreatedBy());
        map.put("creationDate", DateUtil.getMyTime(String.valueOf(System.currentTimeMillis())));
        map.put("lastUpdatedBy", questionnaireEntity.getLastUpdatedBy());
        map.put("lastUpdateDate", questionnaireEntity.getLastUpdateDate());
        map.put("questionStop", questionnaireEntity.getQuestionStop());
        if (questionnaireEntity.getId() != null) {

            questionnaireEntityMapper.modifyQuestionnaireInfo(map);

        } else {
            questionnaireEntityMapper.addQuestionnaire(map);
        }

        return (String) map.get("id");
    }

    public List<Object> queryQuestionListByProjectId(String projectID) {
        List<Map<String, Object>> list = questionnaireEntityMapper.queryQuestionListByProjectId(projectID);

        List<Object> newList = new ArrayList<>();
        for (Map<String, Object> m : list) {
            QuestionnaireEntity q = new QuestionnaireEntity();
            q.setQuestionName((String) m.get("questionName"));

            q.setId((String) m.get("id"));
            q.setProjectId(projectID);

            newList.add(q);
        }
        return newList;
    }

    public List<Object> queryAllQuestionnaireByCreated(UserEntity userEntity) {
        HashMap<String, Object> map = new HashMap<>();
        List<Object> newList = new ArrayList<>();
        map.put("user", userEntity.getId());
        List<Map<String, Object>> list = questionnaireEntityMapper.queryAllQuestionnaireByCreated(map);
        for (Map<String, Object> m : list) {
            QuestionnaireEntity q = new QuestionnaireEntity();
            q.setQuestionName((String) m.get("questionName"));

            q.setId((String) m.get("id"));
            q.setProjectId((String) m.get("projectId"));

            newList.add(q);
        }
        return newList;
    }

    public QuestionnaireEntity getQuestionnaireById(String questionId) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("questionId", questionId);

        Map map1 = questionnaireEntityMapper.queryQuestionnaireById(map);

        QuestionnaireEntity questionnaireEntity = new QuestionnaireEntity();

        System.out.println((String) map1.get("questionList"));
        questionnaireEntity.setQuestion((String) map1.get("questionList"));

        questionnaireEntity.setQuestionTitle((String) map1.get("questionTitle"));
        questionnaireEntity.setQuestionName((String) map1.get("questionName"));

        return questionnaireEntity;

    }

    @Value("${spring.mail.from}") // 从application.yml配置文件中获取
    private String from; // 发送发邮箱地址


    @Autowired
    public JavaMailSender mailSender;

    public int sendQuestionnaireByEmail(QuestionnaireEntity questionnaireEntity) {
        List<AnswerEntity> list = questionnaireEntity.getSendInfo();

        int i = 0;
        for (AnswerEntity answerEntity : list) {
            MimeMessage mimeMailMessage = mailSender.createMimeMessage();
            try {
                MimeMessageHelper helper = new MimeMessageHelper(mimeMailMessage, true);
                helper.setFrom(from);
                helper.setTo(answerEntity.getAnswerEmail());
                helper.setSubject("调查问卷");
                helper.setText(questionnaireEntity.getContext());
            } catch (MessagingException e) {
                e.printStackTrace();
            }
            mailSender.send(mimeMailMessage);
            i++;
        }
        System.out.println("在service中   " + i);
        return i;
    }

    public int deleteQuestionnaireById(String id) {
        return questionnaireEntityMapper.deleteByPrimaryKey(id);
    }

}
