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
            Node* nextNode=curr->next;
            if(curr->child)
            {
                Node* childNode=curr->child;
                curr->child=NULL;

                Node* childTail=solve(childNode);

                childTail->next=nextNode;
                if(nextNode)
                nextNode->prev=childTail;

                curr->next=childNode;
                childNode->prev=curr;

                tail=childTail;
            }
            
            curr=nextNode;
            if(nextNode)
            tail=curr;
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