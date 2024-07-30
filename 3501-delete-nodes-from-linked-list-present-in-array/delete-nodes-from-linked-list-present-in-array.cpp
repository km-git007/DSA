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
    ListNode* modifiedList(vector<int>& nums, ListNode* head) 
    {
        unordered_set<int> set(nums.begin(),nums.end());
        ListNode* dummy=new ListNode(-1);
        ListNode *prev=dummy,*curr=head;
        dummy->next=head;
        while(curr)
        {
            if(set.count(curr->val))
            {
                prev->next=curr->next;
                delete curr;
                curr=prev->next;
            }
            else
            {
                prev=curr;
                curr=curr->next;
            }
        }
        return dummy->next;
    }
};