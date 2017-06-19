/*Book sınıfımız*/

package bns237.mylibrary;




public class Book {

    private String  BookName , AuthorName , PublisherName ;
 //Kurucu metod
    public Book() {

    }
//Parametre alan kurucu metod
    public Book(String bookName, String authorName, String publisherName) {
        BookName = bookName;
        AuthorName = authorName;
        PublisherName = publisherName;
    }

//Setterlar
    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public void setAuthorName(String authorName) {
        AuthorName = authorName;
    }

    public void setPublisherName(String publisherName) {
        PublisherName = publisherName;
    }
//Getterlar
    public String getBookName() {
        return BookName;
    }

    public String getAuthorName() {
        return AuthorName;
    }

    public String getPublisherName() {
        return PublisherName;
    }
}
