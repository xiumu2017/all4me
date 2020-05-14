package com.paradise.think.enum19.chain;

import com.paradise.think.enum19.Enums;

import java.util.Iterator;

/**
 * Chain of Responsibility
 *
 * @author Paradise
 */
public class Mail {
    enum GeneralDelivery {YES, NO1, NO2, NO3, NO4, NO5}

    enum Scannability {UNSCANNABLE, YES1, YES2, YES3, YES4}

    enum Readability {ILLEGIBLE, YES1, YES2, YES3, YES4}

    enum Address {INCORRECT, OK1, OK2, OK3, OK4, OK5, OK6}

    enum ReturnAddress {MISSING, OK1, OK2, OK3, OK4, OK5}

    GeneralDelivery generalDelivery;
    Scannability scannability;
    Readability readability;
    Address address;
    ReturnAddress returnAddress;
    private static long counter = 0;
    private long id = counter++;

    @Override
    public String toString() {
        return "Mail{" + id + "}";
    }

    String details() {
        return "Mail{" +
                "GeneralDelivery=" + generalDelivery +
                ", Scannability=" + scannability +
                ", Readability=" + readability +
                ", Address=" + address +
                ", ReturnAddress=" + returnAddress +
                ", id=" + id +
                '}';
    }

    private static Mail randomMail() {
        Mail mail = new Mail();
        mail.generalDelivery = Enums.random(GeneralDelivery.class);
        mail.scannability = Enums.random(Scannability.class);
        mail.readability = Enums.random(Readability.class);
        mail.address = Enums.random(Address.class);
        mail.returnAddress = Enums.random(ReturnAddress.values());
        return mail;
    }

    public static Iterable<Mail> generator(final int count) {
        return new Iterable<Mail>() {
            int n = count;

            @Override
            public Iterator<Mail> iterator() {
                return new Iterator<Mail>() {
                    @Override
                    public boolean hasNext() {
                        return n-- > 0;
                    }

                    @Override
                    public Mail next() {
                        return randomMail();
                    }
                };
            }
        };

    }
}
