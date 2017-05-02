package com.nixsolutions.controller.rest;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nixsolutions.dto.AddressDTO;
import com.nixsolutions.dto.UserDTO;
import com.nixsolutions.entity.Orders;
import com.nixsolutions.service.ServiceApi.OrdersService;
import com.nixsolutions.service.ServiceApi.UserService;

@Controller
@Path("person")
public class RestControllerImpl implements GeneralRestController {

	@Autowired
	private UserService userService;

	@Autowired
	private OrdersService orderService;

	@GET
	@Path("get/{id}/")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Response getUser(@PathParam("id") String id) throws NumberFormatException, SQLException {
		UserDTO user = userService.getUserDtoById(Integer.parseInt(id));
		if (user == null) {
			throw new UserNotExistException("This user doesn't exist!");
		}
		return Response.status(200).entity(user).build();
	}

	@POST
	@Path("save")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Response saveUser(UserDTO user) throws SQLException {
		Integer id = userService.createUser(user);
		return Response.status(200).entity(id).build();
	}

	@DELETE
	@Path("delete/{id}")
	@Override
	public Response deleteUser(@PathParam("id") String id) throws NumberFormatException, Exception {
		
		for (Orders order : orderService.getAll()) {
			if (order.getOrdersId() == order.getOrdersId()) {
				orderService.delete(order.getOrdersId());
			}
		}
		
		userService.delete(Integer.parseInt(id));	
		String result = "User " + id + " is deleted.";
		int status = 200;
		return Response.status(status).entity(result).build();
	}

}
