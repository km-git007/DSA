class FrequencyTracker {
public:

    unordered_map<int,int> map;
    unordered_map<int,int> freqMap;

    FrequencyTracker() 
    {
        map.clear();
        freqMap.clear();
    }
    
    void add(int number) 
    {
        // if the number is not present in the map
        if(!map.count(number))
        {
            map[number]++;
            freqMap[1]++;
        }
        else
        {
            // remove the old frequency of the number
            int freq=map[number];
            freqMap[freq]--;
            if(freqMap[freq]==0)
            freqMap.erase(freq);

            map[number]++;
            freqMap[map[number]]++;
        }
    }
    
    void deleteOne(int number) 
    {
        // you cant delete a number that doesn't exist.
        if(!map.count(number))
        return;

        int freq=map[number];

        freqMap[freq]--;
        if(freqMap[freq]==0)
        freqMap.erase(freq);

        map[number]--;
        if(map[number]==0)
        map.erase(number);
        else
        freqMap[map[number]]++;
    }
    
    bool hasFrequency(int frequency) 
    {
        return freqMap.count(frequency)>0;
    }
};

/**
 * Your FrequencyTracker object will be instantiated and called as such:
 * FrequencyTracker* obj = new FrequencyTracker();
 * obj->add(number);
 * obj->deleteOne(number);
 * bool param_3 = obj->hasFrequency(frequency);
 */