package ltd.newbee.mall.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import ltd.newbee.mall.entity.QuestionGoods;

public interface QuestionGoodsMapper {
	
	List<QuestionGoods> getQAList(@Param("goodsId") int goodsId,
			@Param("orderBy") String orderBy,
			@Param("start") int start,
		   @Param ("pageSize")int pageSize);

public	int getLikeCount(int goodsId,String questionId);

Integer getQuestionCount(int goodsId);
	

}
