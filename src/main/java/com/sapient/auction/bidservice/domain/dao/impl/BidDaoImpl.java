/* Copyright (C) 2016 Sapient. All Rights Reserved. */
package com.sapient.auction.bidservice.domain.dao.impl;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.sapient.auction.bidservice.domain.dao.BidDao;
import com.sapient.auction.bidservice.domain.model.Bid;

import io.dropwizard.hibernate.AbstractDAO;


public class BidDaoImpl extends AbstractDAO<Bid> implements BidDao {

	private static final Logger LOGGER = Logger.getLogger(BidDaoImpl.class);

	/**
	 * it will return the bid detail of given item id.
	 */

	public BidDaoImpl(SessionFactory factory) {
		super(factory);
	}

	@Override
	public int create(Bid bid) {
		int bidId = persist(bid).getBidId();
		return bidId;
	}

	@Override
	public Bid findByBidId(Integer id) {
		return get(id);
	}

	@Override
	public Bid findHeighestBidOfItem(Integer itemId) {

		String hql = "from Bid where bidPrice=(select max(bidPrice) from Bid where itemId= :item_id) and itemId= :item_id";

		Query query = currentSession().createQuery(hql).setInteger("item_id", itemId);
		return uniqueResult(query);
	}

}
