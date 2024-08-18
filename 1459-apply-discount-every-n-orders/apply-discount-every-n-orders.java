class Cashier {

    private int customerNumber;
    private int luckyCustomer;
    private double discount;
    private int[] prices;
    public Cashier(int n, int discount, int[] product, int[] prices)
    {
        luckyCustomer=n;
        customerNumber=0;
        this.prices=new int[201];
        this.discount=((double)discount)/100;
        for(int i=0;i<prices.length;i++){
            this.prices[product[i]]=prices[i];
        }
    }

    public double getBill(int[] product, int[] amount)
    {
        customerNumber++;
        double bill=0;
        for(int i=0;i<amount.length;i++)
        {
            int id=product[i];
            bill+=amount[i]*prices[id];
        }
        
        if(customerNumber%luckyCustomer==0)
            return (1-discount)*bill;
        
        return bill;
    }
}

/**
 * Your Cashier object will be instantiated and called as such:
 * Cashier obj = new Cashier(n, discount, products, prices);
 * double param_1 = obj.getBill(product,amount);
 */