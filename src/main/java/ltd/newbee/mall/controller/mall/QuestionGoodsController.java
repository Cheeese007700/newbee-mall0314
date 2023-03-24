package ltd.newbee.mall.controller.mall;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ltd.newbee.mall.entity.QuestionGoods;
import ltd.newbee.mall.service.QuestionGoodsService;
import ltd.newbee.mall.util.PageResult;

@RestController
public class QuestionGoodsController {
	@Autowired
	private QuestionGoodsService questionGoodsService;
	private String questionId;

	@GetMapping("/qa/page")
	public Map<String, Object> getQAList(
	    @RequestParam(value ="goodsId") int goodsId,
	    String questionId,
	    @RequestParam(value = "orderBy", defaultValue = "Like") String orderBy,
	    @RequestParam(value = "currPage", defaultValue = "1") int currPage) {
	    int pageSize=3;
	    List<QuestionGoods> questionList = questionGoodsService.getQAList(goodsId, orderBy, currPage, pageSize);
	    Integer totalCount = questionGoodsService.getQuestionCount(goodsId);
	    
	    PageResult pageResult=new PageResult(questionList,totalCount,pageSize,currPage);
	    
	    Map<String,Object> resultMap=new HashMap<>();
	    resultMap.put("currPage", currPage);
	    resultMap.put("totalPage", pageResult.getTotalPage());
	    resultMap.put("questionList", questionList);
	    return resultMap;
	}
}