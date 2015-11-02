
package org.videoplaza.utils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.videoplaza.core.Customer;

/**
 * @version $Id:$
 */
public class JsonToCustomers {
	ObjectMapper mapper = new ObjectMapper();

	public JsonToCustomers() {}

	public List<Customer> convertJsonToCustomerList(String customerJsonFilePath) {
		List<Customer> customers = new ArrayList<Customer>();
		try {
			// Convert JSON string from file to Object

			customers = mapper.readValue(new File(customerJsonFilePath), new TypeReference<List<Customer>>(){});
			// filter out customers that have 0 as revenue
			for( Iterator<Customer> it = customers.iterator(); it.hasNext() ; )
			{
				Customer customer = it.next();
				if(customer.getRevenue() == 0)
				{
					it.remove();
				}
			}
			return customers;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return customers;
		} catch (IOException e) {
			e.printStackTrace();
			return customers;
		}
	}

	public Customer[] convertJsonToCustomerArray(String customerJsonFilePath) {
		Customer[] customers = new Customer[0];
		try {
			// Convert JSON string from file to Object
			customers = mapper.readValue(new File(customerJsonFilePath), Customer[].class);
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
