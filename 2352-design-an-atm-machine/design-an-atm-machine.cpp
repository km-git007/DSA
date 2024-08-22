
class ATM {
public:

    vector<int> banknotes;
    vector<int> money;
    bool canWithdraw;

    ATM() 
    {
        banknotes = vector<int>(5, 0);
        money = {20, 50, 100, 200, 500};
    }
    
    vector<int> getDenomination(int amount, vector<int>& banknotes) 
    {
        vector<int> denomination(5, 0);
        int index=4;
        for (int i=4;i>=0;i--) 
        {
            if(banknotes[i]==0)
                continue;

            // available count of notes in the bank
            int notesAvailable = banknotes[i];

            // count of notes of particular denomination required to process the withdrawal
            int notesRequired = amount / money[i];

            // for example if amount=1700$ and 500$ notes available in bank is '2' then
            // notesAvailable=2 and notesRequired=1700/500=3 hence actual count of the notes used to
            // process the withdrawal will be minimum of the two.
            int notesUsed = min(notesRequired, notesAvailable);
            amount -= money[i] * notesUsed;

            // updating the denomination array with the count of the notesUsed.
            denomination[i] = notesUsed;

            // break when amount becomes equal 0.
            if (amount == 0)
                break;
        }

        // if amount becomes exactly zero then the withdrawal request can be processed successfully
        // hence update the canWithdraw flag to true.
        if(amount==0)
        canWithdraw=true;

        return denomination;
    }

    void deposit(vector<int> banknotesCount) 
    {
        // simply deposit the notes in the bank.
        for (int i=4;i>=0;i--) 
        banknotes[i]+=banknotesCount[i];
    }

    vector<int> withdraw(int amount) 
    {
        // set canWithdraw to false before each withdrawal request
        canWithdraw=false;

        // getting the denominations for the given amount
        vector<int> denomination=getDenomination(amount, banknotes);

        // if canWithdraw remains false means the withdrawal can't be processed
        if(!canWithdraw)
        return {-1};

        // updating the notes in the bank
        for (int i=4;i>=0;i--) 
        banknotes[i]-=denomination[i];

        return denomination;
    }
};


/**
 * Your ATM object will be instantiated and called as such:
 * ATM* obj = new ATM();
 * obj->deposit(banknotesCount);
 * vector<int> param_2 = obj->withdraw(amount);
 */