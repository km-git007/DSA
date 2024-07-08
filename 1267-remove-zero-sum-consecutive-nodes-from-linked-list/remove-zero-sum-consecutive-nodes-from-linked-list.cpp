/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullnode) {}
 *     ListNode(int x) : val(x), next(nullnode) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* removeZeroSumSublists(ListNode* head) 
    {
        unordered_map<int,ListNode*> map;
        ListNode* dummy=new ListNode(-1);
        dummy->next=head;
        map[0]=dummy;

        int pSum=0;
        ListNode* curr=head;
        while(curr)
        {
            pSum+=curr->val;
            if(map.count(pSum)>0)
            {
                ListNode* node=map[pSum]->next;
                int tempSum=pSum;
                // erasing elements in the map present between zero sum nodes.
                // dry run this example to understand [1,3,2,-3,-2,5,5,-5,1]
                while(node!=curr)         
                {
                    tempSum+=node->val;
                    map.erase(tempSum);
                    node=node->next;
                }
                map[pSum]->next=curr->next;
            }
            else
            map[pSum]=curr;
            
            curr=curr->next;
        }
        return dummy->next;
    }
};