

public class Account {
    //private variables
    private String account_number;
    private String email;
    private String password;
    private String name;
    private String phone_number;
    private String date;
    private String address;
    private double balance;
    
    //public functions
    public Account(String account_number_, String email_, String password_, String name_, String phone_number_, String date_, String address_, double balance_)
    {
        account_number = account_number_;
        email = email_;
        password = password_;
        name = name_;
        phone_number = phone_number_;
        date = date_;
        address = address_;
        balance = balance_;
    }
    
    public int withdraw(double amount)
    {
        if (amount > 0)
        {
            if(amount > balance)
            {
                return 1;
            }
            else
            {
                balance = balance - amount;
                return 0;
            }
        }
        else
        {
            return 2;
        }
    }
    
    public int deposit(double amount)
    {
        if (amount > 0)
        {
            balance = balance + amount;
            return 0;
        }
        else
        {
            return 1;
        }
    }
    
    public String getAccountNumber()
    {
        return account_number;
    }
    
    public String getEmail()
    {
        return email;
    }

    public String getPassword(){
        return password;
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getPhoneNumber()
    {
        return phone_number;
    }
    
    public String getDate()
    {
        return date;
    }
    
    public String getAddress()
    {
        return address;
    }
    
    public double getBalance()
    {
        return balance;
    }
    
    
}