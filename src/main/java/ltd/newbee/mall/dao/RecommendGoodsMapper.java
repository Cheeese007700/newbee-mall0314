package ltd.newbee.mall.dao;

import java.util.List;
import java.util.Map;

import ltd.newbee.mall.entity.RecommendGoods;

public interface RecommendGoodsMapper {
    List<RecommendGoods> findRecommendGoodsList(Map<String, Object> paramMap);

	int deleteRecommendGoods(Integer goodsId);

}

