/* Copyright (C) 2016 Sapient. All Rights Reserved. */
package com.sapient.auction.bidservice.services;

import com.sapient.auction.bidservice.domain.model.Bid;

/**
 * @author avish9 Service for operating upon {@link Bid} objects.
 */
public interface BidService {

	/**
	 * @param bidId
	 * @return bid object of given item id
	 */
	public Bid findByBidId(Integer itemID);

	/**
	 * placed a bid of current user
	 * 
	 * @param bid
	 */
	public void createBid(Bid bid);
}
