package com.capgemini.forsertmanagement.controller;

import java.util.List;
import java.util.Scanner;

import com.capgemini.forestmanagement.dto.OrderBean;
import com.capgemini.forestmanagement.exception.DataBaseNotFoundException;
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
		OrderBean bean = new OrderBean();

		while (true) {
			System.out.println("Press 1 to add order details");
			System.out.println("Press 2 to search order details");
			System.out.println("Press 3 to get list of order details");
			System.out.println("Press 4 to update order details");
			System.out.println("Press 5 to delete order details");
			System.out.println("Press 6 to go home page");
			System.out.println("Press 7 to logout");

			String ch = sc.next();
			ch = Validations.validCaseForCrudOperations(ch);

			switch (Integer.parseInt(ch)) {
			case 1:
				bean = new OrderBean();

				System.out.println("Enter the customer id [Value should be in between 1 and 999]");
				String customerId = sc.next();
				customerId = Validations.IdValidation(customerId);
				bean.setCustomerId(Integer.parseInt(customerId));

				System.out.println("Enter the product id [Value should be in between 1 and 999]");
				String productId = sc.next();
				productId = Validations.IdValidation(productId);
				bean.setProductId(Integer.parseInt(productId));

				System.out.println("Enter the haulier id [Value should be in between 1 and 999]");
				String haulierId = sc.next();
				haulierId = Validations.IdValidation(haulierId);
				bean.setHaulierId(Integer.parseInt(haulierId));

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

				List<OrderBean> orders = service.getAllOrders();
				int orderNo = orders.size() + 1;
				bean.setOrderNo(orderNo);
				try {
					boolean check = service.addOrder(bean);
					if (check) {
						System.out.println("Good, You successfully added the details with order number " + orderNo);
						System.out.println("--------------------------------------");
					} else {
						System.err.println("Oops, Something went wrong. Please add one more time.");
						System.out.println("--------------------------------------");
					}
				} catch (DataBaseNotFoundException e) {
					System.err.println(e.getMessage());
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
						System.out.println("Customer id= " + order.getCustomerId());
						System.out.println("Product id= " + order.getProductId());
						System.out.println("Haulier id= " + order.getHaulierId());
						System.out.println("Delivery date= " + order.getDeliveryDate());
						System.out.println("Delivery day= " + order.getDeliveryDay());
						System.out.println("Quantity= " + order.getQuantity());
						System.out.println("--------------------------------------");
					} else {
						System.err.println("Oops, No data Found.");
						System.out.println("---------------------------");
					}
				} catch (DataBaseNotFoundException e) {
					System.err.println(e.getMessage());
				} catch (Exception e) {
					System.err.println("Input mismatch exception. Please give valid input.");
				}
				break;

			case 3:
				try {
					List<OrderBean> order = service.getAllOrders();
					if (order == null) {
						System.err.println("Oops, No Records Found.");
						System.out.println("----------------------------");
					} else {
						for (OrderBean orderBean : order) {
							System.out.println("Hi!! Here is your data....");
							System.out.println("*************************************************************");
							System.out.println("Order number= " + orderBean.getOrderNo());
							System.out.println("Customer id= " + orderBean.getCustomerId());
							System.out.println("Product id= " + orderBean.getProductId());
							System.out.println("Haulier id= " + orderBean.getHaulierId());
							System.out.println("Delivery date= " + orderBean.getDeliveryDate());
							System.out.println("Delivery day= " + orderBean.getDeliveryDay());
							System.out.println("Quantity= " + orderBean.getQuantity());
							System.out.println("--------------------------------------");
						}
					}
				} catch (DataBaseNotFoundException e) {
					System.err.println(e.getMessage());
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
								System.out.println("Enter the new customer id [Value should be in between 1 and 999]");
								String newId = sc.next();
								newId = Validations.IdValidation(newId);
								bean.setCustomerId(Integer.parseInt(newId));
								break;
							case 2:
								System.out.println("Enter the new product id [Value should be in between 1 and 999]");
								String newProductId = sc.next();
								newProductId = Validations.IdValidation(newProductId);
								bean.setProductId(Integer.parseInt(newProductId));
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
								System.out.println("Enter the new haulier Id [Value should be in between 1 and 999]");
								String newId1 = sc.next();
								newId1 = Validations.IdValidation(newId1);
								bean.setHaulierId(Integer.parseInt(newId1));
								break;
							case 7:
								update = true;
								break;
							case 8:
								System.exit(0);

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
				} catch (DataBaseNotFoundException e) {
					System.err.println(e.getMessage());
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
				} catch (DataBaseNotFoundException e) {
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
