/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    
    ListNode* mergeKLists(vector<ListNode*>& lists) 
    {
        if(lists.size()==0)
        return NULL;

        priority_queue<pair<int,ListNode*>,vector<pair<int,ListNode*>>,greater<pair<int,ListNode*>>> minHeap;
        
        for(ListNode* list : lists) 
        if(list)
        minHeap.push({list->val,list});

        ListNode* dummy=new ListNode(-1);
        ListNode* tail=dummy;
        while(!minHeap.empty())
        {
            ListNode* node=minHeap.top().second;
            minHeap.pop();

            tail->next=node;
            tail=tail->next;
            node=node->next;

            if(node)
            minHeap.push({node->val,node});
        }
        return dummy->next;
    }
};