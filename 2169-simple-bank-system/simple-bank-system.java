class Bank {

    private int n;
    private long[] balance;
    public Bank(long[] bal) {
        n=bal.length;
        balance=bal;
    }
    
    public boolean transfer(int account1, int account2, long money) {
        if(account1>n || account2>n || balance[account1-1]<money)
        return false;

        withdraw(account1,money);
        deposit(account2,money);
        return true;
    }
    
    public boolean deposit(int account, long money) {
        if(account>n)
        return false;

        balance[account-1]+=money;
        return true;
    }
    
    public boolean withdraw(int account, long money) {
        if(account>n || balance[account-1]<money)
        return false;

        balance[account-1]-=money;
        return true;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */