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

		printReceiptHeader(output);

		printsLineItems(output);

		printSalesTax(output, totalSalesTax);

		printTotalAmount(output, totalAmount);
		return output.toString();
	}

	private void printsLineItems(StringBuilder output) {
		for (LineItem lineItem : order.getLineItems()) {
			createOutputLine(output, lineItem);

            double salesTax = calculateSalesTax(lineItem);
            totalSalesTax += salesTax;

            totalAmount += lineItem.totalAmount() + salesTax;
		}
	}

	private void printReceiptHeader(StringBuilder output) {
		output.append("======Printing Orders======\n");

		output.append(order.getCustomerName());
		output.append(order.getCustomerAddress());
	}

	private void printSalesTax(StringBuilder output, double totalSalesTax) {
		output.append("Sales Tax").append('\t').append(totalSalesTax);
	}

	private void printTotalAmount(StringBuilder output, double totalAmount){
		output.append("Total Amount").append('\t').append(totalAmount);

	}
	private double calculateSalesTax(LineItem lineItem) {
		return lineItem.totalAmount() * TAX;
	}

	private void createOutputLine(StringBuilder output, LineItem lineItem) {
		output.append(lineItem.getDescription()+'\t');
		output.append(lineItem.getPrice()+'\t');
		output.append(lineItem.getQuantity()+'\t');
		output.append(lineItem.totalAmount()+'\n');
	}


}