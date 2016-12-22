/* Copyright (C) 2016 Sapient. All Rights Reserved. */
package com.sapient.auction.bidservice.domain.dao;

import com.sapient.auction.bidservice.domain.model.Bid;

/**
 * @author avish9 Object for read/writing {@link Bid} data from/to a data
 *         source.
 */
public interface BidDao {

	/**
	 * placed a bid of current user
	 * 
	 * @param bid
	 */
	public int create(Bid bid);

	public Bid findByBidId(Integer id);

	public Bid findHeighestBidOfItem(Integer itemID);

}
