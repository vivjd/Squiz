# CSC207CourseProject
Members: Vivian Deng, Jaehyeong Jang, Min Tun Myo, Emily Shen

## Problem Domain
As university students, studying plays a large part in our daily lives and remains a crucial component of our academic career. Although there is a wide variety of studying available apps, we want to create a study application tailored to how university students study.

A large part of our learning stems from attending lectures and self-revision of these materials. We believe that self-assessment is a major tool used by current students to increase their understanding of course materials. These tasks seem trivial but are rather crucial for our learning in many areas, and the experience can be enhanced with an application.

## Description
Since every students has their own way to stay productive, this also means that they have a lot of different applications for very specific tasks. Our program will tackle taking quizzes. With this study program, students can actually spend time to study without having to spent extra time creating study questions and knowing the answer to them. Squiz aims to help students to prepare for upcoming examinations by ensuring the quizzes they give are related to the notes given and that the students has no idea what questions the quiz will give them.  

Features we plan have implemented:
- **Quiz Generator:** using the notes the user writes, the program can generate a quiz for them to take. This quiz will be reworded and have different types of questions (e.g. short response, multiple choice, fill in the blank, etc).
- **Taking the Quiz:** Once the quiz is generated, users can take it. Once they submit their answer, they will automatically get the correct answer back. The correct answer for open-ended question is the answe GPT gives when creating the quz.
- **Saving quizzes:** using the quiz generated, users can save the quiz and access it later on.
- **Saving notes:** the user can save their note to MongoDB database and access it later on.
- **Deleting quizzes:** if users do not want to keep the quiz, they can delete it from the database.
- **Deleting quizzes:** if users do not want to keep the note they saved, they can delete it from the database.
- **Displaying all notes:** users can see all the notes from the database. From there, they can generate a quiz with it or delete it.
- **Displaying all quizzes:** users can see all the quizzes from the database. From there, they can take the quiz or delete it.

Future implementations that will enhance our program more:
- **Searching quizzes:** users will be able to search for existing quizzes and be able to test themselves with the quiz they select.
- **Edit quiz:** users will be able to delete certain questions they don't want anymore.
- **Customized input questions:** sometimes users want to create their own questions for their quiz. This option allows them to write their own answers and questions. After they added their questions, they will be shuffled into the generated quiz questions.
- **Automatic marking:** once the user finishes the quiz, we could implement it so that it will mark the quiz and display the score.

Our screens look something like this:

**Home Page**

![image](https://github.com/vivjd/Squiz/assets/105073190/bdea61d0-dbe1-4889-ac13-621b7732e926)

**All Notes Page**

![image](https://github.com/vivjd/Squiz/assets/105073190/cffb42d8-a90b-4f61-8320-25803919392d)

**All Quizzes Page**

![image](https://github.com/vivjd/Squiz/assets/105073190/ad0dd461-cea7-4736-ac1e-28e32c0c94a4)

**Multiple Choice Question Page**

![image](https://github.com/vivjd/Squiz/assets/105073190/fd25e3d4-0177-4173-bcb0-18e8664cd014)

**Open Answer Question Page**

![image](https://github.com/vivjd/Squiz/assets/105073190/e01d8e63-b9a2-4380-9cf7-d8f5dcb884db)

**Example Answer Feedback PopUp**

![image](https://github.com/vivjd/Squiz/assets/105073190/34ca54fb-0f4b-427f-95db-eadb134a826e)


## API Documentation
- Link to the GPT API: https://platform.openai.com/docs/api-reference
- Link to MongoDB API: https://www.mongodb.com/docs/atlas/app-services/data-api/
  
## API Call

## Example Output

```
{
  "_id": {
    "$oid":"6564ae7fab7eb24248c437b8"
  },
    "title":"CSC207",
    "userPrompt":"We love Java!"
}
```

## Technical Problem & Limitations
1. Limitation: due to the limited number of tokens to use, the quiz generated by GPT 3.5 may not always create the most ideal quiz to take based on the note. Depending on how generic the note may be, the quiz might not reference the note a whole lot. There are limitations to how long the notes are depending on the number of tokens you are wiling to use.
2. Due to the inconsistent response format of GPT api, we may not always format it correctly (ie. there might be some spacing issues in the questions given as well as potential punctuation errors) 
