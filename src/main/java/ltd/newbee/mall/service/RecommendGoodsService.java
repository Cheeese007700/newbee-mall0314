package ltd.newbee.mall.service;

import java.util.List;

import ltd.newbee.mall.entity.RecommendGoods;
import ltd.newbee.mall.util.PageQueryUtil;

public interface RecommendGoodsService {

    List<RecommendGoods> findRecommendGoodsList(PageQueryUtil pageUtil);

}

