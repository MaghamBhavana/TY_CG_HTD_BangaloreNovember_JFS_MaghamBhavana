package com.capgemini.forsertmanagement.controller;

import java.util.List;
import java.util.Scanner;

import com.capgemini.forestmanagement.dto.CustomerBean;
import com.capgemini.forestmanagement.dto.HaulierBean;
import com.capgemini.forestmanagement.dto.OrderBean;
import com.capgemini.forestmanagement.dto.ProductBean;
import com.capgemini.forestmanagement.exception.OrderIdNotFoundException;
import com.capgemini.forestmanagement.factory.OrderFactory;
import com.capgemini.forestmanagement.service.OrderService;
import com.capgemini.forestmanagement.validation.Validations;

public class OrderController {

	static OrderService service;
	static {
		service = OrderFactory.instanceOfOrderServiceImpl();
	}

	public static void orderLogic() {

		Scanner sc = new Scanner(System.in);
		OrderBean bean ;

		while (true) {
			System.out.println("Press 1 to add order details");
			System.out.println("Press 2 to search order details");
			System.out.println("Press 3 to get list of order details");
			System.out.println("Press 4 to update order details");
			System.out.println("Press 5 to delete order details");
			System.out.println("Press 6 to go homepage");
			System.out.println("Press 7 to logout");

			String ch = sc.next();
			ch = Validations.validCaseForCrudOperations(ch);

			switch (Integer.parseInt(ch)) {
			case 1:
				bean = new OrderBean();

				System.out.println("Enter the customer id [Value should be in between 1 and 999]");
				String customerId = sc.next();
				customerId = Validations.IdValidation(customerId);
				CustomerBean customerBean = service.getCustomer(Integer.parseInt(customerId));
				bean.setCustomer(customerBean);

				System.out.println("Enter the product id [Value should be in between 1 and 999]");
				String productId = sc.next();
				productId = Validations.IdValidation(productId);
				ProductBean productBean = service.getProduct(Integer.parseInt(productId));
				bean.setProduct(productBean);

				System.out.println("Enter the haulier id [Value should be in between 1 and 999]");
				String haulierId = sc.next();
				haulierId = Validations.IdValidation(haulierId);
				HaulierBean haulierBean = service.getHaulier(Integer.parseInt(haulierId));
				bean.setHaulier(haulierBean);

				System.out.println("Enter the delivery date [Date format should be in 'YYYY/MM/DD']");
				String date = sc.next();
				date = Validations.dateValidation(date);
				bean.setDeliveryDate(date);
				
				System.out.println("Enter the delivery day [Day format should be in 'Monday']");
				String deliveryDay = sc.next();
				boolean isCorrect5 = true;
				do {
					if (deliveryDay.equalsIgnoreCase("Monday") || deliveryDay.equalsIgnoreCase("Tuesday")
							|| deliveryDay.equalsIgnoreCase("Wednesday") || deliveryDay.equalsIgnoreCase("Thursday")
							|| deliveryDay.equalsIgnoreCase("Friday") || deliveryDay.equalsIgnoreCase("Saturday")
							|| deliveryDay.equalsIgnoreCase("Sunday")) {
						isCorrect5 = false;
					} else {
						System.err.println("Sorry!!! Please enter valid day");
						deliveryDay = sc.next();
					}
				} while (isCorrect5);
				bean.setDeliveryDay(deliveryDay);
				
				System.out.println("Enter the quantity [Value should be in between 1 and 999]");
				String quantity = sc.next();
				quantity = Validations.quantityValidation(quantity);
				bean.setQuantity(Integer.parseInt(quantity));
				
				boolean check = service.addOrder(bean);
				if (check) {
					System.out.println("Good, You successfully added the details of order ");
					System.out.println("--------------------------------------");
				} else {
					System.err.println("Oops, Something went wrong. Please add one more time.");
					System.out.println("--------------------------------------");
				}
				break;
			case 2:
				try {
					System.out.println("Enter which order number details you want to search.");
					int orderNo1 = sc.nextInt();
					OrderBean order = service.getOrder(orderNo1);
					if (order != null) {
						System.out.println("Hi!! Here is your data....");
						System.out.println("*************************************************************");
						System.out.println("Order number= " + order.getOrderNo());
						 System.out.println("Customer id= " + order.getCustomer().getCustomerId());
						 System.out.println("Product id= " + order.getProduct().getProductId());
						 System.out.println("Haulier id= " + order.getHaulier().getHaulierId());
						 System.out.println("Delivery date= " + order.getDeliveryDate());
						System.out.println("Delivery day= " + order.getDeliveryDay());
						System.out.println("Quantity= " + order.getQuantity());
						System.out.println("--------------------------------------");
					} else {
						System.err.println("Oops, No data Found.");
						System.out.println("---------------------------");
					}
				} catch (Exception e) {
					System.err.println("Input mismatch exception. Please give valid input.");
				}
				break;
			case 3:
				List<OrderBean> order = service.getAllOrders();
				if (order == null) {
					System.err.println("Oops, No Records Found.");
					System.out.println("----------------------------");
				} else {
					for (OrderBean orderBean : order) {
						System.out.println("Hi!! Here is your data....");
						System.out.println("*************************************************************");
						System.out.println("Order number= " + orderBean.getOrderNo());
						System.out.println("Customer id= " + orderBean.getCustomer().getCustomerId());
						System.out.println("Product id= " + orderBean.getProduct().getProductId());
						System.out.println("Haulier id= " + orderBean.getHaulier().getHaulierId());
						System.out.println("Delivery date= " + orderBean.getDeliveryDate());
						System.out.println("Delivery day= " + orderBean.getDeliveryDay());
						System.out.println("Quantity= " + orderBean.getQuantity());
						System.out.println("--------------------------------------");
					}
				}
				break;
			case 4:
				bean = new OrderBean();
				try {
					System.out.println("Enter which order number details you want to update.");
					int orderNo1 = sc.nextInt();

					OrderBean order1 = service.getOrder(orderNo1);
					boolean isFound = false;
					if (order1 != null) {
						isFound = true;
						bean = order1;
					}

					if (isFound) {
						boolean update = false;
						do {
							System.out.println("Hi manager, Here is your list to update.....");
							System.out.println("*****************************************");
							System.out.println("Please enter 1 to modify customer id");
							System.out.println("Please enter 2 to modify product id");
							System.out.println("Please enter 3 to modify quantity");
							System.out.println("Please enter 4 to modify deliveryday");
							System.out.println("Please enter 5 to modify deliverydate");
							System.out.println("Please enter 6 to modify haulier id");
							System.out.println("Please enter 7 to update all the modified details");
							System.out.println("Please enter 8 to logout");
							String ch1 = sc.next();
							ch1 = Validations.validCaseForUpdateOperation(ch1);

							switch (Integer.parseInt(ch1)) {
							case 1:
								boolean isCustomerFound = false;
								CustomerBean customerBean1 = null;
								do {
									System.out.println(
											"Enter the new customer id [Value should be in between 1 and 999]");
									String newId = sc.next();
									newId = Validations.IdValidation(newId);
									customerBean1 = service.getCustomer(Integer.parseInt(newId));
									if (customerBean1 != null) {
										isCustomerFound = true;
									} else {
										System.err.println("No Customer found with id " + newId);
									}
								} while (isCustomerFound);
								bean.setCustomer(customerBean1);
								break;
							case 2:
								boolean isProductFound = false;
								ProductBean productBean1 = null;
								do {
									System.out
											.println("Enter the new product id [Value should be in between 1 and 999]");
									String newProductId = sc.next();
									newProductId = Validations.IdValidation(newProductId);
									productBean1 = service.getProduct(Integer.parseInt(newProductId));
									if (productBean1 != null) {
										isProductFound = true;
									} else {
										System.err.println("No Product found with id " + newProductId);
									}
								} while (isProductFound);
								bean.setProduct(productBean1);
								break;
							case 3:
								System.out.println("Enter the new quantity [Value should be in between 1 and 999]");
								String quantity1 = sc.next();
								quantity1 = Validations.quantityValidation(quantity1);
								bean.setQuantity(Integer.parseInt(quantity1));
								break;
							case 4:
								System.out.println("Enter the delivery day [Day format should be in 'Monday']");
								String newDay = sc.next();
								boolean isCorrect10 = true;
								do {

									if (newDay.equalsIgnoreCase("Monday") || newDay.equalsIgnoreCase("Tuesday")
											|| newDay.equalsIgnoreCase("Wednesday")
											|| newDay.equalsIgnoreCase("Thursday") || newDay.equalsIgnoreCase("Friday")
											|| newDay.equalsIgnoreCase("Saturday")
											|| newDay.equalsIgnoreCase("Sunday")) {
										isCorrect10 = false;
									} else {
										System.err.println("Sorry!!! Please enter valid day");
										newDay = sc.next();
									}
								} while (isCorrect10);
								bean.setDeliveryDay(newDay);
								break;
							case 5:
								System.out
										.println("Enter the new delivery date [Date format should be in 'YYYY/MM/DD']");
								String date1 = sc.next();
								date1 = Validations.dateValidation(date1);
								bean.setDeliveryDate(date1);
								break;
							case 6:
								boolean isHaulierFound = false;
								HaulierBean haulierBean1 = null;
								do {
									System.out
											.println("Enter the new haulier Id [Value should be in between 1 and 999]");
									String newId1 = sc.next();
									newId1 = Validations.IdValidation(newId1);
									haulierBean1 = service.getHaulier(Integer.parseInt(newId1));
									if (haulierBean1 != null) {
										isProductFound = true;
									} else {
										System.err.println("No Product found with id " + newId1);
									}
								} while (isHaulierFound);
								bean.setHaulier(haulierBean1);
								break;
							case 7:
								update = true;
								break;
							case 8:
								LoginPage.main(null);
							}
						} while (!update);
						boolean contract3 = service.updateOrder(orderNo1, bean);
						if (contract3) {
							System.out.println("Good, You successfully updated order details");
							System.out.println("---------------------------");
						} else {
							System.err.println("Oops, Something went wrong. Please try again");
							System.out.println("----------------------------------");
						}
					} else {
						// System.err.println("No data found with this Id");
						throw new OrderIdNotFoundException();
					}
				} catch (OrderIdNotFoundException e) {
					System.err.println(e.getMessage());
				} catch (Exception e) {
					System.err.println("Input mismatch exception. Please enter valid input");
				}
				break;
			case 5:
				try {
					System.out.println("Enter which ordernumber details you want to delete");
					int deleteId = sc.nextInt();
					OrderBean orderId = service.getOrder(deleteId);
					boolean isFound = false;
					if (orderId != null) {
						isFound = true;
					}
					if (isFound) {
						boolean check1 = service.deleteOrder(deleteId);
						if (check1) {
							System.out.println("Good, you deleted details successfully");
							System.out.println("-------------------------");
						} else {
							System.err.println("Oops, Something went wrong. Please try again");
							System.out.println("--------------------------");
						}
					} else {
						// System.err.println("No data is found with this Id");
						throw new OrderIdNotFoundException();
					}
				} catch (OrderIdNotFoundException e) {
					System.err.println(e.getMessage());
				} catch (Exception e) {
					System.err.println("Input mismatch exception. Please enter valid input");
				}
				break;
			case 6:
				HomePage.clientOptions();
				break;
			case 7:
				LoginPage.main(null);

			}

		}
	}

}
