
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
 * 报修
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/baoxiu")
public class BaoxiuController {
    private static final Logger logger = LoggerFactory.getLogger(BaoxiuController.class);

    private static final String TABLE_NAME = "baoxiu";

    @Autowired
    private BaoxiuService baoxiuService;


    @Autowired
    private TokenService tokenService;

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
    private FangwuLiuyanService fangwuLiuyanService;//房屋留言
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
        PageUtils page = baoxiuService.queryPage(params);

        //字典表数据转换
        List<BaoxiuView> list =(List<BaoxiuView>)page.getList();
        for(BaoxiuView c:list){
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
        BaoxiuEntity baoxiu = baoxiuService.selectById(id);
        if(baoxiu !=null){
            //entity转view
            BaoxiuView view = new BaoxiuView();
            BeanUtils.copyProperties( baoxiu , view );//把实体数据重构到view中
            //级联表 房屋
            //级联表
            FangwuEntity fangwu = fangwuService.selectById(baoxiu.getFangwuId());
            if(fangwu != null){
            BeanUtils.copyProperties( fangwu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setFangwuId(fangwu.getId());
            }
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(baoxiu.getYonghuId());
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
    public R save(@RequestBody BaoxiuEntity baoxiu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,baoxiu:{}",this.getClass().getName(),baoxiu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            baoxiu.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<BaoxiuEntity> queryWrapper = new EntityWrapper<BaoxiuEntity>()
            .eq("fangwu_id", baoxiu.getFangwuId())
            .eq("yonghu_id", baoxiu.getYonghuId())
            .eq("baoxiu_address", baoxiu.getBaoxiuAddress())
            .eq("baoxiu_name", baoxiu.getBaoxiuName())
            .eq("baoxiu_types", baoxiu.getBaoxiuTypes())
            .in("baoxiu_yesno_types", new Integer[]{1,2})
            .eq("baoxiu_zhuangtai_types", baoxiu.getBaoxiuZhuangtaiTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        BaoxiuEntity baoxiuEntity = baoxiuService.selectOne(queryWrapper);
//        if(baoxiuEntity==null){
            baoxiu.setBaoxiuYesnoTypes(1);
            baoxiu.setInsertTime(new Date());
            baoxiu.setCreateTime(new Date());
            baoxiuService.insert(baoxiu);
            return R.ok();
//        }else {
//            if(baoxiuEntity.getBaoxiuYesnoTypes()==1)
//                return R.error(511,"有相同的待审核的数据");
//            else if(baoxiuEntity.getBaoxiuYesnoTypes()==2)
//                return R.error(511,"有相同的审核通过的数据");
//            else
//                return R.error(511,"表中有相同数据");
//        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody BaoxiuEntity baoxiu, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,baoxiu:{}",this.getClass().getName(),baoxiu.toString());
        BaoxiuEntity oldBaoxiuEntity = baoxiuService.selectById(baoxiu.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            baoxiu.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(baoxiu.getBaoxiuPhoto()) || "null".equals(baoxiu.getBaoxiuPhoto())){
                baoxiu.setBaoxiuPhoto(null);
        }
        if("".equals(baoxiu.getBaoxiuContent()) || "null".equals(baoxiu.getBaoxiuContent())){
                baoxiu.setBaoxiuContent(null);
        }
        if("".equals(baoxiu.getBaoxiuYesnoText()) || "null".equals(baoxiu.getBaoxiuYesnoText())){
                baoxiu.setBaoxiuYesnoText(null);
        }

            baoxiuService.updateById(baoxiu);//根据id更新
            return R.ok();
    }


    /**
    * 审核
    */
    @RequestMapping("/shenhe")
    public R shenhe(@RequestBody BaoxiuEntity baoxiuEntity, HttpServletRequest request){
        logger.debug("shenhe方法:,,Controller:{},,baoxiuEntity:{}",this.getClass().getName(),baoxiuEntity.toString());

        BaoxiuEntity oldBaoxiu = baoxiuService.selectById(baoxiuEntity.getId());//查询原先数据

        if(baoxiuEntity.getBaoxiuYesnoTypes() == 2){//通过
            baoxiuEntity.setBaoxiuZhuangtaiTypes(2);
        }else if(baoxiuEntity.getBaoxiuYesnoTypes() == 3){//拒绝
//            baoxiuEntity.setBaoxiuTypes();
        }
        baoxiuEntity.setBaoxiuShenheTime(new Date());//审核时间
        baoxiuService.updateById(baoxiuEntity);//审核

        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<BaoxiuEntity> oldBaoxiuList =baoxiuService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        baoxiuService.deleteBatchIds(Arrays.asList(ids));

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
            List<BaoxiuEntity> baoxiuList = new ArrayList<>();//上传的东西
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
                            BaoxiuEntity baoxiuEntity = new BaoxiuEntity();
//                            baoxiuEntity.setFangwuId(Integer.valueOf(data.get(0)));   //房屋 要改的
//                            baoxiuEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            baoxiuEntity.setBaoxiuUuidNumber(data.get(0));                    //报修编号 要改的
//                            baoxiuEntity.setBaoxiuAddress(data.get(0));                    //报修标题 要改的
//                            baoxiuEntity.setBaoxiuName(data.get(0));                    //报修位置 要改的
//                            baoxiuEntity.setBaoxiuPhoto("");//详情和图片
//                            baoxiuEntity.setBaoxiuTypes(Integer.valueOf(data.get(0)));   //报修类型 要改的
//                            baoxiuEntity.setBaoxiuContent("");//详情和图片
//                            baoxiuEntity.setBaoxiuYesnoTypes(Integer.valueOf(data.get(0)));   //申请状态 要改的
//                            baoxiuEntity.setBaoxiuYesnoText(data.get(0));                    //审核意见 要改的
//                            baoxiuEntity.setBaoxiuShenheTime(sdf.parse(data.get(0)));          //审核时间 要改的
//                            baoxiuEntity.setInsertTime(date);//时间
//                            baoxiuEntity.setBaoxiuZhuangtaiTypes(Integer.valueOf(data.get(0)));   //报修状态 要改的
//                            baoxiuEntity.setCreateTime(date);//时间
                            baoxiuList.add(baoxiuEntity);


                            //把要查询是否重复的字段放入map中
                                //报修编号
                                if(seachFields.containsKey("baoxiuUuidNumber")){
                                    List<String> baoxiuUuidNumber = seachFields.get("baoxiuUuidNumber");
                                    baoxiuUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> baoxiuUuidNumber = new ArrayList<>();
                                    baoxiuUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("baoxiuUuidNumber",baoxiuUuidNumber);
                                }
                        }

                        //查询是否重复
                         //报修编号
                        List<BaoxiuEntity> baoxiuEntities_baoxiuUuidNumber = baoxiuService.selectList(new EntityWrapper<BaoxiuEntity>().in("baoxiu_uuid_number", seachFields.get("baoxiuUuidNumber")));
                        if(baoxiuEntities_baoxiuUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(BaoxiuEntity s:baoxiuEntities_baoxiuUuidNumber){
                                repeatFields.add(s.getBaoxiuUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [报修编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        baoxiuService.insertBatch(baoxiuList);
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
        PageUtils page = baoxiuService.queryPage(params);

        //字典表数据转换
        List<BaoxiuView> list =(List<BaoxiuView>)page.getList();
        for(BaoxiuView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        BaoxiuEntity baoxiu = baoxiuService.selectById(id);
            if(baoxiu !=null){


                //entity转view
                BaoxiuView view = new BaoxiuView();
                BeanUtils.copyProperties( baoxiu , view );//把实体数据重构到view中

                //级联表
                    FangwuEntity fangwu = fangwuService.selectById(baoxiu.getFangwuId());
                if(fangwu != null){
                    BeanUtils.copyProperties( fangwu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setFangwuId(fangwu.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(baoxiu.getYonghuId());
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
    public R add(@RequestBody BaoxiuEntity baoxiu, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,baoxiu:{}",this.getClass().getName(),baoxiu.toString());
        Wrapper<BaoxiuEntity> queryWrapper = new EntityWrapper<BaoxiuEntity>()
            .eq("fangwu_id", baoxiu.getFangwuId())
            .eq("yonghu_id", baoxiu.getYonghuId())
            .eq("baoxiu_uuid_number", baoxiu.getBaoxiuUuidNumber())
            .eq("baoxiu_address", baoxiu.getBaoxiuAddress())
            .eq("baoxiu_name", baoxiu.getBaoxiuName())
            .eq("baoxiu_types", baoxiu.getBaoxiuTypes())
            .in("baoxiu_yesno_types", new Integer[]{1,2})
            .eq("baoxiu_yesno_text", baoxiu.getBaoxiuYesnoText())
            .eq("baoxiu_zhuangtai_types", baoxiu.getBaoxiuZhuangtaiTypes())
//            .notIn("baoxiu_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        BaoxiuEntity baoxiuEntity = baoxiuService.selectOne(queryWrapper);
        if(baoxiuEntity==null){
            baoxiu.setBaoxiuYesnoTypes(1);
            baoxiu.setInsertTime(new Date());
            baoxiu.setCreateTime(new Date());
        baoxiuService.insert(baoxiu);

            return R.ok();
        }else {
            if(baoxiuEntity.getBaoxiuYesnoTypes()==1)
                return R.error(511,"有相同的待审核的数据");
            else if(baoxiuEntity.getBaoxiuYesnoTypes()==2)
                return R.error(511,"有相同的审核通过的数据");
            else
                return R.error(511,"表中有相同数据");
        }
    }

    /**
     * 评价
     */
    @RequestMapping("/commentback")
    public R commentback(Integer id, String commentbackText, Integer baoxiuCommentbackPingfenNumber, HttpServletRequest request){
        logger.debug("commentback方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        BaoxiuEntity baoxiu = baoxiuService.selectById(id);
        if(baoxiu == null)
            return R.error(511,"查不到该订单");
//        Integer baoxiuId = baoxiu.getbaoxiuId();
//        if(baoxiuId == null)
//            return R.error(511,"查不到该团队活动");

        BaoxiuCommentbackEntity baoxiuCommentbackEntity = new BaoxiuCommentbackEntity();
        baoxiuCommentbackEntity.setId(id);
        baoxiuCommentbackEntity.setBaoxiuId(baoxiu.getId());
        baoxiuCommentbackEntity.setYonghuId((Integer) request.getSession().getAttribute("userId"));
        baoxiuCommentbackEntity.setBaoxiuCommentbackText(commentbackText);
        baoxiuCommentbackEntity.setInsertTime(new Date());
        baoxiuCommentbackEntity.setReplyText(null);
        baoxiuCommentbackEntity.setUpdateTime(null);
        baoxiuCommentbackEntity.setCreateTime(new Date());
        baoxiuCommentbackService.insert(baoxiuCommentbackEntity);

        baoxiu.setBaoxiuZhuangtaiTypes(3);//设置订单状态为已评价
        baoxiuService.updateById(baoxiu);//根据id更新
        return R.ok();
    }


}

