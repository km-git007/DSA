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
    vector<vector<int>> spiralMatrix(int n, int m, ListNode* head) 
    {
        int left=0,right=m-1;
        int top=0,bottom=n-1;
        vector<vector<int>> ans(n,vector<int>(m,-1));
        while(left<=right && top<=bottom)
        {
            for(int j=left;j<=right;j++)
            {
                if(head!=NULL)
                {
                    ans[top][j]=head->val;
                    head=head->next;
                }
            }
            top++;
            if(top>bottom)
            break;

            for(int i=top;i<=bottom;i++)
            {
                if(head!=NULL)
                {
                    ans[i][right]=head->val;
                    head=head->next;
                }
            }
            right--;
            if(right<left)
            break;
        
            for(int j=right;j>=left;j--)
            {
                if(head!=NULL)
                {
                    ans[bottom][j]=head->val;
                    head=head->next;
                }
            }
            bottom--;
            if(top>bottom)
            break;

            for(int i=bottom;i>=top;i--)
            {
                if(head!=NULL)
                {
                    ans[i][left]=head->val;
                    head=head->next;
                }
            }
            left++;
        }
        return ans;
    }
};