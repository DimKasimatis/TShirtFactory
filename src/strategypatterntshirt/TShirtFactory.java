/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategypatterntshirt;

import interfaces.IPayment;
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
        TShirt tshirt1 = new TShirt("MARCO POLO", Color.RED, Size.XS, Fabric.WOOL);
        TShirt tshirt2 = new TShirt("WOOF LAREN", Color.VIOLET, Size.XXXL, Fabric.CASHMERE);
        TShirt tshirt3 = new TShirt ("WOOFY LOREN", Color.VIOLET, Size.XS, Fabric.POLYESTER);
        TShirtFactory myMainClass = new TShirtFactory();
        
        // CreditDebitCard
        IPayment payment = new CreditDebitCard();
        myMainClass.makeAnOrder(tshirt1, payment);

        // MoneyBankTransfer
        payment = new MoneyBankTransfer();
        myMainClass.makeAnOrder(tshirt2, payment);

        // Cash
        payment = new Cash();
        myMainClass.makeAnOrder(tshirt3, payment);
    }

    public void makeAnOrder(TShirt tshirt, IPayment payment) {
        System.out.println(tshirt);
//        System.out.println(payment.getClass().getName());
        if (payment.getClass().getName().equals("strategypatterntshirt.CreditDebitCard")) {
            payment.pay(tshirt.getFabric().getUnitPrice() + tshirt.getColor().getUnitPrice()
                    + tshirt.getSize().getUnitPrice() + 5.0f);
        }
//        System.out.println("");
        if (payment.getClass().getName().equals("strategypatterntshirt.MoneyBankTransfer")) {
            payment.pay(tshirt.getFabric().getUnitPrice() + tshirt.getColor().getUnitPrice()
                    + tshirt.getSize().getUnitPrice() + 3.0f);
        }

        if (payment.getClass().getName().equals("strategypatterntshirt.Cash")) {
            payment.pay(tshirt.getFabric().getUnitPrice() + tshirt.getColor().getUnitPrice()
                    + tshirt.getSize().getUnitPrice());
        }

    }

}
