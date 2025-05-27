package com.example.Library.management.System.Controller;

import com.example.Library.management.System.Entities.Book;
import com.example.Library.management.System.Entities.User;
import com.example.Library.management.System.Entities.UserProfile;
import com.example.Library.management.System.Service.LibraryManagementSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.HashMap;

@Controller
public class TestController {
    @Autowired
    public LibraryManagementSystem libraryManagementSystem;
    public void Testcases(){
        Book book = new Book(null,"Shivangi","HeyMyFirstBook",5);
        String bookId1 = libraryManagementSystem.addBook(book);
        String user1 = libraryManagementSystem.addUser(new User(null,"Shivangi", UserProfile.STUDENT,new HashMap<>()));
        System.out.println(libraryManagementSystem.booksByAuthorName("Shiva"));
        System.out.println(libraryManagementSystem.borrowBook(user1,bookId1));
        System.out.println(libraryManagementSystem.getAllBooks());
        System.out.println(libraryManagementSystem.getUserBorrows(user1));
        System.out.println(libraryManagementSystem.returnBook(user1,bookId1));
        System.out.println(libraryManagementSystem.getAllBooks());
    }
}
