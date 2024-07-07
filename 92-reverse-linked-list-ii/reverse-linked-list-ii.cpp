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

    ListNode* reverseList(ListNode* head,int count)
    {
        ListNode *curr=head,*prev=NULL;
        while(curr && count)
        {
           ListNode *Next=curr->next;
           curr->next=prev;
           prev=curr;
           curr=Next; 
           count--;
        }

        // making connection with the remaining list in the right side.
        head->next=curr;
        return prev;
    }

    ListNode* reverseBetween(ListNode* head, int left, int right) 
    {
        if(left==right)
        return head;

        ListNode* dummy=new ListNode(0);
        dummy->next=head;
        ListNode *leftEnd=dummy;

        for(int steps=0;steps<left-1;steps++)
        leftEnd=leftEnd->next;

        ListNode* reversedHead=reverseList(leftEnd->next,right-left+1);
        leftEnd->next=reversedHead;
        return dummy->next;  
    }
};