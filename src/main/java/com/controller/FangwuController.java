
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
 * 房屋
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/fangwu")
public class FangwuController {
    private static final Logger logger = LoggerFactory.getLogger(FangwuController.class);

    private static final String TABLE_NAME = "fangwu";

    @Autowired
    private FangwuService fangwuService;


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
        params.put("fangwuDeleteStart",1);params.put("fangwuDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = fangwuService.queryPage(params);

        //字典表数据转换
        List<FangwuView> list =(List<FangwuView>)page.getList();
        for(FangwuView c:list){
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
        FangwuEntity fangwu = fangwuService.selectById(id);
        if(fangwu !=null){
            //entity转view
            FangwuView view = new FangwuView();
            BeanUtils.copyProperties( fangwu , view );//把实体数据重构到view中
            //级联表 房东
            //级联表
            FangdongEntity fangdong = fangdongService.selectById(fangwu.getFangdongId());
            if(fangdong != null){
            BeanUtils.copyProperties( fangdong , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "fangdongId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setFangdongId(fangdong.getId());
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
    public R save(@RequestBody FangwuEntity fangwu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,fangwu:{}",this.getClass().getName(),fangwu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("房东".equals(role))
            fangwu.setFangdongId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<FangwuEntity> queryWrapper = new EntityWrapper<FangwuEntity>()
            .eq("fangdong_id", fangwu.getFangdongId())
            .eq("fangwu_name", fangwu.getFangwuName())
            .eq("fangwu_address", fangwu.getFangwuAddress())
            .eq("fangwu_types", fangwu.getFangwuTypes())
            .eq("fangwu_zhuangtai_types", fangwu.getFangwuZhuangtaiTypes())
            .eq("fangwu_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FangwuEntity fangwuEntity = fangwuService.selectOne(queryWrapper);
        if(fangwuEntity==null){
            fangwu.setFangwuDelete(1);
            fangwu.setInsertTime(new Date());
            fangwu.setCreateTime(new Date());
            fangwuService.insert(fangwu);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody FangwuEntity fangwu, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,fangwu:{}",this.getClass().getName(),fangwu.toString());
        FangwuEntity oldFangwuEntity = fangwuService.selectById(fangwu.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("房东".equals(role))
//            fangwu.setFangdongId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(fangwu.getFangwuPhoto()) || "null".equals(fangwu.getFangwuPhoto())){
                fangwu.setFangwuPhoto(null);
        }
        if("".equals(fangwu.getFangwuFile()) || "null".equals(fangwu.getFangwuFile())){
                fangwu.setFangwuFile(null);
        }
        if("".equals(fangwu.getFangwuContent()) || "null".equals(fangwu.getFangwuContent())){
                fangwu.setFangwuContent(null);
        }

            fangwuService.updateById(fangwu);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<FangwuEntity> oldFangwuList =fangwuService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<FangwuEntity> list = new ArrayList<>();
        for(Integer id:ids){
            FangwuEntity fangwuEntity = new FangwuEntity();
            fangwuEntity.setId(id);
            fangwuEntity.setFangwuDelete(2);
            list.add(fangwuEntity);
        }
        if(list != null && list.size() >0){
            fangwuService.updateBatchById(list);
        }

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
            List<FangwuEntity> fangwuList = new ArrayList<>();//上传的东西
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
                            FangwuEntity fangwuEntity = new FangwuEntity();
//                            fangwuEntity.setFangdongId(Integer.valueOf(data.get(0)));   //房东 要改的
//                            fangwuEntity.setFangwuName(data.get(0));                    //房屋名称 要改的
//                            fangwuEntity.setFangwuUuidNumber(data.get(0));                    //房屋编号 要改的
//                            fangwuEntity.setFangwuPhoto("");//详情和图片
//                            fangwuEntity.setFangwuAddress(data.get(0));                    //房屋地点 要改的
//                            fangwuEntity.setFangwuFile(data.get(0));                    //房屋信息文件 要改的
//                            fangwuEntity.setFangwuTypes(Integer.valueOf(data.get(0)));   //房屋类型 要改的
//                            fangwuEntity.setFangwuZhuangtaiTypes(Integer.valueOf(data.get(0)));   //房屋状态 要改的
//                            fangwuEntity.setFangwuNewMoney(data.get(0));                    //现价/积分 要改的
//                            fangwuEntity.setFangwuContent("");//详情和图片
//                            fangwuEntity.setFangwuDelete(1);//逻辑删除字段
//                            fangwuEntity.setInsertTime(date);//时间
//                            fangwuEntity.setCreateTime(date);//时间
                            fangwuList.add(fangwuEntity);


                            //把要查询是否重复的字段放入map中
                                //房屋编号
                                if(seachFields.containsKey("fangwuUuidNumber")){
                                    List<String> fangwuUuidNumber = seachFields.get("fangwuUuidNumber");
                                    fangwuUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> fangwuUuidNumber = new ArrayList<>();
                                    fangwuUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("fangwuUuidNumber",fangwuUuidNumber);
                                }
                        }

                        //查询是否重复
                         //房屋编号
                        List<FangwuEntity> fangwuEntities_fangwuUuidNumber = fangwuService.selectList(new EntityWrapper<FangwuEntity>().in("fangwu_uuid_number", seachFields.get("fangwuUuidNumber")).eq("fangwu_delete", 1));
                        if(fangwuEntities_fangwuUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(FangwuEntity s:fangwuEntities_fangwuUuidNumber){
                                repeatFields.add(s.getFangwuUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [房屋编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        fangwuService.insertBatch(fangwuList);
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
    * 个性推荐
    */
    @IgnoreAuth
    @RequestMapping("/gexingtuijian")
    public R gexingtuijian(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("gexingtuijian方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        CommonUtil.checkMap(params);
        List<FangwuView> returnFangwuViewList = new ArrayList<>();

        //查看收藏
        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("yonghuId",request.getSession().getAttribute("userId"));
        params1.put("shangxiaTypes",1);
        params1.put("fangwuYesnoTypes",2);
        PageUtils pageUtils = fangwuCollectionService.queryPage(params1);
        List<FangwuCollectionView> collectionViewsList =(List<FangwuCollectionView>)pageUtils.getList();
        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
        for(FangwuCollectionView collectionView:collectionViewsList){
            Integer fangwuTypes = collectionView.getFangwuTypes();
            if(typeMap.containsKey(fangwuTypes)){
                typeMap.put(fangwuTypes,typeMap.get(fangwuTypes)+1);
            }else{
                typeMap.put(fangwuTypes,1);
            }
        }
        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        for(Integer type:typeList){
            Map<String, Object> params2 = new HashMap<>(params);params2.put("fangwuTypes",type);
            params2.put("shangxiaTypes",1);
            params2.put("fangwuYesnoTypes",2);
            PageUtils pageUtils1 = fangwuService.queryPage(params2);
            List<FangwuView> fangwuViewList =(List<FangwuView>)pageUtils1.getList();
            returnFangwuViewList.addAll(fangwuViewList);
            if(returnFangwuViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
        }
        params.put("shangxiaTypes",1);
        params.put("fangwuYesnoTypes",2);
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = fangwuService.queryPage(params);
        if(returnFangwuViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnFangwuViewList.size();//要添加的数量
            List<FangwuView> fangwuViewList =(List<FangwuView>)page.getList();
            for(FangwuView fangwuView:fangwuViewList){
                Boolean addFlag = true;
                for(FangwuView returnFangwuView:returnFangwuViewList){
                    if(returnFangwuView.getId().intValue() ==fangwuView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnFangwuViewList.add(fangwuView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnFangwuViewList = returnFangwuViewList.subList(0, limit);
        }

        for(FangwuView c:returnFangwuViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnFangwuViewList);
        return R.ok().put("data", page);
    }

    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = fangwuService.queryPage(params);

        //字典表数据转换
        List<FangwuView> list =(List<FangwuView>)page.getList();
        for(FangwuView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        FangwuEntity fangwu = fangwuService.selectById(id);
            if(fangwu !=null){


                //entity转view
                FangwuView view = new FangwuView();
                BeanUtils.copyProperties( fangwu , view );//把实体数据重构到view中

                //级联表
                    FangdongEntity fangdong = fangdongService.selectById(fangwu.getFangdongId());
                if(fangdong != null){
                    BeanUtils.copyProperties( fangdong , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "fangdongId"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setFangdongId(fangdong.getId());
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
    public R add(@RequestBody FangwuEntity fangwu, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,fangwu:{}",this.getClass().getName(),fangwu.toString());
        Wrapper<FangwuEntity> queryWrapper = new EntityWrapper<FangwuEntity>()
            .eq("fangdong_id", fangwu.getFangdongId())
            .eq("fangwu_name", fangwu.getFangwuName())
            .eq("fangwu_uuid_number", fangwu.getFangwuUuidNumber())
            .eq("fangwu_address", fangwu.getFangwuAddress())
            .eq("fangwu_types", fangwu.getFangwuTypes())
            .eq("fangwu_zhuangtai_types", fangwu.getFangwuZhuangtaiTypes())
            .eq("fangwu_delete", fangwu.getFangwuDelete())
//            .notIn("fangwu_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FangwuEntity fangwuEntity = fangwuService.selectOne(queryWrapper);
        if(fangwuEntity==null){
            fangwu.setFangwuDelete(1);
            fangwu.setInsertTime(new Date());
            fangwu.setCreateTime(new Date());
        fangwuService.insert(fangwu);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

