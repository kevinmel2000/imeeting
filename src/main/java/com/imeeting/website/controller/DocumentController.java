package com.imeeting.website.controller;

import com.imeeting.website.domain.Document;
import com.imeeting.website.domain.Find;
import com.imeeting.website.service.implement.DocumentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/document")
public class DocumentController {

    /**
     * Created by elvan on 12/10/17.
     */

    @Autowired
    private DocumentServiceImpl documentService;

    /**
     * Api get all data. we dont need PSS because the bispro dont have more of document
     * @return */

    @RequestMapping(method = RequestMethod.GET)
    public Map getAll(){
        return documentService.getAll();
    }

    /**
     * Api Update data of document. client must send the data in JSON
     * * ex JSON :
     * {
     *     "id":"1211",
     *      "email":"matius.prastowo@iconpln.co.id",
     *      "password":"P@ssw0rd123",
     *      "nama":"matius apry prastowo"
     * }
     *
     * @param document entity from document
     * @return
     * */

    @RequestMapping(method = RequestMethod.PUT)
    public Map edit(@RequestBody Document document){
        return documentService.edit(document);
    }

    /**
     * Api save data document. client must send data in JSON
     * * ex JSON :
     * {
     *     "id":"1211",
     *      "email":"matius.prastowo@iconpln.co.id",
     *      "password":"P@ssw0rd123",
     *      "nama":"matius apry prastowo"
     * }
     *
     * @param document entity from document
     * @return
     */

    @RequestMapping(method = RequestMethod.POST)
    public Map save (@RequestBody Document document){
        return documentService.save(document);
    }

    /**
     * Api del data document. the data will be delete form the database
     * client must input id parameter form document
     *
     * @param id id_document from document
     * @return
     */

    @RequestMapping(value = "del/{id}", method = RequestMethod.GET)
    public Map del(@PathVariable Integer id){
        return documentService.del(id);
    }

    /**
     * Api find data document. this method find for searching data document
     *
     * @param find this entity is keyword and value of search data document
     * @return
     */

    @RequestMapping(value = "/find", method = RequestMethod.POST)
    public Map find(@RequestBody Find find) {
        if (find.getKey().equals("id")){
            return documentService.findOne(Integer.parseInt(find.getValue()));
        } else {
            Map m = new HashMap();
            m.put("message","Keyword not found");
            m.put("response", -1);
            return m;
        }
    }
}
