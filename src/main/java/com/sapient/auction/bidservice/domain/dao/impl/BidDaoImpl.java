/* Copyright (C) 2016 Sapient. All Rights Reserved. */
package com.sapient.auction.bidservice.domain.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;

import com.sapient.auction.bidservice.domain.dao.BidDao;
import com.sapient.auction.bidservice.domain.model.Bid;

import io.dropwizard.hibernate.AbstractDAO;

/**
 * @author avish9 JDBC DAO implementation for {@link Bid}.
 */
public class BidDaoImpl extends AbstractDAO<Bid> implements BidDao {

	private static final Logger LOGGER = Logger.getLogger(BidDaoImpl.class);

	/**
	 * it will return the bid detail of given item id.
	 */

	public BidDaoImpl(SessionFactory factory) {
		super(factory);
	}

	public int create(Bid bid) {
		return persist(bid).getBidId();
	}

	public Bid findByBidId(Integer id) {
		return get(id);
	}

	@Override
	public List<Bid> findByItemId(Integer itemID) {

		return null;
	}

	/*
	 * public List<Bid> findAll() { return
	 * list(namedQuery("com.example.helloworld.core.Person.findAll")); }
	 */

}
