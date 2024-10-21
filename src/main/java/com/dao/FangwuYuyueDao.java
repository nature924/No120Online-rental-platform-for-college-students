package com.dao;

import com.entity.FangwuYuyueEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.FangwuYuyueView;

/**
 * 房屋租赁 Dao 接口
 *
 * @author 
 */
public interface FangwuYuyueDao extends BaseMapper<FangwuYuyueEntity> {

   List<FangwuYuyueView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
