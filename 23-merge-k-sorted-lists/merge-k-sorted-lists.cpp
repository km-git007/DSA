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
    
     ListNode* mergeTwoLists(ListNode* head1,ListNode* head2)
    {
        ListNode* dummy=new ListNode(-1);
        ListNode* tail=dummy;
        while(head1 && head2)
        {
            if(head1->val<=head2->val)
            {
                tail->next=head1;
                head1=head1->next;
            }
            else
            {
                tail->next=head2;
                head2=head2->next;
            }
            tail=tail->next;
        }
        tail->next=(!head1)?head2:head1;

        ListNode* newHead=dummy->next;
        delete dummy;
        return newHead;  
    }

    ListNode* mergeSort(vector<ListNode*>& list,int low,int high)
    {
        if(low==high)
        return list[low];

        int mid=low+(high-low)/2;
        ListNode* left=mergeSort(list,low,mid);
        ListNode* right=mergeSort(list,mid+1,high);
        return mergeTwoLists(left,right);
    }

    ListNode* mergeKLists(vector<ListNode*>& list) 
    {
        if(list.size()==0)
        return NULL;

        return mergeSort(list,0,list.size()-1);
    }
};