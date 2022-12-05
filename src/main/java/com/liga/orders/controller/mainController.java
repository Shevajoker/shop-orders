package com.liga.orders.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.liga.orders.entity.Client;
import com.liga.orders.entity.Employee;
import com.liga.orders.entity.Order;

import com.liga.orders.service.ClientService;
import com.liga.orders.service.EmployeeService;
import com.liga.orders.service.OrderService;

@Controller
public class mainController {

	@Autowired
	private OrderService orderService;

	@Autowired
	private ClientService clientService;

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping("/")
	public String naimIndex() {
		return "main";
	}
	
	@RequestMapping("/main")
	public String naim() {
		return "main";
	}

	

	@RequestMapping("/order")
	public String order(Model model) {

		model.addAttribute("allClients", clientService.getAllClients());
		model.addAttribute("allEmployees", employeeService.getAllEmployees());
		model.addAttribute("client", new Client());
		model.addAttribute("employee", new Employee());
		model.addAttribute("order", new Order());

		return "order";
	}

	@PostMapping("/saveOrder")
	public String saveOrder(@ModelAttribute("order") Order order, @ModelAttribute("clientId") int clientId,
			@ModelAttribute("employeeId") int employeeId, Model model) {

		Client client = clientService.getClientById(clientId);
		Employee employee = employeeService.getEmployeeById(employeeId);

		if (client == null) {
			return "redirect:/newClient";
		}

		if (employee == null) {
			return "redirect:/newEmployee";
		}

		order.setClient(client);
		order.setEmployee(employee);
		if(order.getCreationDate() == null) {
		order.setCreationDate(new Date());
		}

		System.out.println(order.toString());
		orderService.saveOrder(order);

		return "redirect:/order";
	}

	@RequestMapping("/newClient")
	public String newClient(Model model) {
		model.addAttribute("client", new Client());
		return "newClient";
	}

	@PostMapping("/saveClient")
	private String saveClient(@ModelAttribute("client") Client client) {

		clientService.saveClient(client);

		return "redirect:/newClient";
	}

	@RequestMapping("/newEmployee")
	public String newEmployee(Model model) {
		model.addAttribute("employee", new Employee());
		return "newEmployee";
	}

	@PostMapping("/saveEmployee")
	public String saveEmployee(Employee employee) {

		employeeService.saveEmployee(employee);

		return "redirect:/newEmployee";
	}

	@GetMapping("/clientOrders")
	public String clientOrders(Model model) {
		model.addAttribute("allClients", clientService.getAllClients());
		model.addAttribute("selectClient", "");
		model.addAttribute("selectClientId", 0);
		return "client-orders";
	}

	@PostMapping("/clientOrders")
	public String clientOrders(@ModelAttribute("clientId") int clientId, Model model) {
		model.addAttribute("allClients", clientService.getAllClients());
		Client client = clientService.getClientById(clientId);

		List<Order> orders = client.getOrders();
		double totalSaleAmount = orders.stream().mapToDouble(x -> x.getSaleAmount()).sum();
		double totalPaymentAmount = orders.stream().mapToDouble(x -> x.getPaymentAmount()).sum();
		
		model.addAttribute("listOrders", orders);
		model.addAttribute("selectClient", client.getClientName() + " " + client.getClientSurName());
		model.addAttribute("selectClientId", client.getId());
		model.addAttribute("totalSaleAmount", totalSaleAmount);
		model.addAttribute("totalPaymentAmount", totalPaymentAmount);

		return "client-orders";
	}

	
	@GetMapping("/employeeOrders")
	public String employeeOrders(Model model) {
		model.addAttribute("allEmployeers", employeeService.getAllEmployees());
		model.addAttribute("selectEmployee", "");
		model.addAttribute("selectEmployeeId", 0);
		return "employee-orders";
	}
	
	@PostMapping("/employeeOrders")
	public String employeeOrders(@ModelAttribute("employeeId") int employeeId, Model model) {
		model.addAttribute("allEmployeers", employeeService.getAllEmployees());
		Employee employee =  employeeService.getEmployeeById(employeeId);

		List<Order> orders = employee.getOrders();
		
		double totalSaleAmount = orders.stream().mapToDouble(x -> x.getSaleAmount()).sum();
		double totalPaymentAmount = orders.stream().mapToDouble(x -> x.getPaymentAmount()).sum();
		
		
		
		model.addAttribute("listOrders", orders);
		model.addAttribute("selectEmployee", employee.getEmployeeName() + " " + employee.getEmlpoyeeSurName());
		model.addAttribute("selectEmployeeId", employee.getId());
		model.addAttribute("totalSaleAmount", totalSaleAmount);
		model.addAttribute("totalPaymentAmount", totalPaymentAmount);

		return "employee-orders";
	}
}
