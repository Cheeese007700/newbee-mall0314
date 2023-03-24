package ltd.newbee.mall.controller.mall;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.hutool.core.util.PageUtil;
import ltd.newbee.mall.entity.RecommendGoods;
import ltd.newbee.mall.service.RecommendGoodsService;

@Controller
public class RecommendGoodsController {

    @Autowired
    private RecommendGoodsService recommendGoodsService;

    @GetMapping("/recommendgoods")
    @ResponseBody
    public ResponseEntity<List<RecommendGoods>> getRecommendGoodsList(@RequestParam("type") Integer type,
                                               @RequestParam(value = "orderBy",defaultValue = "priceAsc") String orderBy,
                                               @RequestParam(value = "limit", defaultValue = "10") Integer limit) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("type", type);
        paramMap.put("orderBy", orderBy);
        paramMap.put("limit", limit);
        List<RecommendGoods> recommendGoodsList = recommendGoodsService.findRecommendGoodsList(paramMap);

        for (RecommendGoods recommendGoods : recommendGoodsList) {
            // 判断库存数量是否为0
            if (recommendGoods.getStockNum() == 0) {
                recommendGoods.setStockStatus("在庫なし");
            } else {
                recommendGoods.setStockStatus("在庫");
            }
            // 判断是否已删除
            if (recommendGoods.getDeleteFlag() == 1) {
                recommendGoods.setGoodsName(null);
            } else {
                // 限制商品名称长度为15个字符，超过部分用"..."表示
                String goodsName = recommendGoods.getGoodsName();
                if (goodsName.length() > 15) {
                    recommendGoods.setGoodsName(goodsName.substring(0, 15) + "...");
                }
            }
        }  

        return ResponseEntity.ok(recommendGoodsList);
    }
    
   
}
