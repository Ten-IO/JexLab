/**
 *  a program to create a bank management system and manage accounts, and 
 * transaction. You must have two needed classes “Account” and “BankManagment”
 * ▪ Withdraw/Deposit (Use Exceptions to prevent wrong input ):
 * ▪ Minimum and maximum balance limits (ensure that the account balance 
 * does not fall below or exceed a certain)
 * ▪ The input field for the account balance should accept only numeric values 
 * Allow only two decimal points and prevent users from inputting values 
 * such as $100.1234
 * ▪ Deposit range (  0 < amount <= 1000$  )
 * ▪ Transferring money must be through ACCOUNT_ID 
 * *** All attributes of class Account must be in private access
 * *** Implement  Setter and Getter concepts
 */

package week08;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Scanner;

public class e02_bank {
    static Scanner scan = new Scanner(System.in);

    class Account {
        private String ACCOUNT_ID, HOLDER;
        private float BALANCE;

        public String getACCOUNT_ID() {
            return ACCOUNT_ID;
        }

        public void setACCOUNT_ID(String account_id) {
            ACCOUNT_ID = account_id;
        }

        public String getHOLDER() {
            return HOLDER;
        }

        public void setHOLDER(String holder) {
            HOLDER = holder;
        }

        public float getBALANCE() {
            return BALANCE;
        }

        public void setBALANCE(float balance) {
            BALANCE = balance;
        }
    }

    class BankManagment {
        float MIN = 0f, MAX = 1000;

        void withdraw(Account acc, float amount) throws IllegalArgumentException {
            if (amount > MIN && amount < MAX) {
                float b = acc.getBALANCE();
                if (amount < b)
                    b -= amount;
                acc.setBALANCE(b);
                System.out.println("Withdrawed: " + amount);
            }
        }

        void deposit(Account acc, float amount) throws IllegalArgumentException {
            if (amount > MIN && amount < MAX) {
                float b = acc.getBALANCE();
                b += amount;
                acc.setBALANCE(b);
                System.out.println("Deposited: " + amount);
            }
        }

        void tranfer(Account own, Account oth, float amount) throws IllegalArgumentException {
            withdraw(own, amount);
            deposit(oth, amount);
        }

        void show(Account acc) {
            System.out.println("ACC_ID: " + acc.getACCOUNT_ID());
            System.out.println("ACC_HOLDER: " + acc.getHOLDER());
            System.out.println("ACC_BALANCE: " + String.format("%.2f", acc.getBALANCE()) + '$');
        }
    }

    static int input(String prompt) {
        System.out.print(prompt);
        return scan.nextInt();
    }

    static float inputD(String prompt) {
        System.out.print(prompt);
        float in = scan.nextFloat();
        BigDecimal bd = new BigDecimal(Float.toString(in))
                .setScale(2, RoundingMode.DOWN);
        float res = bd.floatValue();
        return res;
    }

    static String inputStr(String prompt) {
        System.out.print(prompt);
        String line = scan.nextLine();
        while (line.isEmpty())
            line = scan.nextLine();
        return line;
    }

    public static void main(String[] args) {
        ArrayList<Account> db = new ArrayList<Account>();
        BankManagment sys = new e02_bank().new BankManagment();

        int choice;
        do {
            System.out.println(
                    "\n::: The Bank :::\n1. Account List\n2. Create an account\n3. Deposit into an account\n4. Withdraw from an account\n5. Transfer to another account\n6. Quit");
            choice = input("Choose an opt: ");
            switch (choice) {
                case 1:
                    if (db.isEmpty())
                        System.out.println("No account in the list yet!");
                    int i = 0;
                    for (Account acc : db) {
                        System.out.println("\nNo #" + ++i);
                        sys.show(acc);
                    }
                    break;

                case 2: {
                    Account acc = new e02_bank().new Account();
                    acc.setACCOUNT_ID(inputStr("Given id: "));
                    acc.setHOLDER(inputStr("Holder: "));
                    db.add(acc);
                }
                    break;
                case 3: {
                    String holder = inputStr("Holder: ");
                    for (Account acc : db)
                        if (acc.getHOLDER().equals(holder))
                            sys.deposit(acc, inputD("Amount: "));
                }
                    break;
                case 4: {
                    String holder = inputStr("Holder: ");
                    for (Account acc : db)
                        if (acc.getHOLDER().equals(holder))
                            sys.withdraw(acc, inputD("Amount: "));
                }
                    break;
                case 5: {
                    String own = inputStr("Owner id: ");
                    String oth = inputStr("Tranfer id: ");
                    for (Account acc : db)
                        if (acc.getACCOUNT_ID().equals(own))
                            for (Account o_acc : db)
                                if (o_acc.getACCOUNT_ID().equals(oth))
                                    sys.tranfer(acc, o_acc, inputD("Amount"));
                }
                    break;
                case 6:
                    System.out.println("By3!");
                    return;
                default:
                    break;
            }
        } while (choice != 8);
        scan.close();
    }
}