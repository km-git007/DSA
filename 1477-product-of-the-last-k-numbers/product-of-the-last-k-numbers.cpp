class ProductOfNumbers {
public:
    int lastZeroIndex;
    vector<int> prod;
    ProductOfNumbers() 
    {
        lastZeroIndex = -1;
    }
    
    void add(int num) 
    {
        if(prod.empty() || prod.back() == 0 || num == 0)
        {
            prod.push_back(num);
            // if the number is zero than update the zero index
            if(num == 0)
            lastZeroIndex = prod.size() - 1;

            return;
        }

        // multiply the num with the last entry
        prod.push_back(num * prod.back());
    }
    
    int getProduct(int k) 
    {
        int index = prod.size() - 1;
        // if a zero is present in the k elements
        if(lastZeroIndex > index - k)
        return 0;

        // the zero is present just before last k elements
        if(lastZeroIndex == index - k)
        return prod.back();

        return prod.back() / prod[index - k];
    }
};

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers* obj = new ProductOfNumbers();
 * obj->add(num);
 * int param_2 = obj->getProduct(k);
 */