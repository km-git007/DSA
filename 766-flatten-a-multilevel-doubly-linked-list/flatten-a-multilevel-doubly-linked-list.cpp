/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* prev;
    Node* next;
    Node* child;
};
*/

class Solution {
public:
    Node* solve(Node* head)
    {
        Node* curr=head;
        Node* tail=head;
        while(curr)
        {
            if(curr->child)
            {
                Node* childNode=curr->child;
                curr->child=NULL;

                Node* childTail=solve(childNode);

                childTail->next=curr->next;
                if(curr->next)
                curr->next->prev=childTail;

                curr->next=childNode;
                childNode->prev=curr;

                tail=childTail;
            }

            tail=curr;
            curr=curr->next;
        }
        return tail;
    }

    Node* flatten(Node* head) 
    {
        if(!head)
        return head;

        solve(head);
        return head;
    }

};