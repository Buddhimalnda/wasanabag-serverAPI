package com.wasanabag.serverAPI.servicer;

import com.wasanabag.serverAPI.model.Order;
import com.wasanabag.serverAPI.model.PrintingBill;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@AllArgsConstructor
@Service
public class PrintBillService {

    public String printBill(List<Order> orders,double paid, double discount) {
        PrintingBill printingBill = new PrintingBill(orders, "success");
        return printingBill.printBill(paid, discount);
    }

}
