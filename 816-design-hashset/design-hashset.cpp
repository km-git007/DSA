class MyHashSet {
private:
    int CAP;
    vector<list<int>> buckets;
public:
    MyHashSet(){
        CAP = 10000;
        buckets = vector<list<int>>(CAP, list<int>{});
    }
    
    void add(int key){
        int index = key % CAP;
        auto& list = buckets[index];
        auto itr = find(list.begin(), list.end(), key);

        if(itr == list.end())
        list.push_back(key);
    }
    
    void remove(int key){
        int index = key % CAP;
        auto& list = buckets[index];
        auto itr = find(list.begin(), list.end(), key);

        if(itr != list.end())
        list.erase(itr);
    }
    
    bool contains(int key){
        int index = key % CAP;
        auto& list = buckets[index];
        auto itr = find(list.begin(), list.end(), key);

        return itr != list.end();
    }
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */