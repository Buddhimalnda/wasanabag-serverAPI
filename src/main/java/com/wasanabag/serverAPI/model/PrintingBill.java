package com.wasanabag.serverAPI.model;

import com.wasanabag.serverAPI.types.Company;
import com.wasanabag.serverAPI.types.Orderlist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrintingBill {
    private List<Order> order;
    private String status;


    public Price makeBill(double paid, double discount){
        double total = 0;
        for(Order order : this.order){
            total += order.getTotal();
        }
        return new Price(total, paid, discount, 18);
    }

    public String printBill(double paid, double discount) {
        Date timestamp = new Date();
        Price price = this.makeBill(paid, discount);
        StringBuilder bill = new StringBuilder();
        bill.append(Company.name + "\n");
        bill.append(Company.address + "\n");
        bill.append("Tel:" + Company.phone + "\n");
        bill.append("Email:" + Company.email + "\n");
        bill.append("--------------------------------\n");
        bill.append("Date:").append(timestamp.toString()).append("\n");
        bill.append("--------------------------------\n");
        bill.append("#\tItem\tQty\tPrice\n");
        int i = 1;
        for (Order order : this.order) {
            for (Orderlist<Item, Integer> orderlist : order.getList()) {
                bill.append("#").append(i++).append("\t").append(orderlist.getX().getName().split(" ")[0]).append("\t").append("\t").append(orderlist.getY()).append("\t").append(orderlist.getX().getPrice()*orderlist.getY()).append("\n");
            }
        }
        bill.append("--------------------------------\n");
        bill.append("Total:\t\t\t\t").append(price.getTotal()).append("\n");
        bill.append("Discount:\t\t\t").append(price.getDiscount()).append("\n");
        bill.append("VAT:\t\t\t\t").append(price.getVat()).append("\n");
        bill.append("Sub Total:\t\t\t").append(price.getSubTotal()).append("\n");
        bill.append("Paid:\t\t\t\t").append(price.getPaid()).append("\n");
        bill.append("Due:\t\t\t\t").append(price.getDue()).append("\n");
        bill.append("--------------------------------\n");
        bill.append("Thank you for shopping with us\n");
        bill.append("--------------------------------\n");
        System.out.println(bill.toString());
        return bill.toString();
    }
}

@Data
@AllArgsConstructor
class Price{
    private double total;
    private double paid;
    private double discount;
    private double vat;

    public double getVat(){
        return (this.total * this.vat) / 100;
    }
    public double getSubTotal(){
        return this.total + this.getVat() - this.discount;
    }
    public double getDue(){
        return this.getSubTotal() - this.paid;
    }
}
