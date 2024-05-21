# Investment Insights Backend

This project is a backend system for generating investment insights using GPT-4.

## Features

- Store user preferences in MongoDB
- Generate investment insights using GPT-4
- REST API for managing user preferences and retrieving insights
- Basic security with HTTP Basic Authentication

## Prerequisites

- Java 11 or higher
- Maven
- MongoDB (if using locally, ensure it is running on the default port 27017)
- OpenAI API key

## Setup

### Step 1: Clone the Repository

\`\`\`bash
git clone <your-github-repo-url>
cd investment-insights
\`\`\`

### Step 2: Configure the Application

Update `src/main/resources/application.properties` with your MongoDB settings and OpenAI API key.

For MongoDB:

\`\`\`properties
spring.data.mongodb.uri=mongodb://localhost:27017/investmentdb
openai.api.key=YOUR_OPENAI_API_KEY
\`\`\`

### Step 3: Build and Run the Application

\`\`\`bash
mvn clean install
mvn spring-boot:run
\`\`\`

## API Endpoints

1. Save User Preferences

   URL: `POST /api/preferences`

   Request Body:

   \`\`\`json
   {
     "userId": "user123",
     "preferences": "I am interested in technology stocks and sustainable energy investments."
   }
   \`\`\`

   Sample Request:

   \`\`\`bash
   curl -X POST http://localhost:8080/api/preferences \\
     -H "Content-Type: application/json" \\
     -d '{"userId": "user123", "preferences": "I am interested in technology stocks and sustainable energy investments."}'
   \`\`\`

   Response:

   \`\`\`json
   {
     "id": "60c72b2f8e62015a544f7b91",
     "userId": "user123",
     "preferences": "I am interested in technology stocks and sustainable energy investments."
   }
   \`\`\`

2. Get Investment Insights

   URL: `GET /api/insights`

   Query Parameter: `userId` (string)

   Sample Request:

   \`\`\`bash
   curl -X GET "http://localhost:8080/api/insights?userId=user123"
   \`\`\`

   Response:

   \`\`\`json
   {
     "insight": "Based on your preference for technology stocks, consider investing in companies that are leading in AI development. Additionally, sustainable energy investments are growing, with solar and wind energy companies showing promising returns."
   }
   \`\`\`

## Security

The application uses HTTP Basic Authentication. Ensure you send the proper authentication headers in your requests.

Sample Request with Authentication (For a user with username `user` and password `password`):

\`\`\`bash
curl -X GET "http://localhost:8080/api/insights?userId=user123" -u user:password
\`\`\`

## Running Tests

To run the tests, use the following command:

\`\`\`bash
mvn test
\`\`\`

## Troubleshooting

- Ensure MongoDB is running and accessible at the URI specified in `application.properties`.
- Verify that your OpenAI API key is correct and has the necessary permissions.