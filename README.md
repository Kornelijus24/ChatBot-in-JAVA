# ChatBot created using the JAVA programming language

## **Author & Contact**
- **Developed by:** Kornelijus
- **Email:** kornelijus.baublys@mif.stud.vu.lt
- **Created on:** 2025-02-19
- **Github repository:** https://github.com/Kornelijus24/ChatBot-in-JAVA

---------------------------------------------------------------------------------------------------------------------

## **Version History**
- **ChatBot Version 1** - 2025-02-19
  - Initial chatbot implementation with basic text interaction and features.
  
- **ChatBot Version 2** - 2025-03-05
  - Added more features, including jokes, facts, and a number guessing game.
  - Improved interaction flow and user experience.
  
- **ChatBot Version 3** - 2025-03-17
  - Refactored into multiple **object-oriented classes**.
  - Implemented **exception handling** for robust error management.
  - Improved **code modularity** and reusability.
  - Added **documentation** and structured error messages.
  - Enhanced **user experience** with smoother conversation handling.

- **ChatBot Version 3.1** - 2025-03-19
  - **Added Colors and Typewriter Effect**: 
    - Improved chatbot **visual appearance** in the terminal.
    - Removed pause and changed it to **typewriter effect**.
  - **Enhanced Calculator Input Handling**: 
    - Prevents crashes when entering **non-numeric** input.
    - Ensures **valid menu selection** before proceeding.
    - Keeps asking for a **valid number** instead of returning an error and going back to menu.
  - **Fixed User Input Display Issues**: 
    - Properly formats user responses **without showing raw input**.
    - Ensures that **color resets correctly** after messages.
  - **Bug Fixes and Code Optimization**:
    - **Fixed division by zero** handling in the calculator.
    - Improved **menu structures** for better readability.
    - General **code cleanup** and improved efficiency.

---------------------------------------------------------------------------------------------------------------------

## **ChatBot Features**
This chatbot provides an interactive experience by engaging with users through multiple activities.

### **1. Greeting and Name Registration**
- The chatbot introduces itself and asks for the user's name.
- The user provides their name, which is stored for future interactions.

### **2. Main Menu - User Options**
After greeting the user, the chatbot presents a **main menu** with six options:

#### **1. Chat with the User (Mood-Based Conversation)**
- The chatbot asks about the user's **current mood**.
- Based on the response, the chatbot:
  - Engages in a positive conversation if the user is happy.
  - Offers a joke if the user is sad.
  - Asks about hobbies or interests to continue the conversation.

#### **2. Play a Number Guessing Game**
- The chatbot picks a **random number between 1 and 10**.
- The user has **3 attempts** to guess the correct number.
- If the user wins, they receive a congratulatory message.
- If they fail, the chatbot reveals the correct answer.

#### **3. Tell a Random Joke**
- The chatbot selects and tells a **random joke** from a predefined list.
- This feature is designed to make the conversation more entertaining.

#### **4. Provide a Random Fun Fact**
- The chatbot shares **an interesting fact** from various topics.
- Example:
  - "Honey never spoils. Archaeologists found 3000-year-old honey in Egyptian tombs!"

#### **5. Perform Basic Calculations**
- The chatbot can perform **addition, subtraction, multiplication, and division**.
- The user enters **two numbers**, and the chatbot calculates the result.
- If the user attempts to **divide by zero**, an appropriate error message is displayed.
- **Menu selection validation**: Prevents invalid choices before asking for numbers.
- **Handles non-numeric input**: Keeps asking until the user provides a valid number.

#### **6. Exit the Program**
- The chatbot **says goodbye** to the user and exits.

---------------------------------------------------------------------------------------------------------------------

## **Additional Features**
### **✔ Basic Error Handling**
- The chatbot detects **invalid user input** and provides appropriate error messages.
- If an exception occurs, the chatbot handles it without crashing.

### **✔ Improved Visual Experience**
- **Added colors and structured formatting** for better readability.
- **Typewriter effect** makes responses **appear more natural and engaging**.
- **Corrected color resets** to prevent formatting issues.

### **✔ Waiting for User Key Press**
- Before continuing to the next step, the chatbot waits for the **user to press ENTER**.
- This allows the user to read messages at their own pace.

---------------------------------------------------------------------------------------------------------------------

## **Technical Details**
- **Programming Language:** Java
- **Course:** Object-Oriented Programming (OOP)
- **OS:** Windows / Linux
- **Java Development Kit:** 23.0.2
- **Java SE Runtime Environment:** 1.8.0_401

---------------------------------------------------------------------------------------------------------------------