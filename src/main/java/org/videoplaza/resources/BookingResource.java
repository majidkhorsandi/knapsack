package org.videoplaza.resources;

import com.codahale.metrics.annotation.Timed;
import io.dropwizard.jersey.params.IntParam;
import org.videoplaza.core.Bookings;
import org.videoplaza.core.Customers;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BookingResource {

   @POST
   @Path("booking")
   @Timed
   public Bookings optimizeCampaigns(Customers body, @QueryParam("inventory") IntParam inventory) {
      return new Bookings(body, inventory.get());
   }

   @GET
   @Path("info")
   @Timed
   public String info() {
      String str = "Usage\n"
         + "\n"
         + "Info page\n"
         + "GET localhost:8080/info\n"
         + "Response: This page\n"
         + "\n"
         + "Campaign optiomisation\n"
         + "POST localhost:8080/booking?inventory=12000\n"
         + "Input:\n"
         + "Query param = number of available impressions\n"
         + "Content-type: application/json\n"
         + "Body:\n"
         + "{\n"
         + "  \"customers\":[\n"
         + "     {\n"
         + "        \"name\":\"CustomerA\",\n"
         + "        \"impressions\":10000,\n"
         + "        \"revenue\":100\n"
         + "     },\n"
         + "     {\n"
         + "        \"name\":\"CustomerB\",\n"
         + "        \"impressions\":5000,\n"
         + "        \"revenue\":60\n"
         + "     },\n"
         + "     {\n"
         + "        \"name\":\"CustomerC\",\n"
         + "        \"impressions\":2000,\n"
         + "        \"revenue\":20\n"
         + "     }\n"
         + "  ]\n"
         + "}\n"
         + "\n"
         + "Response:\n"
         + "{\n"
         + "    \"soldCampaigns\": [\n"
         + "        {\n"
         + "            \"customerName\": \"CustomerB\",\n"
         + "            \"sold\": 2,\n"
         + "            \"impressions\": 10000,\n"
         + "            \"revenue\": 120\n"
         + "        },\n"
         + "        {\n"
         + "            \"customerName\": \"CustomerC\",\n"
         + "            \"sold\": 2,\n"
         + "            \"impressions\": 2000,\n"
         + "            \"revenue\": 20\n"
         + "        }\n"
         + "    ],\n"
         + "    \"inventory\": 12000,\n"
         + "    \"revenue\": 140\n"
         + "}";

      return str;
   }
}
