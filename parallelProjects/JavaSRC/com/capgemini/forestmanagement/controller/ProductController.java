package com.capgemini.forestmanagement.controller;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Map.Entry;

import com.capgemini.forestmanagement.dto.ProductBean;
import com.capgemini.forestmanagement.factory.ProductFactory;
import com.capgemini.forestmanagement.validation.Validations;
import com.capgemini.forestmangement.service.ProductService;

public class ProductController {

	static ProductService service;
	static {
		service = ProductFactory.instanceOfProductServiceImpl();
	}

	public static void productLogic() {

		ProductService service = ProductFactory.instanceOfProductServiceImpl();
		Scanner sc = new Scanner(System.in);
		ProductBean bean = new ProductBean();

		while (true) {
			System.out.println("Press 1 to add product details");
			System.out.println("Press 2 to get list of product details");
			System.out.println("Press 3 to search product details");
			System.out.println("Press 4 to update product details");
			System.out.println("Press 5 to delete product details");
			System.out.println("Press 6 to go homepage");
			System.out.println("Press 7 to logout");

			String ch = sc.next();
			ch = Validations.validCaseForCurdOperations(ch);
			switch (Integer.parseInt(ch)) {
			case 1:
				bean = new ProductBean();
				System.out.println("Enter the product name [e.g:CapGemini, Length should be in between 3 to 25]");
				String productName = sc.next();
				productName = Validations.nameValidation(productName);
				bean.setProductName(productName);

				HashMap<Integer, ProductBean> products = service.getAllProducts();
				int productId = products.size() + 1;
				boolean check = service.addProduct(productId, bean);
				if (check) {
					System.out.println("Good, you added product Details successfully");
					System.out.println("--------------------------------------");
				} else {
					System.err.println("Oops, Something went wrong. Please add one more time");
					System.out.println("---------------------------------------");
				}
				break;
			case 2:
				HashMap<Integer, ProductBean> product = service.getAllProducts();
				if (product == null) {
					System.err.println("Oops, No records Found");
					System.out.println("----------------------------");
				} else {
					for (Entry<Integer, ProductBean> productBean : product.entrySet()) {
						System.out.println("Product id= " + productBean.getKey());
						System.out.println("Product name= " + productBean.getValue().getProductName());
						System.out.println("*********************************************************");

					}
				}
				break;
			case 3:
				try {
					System.out.println("Enter which product id details you want to search");
					int productId1 = sc.nextInt();
					Entry<Integer, ProductBean> product1 = service.getProduct(productId1);
					if (product1 != null) {
						System.out.println("Hi!! Here is your data....");
						System.out.println("*************************************************************");
						System.out.println("Product id= " + product1.getKey());
						System.out.println("Product name= " + product1.getValue().getProductName());
						System.out.println("--------------------------------------------------");
					} else {
						System.err.println("Oops, No records Found");
						System.out.println("--------------------------------");
					}
				} catch (Exception e2) {
					System.err.println("Input mimsmatch exception. Please enter valid Input");
				}
				break;
			case 4:
				bean = new ProductBean();
				try {
					System.out.println("Enter which Product id details you want to update");
					int productId2 = sc.nextInt();

					Entry<Integer, ProductBean> product1 = service.getProduct(productId2);
					boolean isFound = false;
					if (product1 != null) {
						isFound = true;
						bean = product1.getValue();
					}

					if (isFound) {
						System.out.println(
								"Enter the new Product name [e.g:CapGemini, Length should be in between 3 to 25]");
						String newName = sc.next();
						newName = Validations.nameValidation(newName);
						bean.setProductName(newName);

						boolean product2 = service.updateProduct(productId2, bean);
						if (product2) {
							System.out.println("Good, you successfully updated Product Details");
							System.out.println("-------------------------------");
						} else {
							System.err.println("Oops, Something went wrong. Please try again");
							System.out.println("--------------------------------");
						}
					} else {
						System.err.println("No data is present with Id");
					}
				} catch (Exception e1) {
					System.err.println("Input mismatch exception. Please, enter valid Input");
				}

				break;
			case 5:

				try {
					System.out.println("Enter which product id details you want to delete");
					int productId3 = sc.nextInt();
					HashMap<Integer, ProductBean> product2 = service.getAllProducts();

					boolean isFound2 = false;
					for (Entry<Integer, ProductBean> productBean : product2.entrySet()) {

						if (productBean.getKey() == productId3) {
							isFound2 = true;
						}
					}
					if (isFound2) {
						boolean product3 = service.deleteProduct(productId3);
						if (product3) {
							System.out.println("Good, you deleted product details successfully");
							System.out.println("----------------------------");
						} else {
							System.err.println("Oops, Something went wrong. Please try again");
							System.out.println("------------------------------");
						}
					} else {
						System.err.println("No data present with this Id");
					}
				} catch (Exception e) {
					System.err.println("Input mismatch exception. Please enter valid Input");
				}
				break;
			case 6:
				HomePage.managerOptions();
				break;
			case 7:
				System.exit(0);
			}
		}
	}

}
