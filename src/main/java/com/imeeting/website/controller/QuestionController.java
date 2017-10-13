package com.imeeting.website.controller;

import com.imeeting.website.domain.Question;
import com.imeeting.website.domain.Find;
import com.imeeting.website.service.implement.QuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/question")
public class QuestionController {

    /**
     * Created by elvan on 12/10/17.
     */

    @Autowired
    private QuestionServiceImpl questionService;

    /**
     * Api get all data. We dont need PSS because the bispro dont have more of document
     * @return
     */

    @RequestMapping(method = RequestMethod.GET)
    public Map getAll() {
        return questionService.getAll();
    }

    /**
     * Api update data of question. Client must send the data in JSON
     * ex JSON :
     * {
     *     "id":"1211",
     *      "email":"matius.prastowo@iconpln.co.id",
     *      "password":"P@ssw0rd123",
     *      "nama":"matius apry prastowo"
     * }
     *
     * @param question this entity from question
     * @return
     */

    @RequestMapping(method = RequestMethod.PUT)
    public Map edit(@RequestBody Question question) {
        return questionService.edit(question);
    }

    /**
     * Api save data of question. Client must send the data in JSON
     * ex JSON :
     * {
     *     "id":"1211",
     *      "email":"matius.prastowo@iconpln.co.id",
     *      "password":"P@ssw0rd123",
     *      "nama":"matius apry prastowo"
     * }
     * @param question this entity form question
     * @return
     */

    @RequestMapping(method = RequestMethod.POST)
    public Map save(@RequestBody Question question) {
        return questionService.save(question);
    }

    /**
     * Api del data. The data will be delete from the database
     * client must input id parameter from question
     *
     * @param id id_question from question
     * @return
     */

    @RequestMapping(value = "/del/{id}", method = RequestMethod.GET)
    public Map del(@RequestBody Integer id) {
        return questionService.del(id);
    }

    /**
     * Api find data question. this method for searcing the data question
     *
     * @param find this entity is keyword and value of search data question
     * @return
     */

    @RequestMapping(value = "/find", method = RequestMethod.POST)
    public Map find(@RequestBody Find find){
        if (find.getKey().equals("id")){
            return questionService.findOne(Integer.parseInt(find.getValue()));
        } else{
            Map m = new HashMap();
            m.put("message","Keyword not found");
            m.put("response",-1);
            return m;
        }
    }




}
