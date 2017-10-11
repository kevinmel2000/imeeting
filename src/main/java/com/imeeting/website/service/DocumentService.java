package com.imeeting.website.service;

import com.imeeting.website.domain.Document;

import java.util.Map;

/**
 * Created by mrapry on 10/10/17.
 */
public interface DocumentService {

    Map findOne(Integer id);
    Map save(Document document);
    Map edit(Document document);
    Map del(Integer id);
    Map getAll();
}
