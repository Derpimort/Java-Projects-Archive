package com.javaproject.librarymanagement;

public class BookBean 
{
  private int bookId;
  public int getBookId() {
	return bookId;
}
public void setBookId(int bookId) {
	this.bookId = bookId;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}

public String getAuthor() {
		return author;
}
public void setAuthor(String author) {
	this.author=author;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
private String title;
  private float price;
  private String author;
  private int quantity;
  
  
  
  
  
}
