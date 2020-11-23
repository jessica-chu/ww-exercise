# WW Coding Exercise

## Usage
Note: I used Visual Studio Code to complete the coding exercise. All programs can be run in the terminal in their respective directories.
* Files in the directory `src` include coding exercise questions 1 and 3.

### Question 1
```bash
cd src
java -jar FileExist.java
```

### Question 2
Located in the directory `ww-test`. I used ChromeDriver for this exercise. `AboutUsTest` and `FindWorkshopTest` can be run using:

```bash
cd ww-test
mvn -Dtest=AboutUsTest test
mvn -Dtest=FindWorkshopTest test
```

* `@Parameter` is not passed as an argument when `mvn -Dtest=WorkshopTest test` is used (it will take `@Optional` instead). Instead, use:

```bash
mvn test
```

### Question 3
*Required*: Installation of [Node.js](https://nodejs.org/en/)

This Javascript program can be run as such:

```bash
node NthSmallest.js
```

---

### Question 1

There is a file containing a word and its possible meanings (like a Dictionary). The contents of the file look like this:

Apple – a fruit, a tech firm  
Table – an object, contains rows and columns when used in context of computers  
Orange – a fruit  

Given a path to the file, do the following:

a) Create a method called `doesFileExist(String path)` which takes the path of the file and tells the user if the file exists at that path or not. Assume all paths are relative to your project structure. If the file does not exist, catch the requisite exception.
b) Read each word and its possible meanings and print them out. Your output should look like this:

```
Word1
Meaning 1
Meaning 2
Word2
Meaning1
Meaning2
```

Use appropriate data structures wherever necessary.

### Question 2

Write an automated test for this scenario using WebDriver.
The following exercise does not require user login. Please use ID or class as selectors.

Steps:
1. Navigate to https://www.weightwatchers.com/us/
2. Assert loaded page title matches “WW (Weight Watchers): Weight Loss & Wellness Help | WW USA”
3. On the right corner of the page, click on “Find a Workshop”
4. Assert loaded page title contains “Find WW Studios & Meetings Near You | WW USA”
5. In the search field, search for meetings for zip code: 10011
6. Print the title of the first result and the distance (located on the right of location title/name)
7. Click on the first search result and then, verify displayed location name/title matches with the name of the first searched result that was clicked.
8. From this location page, print TODAY’s hours of operation (located towards the bottom of the page)
9. Create a method to print the number of meetings each person (under the scheduled time) has a particular day of the week

e.g. `printMeetings("Mon")`

Output should be:
```
Person A  3
Person B  1
```

### Question 3

Generate 500 random numbers and create a method to print the nth smallest number in a programming language of your choice.
