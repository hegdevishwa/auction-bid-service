package com.sapient.auction.bidservice.domain.dao.impl;

import org.hibernate.SessionFactory;

import com.sapient.auction.bidservice.domain.dao.BaseDao;

public abstract class BaseDaoImpl implements BaseDao {

	protected SessionFactory sessionFactory;

	/**
	 * @param dataSource
	 *            the dataSource to set
	 */
	public void BaseDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
