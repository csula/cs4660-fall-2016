# Introduction to AI

Welcome to introduction to AI course!

## Objectives

* Syllabus
* Introduction to AI
* Set up environment

## Metrics

* Environment setup
* Concept of Artificial Intelligence

### What is Artificial Intelligence?

AI is basically an **intelligent agent** that makes decisions based on its sensors
and use actuators to mutate environment.

An example of the intelligent agent would be *financial agent*. They can get the
stock market information (**sensors**) and use it to make trades (**actuators**).

The **decisions** it involves between the information from sensors to actions of
actuators is the key of AI.

This entire loop of sensors getting information to making decisions from AI algorithm
and to actions of actuators is often called **Perception-Action cycle**.

Perception-Action cycle is what we (Artificial Intelligence developers) are usually
interested of implementing.

### Terminologies

Following terminologies will be focus on the environment types:

* Fully vs partially observables
  * Fully means your agent can fully observe all variables of environment (e.g. chess)
  * Partially observables means your agent can only observe part of the environment (e.g. Starcraft, self-driving car)
* Deterministic vs stochastic
  * Deterministic means haves no random effects (like chess -- each moves determines next state deterministically)
  * Stochastic means having some random outcomes (like games involves dices rolling)
* Discrete vs continuous
  * Number of states in games is countable (discrete) and not-countable (continuous)
* Benign vs adversarial
  * Environment goes against you (benign) like Chess (environment -- your opponent -- is trying to defeat you)
  * Or environment is just there (like weather effect for selv-driving car)

### Summary

AI can often be seen as an uncertainty management.

In other word, "what would you do when you don't know what to do?"

In example, we cant possibly create an imperative program that predicts every single
state for self-driving car or Go.

But how do our agents handle the situation it hasn't seen or programmed to do?

Artificial intelligence is to create such algorithm to do general problem solving.

### Recommended reading

* https://en.wikipedia.org/wiki/Intelligent_agent

## Environment setup

Follow the note to set up Java and Gradle -- https://github.com/csula/Utilities/blob/master/setups/java-gradle-setup.md

And follow the note to set up Git/Github -- https://github.com/csula/Utilities/blob/master/setups/git-github-notes.md

## Wrap Up Java Review Exercise

Once you set up the above two dependencies, please do this wrap up exercise to
test your local environment setup!

Since not everyone has experience of using Github/git before, we will go over
in class exercise to demonstrate how you should submit your assignment in future.

The goal of this exercise is to review mainly two concepts (Java File IO &
Object Oriented Programming) as they are the primary requirements for the course.

You may start reading through the source code folder for some starting point of the project.

1. Fork/clone repository
2. Code, Commit & pass unit test  
> Note 1: You can run `gradle check` to check if you passed the provided unit tests right away locally  
> Note 2: DO NOT MODIFY ANY EXISTING CODE

3. Pull request & review comments  
> Note that in the pull request, you will see the build result immediately in the pull request status. Please make sure you at least pass the unit tests as they are one of the grading criteria.

If you have trouble pushing to your own repository under your workspace

```bash
git remote set-url origin {Your repository url} # https://github.com/csula/cs4660-fall-2016-exercise-1-rcliao.git for example
git commit -a # will open text editor for you to enter commit message
git push # push to origin server (which will be your repository)
```

Click here to set your repository -- https://classroom.github.com/assignment-invitations/d81e544ad4dc4b205f3ae61d41824625

1. Push your code to that repository.
2. Paste link to CSNS "Your repository" section
