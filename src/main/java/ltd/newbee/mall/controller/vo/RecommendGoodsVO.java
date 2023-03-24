package ltd.newbee.mall.controller.vo;

import java.io.Serializable;

public class RecommendGoodsVO implements Serializable{
	private int rank;
	private int goodsId;
	private String goodsName;
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	private String goodsIntro;
	
	public String getGoodsIntro() {
		return goodsIntro;
	}
	public void setGoodsIntro(String goodsIntro) {
		this.goodsIntro = goodsIntro;
	}
	
	public int getSellingPrice() {
		return sellingPrice;
	}
	public void setSellingPrice(int sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	private int sellingPrice;
	
	
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public int getStockNum() {
		// TODO Auto-generated method stub
		return getStockNum();
	}
	public void setStockStatus(String string) {
		// TODO Auto-generated method stub
		
	}
	public int getDeleteFlag() {
		// TODO Auto-generated method stub
		return getDeleteFlag();
	}
	public void setGoodsPriceTaxIncluded(String string) {
		// TODO Auto-generated method stub
		
	}

}
