
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 房屋留言
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/fangwuLiuyan")
public class FangwuLiuyanController {
    private static final Logger logger = LoggerFactory.getLogger(FangwuLiuyanController.class);

    private static final String TABLE_NAME = "fangwuLiuyan";

    @Autowired
    private FangwuLiuyanService fangwuLiuyanService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private BaoxiuService baoxiuService;//报修
    @Autowired
    private BaoxiuCommentbackService baoxiuCommentbackService;//报修评价
    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private FangdongService fangdongService;//房东
    @Autowired
    private FangwuService fangwuService;//房屋
    @Autowired
    private FangwuCollectionService fangwuCollectionService;//房屋收藏
    @Autowired
    private FangwuYuyueService fangwuYuyueService;//房屋租赁
    @Autowired
    private ForumService forumService;//租房论坛
    @Autowired
    private GonggaoService gonggaoService;//公告信息
    @Autowired
    private LiuyanService liuyanService;//留言板
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("房东".equals(role))
            params.put("fangdongId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = fangwuLiuyanService.queryPage(params);

        //字典表数据转换
        List<FangwuLiuyanView> list =(List<FangwuLiuyanView>)page.getList();
        for(FangwuLiuyanView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        FangwuLiuyanEntity fangwuLiuyan = fangwuLiuyanService.selectById(id);
        if(fangwuLiuyan !=null){
            //entity转view
            FangwuLiuyanView view = new FangwuLiuyanView();
            BeanUtils.copyProperties( fangwuLiuyan , view );//把实体数据重构到view中
            //级联表 房屋
            //级联表
            FangwuEntity fangwu = fangwuService.selectById(fangwuLiuyan.getFangwuId());
            if(fangwu != null){
            BeanUtils.copyProperties( fangwu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setFangwuId(fangwu.getId());
            }
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(fangwuLiuyan.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody FangwuLiuyanEntity fangwuLiuyan, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,fangwuLiuyan:{}",this.getClass().getName(),fangwuLiuyan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            fangwuLiuyan.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        fangwuLiuyan.setCreateTime(new Date());
        fangwuLiuyan.setInsertTime(new Date());
        fangwuLiuyanService.insert(fangwuLiuyan);

        return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody FangwuLiuyanEntity fangwuLiuyan, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,fangwuLiuyan:{}",this.getClass().getName(),fangwuLiuyan.toString());
        FangwuLiuyanEntity oldFangwuLiuyanEntity = fangwuLiuyanService.selectById(fangwuLiuyan.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            fangwuLiuyan.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(fangwuLiuyan.getFangwuLiuyanText()) || "null".equals(fangwuLiuyan.getFangwuLiuyanText())){
                fangwuLiuyan.setFangwuLiuyanText(null);
        }
        if("".equals(fangwuLiuyan.getReplyText()) || "null".equals(fangwuLiuyan.getReplyText())){
                fangwuLiuyan.setReplyText(null);
        }
        fangwuLiuyan.setUpdateTime(new Date());

            fangwuLiuyanService.updateById(fangwuLiuyan);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<FangwuLiuyanEntity> oldFangwuLiuyanList =fangwuLiuyanService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        fangwuLiuyanService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //.eq("time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
        try {
            List<FangwuLiuyanEntity> fangwuLiuyanList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            FangwuLiuyanEntity fangwuLiuyanEntity = new FangwuLiuyanEntity();
//                            fangwuLiuyanEntity.setFangwuId(Integer.valueOf(data.get(0)));   //房屋 要改的
//                            fangwuLiuyanEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            fangwuLiuyanEntity.setFangwuLiuyanText(data.get(0));                    //留言内容 要改的
//                            fangwuLiuyanEntity.setInsertTime(date);//时间
//                            fangwuLiuyanEntity.setReplyText(data.get(0));                    //回复内容 要改的
//                            fangwuLiuyanEntity.setUpdateTime(sdf.parse(data.get(0)));          //回复时间 要改的
//                            fangwuLiuyanEntity.setCreateTime(date);//时间
                            fangwuLiuyanList.add(fangwuLiuyanEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        fangwuLiuyanService.insertBatch(fangwuLiuyanList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = fangwuLiuyanService.queryPage(params);

        //字典表数据转换
        List<FangwuLiuyanView> list =(List<FangwuLiuyanView>)page.getList();
        for(FangwuLiuyanView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        FangwuLiuyanEntity fangwuLiuyan = fangwuLiuyanService.selectById(id);
            if(fangwuLiuyan !=null){


                //entity转view
                FangwuLiuyanView view = new FangwuLiuyanView();
                BeanUtils.copyProperties( fangwuLiuyan , view );//把实体数据重构到view中

                //级联表
                    FangwuEntity fangwu = fangwuService.selectById(fangwuLiuyan.getFangwuId());
                if(fangwu != null){
                    BeanUtils.copyProperties( fangwu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setFangwuId(fangwu.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(fangwuLiuyan.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody FangwuLiuyanEntity fangwuLiuyan, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,fangwuLiuyan:{}",this.getClass().getName(),fangwuLiuyan.toString());
        fangwuLiuyan.setCreateTime(new Date());
        fangwuLiuyan.setInsertTime(new Date());
        fangwuLiuyanService.insert(fangwuLiuyan);

            return R.ok();
        }

}

