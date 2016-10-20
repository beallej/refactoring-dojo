package com.twu.refactoring;

public class LineItem {
	private String description;
	private double price;
	private int quantity;

	public LineItem(String description, double price, int quantity) {
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}
	public String getLine() {
		StringBuilder output = new StringBuilder();
		output.append(this.description+'\t');
		output.append(Double.toString(this.price)+'\t');
		output.append(Integer.toString(this.quantity)+'\t');
		output.append(Double.toString(this.totalAmount())+'\n');
		return output.toString();
	}
	double totalAmount() {
        return price * quantity;
    }
}