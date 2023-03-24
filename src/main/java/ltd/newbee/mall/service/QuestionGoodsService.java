package ltd.newbee.mall.service;

import java.util.List;

import ltd.newbee.mall.entity.QuestionGoods;

public interface QuestionGoodsService {
	//输出Q and A
	List<QuestionGoods> getQAList(int goodsId, String orderBy,int currPage,int pageSize);

	//分页
	int getLikeCount(int goodsId,String questionId);

	Integer getQuestionCount(int goodsId);

}
