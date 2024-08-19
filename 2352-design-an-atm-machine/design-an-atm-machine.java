class ATM {

    int[] banknotes;
    int[] money;
    boolean canWithdraw;
    
    public ATM()
    {
        banknotes=new int[5];
        money=new int[]{20,50,100,200,500};
    }
    
    private int[] getDenomination(int originalAmount,int[] banknotes)
    {
        int[] denomination=new int[5];
        int amount=originalAmount;
        int index=4;
        for(int i=4;i>=0;i--)
        {
            if(banknotes[i]==0)
            continue;

            int notes=amount/money[i];
            notes=Math.min(notes,banknotes[i]);
            amount-=money[i]*notes;
            denomination[i]=notes;

            if(amount<=0)
            break;
        }
        if(amount==0)
        canWithdraw=true;
        return denomination;
    }

    public void deposit(int[] banknotesCount)
    {
        // simply deposit the notes in the bank.
        for(int i=4;i>=0;i--)
        banknotes[i]+=banknotesCount[i];
    }

    public int[] withdraw(int amount) 
    {
        // set canWithdraw to false before each withdrawl request
        canWithdraw=false;

        // getting the denominations for the given amount
        int[] denomination=getDenomination(amount,banknotes);

        // if canWithdraw remains false means the withdrawl can't be processed
        if(!canWithdraw)
        return new int[]{-1};

        // updating the notes in the bank
        for(int i=0;i<5;i++)
        banknotes[i]-=denomination[i];
        return denomination;
    }
}
/**
 * Your ATM object will be instantiated and called as such:
 * ATM obj = new ATM();
 * obj.deposit(banknotesCount);
 * int[] param_2 = obj.withdraw(amount);
 */