package nl.msemnani.other

import scala.annotation.tailrec

case class BTree[A](var left: Option[BTree[A]], var right: Option[BTree[A]], key: A)

class BinarySearchTree {

  private var root: Option[BTree[Int]] = None

  def add (btree: Option[BTree[Int]] ,key: Int): Unit = {
    @tailrec
    def findParent(current: Option[BTree[Int]], parent: Option[BTree[Int]]): Option[BTree[Int]] = {
      current match {
        case None => parent
        case Some(node) if (key < node.key) => findParent(node.left, current)
        case Some(node) if (key > node.key) => findParent(node.right, current)
      }
    }

    val parent = findParent(btree, None)
    parent match {
      case None => root = Some(BTree(None, None, key))
      case Some(node) if (key < node.key) => node.left = Some(BTree(None, None, key))
      case Some(node) if (key > node.key) => node.right = Some(BTree(None, None, key))
      case Some(node) if (key == node.key) =>
    }
  }

  def + (key: Int): Unit = add(root, key)

  def recursivePrint(node: Option[BTree[Int]]): Unit = {
    node match {
      case None =>
      case Some(n) =>
        recursivePrint(n.left)
        println(n.key)
        recursivePrint(n.right)
    }
  }

  def iterativePrint(): Unit = {

  }

  def print(): Unit = recursivePrint(root)
}

object Runner extends App{
  val tree = new BinarySearchTree()
  tree + 7
  tree + 2
  tree + 1
  tree + 3
  tree + 9
  tree + 15
  tree + 13
  tree + 4

  tree.print()
}
