package ltd.newbee.mall.service;

import java.util.List;
import java.util.Map;

import ltd.newbee.mall.entity.RecommendGoods;

public interface RecommendGoodsService {
    List<RecommendGoods> findRecommendGoodsList(Integer type, String orderBy, Integer limit);


	boolean deleteRecommendGoods(Integer goodsId);


	List<RecommendGoods> findRecommendGoodsList(Map<String, Object> paramMap);
}
