package com.twu.refactoring;

import java.util.List;

public class Order {
    String name;
    String address;
    List<LineItem> lineItems;

    public Order(String name, String address, List<LineItem> lineItems) {
        this.name = name;
        this.address = address;
        this.lineItems = lineItems;
    }

    public String getCustomerName() {
        return name;
    }

    public String getCustomerAddress() {
        return address;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public String printCustomerInformation() {
        StringBuilder output = new StringBuilder();
        output.append(this.name);
        output.append(this.address + "\n");
        return output.toString();
    }
}
