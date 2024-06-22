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
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    TreeNode* preOrder(vector<int> &a,int low,int high)
    {
        if(low>high)
        return NULL;

        int mid=low+(high-low)/2;
        TreeNode* node=new TreeNode(a[mid]);

        node->left=preOrder(a,low,mid-1);
        node->right=preOrder(a,mid+1,high);

        return node;
    }

    TreeNode* sortedListToBST(ListNode* head) 
    {
        vector<int> a;
        while(head)
        {
            a.push_back(head->val);
            head=head->next;
        }
        return preOrder(a,0,a.size()-1);
    }
};