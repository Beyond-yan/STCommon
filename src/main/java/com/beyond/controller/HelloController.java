package com.beyond.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.beyond.dao.GoodsDao;
import com.beyond.entity.Goods;
import com.beyond.exception.ServiceException;
import com.beyond.mapper.GoodsMapper;
import com.beyond.service.GoodsService;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.List;

/**
 * @Author 闫波
 * @Date 2018/12/2 0002
 **/
@Controller
@Scope("session")
public class HelloController {
   // @Autowired
    //GoodsMapper goodsMapper;

    @Autowired
    GoodsDao goodsDao;

    @Autowired
    GoodsService goodsService;

    private ModelMap modelMap ;

    //@PostConstruct当bean加载完之后，就会执行init方法，并且将list实例化；
    @PostConstruct
    public void init(){
        modelMap = new ModelMap();
        modelMap.addAttribute("page" , "1");
    }

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "hello";
    }

    /*--------------mybatis plus的写法-------------------*/
    @RequestMapping("/home")
    public String index(Model model , String type){
        int page = Integer.valueOf((String)modelMap.get("page"));
        if(StringUtils.isNotBlank(type))
            page = Integer.valueOf(type)==2 ? ++page  : (--page < 1 ? ++page : page);

        EntityWrapper entityWrapper = new EntityWrapper();
        Page<Goods> pageList = goodsService.selectPage(new Page<Goods>(page , 2));
        List<Goods> goodsList = pageList.getRecords();
        model.addAttribute("goodsList" , goodsList);
        System.out.println(page);
        modelMap.addAttribute("page" , String.valueOf(page));
        return "index";
    }

    @RequestMapping("/find")
    public String selectGoodsByName(String beyond , Model model){
        EntityWrapper entityWrapper = new EntityWrapper();
        if(StringUtils.isNotBlank(beyond))
            entityWrapper.eq("name" , beyond);
        List<Goods> goodsList = goodsService.selectList(entityWrapper);
        model.addAttribute("goodsList" , goodsList);
        return "index";
    }

    @RequestMapping("/edit")
    public String editGoods(String id , Model model){
        EntityWrapper entityWrapper = new EntityWrapper();
        if(StringUtils.isNotBlank(id))
            entityWrapper.eq("id" , id);
        Goods goods = goodsService.selectById(id);
        model.addAttribute("goods" , goods);
        return "edit";
    }

    @RequestMapping("/update")
    public String updateGoods(Goods good , Model model){
        if(null == good) return "index";
        Goods goods = goodsService.selectById(good.getId());
        if(null == good) return "index";

        EntityWrapper entityWrapper = new EntityWrapper();
        entityWrapper.eq("id" , good.getId());

        boolean result = goodsService.update(good , entityWrapper);

        return "redirect:home";
    }

    @RequestMapping("/save")
    public String save() throws Exception{
        EntityWrapper entityWrapper = new EntityWrapper();
        List<Goods> goodsList = goodsService.selectList(entityWrapper);
        File file = new File("D:/goods.txt");
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
//        String o = JSONObject.toJSONString(goodsList);
//        writer.write(o);
//        writer.close();
        JSONObject.writeJSONString(writer , goodsList);
        writer.close();

        return "redirect:home";
    }

    @RequestMapping("/read")
    public String read() throws Exception{
        File file = new File("D:/goods.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        String o = reader.readLine();
        List<Goods> goodsList = JSONObject.parseArray(o , Goods.class);
        for(Goods goods : goodsList){
           System.out.println(goods.getName());
        }
        reader.close();

        return "redirect:home";
    }

    /* mybatis mapper接口的写法
    public String index(Model model){
        List<Goods> goodsList = goodsMapper.allGoods();
        model.addAttribute("goodsList" , goodsList);
        return "index";
    }
    */
}
