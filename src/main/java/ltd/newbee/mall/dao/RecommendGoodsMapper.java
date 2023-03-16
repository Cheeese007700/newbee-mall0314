package ltd.newbee.mall.dao;

import java.util.List;

import ltd.newbee.mall.entity.RecommendGoods;
import ltd.newbee.mall.util.PageQueryUtil;

public interface RecommendGoodsMapper {
	  
	List<RecommendGoods> findRecommendGoodsList(PageQueryUtil pageUtil);
	  
    }
