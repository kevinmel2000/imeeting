package com.imeeting.website.service.implement;

import com.imeeting.website.domain.Question;
import com.imeeting.website.repository.QuestionDao;
import com.imeeting.website.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mrapry on 10/10/17.
 */
@Service
public class QuestionServiceImpl implements QuestionService {
    
    @Autowired
    private QuestionDao questionDao;

    @Override
    public Map findOne(Integer id) {
        Map m = new HashMap();
        Question Questions = questionDao.findOne(id);
        if (Questions==null){
            m.put("message","Data Question not found");
            m.put("response",-1);
        }else{
            m.put("message",Questions);
            m.put("response",1);
        }
        return m;
    }

    @Override
    public Map save(Question question) {
        Map m = new HashMap();
        questionDao.save(question);
        m.put("message","Data Question hasben saved");
        m.put("response",1);
        return m;
    }

    @Override
    public Map edit(Question question) {
        Map m = new HashMap();
        questionDao.save(question);
        m.put("message","Data Question hasben edited");
        m.put("response",1);
        return m;
    }

    @Override
    public Map del(Integer id) {
        Map m = new HashMap();
        questionDao.delete(id);
        m.put("message","Data Question hasben deleted");
        m.put("response",1);
        return m;
    }

    @Override
    public Map getAll() {
        Map m = new HashMap();
        m.put("message",questionDao.findAll());
        m.put("response",1);
        return m;
    }
}
