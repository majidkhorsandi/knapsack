/*************************************************************************
 *
 * NORDNET CONFIDENTIAL
 *
 * [1996] - [2014] Nordnet Bank AB
 * All Rights Reserved.
 *
 * NOTICE:  All information contained herein is, and remains
 * the property of Nordnet Bank AB and its suppliers,
 * if any.  The intellectual and technical concepts contained
 * herein are proprietary to Nordnet Bank AB.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Nordnet Bank AB.
 *************************************************************************/

package org.videoplaza.helper;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.videoplaza.core.Customer;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * @version $Id:$
 */
public class JsonToCustomers {
	ObjectMapper mapper = new ObjectMapper();

	public JsonToCustomers() {}

	public Customer[] convertJsonToCustomer() {
		Customer[] customers = new Customer[0];
		try {
			// Convert JSON string from file to Object
			customers = mapper.readValue(new File("src/main/java/org/videoplaza/resources/customers1.json"), Customer[].class);
			System.out.println(customers);
			//Pretty print
			String theCustomer = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(customers);
			System.out.println(theCustomer);
			return customers;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return customers;
		} catch (IOException e) {
			e.printStackTrace();
			return customers;
		}
	}

}
