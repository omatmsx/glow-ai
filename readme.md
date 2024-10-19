# Glow AI: Skincare Recommendation App

## Overview

Glow AI is an innovative skincare recommendation app that utilizes Face++ for face analysis and ChatGPT for generating personalized skincare routines. The app also provides weather-based skincare tips to enhance user experience.

## Features

- **Face Analysis**: Utilizes Face++ for detailed face analysis to gather skin condition data.
- **Personalized Recommendations**: Sends the face analysis data to ChatGPT to generate recommended skincare products and routines.
- **Local Storage**: Saves user data and skincare routines to a local Room database for easy access and retrieval.
- **Dashboard**: Displays all user data, recommended products, and skincare routines.
- **Weather-Based Tips**: Fetches skincare tips based on the current weather and displays them as notifications.

## Technology Stack

- **Face++**: For facial recognition and analysis.
- **ChatGPT**: For generating personalized skincare recommendations.
- **Room Database**: For local data storage.
- **Android**: The platform for the app.

## Getting Started

### Prerequisites

- Android Studio
- Dependencies for Face++ and Room database
- OpenAI API key for ChatGPT

### Installation

1. Clone the repository:
   ```bash
   https://github.com/omatmsx/glow-ai.git
2. Open the project in Android Studio.

3. Add your OpenAI API key in the  file  (note ask us for api key if you want to run app)
   ```com.mindstix.capabilities.network.rest.api.ApiConfig.kt ```
   ``` onst val apiKey = "like this" ```


4. Sync your project to download the necessary dependencies.

5. Build and run the app on an Android device or emulator.

### Usage
- Launch the app and follow the prompts to analyze your face using Face++.
- After analysis, receive personalized skincare product recommendations and routines.
- View all saved data on the dashboard.
- Enable notifications to receive weather-based skincare tips.

### Contributing
- If you would like to contribute to Glow AI, please fork the repository and submit a pull request with your changes.