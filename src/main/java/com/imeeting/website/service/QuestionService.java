package com.imeeting.website.service;


import com.imeeting.website.domain.Question;

import java.util.Map;

/**
 * Created by mrapry on 10/10/17.
 */
public interface QuestionService {

    Map findOne(Integer id);
    Map save(Question user);
    Map edit(Question user);
    Map del(Integer id);
    Map getAll();
}
