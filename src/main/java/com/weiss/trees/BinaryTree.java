package com.weiss.trees;

import java.util.Objects;

/**
 * @author Nabeel Ali Memon
 */
public class BinaryTree<AnyType extends Comparable<? super AnyType>> {
  BinaryNode<AnyType> root;
  int size;

  public boolean contains(AnyType element) {
    return contains(root, element);
  }

  boolean contains(BinaryNode<AnyType> node, AnyType element) {
    if (node == null) {
      return false;
    }
    int comparison = element.compareTo(node.getElement());
    if (comparison < 0) {
      contains(node.getLeft(), element);
    }
    if (comparison > 0) {
      contains(node.getRight(), element);
    }
    return true;
  }

  public AnyType findMin() {
    Objects.requireNonNull(root);
    return findMin(root);
    /*BinaryNode<AnyType> left = root.getLeft();
    if (left != null) {
      while (left.getLeft() != null) {
        left = left.getLeft();
      }
      return left.element;
    }
    return root.element;*/
  }

  AnyType findMin(BinaryNode<AnyType> node) {
    if (node.getLeft() == null) {
      return node.getElement();
    }
    return findMin(node.getLeft());
  }

  public AnyType findMax() {
    Objects.requireNonNull(root);
    return findMax(root);
    /*BinaryNode<AnyType> right = root.getRight();
    if (right != null) {
      while (right.getRight() != null) {
        right = right.getRight();
      }
      return right.element;
    }
    return root.element;*/
  }

  AnyType findMax(BinaryNode<AnyType> node) {
    if (node.getRight() == null) {
      return node.getElement();
    }
    return findMax(node.getRight());
  }

  public void insert(AnyType element) {
    insert(root, element);
  }

  boolean insert(BinaryNode<AnyType> node, AnyType newElement) {
    if (node == null) {
      node = new BinaryNode<>(newElement);
      return true;
    }
    int comparison = newElement.compareTo(node.getElement());
    if (comparison < 0) {
      return insert(node.getLeft(), newElement);
    }
    if (comparison > 0) {
      return insert(node.getRight(), newElement);
    }
    else return false; //duplicate not allowed as of now
  }

  public void remove(AnyType element) {

  }

  public void makeEmpty() {
    root = null;
  }

  public boolean isEmpty() {
    return root == null;
  }

  @Override public String toString() {
    return "is that how a tree prints?";
  }
}
