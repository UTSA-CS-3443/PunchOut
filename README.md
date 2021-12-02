# PunchOut

### CLONING
To clone: `git clone https://github.com/UTSA-CS-3443/PunchOut.git`

### RUNNING
To run the application in Eclipse simply navigate to `src/application/Main` and right click -> Run As -> Java Application.

### DESCRIPTION
We are Grandma's Buttermilk Cookies and our project is: PunchOut.

PunchOut is a boxing game played using the Keyboard. You simply click `New Game` from the main menu, read the instructions and click `Continue`, then press Z to punch, A or D to dodge left and right, and if you punch enough times before the timer runs out, the health of the enemy drops to 0. 

What we have implemented:

 - Punching drains health.
 - Timer ticks down.
 - Saving scores saves in persistent storage for leaderboard.
 - Music and sound for punching.
 - A and D keys move the player sprite.
 - All views navigate properly.

What we have not implemented: 

 - Ending the game when the timer runs out.
 - Simulating enemy punches automatically (currently must press I to make Drago punch).