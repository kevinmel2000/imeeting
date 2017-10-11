package com.imeeting.website.service.implement;

import com.imeeting.website.domain.Document;
import com.imeeting.website.repository.DocumentDao;
import com.imeeting.website.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mrapry on 10/10/17.
 */
@Service
public class DocumentServiceImpl implements DocumentService {
    
    @Autowired
    private DocumentDao documentDao;

    @Override
    public Map findOne(Integer id) {
        Map m = new HashMap();
        Document document = documentDao.findOne(id);
        if (document==null){
            m.put("message","Data Document not found");
            m.put("response",-1);
        }else{
            m.put("message",document);
            m.put("response",1);
        }
        return m;
    }

    @Override
    public Map save(Document question) {
        Map m = new HashMap();
        documentDao.save(question);
        m.put("message","Data Document hasben saved");
        m.put("response",1);
        return m;
    }

    @Override
    public Map edit(Document question) {
        Map m = new HashMap();
        documentDao.save(question);
        m.put("message","Data Document hasben edited");
        m.put("response",1);
        return m;
    }

    @Override
    public Map del(Integer id) {
        Map m = new HashMap();
        documentDao.delete(id);
        m.put("message","Data Document hasben deleted");
        m.put("response",1);
        return m;
    }

    @Override
    public Map getAll() {
        Map m = new HashMap();
        m.put("message",documentDao.findAll());
        m.put("response",1);
        return m;
    }
}
