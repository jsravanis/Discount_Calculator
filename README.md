# Android Discount Calculator App

This Android application allows users to calculate discounts on item prices based on different sale options including pre-defined percentages and custom values. Users can enter the item price, select a sale option, and adjust a custom sale value using a SeekBar. The app calculates and displays the discount and final price accordingly.

## Features

- Uses EditText to input the item price, allowing only positive numbers.
- Uses RadioGroup with RadioButtons to select from pre-defined sale options (10%, 15%, 18%, and Custom).
- Uses SeekBar to set a custom sale value, with a maximum of 50%.
- Displays current progress of the SeekBar using a TextView.
- Displays discount and final price using TextView components.
- Reset button clears inputs and resets the app to the initial state.
- Calculate button computes discounts and final prices based on user inputs.

## Initial State

- Item price EditText is empty, displaying the hint message "Enter List Price".
- 10% sale option is selected by default.
- SeekBar is set to 25%.
- Discount and final price values are both empty.

## Reset Button

- Clears the item price value to empty.
- Sets the sale radio group to 10%.
- Sets the SeekBar to 25%.
- Sets the discount and final price to 0.00.

## Calculate Button

- If the item price is empty, displays an error toast message instructing the user to "Enter Item Price".
- Retrieves the selected sale percentage based on the checked radio button.
- Calculates the discount and updates the discount and final price values accordingly.

## Screenshots

![Screenshot 1](screenshots/screenshot1.jpeg)    ![Screenshot 2](screenshots/screenshot2.jpeg)    ![Screenshot 3](screenshots/screenshot3.jpeg)

## Dependencies

- No external dependencies required.

## Installation

- Clone the repository.
- Open the project in Android Studio.
- Build and run the project on an Android device or emulator.

## Author

Jaya Sravani Sirigineedi

## Acknowledgments

- This app was created as part of Mobile Application Development course at UNCC.
