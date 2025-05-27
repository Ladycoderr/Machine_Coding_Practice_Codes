package com.example.Library.management.System.Service;

import com.example.Library.management.System.Entities.Book;
import com.example.Library.management.System.Entities.User;
import com.example.Library.management.System.Entities.UserProfile;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class LibraryManagementSystem {
    Map<String,User>userMap = new HashMap<>();
    Map<String,Book>bookMap = new HashMap<>();
    public String addUser(User user){
        String userId = UUID.randomUUID().toString();
        user.setUserId(userId);
        userMap.put(userId,user);
        System.out.println("Added User with Userid" + userId);
        return userId;
    }
    public Set<String> getUserBorrows(String userID){
        User user = userMap.get(userID);
        if(user == null){
            throw new IllegalArgumentException("Wrong userid");
        }
        Set<String>bookIds = userMap.get(userID).getBorrowedBooks().keySet();
        return  bookIds;
    }
    public String addBook(Book book){
        String bookId = UUID.randomUUID().toString();
        book.setBookId(bookId);
        bookMap.put(bookId,book);
        System.out.println("Added book in Library with Name and ID " + book.getTitle() +" "+ bookId);
        return bookId;
    }
    public String removeBook(Book book){
        String bookId = UUID.randomUUID().toString();
        bookMap.remove(bookId);
        return "Book has been removed";
    }
    public List<Book> searchByTitle(String title){
        ArrayList<Book> allBooks = new ArrayList<>(bookMap.values());
        return allBooks.stream().filter(book -> book.getTitle().startsWith(title)).collect(Collectors.toList());
    }
    public List<Book> booksByAuthorName(String authorName){
        ArrayList<Book>allBooks = new ArrayList<>(bookMap.values());
        return allBooks.stream().filter(book -> book.getAuthor().startsWith(authorName)).collect(Collectors.toList());
    }
    public List<Book> getAllBooks(){
        if(!bookMap.isEmpty()){
            return new ArrayList<>(bookMap.values());
        }
        return new ArrayList<>();
    }
    public String borrowBook(String userId, String bookId){
        User user = userMap.get(userId);
        Book book = bookMap.get(bookId);
        if(user==null) {
            throw new IllegalArgumentException("Userid is wrong");
        }
        if(user.getUser()== UserProfile.TEACHER){
            if(user.getBorrowedBooks().size()<5 && book.getQuantity()>0){
                user.getBorrowedBooks().putIfAbsent(bookId, LocalDateTime.now());
                book.setQuantity(book.getQuantity()-1);
            }else{
                System.out.println("User has exceeded limit of getting books");
            }
        }else if (user.getUser() == UserProfile.STUDENT && book.getQuantity()>0){
            if(user.getBorrowedBooks().size()<3){
                user.getBorrowedBooks().putIfAbsent(bookId, LocalDateTime.now());
                book.setQuantity(book.getQuantity()-1);
            }else{
                System.out.println("User has exceeded limit of getting books");
            }
        }
        return user.getUsername() + "User has borrowed book" + book.getTitle();
    }
    public String returnBook(String userId, String bookId) {
        User user = userMap.get(userId);
        user.getBorrowedBooks().remove(bookId);
        Book book = bookMap.get(bookId);
        book.setQuantity(book.getQuantity()+1);
        return user.getUsername()+ "has returned book" + book.getBookId();
    }
    public LocalDateTime trackDueDate(String userId, String bookId){
        User user = userMap.get(userId);
        LocalDateTime currentDate = user.getBorrowedBooks().get(bookId);
        LocalDateTime dueDate = currentDate.plusDays(14);
        return dueDate;
    }
    public List<String> showOverDueBooks(String userId){
        List<String>allOverDueBooks = new ArrayList<>();
        Map<String,LocalDateTime>allBooksForUser = userMap.get(userId).getBorrowedBooks();
       for(Map.Entry<String,LocalDateTime>entry:allBooksForUser.entrySet()){
            if(!entry.getValue().plusDays(14).isAfter(LocalDateTime.now())){
                Book book = bookMap.get(entry.getKey());
                allOverDueBooks.add(book.getTitle());
            }
        }
       return allOverDueBooks;
    }
}
