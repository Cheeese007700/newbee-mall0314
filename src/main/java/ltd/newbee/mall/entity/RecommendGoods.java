package ltd.newbee.mall.entity;

import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class RecommendGoods {
	private int rank;
	private int goodsId;
	
	@JsonIgnore
	private int type;
	 @JsonIgnore
	private int limit;
	 @JsonIgnore
	private int sellingPrice;
	private String goodsPriceTaxIncluded;
	private int stockNum;
	 @JsonIgnore
	private int deleteFlag;
	private Date productionDate;
	
	
	public int getStockNum() {
		 return stockNum;
	}
	public void setStockNum(int stockNum) {
		this.stockNum = stockNum;
	}
	public int getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	public Date getProductionDate() {
		return productionDate;
	}
	public void setProductionDate(Date productionDate) {
		this.productionDate = productionDate;
	}
	
	public int getSellingPrice() {
		return sellingPrice;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	private String goodsName;

	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	
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
	public void setStockStatus(String string) {
		// TODO Auto-generated method stub
		
	}
	
	public String getGoodsPriceTaxIncluded() {
		return goodsPriceTaxIncluded+ "円";
	}
	public void setSellingPrice(int sellingPrice) {
		this.sellingPrice = sellingPrice;
		  int goodsPriceTaxIncluded = Math.round(sellingPrice * 1.1f);
        this.goodsPriceTaxIncluded = NumberFormat.getInstance(Locale.JAPAN).format(goodsPriceTaxIncluded) + "円";
		
	}

	
}

