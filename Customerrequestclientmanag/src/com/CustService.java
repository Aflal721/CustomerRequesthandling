package com;

import model.Customerrequest;
//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;
//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;
@Path("/Customerrequest")
public class CustService
{
Customerrequest itemObj = new Customerrequest();
@GET
@Path("/")
@Produces(MediaType.TEXT_HTML)
public String readItems()
 {
 return itemObj.readCustomerrequest();
 }


@POST
@Path("/")
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
@Produces(MediaType.TEXT_PLAIN)
public String insertItem(@FormParam("customerName") String customerName,
 @FormParam("customerEmail") String customerEmail,
 @FormParam("customerPhone") String customerPhone,
 @FormParam("projecttype") String projecttype,
 @FormParam("Description") String Description,
 @FormParam("Duration") String Duration)
{
	 String output = itemObj.insertcustomerdetails(customerName, customerEmail, customerPhone, projecttype, Description, Duration);
		return output;
}

@PUT
@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.TEXT_PLAIN)
public String updateItem(String itemData)
{
//Convert the input string to a JSON object
	 JsonObject Object = new JsonParser().parse(itemData).getAsJsonObject();
		//Read the values from the JSON object
		//(`customerID`, `customerName`, `customerEmail`, `customerPhone`, `projecttype`, `Description`, `Duration`)
		 String customerID = Object.get("customerID").getAsString();
		 String customerName = Object.get("customerName").getAsString();
		 String customerEmail = Object.get("customerEmail").getAsString();
		 String customerPhone = Object.get("customerPhone").getAsString();
		 String projecttype = Object.get("projecttype").getAsString();
		 String Description = Object.get("Description").getAsString();
		 String Duration = Object.get("Duration").getAsString();
		 String output = itemObj.updatecustomerdetails(customerID, customerName, customerEmail, customerPhone, projecttype, Description, Duration);
		return output;
		}



@DELETE
@Path("/")
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.TEXT_PLAIN)
public String deleteItem(String itemData)
{
//Convert the input string to an XML document
 Document doc = Jsoup.parse(itemData, "", Parser.xmlParser());

//Read the value from the element <itemID>
 String customerID = doc.select("customerID").text();
 String output = itemObj.deleteItem(customerID);
return output;
}


}