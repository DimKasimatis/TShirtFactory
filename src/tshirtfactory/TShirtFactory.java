/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tshirtfactory;

import interfaces.IPayment;
import java.util.ArrayList;
import java.util.List;
import models.Color;
import models.Fabric;
import models.Size;
import models.TShirt;

/**
 *
 * @author Dim.Kasimatis
 */
public class TShirtFactory {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        TShirtFactory myMainClass = new TShirtFactory();
        List<TShirt> tshirts = myMainClass.makeAllCombinations();

        myMainClass.makeAnOrder(tshirts.get(20), new CreditDebitCard());
        myMainClass.makeAnOrder(tshirts.get(20), new Cash());
        myMainClass.makeAnOrder(tshirts.get(20), new MoneyBankTransfer());
        myMainClass.makeAnOrder(tshirts.get(40), new MoneyBankTransfer());

    }

    public void makeAnOrder(TShirt tshirt, IPayment payment) {
        System.out.println(tshirt);
        if (payment.getClass().getName().equals("tshirtfactory.CreditDebitCard")) {
            payment.pay(tshirt.getFabric().getUnitPrice() + tshirt.getColor().getUnitPrice()
                    + tshirt.getSize().getUnitPrice());
        }
        if (payment.getClass().getName().equals("tshirtfactory.MoneyBankTransfer")) {
            payment.pay(tshirt.getFabric().getUnitPrice() + tshirt.getColor().getUnitPrice()
                    + tshirt.getSize().getUnitPrice());
        }
        if (payment.getClass().getName().equals("tshirtfactory.Cash")) {
            payment.pay(tshirt.getFabric().getUnitPrice() + tshirt.getColor().getUnitPrice()
                    + tshirt.getSize().getUnitPrice());
        }

    }


    public static List<TShirt> makeAllCombinations() {
        RandomName rnd = new RandomName();
        List<TShirt> tshirts = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            Color color = Color.values()[i];
            for (int j = 0; j < 7; j++) {
                Size size = Size.values()[j];
                for (int k = 0; k < 7; k++) {
                    Fabric fabric = Fabric.values()[k];
                    tshirts.add(new TShirt(rnd.randomName(), color, size, fabric));
                }
            }
        }
        return (tshirts);
    }

}
