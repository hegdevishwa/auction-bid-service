/* Copyright (C) 2016 Sapient. All Rights Reserved. */
package com.sapient.auction.bidservice.services.impl;

import javax.inject.Singleton;

import org.apache.log4j.Logger;

import com.sapient.auction.bidservice.domain.dao.BidDao;
import com.sapient.auction.bidservice.domain.model.Bid;
import com.sapient.auction.bidservice.exception.DataNotFoundException;
import com.sapient.auction.bidservice.services.BidService;


@Singleton
public class BidServiceImpl implements BidService {

	private static final Logger LOGGER = Logger.getLogger(BidServiceImpl.class);

	private BidDao bidDao;

	public BidServiceImpl(BidDao bidDao) {
		super();
		this.bidDao = bidDao;
	}

	@Override
	public void createBid(Bid bid) {

		LOGGER.info("bid details is goiong to save");
		bidDao.create(bid);
	}

	@Override
	public Bid findHeighestBidOfItem(Integer itemId) {

		Bid bid = bidDao.findHeighestBidOfItem(itemId);
		if (bid == null) {
			throw new DataNotFoundException("Bid details not found for the gien Item id");
		}
		return bid;

	}
}
