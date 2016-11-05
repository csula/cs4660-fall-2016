# Quiz 2

Total points: 10 pts

Due date: Oct 16th 11:59pm (at the end of day)

## Context

You woke up in the middle of empty room. You look around and realize you are in an empty room of a dungeon.

Your job is to find a way out from this empty room to a dark room containing the portal to outside world.

## Technical requirement

Implement BFS search to find path to state starting from 
`10a5461773e8fd60940a56d2e9ef7bf4` to `e577aa79473673f6158cc73e0e5dc122`

> updated at 11am Oct 15

> For Dikjstra search, you will need to take the event effect (edge cost) into the consideration. Find out the best path that returns the highest value (or lowest cost)

You will have to modify App.java to find the answer.

Please submit `solution.txt` containing link to your App.java and path from initial state to desination state to CSNS when you are done:

> You should commit your changes to your branch `quiz-2`

Example of `solution.txt`:

```
link to my solution: https://github.com/csula-students/cs-4660-fall-homework-rcliao/blob/master/src/main/java/csula/cs4660/exercises/FileRead.java

BFS Path:

Empty Room:Hall Way:-30
...

Dijkstra Path:

Empty Room:Hall Way:-30
...
```

**Hint**

* You can and should reuse your `Graph.java` implementation
* You don't know all the state ahead of time, but you can use the server as the state holder to traverse through states

## Solution

See source code under https://github.com/csula/cs4660-fall-2016/blob/master/src/main/java/csula/cs4660/quizes/App.java

```
BFS:
State{id='10a5461773e8fd60940a56d2e9ef7bf4', location=Location{name='Empty Room', description='null'}, neighbors=[State{id='4b2a41cdcc99bb9fdeeda9d4aec30970', location=Location{name='Hall Way', description='null'}, neighbors=[]}, State{id='0c32523e344445c79fad7e3c59eb75b0', location=Location{name='Dark Room', description='null'}, neighbors=[]}, State{id='9b2c9bc20df04fac55e940b75c091a4b', location=Location{name='Chamber', description='null'}, neighbors=[]}, State{id='3f2c4bf9f3ecd8062a7cd581e2c5ae79', location=Location{name='Chamber', description='null'}, neighbors=[]}]}:0
State{id='0c32523e344445c79fad7e3c59eb75b0', location=Location{name='Dark Room', description='null'}, neighbors=[]}:-30
State{id='5914c7373d69c7bf8d734189ed995971', location=Location{name='Room with cage', description='null'}, neighbors=[]}:-30
State{id='6bd9d2258bedb3cdff2b715da1a6ba34', location=Location{name='Room with cage', description='null'}, neighbors=[]}:-30
State{id='925cc86f5ce88acbd27a32a6fae32658', location=Location{name='Dire Tombs', description='null'}, neighbors=[]}:-50
State{id='adfb3580809a2354f02ba36a07f6b297', location=Location{name='Room with cage', description='null'}, neighbors=[]}:-50
State{id='e577aa79473673f6158cc73e0e5dc122', location=Location{name='Dark Room', description='null'}, neighbors=[]}:-50
DijkStra:
State{id='10a5461773e8fd60940a56d2e9ef7bf4', location=Location{name='Empty Room', description='null'}, neighbors=[State{id='4b2a41cdcc99bb9fdeeda9d4aec30970', location=Location{name='Hall Way', description='null'}, neighbors=[]}, State{id='0c32523e344445c79fad7e3c59eb75b0', location=Location{name='Dark Room', description='null'}, neighbors=[]}, State{id='9b2c9bc20df04fac55e940b75c091a4b', location=Location{name='Chamber', description='null'}, neighbors=[]}, State{id='3f2c4bf9f3ecd8062a7cd581e2c5ae79', location=Location{name='Chamber', description='null'}, neighbors=[]}]}:0
State{id='9b2c9bc20df04fac55e940b75c091a4b', location=Location{name='Chamber', description='null'}, neighbors=[]}:0
State{id='903b0202b85a699a4c0588f7d5857a57', location=Location{name='Empty Room', description='null'}, neighbors=[]}:0
State{id='ad4cb8972525ebb92cbd4fe92d8b9bb5', location=Location{name='Room with cage', description='null'}, neighbors=[]}:20
State{id='5178981f0ed36f690bf8a7adb4f33440', location=Location{name='Dark Room', description='null'}, neighbors=[]}:40
State{id='6b29c3861eb49aad378e649b641c92af', location=Location{name='Chamber', description='null'}, neighbors=[]}:40
State{id='beaf6c1a67afd64078335277915bcb70', location=Location{name='Dark Room', description='null'}, neighbors=[]}:60
State{id='395cdd3030fd957c348706f3a16e6caa', location=Location{name='Empty Room', description='null'}, neighbors=[]}:60
State{id='289bc5f03a5c6ee7e38cab3f60b2536f', location=Location{name='Hall Way', description='null'}, neighbors=[]}:60
State{id='81ddc7cf0f72fb153d1982656eb388df', location=Location{name='Empty Room', description='null'}, neighbors=[]}:60
State{id='045a0de32d05abab9807eca787b55a30', location=Location{name='Empty Room', description='null'}, neighbors=[]}:60
State{id='00a8d17716f3c37a8bba7472ce9c1a1b', location=Location{name='Chamber', description='null'}, neighbors=[]}:60
State{id='b3af3292fa2d420f0e45421f2d95295a', location=Location{name='Room with cage', description='null'}, neighbors=[]}:80
State{id='54a0c8315bd85b2348c649b0c9f10353', location=Location{name='Hall Way', description='null'}, neighbors=[]}:80
State{id='be02967d6f048ebd5d6016c5a50c705c', location=Location{name='Room with cage', description='null'}, neighbors=[]}:100
State{id='2544c3a2cd674a967a8b861a5b40aec5', location=Location{name='Room with cage', description='null'}, neighbors=[]}:80
State{id='56e64fa432d95b1fdfd7992c0682d2e1', location=Location{name='Room with cage', description='null'}, neighbors=[]}:100
State{id='a2002509699717182bfc75313f4da33a', location=Location{name='Room with cage', description='null'}, neighbors=[]}:120
State{id='6fbfa694c30c687b3523cba0d24ac7ed', location=Location{name='Room with cage', description='null'}, neighbors=[]}:100
State{id='be7c1456c1f1b90001ee4763642e7a9f', location=Location{name='Dark Room', description='null'}, neighbors=[]}:120
State{id='5154be28cd8217ce30385d7680f21db6', location=Location{name='Dire Tombs', description='null'}, neighbors=[]}:120
State{id='de3e0f26dfb33c2fb20a9b61b2982d8a', location=Location{name='Dark Room', description='null'}, neighbors=[]}:120
State{id='6f8f7eaeb91697175691fc6592027050', location=Location{name='Chamber', description='null'}, neighbors=[]}:120
State{id='15f694dd6d2798a7b55742366c33919a', location=Location{name='Empty Room', description='null'}, neighbors=[]}:120
State{id='0c36a432d9d02bff6139102c2d61a611', location=Location{name='Dark Room', description='null'}, neighbors=[]}:140
State{id='6537a4f6cdae42d90258c5e4c5ea86a4', location=Location{name='Hall Way', description='null'}, neighbors=[]}:140
State{id='0e209f093f080551e53fd2724167437d', location=Location{name='Chamber', description='null'}, neighbors=[]}:140
State{id='0a35c656a2d1af43c957b4d622d24553', location=Location{name='Room with cage', description='null'}, neighbors=[]}:160
State{id='3afdbbcd1050eea2c2ef773b2bed3329', location=Location{name='Room with cage', description='null'}, neighbors=[]}:160
State{id='601547fc3c96182e04f335f0bc605af3', location=Location{name='Dark Room', description='null'}, neighbors=[]}:150
State{id='fb4ec378c150643a7ef9bb2c66622ba9', location=Location{name='Dark Room', description='null'}, neighbors=[]}:150
State{id='e810a8b0dc1b7987d0b32e4a6d383984', location=Location{name='Chamber', description='null'}, neighbors=[]}:150
State{id='a63fc5089b4e0cef84188a2d634a3528', location=Location{name='Room with cage', description='null'}, neighbors=[]}:170
State{id='dcdea8fabac9e4a73732cda28eeb7c1f', location=Location{name='Dire Tombs', description='null'}, neighbors=[]}:170
State{id='086b8a510b224e0c0c3ae60860486922', location=Location{name='Room with cage', description='null'}, neighbors=[]}:170
State{id='a55cada50bc15940c9660a4b24b7d091', location=Location{name='Empty Room', description='null'}, neighbors=[]}:170
State{id='c5be2860da6775bbd6897fc92a70c7ae', location=Location{name='Dark Room', description='null'}, neighbors=[]}:190
State{id='4bc8087dab2ec0c98bd5009771cf68a7', location=Location{name='Chamber', description='null'}, neighbors=[]}:190
State{id='cfedaed3b5bf857082574ca690d15aae', location=Location{name='Empty Room', description='null'}, neighbors=[]}:190
State{id='801773005d765cefcefeac4853e1e01e', location=Location{name='Room with cage', description='null'}, neighbors=[]}:190
State{id='83c6257aaa9ed7362fee3cc92b87fe19', location=Location{name='Dark Room', description='null'}, neighbors=[]}:210
State{id='027ade197404100a824ca84d39a8f03c', location=Location{name='Room with cage', description='null'}, neighbors=[]}:230
State{id='c9d0fc97295242aeb71845f0f1084225', location=Location{name='Dark Room', description='null'}, neighbors=[]}:230
State{id='9c3568508ffe10afc7a0df7ea6dd04ea', location=Location{name='Empty Room', description='null'}, neighbors=[]}:230
State{id='67c90b04b679b64d013b7ab4b7115193', location=Location{name='Empty Room', description='null'}, neighbors=[]}:230
State{id='22f2ad067085896142fd9667b502f5ea', location=Location{name='Dark Room', description='null'}, neighbors=[]}:250
State{id='8c5f6c41e764fb17a3676fe58805c81b', location=Location{name='Room with cage', description='null'}, neighbors=[]}:250
State{id='1704693eccb76321207f7f55e95af028', location=Location{name='Empty Room', description='null'}, neighbors=[]}:250
State{id='6d02252ad102a6a2a1593e21e1aea83c', location=Location{name='Room with cage', description='null'}, neighbors=[]}:250
State{id='1c56240d695c8ce2a325da2e45bb1f60', location=Location{name='Hall Way', description='null'}, neighbors=[]}:250
State{id='e062f1c4b41c0402004010457aa0fee9', location=Location{name='Room with cage', description='null'}, neighbors=[]}:270
State{id='e6e4ddd55a56877c050af6916e43427f', location=Location{name='Empty Room', description='null'}, neighbors=[]}:270
State{id='7af7a88ea17c63bca36d937901b64f9f', location=Location{name='Empty Room', description='null'}, neighbors=[]}:270
State{id='54dd3844d12e1b792d3ceca268ad4685', location=Location{name='Chamber', description='null'}, neighbors=[]}:270
State{id='905860960bd284825c9294a55a68ccf7', location=Location{name='Chamber', description='null'}, neighbors=[]}:270
State{id='e9341cce1c193d71bfbdcb173d1459af', location=Location{name='Dark Room', description='null'}, neighbors=[]}:290
State{id='e680d15443ab2dcf60231506da133b0b', location=Location{name='Dark Room', description='null'}, neighbors=[]}:290
State{id='7f0e91645cc763b86b9ed8f1437144f1', location=Location{name='Empty Room', description='null'}, neighbors=[]}:290
State{id='d3f14609ebcd25f1eef98f9e5f0f5f56', location=Location{name='Hall Way', description='null'}, neighbors=[]}:290
State{id='1608d6e4ac658625eb9112cb56a23c30', location=Location{name='Room with cage', description='null'}, neighbors=[]}:310
State{id='cceff0efe2843d940a4c5b0cb38c7d22', location=Location{name='Dark Room', description='null'}, neighbors=[]}:330
State{id='c85fc46ad270eb7d2e458ce99863b5e1', location=Location{name='Dark Room', description='null'}, neighbors=[]}:330
State{id='fef917d04998a75f364d94c87dd3d23e', location=Location{name='Dire Tombs', description='null'}, neighbors=[]}:310
State{id='7ebf0ebd12c4b1df77692f3281527b43', location=Location{name='Room with cage', description='null'}, neighbors=[]}:310
State{id='4a495d2829074db98df47ce99a0828e0', location=Location{name='Chamber', description='null'}, neighbors=[]}:310
State{id='0a2157e287a7cd84f1aa7962138e7725', location=Location{name='Room with cage', description='null'}, neighbors=[]}:310
State{id='6eea2bb5a2db21a51ea4800443ec66c1', location=Location{name='Room with cage', description='null'}, neighbors=[]}:330
State{id='8c038da6d24249137457710287a19de8', location=Location{name='Dark Room', description='null'}, neighbors=[]}:330
State{id='92fa117503d6ef83f8bf202ce4b4dc82', location=Location{name='Dark Room', description='null'}, neighbors=[]}:330
State{id='3f5c319179f0d01d2bb28bc21b687f69', location=Location{name='Chamber', description='null'}, neighbors=[]}:330
State{id='93d5f2d44eb48ad05bf56f1c35cd46c9', location=Location{name='Dire Tombs', description='null'}, neighbors=[]}:330
State{id='21909ede3fe89541f64365fb7d74c61f', location=Location{name='Chamber', description='null'}, neighbors=[]}:330
State{id='296fcbd58f7833d68f06c1c390b33a1a', location=Location{name='Room with cage', description='null'}, neighbors=[]}:350
State{id='5e75e2e5ecce89cc205501fe5cb31b1d', location=Location{name='Dire Tombs', description='null'}, neighbors=[]}:330
State{id='bc7d0a162c83c32ab5f5faab300ca6ba', location=Location{name='Chamber', description='null'}, neighbors=[]}:330
State{id='c5df27bcc497575863568f8acf8732a5', location=Location{name='Dark Room', description='null'}, neighbors=[]}:350
State{id='925cc86f5ce88acbd27a32a6fae32658', location=Location{name='Dire Tombs', description='null'}, neighbors=[]}:330
State{id='adfb3580809a2354f02ba36a07f6b297', location=Location{name='Room with cage', description='null'}, neighbors=[]}:330
State{id='e577aa79473673f6158cc73e0e5dc122', location=Location{name='Dark Room', description='null'}, neighbors=[]}:330
```

## Extra Credit

4 points

Due at Monday (11/28) midnight (11:59pm) after ThanksGiving.

Goal:

Define Astar Search with heuristic function.

Here are the recommended steps:

1. Modify your existing Dijkstra search to Astar Search
2. Define your heuristic search to optimize the value of events (aka. your final path should be the same as Dijkstra) (Total values should be greater than 250)
3. Modify your App.java to monitor how many requests your code sends. 
  * If you are using Graph.java class. Monitor how many nodes you traverse through in your code.
  
Expected outcome:

You should submit a single solution.txt contains the following:

1. Your source code link
2. Your reasoning of heuristic function
3. How many nodes you traverse through in Dijkstra vs Astar
4. What is the final path of Dijkstra vs Astar

References: https://github.com/rcliao/text-adventure
