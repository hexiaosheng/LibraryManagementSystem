# 一、System Description

This is a Libary command-line management system which provide book service for administrators and users.

# 二、System Environment

It require Java 1.8 or plus.

# 三、Source Code Structure

The system adopt factory design patter to process the command, which it's flexible to support command extension. the detail source code structure as following:

**Command Factory and Command handler** under "src/main/java/com/dbs/comman"

**Entity** under "src/main/java/com/dbs/entity"

**Service** under "src/main/java/com/dbs/service"

**Test Cases** under "src/test/java"

├── main
│   ├── java
│   │   └── com
│   │       └── dbs
│   │           ├── Main.java
│   │           ├── command
│   │           │   ├── CmdBookAdd.java
│   │           │   ├── CmdBookBorrow.java
│   │           │   ├── CmdBookDelete.java
│   │           │   ├── CmdBookList.java
│   │           │   ├── CmdBookReturn.java
│   │           │   ├── CmdBookSearch.java
│   │           │   ├── CmdUserLogin.java
│   │           │   ├── CmdUserRegister.java
│   │           │   ├── Command.java
│   │           │   └── CommandFactory.java
│   │           ├── entity
│   │           │   ├── Book.java
│   │           │   ├── Library.java
│   │           │   └── User.java
│   │           └── service
│   │               ├── AdminBookService.java
│   │               ├── BookService.java
│   │               ├── UserBookService.java
│   │               └── UserService.java
│   └── resources
└── test
    └── java
        ├── AdminBookServiceTest.java
        ├── BookServiceTest.java
        ├── CommandFactoryTest.java
        ├── CommandTest.java
        ├── UserBookServiceTest.java
        └── UserServiceTest.java

# 四、How to Use

open terminal in your PC, and run the runnable jar file under "/out/artifacts/LibraryMgtSystem.jar" in the "LibraryManagementSystem.zip" zip file

run the below command:

~~~java
java -jar LibraryMgtSystem.jar
~~~

Currently, System only support below commands (parameters in cmd split by a space):

**register** "User Role" "User Name" "User Password" 

User Role(two options): admin / user

example: register admin Alice password1/register user Bob password2

**login** "User Name" "User Password"

example: login Alice password1/login Bob password2

**add** "Book Name" "Book Author" "Book Inventory"

example: add "Clean Code" "Robert C. Martin" 5

**list**

**search** "Book Name" " Book Author"

example: search "Clean Code" " Robert C. Martin"

**borrow** "Book Name" " Book Author"

example: borrow "Clean Code" " Robert C. Martin"

**delete** "Book Name" " Book Author"

example: delete "Clean Code" " Robert C. Martin"

**return** "Book Name" " Book Author"

example: return "Clean Code" " Robert C. Martin"