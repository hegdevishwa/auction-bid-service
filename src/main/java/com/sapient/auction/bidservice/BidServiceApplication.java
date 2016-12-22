package com.sapient.auction.bidservice;

import com.sapient.auction.bidservice.configuration.BidServiceConfiguration;
import com.sapient.auction.bidservice.domain.dao.impl.BidDaoImpl;
import com.sapient.auction.bidservice.domain.model.Bid;
import com.sapient.auction.bidservice.exception.DataNotFoundException;
import com.sapient.auction.bidservice.exception.DataNotFoundExceptionMapper;
import com.sapient.auction.bidservice.exception.GenericExceptionMapper;
import com.sapient.auction.bidservice.resource.BidResource;
import com.sapient.auction.bidservice.services.BidService;
import com.sapient.auction.bidservice.services.impl.BidServiceImpl;

import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class BidServiceApplication extends Application<BidServiceConfiguration> {

	private final HibernateBundle<BidServiceConfiguration> hibernate = new HibernateBundle<BidServiceConfiguration>(
			Bid.class) {
		@Override
		public DataSourceFactory getDataSourceFactory(BidServiceConfiguration configuration) {
			return configuration.getDataSourceFactory();
		}
	};

	public static void main(String[] args) throws Exception {
		new BidServiceApplication().run(args);
	}

	@Override
	public void initialize(Bootstrap<BidServiceConfiguration> bootstrap) {
		bootstrap.addBundle(hibernate);
	}

	@Override
	public void run(BidServiceConfiguration config, Environment environment) throws ClassNotFoundException {
		final BidDaoImpl bidDao = new BidDaoImpl(hibernate.getSessionFactory());
		final BidService bidService = new BidServiceImpl(bidDao);
		final BidResource bidResource = new BidResource(bidService);
		environment.jersey().register(new DataNotFoundExceptionMapper());
		environment.jersey().register(new GenericExceptionMapper());

		environment.jersey().register(bidResource);
	}

}
