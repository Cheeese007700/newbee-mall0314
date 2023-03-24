package ltd.newbee.mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ltd.newbee.mall.dao.QuestionGoodsMapper;
import ltd.newbee.mall.entity.QuestionGoods;
import ltd.newbee.mall.service.QuestionGoodsService;

@Service
public class QuestionGoodsServiceImpl implements QuestionGoodsService {
	@Autowired
	private QuestionGoodsMapper questionGoodsMapper;


	public QuestionGoodsServiceImpl(QuestionGoodsMapper questionGoodsMapper) {
		this.questionGoodsMapper = questionGoodsMapper;
	}

	@Override
	public List<QuestionGoods> getQAList(int goodsId, String orderBy, int currPage, int pageSize) {
		int start = (currPage - 1) * pageSize;
		return questionGoodsMapper.getQAList(goodsId, orderBy, start, pageSize);
	}

	@Override
	public int getLikeCount(int goodsId, String questionId) {
	    return questionGoodsMapper.getLikeCount(goodsId, questionId);
	}

	@Override
	public Integer getQuestionCount(int goodsId) {
		return questionGoodsMapper.getQuestionCount(goodsId);
	}
	
}
