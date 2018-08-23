/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int = 0) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun levelOrderBottom(root: TreeNode?): List<List<Int>> {

        if (root == null) return emptyList()
        var ans = mutableListOf<MutableList<Int>>()
        t(root, 0, ans)
        return ans.reversed()
    }

    fun t(node: TreeNode , level: Int, memo: MutableList<MutableList<Int>>) {
        node.left?.let {
            t(node.left!!, level+1, memo)
        }
        node.right?.let {
            t(node.right!!, level+1, memo)
        }
        while (memo.size < level+1) {
            memo.add(mutableListOf())
        }
        memo[level].add(node.`val`)
    }
}