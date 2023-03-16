package ltd.newbee.mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ltd.newbee.mall.dao.RecommendGoodsMapper;
import ltd.newbee.mall.entity.RecommendGoods;
import ltd.newbee.mall.service.RecommendGoodsService;
import ltd.newbee.mall.util.PageQueryUtil;

@Service
public class RecommendGoodsServiceImpl implements RecommendGoodsService {


    @Autowired
    private RecommendGoodsMapper recommendGoodsMapper;

    public List<RecommendGoods> findRecommendGoodsList(PageQueryUtil pageUtil) {
        return recommendGoodsMapper.findRecommendGoodsList(pageUtil);
    }

}

