package com.dao;

import com.entity.FangdongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.FangdongView;

/**
 * 房东 Dao 接口
 *
 * @author 
 */
public interface FangdongDao extends BaseMapper<FangdongEntity> {

   List<FangdongView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
