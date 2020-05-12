package com.byh.mall.vo;
public class CartVO
{
	private String productName;
	private String carttId;
	private String productId;
	private String productImage;
	private String favorPrice;
	private int qty;
	private int isChecked;

	public String getCarttId()
	{
		return carttId;
	}
	public void setCarttId(String carttId)
	{
		this.carttId = carttId;
	}
	public String getProductName()
	{
		return productName;
	}
	public void setProductName(String productName)
	{
		this.productName = productName;
	}
	public String getProductId()
	{
		return productId;
	}
	public void setProductId(String productId)
	{
		this.productId = productId;
	}
	public String getProductImage()
	{
		return productImage;
	}
	public void setProductImage(String productImage)
	{
		this.productImage = productImage;
	}
	public String getFavorPrice()
	{
		return favorPrice;
	}
	public void setFavorPrice(String favorPrice)
	{
		this.favorPrice = favorPrice;
	}
	public int getQty()
	{
		return qty;
	}
	public void setQty(int qty)
	{
		this.qty = qty;
	}
	public int getIsChecked()
	{
		return isChecked;
	}
	public void setIsChecked(int isChecked)
	{
		this.isChecked = isChecked;
	}
}
