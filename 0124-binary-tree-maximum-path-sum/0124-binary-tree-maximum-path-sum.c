/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
int Max (int a, int b) {
    return a < b ? b : a;
}

int helperFunc (struct TreeNode* root, int* max) {
    if(root == NULL) return 0;
    int a = helperFunc(root->left, max);
    if(a < 0) a = 0;
    int b = helperFunc(root->right, max);
    if(b < 0) b = 0;
    *max = *max < (a + b + root->val) ? (a + b + root->val) : *max;
    return root->val + (a < b ? b : a);
}
int maxPathSum(struct TreeNode* root) {
    int max = -1001;
    int res = helperFunc(root, &max);
    return res < max ? max : res;
}