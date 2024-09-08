## Technical Problems Reflection
I was struggling to decide how to store the Polls and Users in the PollManager, if i should store the Users and Polls in a single hashmap or if i should store the only the users and have the users contain the Polls.
I decided to have to seperate hashmaps one which stores the Users and one which stores the Polls. I think there are pros and cons to both solutions.
Another issue was how to retrieve the user and Poll object. I used the username as the key for the user object and i used a pollId for the key to the Poll objects.
It was difficult to decide how to connect all the different objects.
It was also difficult to design the endpoints for the restapi

##Pending Issues
There is no pending issues that i am aware off
