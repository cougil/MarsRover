# Mars Rover Kata
Mars Rover coding exercise


## Considerations

* By default, if there is no information about the rover's value, it will land on (0,0) heading to North on a
Plateau (10,10).
* Related with the movement of the rovers, I've assumed that any misspelled or bad instructions won't be interpreted, so
the rovers won't return any error, they will stand up in the same location and direction after trying to send any
unintelligible statement. The behaviour will be the same if one Mars Rover is located in the next position that one
robot tries to move on: the rovers will not be placed in the same location.
* There is no information related of what could happen when a rover tries to move outside the boundaries of the
plateau. I've assumed that because most of the planets are spherical, the rover will wrap from one edge of the
plateau to the other (top to botttom, left to right, etc).


#### Requirements

* Java 7+


### Run

* You can run the tests associated using maven:

```
mvn test
```

* The main class to use and pass the instructions is the MainMission class, that accepts the inputs in their 'run'
method and returns the expected output created by the rovers.
