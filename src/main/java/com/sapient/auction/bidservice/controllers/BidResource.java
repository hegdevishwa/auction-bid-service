/* Copyright (C) 2016 Sapient. All Rights Reserved. */
package com.sapient.auction.bidservice.controllers;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.sapient.auction.bidservice.domain.model.Bid;
import com.sapient.auction.bidservice.services.BidService;

import io.dropwizard.hibernate.UnitOfWork;

/**
 * @author avish9 Controller for {@link Bid} resources.
 */
@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BidResource {

	/** logger */
	private static final Logger LOGGER = Logger.getLogger(BidResource.class);

	private BidService bidService;

	public BidResource(BidService bidService) {
		super();
		this.bidService = bidService;
	}

	@GET
	public Response pingService() {

		Bid bid = new Bid();
		bid.setBidId(10);
		bid.setBidPrice(1000);
		bid.setItemId(32);
		bid.setUserId(91);

		return Response.ok().entity(bid).build();
		// return Response.ok().entity("Bid service is up and
		// running!!").build();
	}

	/**
	 * this method submit the bid of given by user.
	 * 
	 * @param bid
	 * @param model
	 */
	@POST
	@UnitOfWork
	@Path(value = "/bids")
	public Response createNewBid(Bid bid) {
		LOGGER.info("Method: placedBid called");

		bidService.createBid(bid);
		return null;
	}

	@GET
	@Path(value = "/bids")
	public Response getAllBids(@QueryParam(value = "search-criteria") String searchCriteria,
			@QueryParam(value = "id") int id) {
		LOGGER.info("Method: getAllBids called");

		if (searchCriteria.equalsIgnoreCase("itemid")) {
			Bid bid = new Bid();
			bid.setBidId(10);
			return Response.status(Response.Status.FOUND).entity(bid).build();
		} else if (searchCriteria.equalsIgnoreCase("bidid")) {
			Bid bid = bidService.findByBidId(id);
			return Response.status(Response.Status.FOUND).entity(bid).build();
		}
		return null;
	}

}
