package com.weiss.trees;

/**
* @author Nabeel Ali Memon
*/
public class BinaryNode<AnyType> {
  AnyType element;
  BinaryNode<AnyType> parent;
  BinaryNode<AnyType> left;
  BinaryNode<AnyType> right;

  public BinaryNode() {}

  public BinaryNode(AnyType element) {
    this(null, null, null, element);
  }

  public BinaryNode(BinaryNode<AnyType> left, BinaryNode<AnyType> right, AnyType element) {
    this(left, null, right, element);
  }

  public BinaryNode(BinaryNode<AnyType> left, BinaryNode<AnyType> parent, BinaryNode<AnyType> right, AnyType element) {
    this.element = element;
    this.parent = parent;
    this.left = left;
    this.right = right;
  }

  public AnyType getElement() {
    return element;
  }

  public void setElement(AnyType element) {
    this.element = element;
  }

  public BinaryNode<AnyType> getLeft() {
    return left;
  }

  public void setLeft(BinaryNode<AnyType> left) {
    this.left = left;
  }

  public BinaryNode<AnyType> getRight() {
    return right;
  }

  public void setRight(BinaryNode<AnyType> right) {
    this.right = right;
  }

  public BinaryNode<AnyType> getParent() {
    return parent;
  }

  public void setParent(BinaryNode<AnyType> parent) {
    this.parent = parent;
  }
}
