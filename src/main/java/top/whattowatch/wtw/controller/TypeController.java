package top.whattowatch.wtw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.whattowatch.wtw.service.TypesService;
import top.whattowatch.wtw.utils.TokenValid;

/**
 * @Auther: JNXJ
 * @Date: 2018/8/30 08:55
 * @Description:
 */
@RestController
@RequestMapping("/api")
public class TypeController {
    @Autowired
    TypesService typesService;
    @TokenValid
    @RequestMapping(value = "/types", method = RequestMethod.GET)
    public Object selectTypes() throws Exception{
        return typesService.selectTypes();
    }

}
