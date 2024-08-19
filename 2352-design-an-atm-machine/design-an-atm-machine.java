class ATM {

    int[] banknotes;
    int[] money;
    boolean canWithdraw;
    public ATM()
    {
        banknotes=new int[5];
        money=new int[]{20,50,100,200,500};
    }
    
    private int[] getDenomination(int amount,int[] banknotes)
    {
        int[] denomination=new int[5];
        int index=4;
        for(int i=4;i>=0;i--)
        {
            if(banknotes[i]==0)
            continue;

            // available count of notes in the bank
            int notesAvailable=banknotes[i];

            // count of notes of particular denomination required to process the withdrawl
            int notesRequired=amount/money[i];

            // for example if amount=1700$ and 500$ notes available in bank is '2' then
            // notesAvailable=2 and notesRequired=1700/500=3 hence actual count of the notes used to
            // process the withdrawl will be minimum of the two.
            int notesUsed=Math.min(notesRequired,notesAvailable);
            amount-=money[i]*notesUsed;

            // updating the denomination array with the count of the notesUsed.
            denomination[i]=notesUsed;

            // break when amount becomes <= 0.
            if(amount<=0)
            break;
        }

        // if amount becomes exactly zero then the withdrawl request can be processed sucessfully
        // hence update the canWithdraw flag to true.
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