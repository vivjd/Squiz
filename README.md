# CSC207CourseProject
Members: Vivian Deng, Jaehyeong Jang, Min Tun Myo, Emily Shen

## Problem Domain
As university students, studying plays a large part in our daily lives and remains a crucial component of our academic career. Although there is a wide variety of studying available apps, we want to create a study tailored to how university students study.

A large part of our learning stems from attending lectures and self-revision of these materials. We believe that self-assessment is a major tool used by current students to increase their understanding of course materials. These tasks seem trivial but are rather crucial for our learning in many areas, and the experience can be enhanced with an application.

## Description
Since every students has their own way to stay productive, this also means that they have a lot of different applications for very specific tasks. Our program will allow students to have multiple ways to stay organized and study without the hassle of making too many accounts. With this study program, students can actually spend time to study without having to do a lot of logistical tasks (e.g making their own quizzes, managing deadlines, etc). 

Features we plan on implementing:
- **Quiz Generator:** using the notes the user writes, the program can generate a quiz for them to take. This quiz will be reworded and have different types of questions (e.g. short response, multiple choice, fill in the blank, etc). Once the user is done, the quiz will be automatically graded and provide answers to them. The answers may also point to certain parts of the user's notes to show them what to review.
- **Saving quizzes:**
- **Searching quizzes:**
- **Edit quiz:**
- **Customized inputm questions:**

Our program will have screens to allow users to click different buttons and type. As a rough design, this is what we plan on incorporating:
![Work in Progress of Our Design](https://github.com/vivjd/CSC207CourseProject/assets/105073190/f80bacda-f2f5-4fec-a524-92995a2549f0)


## API Documentation
- Link to the HuggingFace API:
- Link to OpenSearch API:
- Link to AWS API:
  
## API Call

![What is this](hoppscotch_trying_API.png)
## Example Output

```
{
  "parent": {
    "page_id": "cbc4c95a-f066-4f8f-ab34-0835434484b5"
  },
  "properties": {
    "title": [
      {
        "text": {
          "content": "created with API on Java"
        }
      }
    ]
  }
}
```


## Technical Problem
1. Retrieving personal information such as individual assignments, due dates, and notifications on Quercus (Canvas).
The way of authentication is strictly limited when using Quercus API, Moreover, since all the UofT-related web 
services utilize an external application called "Duo" as a mean of authentication, related API calls incorporating 
the Duo service has to be explored as well.


2. Limited capacity of free open APIs: Though all the APIs we have so far identified to use do provide full features with its paid version,
free version has quite limited capacities such as limited lenght of document when using Notion API and limited file size 
for a text file to be converted into a PDF through an API called "pspdfkit.


3. Construction of UI with Java GUI: for this assignment, since use of another language and external tools are restricted, 
the overall aesthetics and functionalities are limited.
