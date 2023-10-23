# CSC207CourseProject
Members: Vivian Deng, Jaehyeong Jang, Min Tun Myo, Emily Shen

## Links to files
https://utoronto-my.sharepoint.com/:f:/r/personal/viv_deng_mail_utoronto_ca/Documents/CSC207/CSC207%20Course%20Project?csf=1&web=1&e=QwX3N4

## Problem Domain
As university students, studying plays a large part in our daily lives and remains a crucial component of our academic career. Although there is a wide variety of studying available apps, we want to create a study application tailored to how university students study.

A large part of our learning stems from attending lectures and self-revision of these materials. We believe that self-assessment is a major tool used by current students to increase their understanding of course materials. These tasks seem trivial but are rather crucial for our learning in many areas, and the experience can be enhanced with an application.

## Description
Since every students has their own way to stay productive, this also means that they have a lot of different applications for very specific tasks. Our program will allow students to have multiple ways to stay organized and study without the hassle of making too many accounts. With this study program, students can actually spend time to study without having to do a lot of logistical tasks (e.g making their own quizzes, managing deadlines, etc). 

Features we plan on implementing:
- **Quiz Generator:** using the notes the user writes, the program can generate a quiz for them to take. This quiz will be reworded and have different types of questions (e.g. short response, multiple choice, fill in the blank, etc). Once the user is done, the quiz will be automatically graded and provide answers to them. The answers may also point to certain parts of the user's notes to show them what to review.
- **Saving quizzes:** using the quiz generated, users can save the quiz and access it later on.
- **Searching quizzes:** users will be able to search for existing quizzes and be able to test themselves with the quiz they select.
- **Edit quiz:** users will be able to delete certain questions they don't want anymore.
- **Customized input questions:** sometimes users want to create their own questions for their quiz. This option allows them to write their own answers and questions. After they added their questions, they will be shuffled into the generated quiz questions.

Our program will have screens to allow users to click different buttons and type. As a rough design, this is what we plan on incorporating:
![Work in Progress of Our Design](https://github.com/vivjd/CSC207CourseProject/assets/105073190/f80bacda-f2f5-4fec-a524-92995a2549f0)


## API Documentation
- Link to the HuggingFace API: https://huggingface.co/inference-api
- Link to MongoDB API: https://www.mongodb.com/docs/atlas/app-services/data-api/
  
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
1. Limited capacity of free open APIs: Though all the APIs we have so far identified to use do provide full features with its paid version,
free version has quite limited capacities such as limited lenght of document when using Notion API and limited file size 
for a text file to be converted into a PDF through an API called "pspdfkit.


2. Construction of UI with Java GUI: for this assignment, since use of another language and external tools are restricted, 
the overall aesthetics and functionalities are limited.
