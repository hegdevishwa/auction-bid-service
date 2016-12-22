/* Copyright (C) 2016 Sapient. All Rights Reserved. */
package com.sapient.auction.bidservice.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.sapient.auction.bidservice.domain.model.Bid;
import com.sapient.auction.bidservice.services.BidService;

import io.dropwizard.hibernate.UnitOfWork;


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

		return Response.ok().entity("Bid service is up and running!!").build();
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
		return Response.ok().build();
	}

	@GET
	@UnitOfWork
	@Path(value = "/bids/{itemId}")
	public Response getAllBids(@PathParam(value = "itemId") int itemId) {
		LOGGER.info("Method: getAllBids called");

		Bid bid = bidService.findHeighestBidOfItem(itemId);
		return Response.status(Response.Status.FOUND).entity(bid).build();

	}

}
