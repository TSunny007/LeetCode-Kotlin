/**
 * Definition for a binary tree node.
 * */

class TreeNode(var `val`: Int = 0) {
     var left: TreeNode? = null
     var right: TreeNode? = null
}

class ConvertBSTToGreaterTree {
    var prev = 0

    fun convertBST(root: TreeNode?): TreeNode? {
        root?.let {
            convertToGST(it)
        }
        return root
    }

    private fun convertToGST(node: TreeNode) {

        node.right?.let {
            convertToGST(it)
        }

        var value = node.`val`
        node.`val` += prev
        prev += value

        node.left?.let {
            convertToGST(it)
        }
    }
}

fun main(args: Array<String>){
    val treeNode = TreeNode(5)
    treeNode.left = TreeNode(2)
    treeNode.right = TreeNode(13)

    var tree = ConvertBSTToGreaterTree()
    var greaterTree = tree.convertBST(treeNode)

    println(greaterTree!!.left!!.`val`)
}