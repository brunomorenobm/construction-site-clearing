package com.oracle.construction.aconex.planing.view.console.sitemap;

import com.oracle.construction.aconex.planing.model.billing.BillItem;
import com.oracle.construction.aconex.planing.model.billing.Item;
import com.oracle.construction.aconex.planing.model.map.SiteMap;

import java.io.PrintStream;
import java.util.List;

public class SiteMapConsolePrinterBill implements SiteMapConsolePrinter {

    @Override
    public void print(SiteMap siteMap, PrintStream out) {
        // Head
        out.printf("\n%1$-45s %2$-12s %3$-4s\n", "Item", "Quantity", "Cost");
        out.println("----");

        // Commands
        for (Item enumItem: Item.values()){
            Integer quantity = 0;
            Double creditUsage = 0d;

            List<BillItem> billItems = siteMap.getBill().getBillItemGroupByType().get(enumItem);

            if (billItems != null){
                quantity =  billItems.stream().mapToInt(item -> item.getQuantity()).sum();
                creditUsage =  billItems.stream().mapToDouble(item -> item.getItem().getCredit()).sum();
            }

            out.printf("%1$-45s %2$8d %3$8.0f \n", enumItem.getDescription(), quantity, creditUsage);
        }

        // Footer - Total
        out.println("----");
        out.printf("%1$-61s %2$-8.0f \n", "Total", siteMap.getBill().getTotal());

    }
}
