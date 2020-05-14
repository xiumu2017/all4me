package com.paradise.think.enum19.chain;

/**
 * @author Paradise
 */
public class PostOffice {
    enum MailHandler {
        /**
         * GENERAL_DELIVERY
         */
        GENERAL_DELIVERY {
            @Override
            boolean handle(Mail mail) {
                if (mail.generalDelivery == Mail.GeneralDelivery.YES) {
                    System.out.println("Using general delivery for " + mail);
                    return true;
                }
                return false;
            }
        },

        MACHINE_SCAN {
            @Override
            boolean handle(Mail mail) {
                if (mail.scannability == Mail.Scannability.UNSCANNABLE) {
                    return false;
                }
                if (mail.address == Mail.Address.INCORRECT) {
                    return false;
                }
                System.out.println("Delivering " + mail + " automatically");
                return true;
            }
        },
        VISUAL_INSPECTION {
            @Override
            boolean handle(Mail mail) {
                if (mail.readability == Mail.Readability.ILLEGIBLE) {
                    return false;
                }
                if (mail.address == Mail.Address.INCORRECT) {
                    return false;
                }
                System.out.println("Delivering " + mail + " normally");
                return true;
            }
        },
        RETURN_TO_SENDER {
            @Override
            boolean handle(Mail mail) {
                if (mail.returnAddress == Mail.ReturnAddress.MISSING) {
                    return false;
                }
                System.out.println("Returning " + mail + " to sender");
                return true;
            }
        };

        abstract boolean handle(Mail mail);
    }

    private static void handle(Mail mail) {
        for (MailHandler handler : MailHandler.values()) {
            if (handler.handle(mail)) {
                return;
            }
        }
        System.out.println(mail + " is a dead letter");
    }

    public static void main(String[] args) {
        for (Mail mail : Mail.generator(10)) {
            System.out.println(mail.details());
            handle(mail);
            System.out.println("-----------------------------------------");
        }
    }
}
