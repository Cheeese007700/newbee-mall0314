package ltd.newbee.mall.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ltd.newbee.mall.dao.RecommendGoodsMapper;
import ltd.newbee.mall.entity.RecommendGoods;
import ltd.newbee.mall.service.RecommendGoodsService;

@Service
public class RecommendGoodsServiceImpl implements RecommendGoodsService {

	
	@Autowired
	private RecommendGoodsMapper recommendGoodsMapper;

	@Override
	public List<RecommendGoods> findRecommendGoodsList(Integer type, String orderBy, Integer limit) {
	    // 封装查询条件
	    Map<String, Object> paramMap = new HashMap<>();
	    paramMap.put("type", type);
	    paramMap.put("orderBy", orderBy);
	    paramMap.put("limit", limit);

	    List<RecommendGoods> recommendGoodsList = recommendGoodsMapper.findRecommendGoodsList(paramMap);

	    // 对查询结果进行处理
	    List<RecommendGoods> resultList = new ArrayList<>();
	    for (RecommendGoods recommendGoods : recommendGoodsList) {
	        // 判断库存数量
	        if (recommendGoods.getStockNum() == 0) {
	            continue; // 不输出商品
	        }

	        // 判断删除标识
	        if (recommendGoods.getDeleteFlag() == 1) {
	            continue; // 不输出商品
	        }

	        RecommendGoods result = new RecommendGoods();
	        result.setGoodsId(recommendGoods.getGoodsId());
	        result.setGoodsName(recommendGoods.getGoodsName());
	        result.setSellingPrice(recommendGoods.getSellingPrice());
	        result.setStockNum(recommendGoods.getStockNum());

	        // 对商品名称进行处理
	        String goodsName = recommendGoods.getGoodsName();
	        if (goodsName.length() > 15) {
	            goodsName = goodsName.substring(0, 15) + "...";
	        }
	        result.setGoodsName(goodsName);

	       
	        // 设置库存状态
	        result.setStockStatus("在库");

	        resultList.add(result);
	    }

	    return resultList;
	}

	@Override
	public boolean deleteRecommendGoods(Integer goodsId) {
	    int count = recommendGoodsMapper.deleteRecommendGoods(goodsId);
	    return count > 0;
	}

	@Override
	public List<RecommendGoods> findRecommendGoodsList(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return null;
	}

}

