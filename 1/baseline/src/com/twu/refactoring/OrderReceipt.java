package com.twu.refactoring;

public class OrderReceipt {
	private static final double TAX = 0.10;
	private Order order;
	private double totalSalesTax;
	private double totalAmount;

	public OrderReceipt(Order order) {
        this.order = order;
	}

	public String printReceipt() {
		StringBuilder output = new StringBuilder();
		totalSalesTax = 0d;
		totalAmount = 0d;
		output.append(printReceiptHeader());
		output.append(printsLineItems());
		output.append(printSalesTax(totalSalesTax));
		output.append(printTotalAmount(totalAmount));
		return output.toString();
	}

	private String printsLineItems() {
		StringBuilder output = new StringBuilder();
		for (LineItem lineItem : order.getLineItems()) {
			output.append(lineItem.getLine());
            double salesTax = calculateSalesTax(lineItem);
            totalSalesTax += salesTax;
            totalAmount += getTotalForLine(lineItem, salesTax);
		}
		return output.toString();
	}

	private double getTotalForLine(LineItem lineItem, double salesTax) {
		return lineItem.totalAmount() + salesTax;
	}

	private String printReceiptHeader() {
		StringBuilder output = new StringBuilder();
		output.append("======Printing Orders======\n");
		output.append(order.printCustomerInformation());
		return output.toString();
	}

	private String printSalesTax(double totalSalesTax) {
		StringBuilder output = new StringBuilder();
		output.append("Sales Tax").append('\t').append(totalSalesTax);
		return output.toString();
	}

	private String printTotalAmount(double totalAmount){
		StringBuilder output = new StringBuilder();
		output.append("Total Amount").append('\t').append(totalAmount);
		return output.toString();

	}
	private double calculateSalesTax(LineItem lineItem) {
		return lineItem.totalAmount() * TAX;
	}



}