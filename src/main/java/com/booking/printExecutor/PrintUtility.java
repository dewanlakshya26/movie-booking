package com.booking.printExecutor;

import com.booking.model.CustomerBillModel;
import com.booking.model.TotalBillModel;

public class PrintUtility {

    public void printTotalRevenue(TotalBillModel totalBillModel) {
        System.out.println("Total Sales:");
        System.out.println("Revenue: Rs. " + totalBillModel.getTotalRevenue());
        System.out.println("Service Tax: Rs. " + totalBillModel.getServiceTax());
        System.out.println("Swachh Bharat Cess: Rs. " + totalBillModel.getSwatchBharatTax());
        System.out.println("Krishi Kalyan Cess: Rs. " + totalBillModel.getKrishiKalyanTax());

    }

    public void printCustomerBill(CustomerBillModel customerBillModel) {
        System.out.println("Subtotal: Rs. " + customerBillModel.getPrice());
        System.out.println("Service Tax @14%: Rs. " + customerBillModel.getServiceTax());
        System.out.println("Swachh Bharat Cess @0.5%: Rs. " + customerBillModel.getSwatchBharatTax());
        System.out.println("Krishi Kalyan Cess @0.5%: Rs. " + customerBillModel.getKrishiKalyanTax());
        System.out.println("Total: Rs." + customerBillModel.getTotalBill());

    }
}
