package com.sapient.auction.bidservice.domain.model;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

public class Item {

	private int itemId;

	@NotEmpty(message = "Please enter name")
	private String name;
	@NotEmpty(message = "Please choose category")
	private String category;
	private String description;
	private double baseBidPrice;
	private Date createDateTime;
	private int userId;
	private Date expiryDate;
	private byte[] imageByteArray;
	private String base64EncodedImage;

	/**
	 * @return the itemId
	 */
	public int getItemId() {
		return itemId;
	}

	/**
	 * @param itemId
	 *            the itemId to set
	 */
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category
	 *            the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the baseBidPrice
	 */
	public double getBaseBidPrice() {
		return baseBidPrice;
	}

	/**
	 * @param baseBidPrice
	 *            the baseBidPrice to set
	 */
	public void setBaseBidPrice(double baseBidPrice) {
		this.baseBidPrice = baseBidPrice;
	}

	/**
	 * @return the createDateTime
	 */
	public Date getCreateDateTime() {
		return createDateTime;
	}

	/**
	 * @param createDateTime
	 *            the createDateTime to set
	 */
	public void setCreateDateTime(Date createDateTime) {
		this.createDateTime = createDateTime;
	}

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return the expiryDate
	 */
	public Date getExpiryDate() {
		return expiryDate;
	}

	/**
	 * @param expiryDate
	 *            the expiryDate to set
	 */
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	/**
	 * @return the imageByteArray
	 */
	public byte[] getImageByteArray() {
		return imageByteArray;
	}

	/**
	 * @param imageByteArray
	 *            the imageByteArray to set
	 */
	public void setImageByteArray(byte[] imageByteArray) {
		this.imageByteArray = imageByteArray;
	}

	/**
	 * @return the base64EncodedImage
	 */
	public String getBase64EncodedImage() {
		return base64EncodedImage;
	}

	/**
	 * @param base64EncodedImage
	 *            the base64EncodedImage to set
	 */
	public void setBase64EncodedImage(String base64EncodedImage) {
		this.base64EncodedImage = base64EncodedImage;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", name=" + name + ", category=" + category + ", description=" + description
				+ ", baseBidPrice=" + baseBidPrice + ", createDate=" + createDateTime + ", userId=" + userId
				+ ", updateDate=" + "]";
	}

}
