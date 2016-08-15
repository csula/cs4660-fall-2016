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

An example of the intelligent agent would be financial agent. They can get the
stock market information (sensors) and use it to make trades (actuators).

The **decisions** it involves between the information from sensors to actions of
actuators is the key of AI.

This entire loop of sensors getting information to making decisions from AI algorithm
and to actions of actuators is often called **Perception-Action cycle**.

### Terminologies

* Fully vs partially observables
* Deterministic vs stochastic
* Discrete vs continuous
* Benign vs adversarial

### Summary

AI can often be seen as an uncertainty management.

In other word, "what would you do when you don't know what to do?"


### Environment setup

As this class will be one of those heavy programming class, we will need to set up environment at the starting of course.

#### Java

Install [OracleJDK 8](http://www.oracle.com/technetwork/java/javase/downloads/index.html) if you don't already have one.

##### Windows User

Click on the link above (OracleJDK 8) to install Java 8. Upon completion of
installation, please set up the `JAVA_HOME` path as well.

##### Mac User

You can install [brew](http://brew.sh/) and follow the following to install Java 8.

```sh
brew tap caskroom/cask
brew install brew-cask
brew cask install java
```

#### Gradle

Install [gradle](https://gradle.org/) as this will be our primary build tool.

##### Windows User

Click on the link above and install Gradle accordingly.

##### Mac User

Install via `brew install gradle` assuming you have `brew` installed.

##### Linux User

* CentOS users can follow the instruction found in [Github Gist](https://gist.github.com/parzonka/9371885).  
* Ubuntu users take a look at the [Ask Ubuntu Stack Exchange Tutorial](https://askubuntu.com/questions/328178/gradle-in-ubuntu).

#### Github

* [Sign up Github account](https://github.com/) if you don't already have one

After finished above two tasks, please download [git](https://git-scm.com/) or
[Github client](https://desktop.github.com/) for you to do source control.

##### Recommended readings for leaning Git/github

Please read through some of the following readings and have clear understanding of
Github/git in order to commit & push your code for code submission.

* https://help.github.com/articles/good-resources-for-learning-git-and-github/
* [Github cheatsheet](https://education.github.com/git-cheat-sheet-education.pdf)

#### Wrap Up Java Review Exercise

[Repository invitation -- click here to be invited to have your own repository](https://classroom.github.com/assignment-invitations/e65c8c059ca93d69dfdcf0e6569e59a0)

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
git remote set-url origin {Your repository url} # https://github.com/csula/exercise-1-amit70.git for example
git commit -a # will open text editor for you to enter commit message
git push # push to origin server (which will be your repository)
```
