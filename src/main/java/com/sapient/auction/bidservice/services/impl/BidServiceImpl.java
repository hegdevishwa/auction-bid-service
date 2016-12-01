/* Copyright (C) 2016 Sapient. All Rights Reserved. */
package com.sapient.auction.bidservice.services.impl;

import javax.inject.Singleton;

import org.apache.log4j.Logger;

import com.sapient.auction.bidservice.domain.dao.BidDao;
import com.sapient.auction.bidservice.domain.model.Bid;
import com.sapient.auction.bidservice.services.BidService;

/**
 * @author avish9 Basic {@link BidService} implementation.
 */
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

	public Bid findByBidId(Integer id) {
		return bidDao.findByBidId(id);
	}
}
